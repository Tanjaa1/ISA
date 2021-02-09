Vue.component("patientReservations", {
    data: function () {
        return {
            patientReceivedReservations:null,
            patientNotReceivedReservations:null
        }
    },
    beforeMount() {

        axios
            .get('/reservation/getReceivedReservationByPatientId/' + '88')
            .then(response => {
                this.patientReceivedReservations = response.data
            })
            .catch(error => {
            })
         axios
             .get('/reservation/getNotReceivedReservationByPatientId/' + '88')
             .then(response => {
                 this.patientNotReceivedReservations = response.data
             })
             .catch(error => {
             })
    },
    template: `
    <div id = "parmaciesShowPatient">
        <div class= "container">
                <br/><h3 class="te">Medicine reservation</h3><br/>
	                            <ul class="nav nav-tabs" role="tablist">
    	                            <li class="nav-item">
    		                            <a id="tabApprovedF" class="nav-link active .cards" data-toggle="tab" href="#approvedF">Received</a>
    	                            </li>
    	                            <li class="nav-item">
    		                            <a id="tabDisapprovedF" class="nav-link .cards" data-toggle="tab" href="#disapprovedF">Not received</a>
    	                            </li>
                                </ul>
                                <div>
                                    <div class="tab-content">
    	                                <div id="approvedF" class="container tab-pane active"><br>
    		                                <div class="container">
	                                                <div class="row">
                                                        <table id="tableApproved" class="table table-bordered">
                                                            <thead>
                                                              <tr>
                                                              <th>Medicine</th>
                                                              <th>Quantity</th>
                                                              <th>Price</th>
                                                              <th>Expiration date</th>
                                                              <th>Pharmacy</th>
                                                              <th>Is received</th>
                                                              <th>Is canceled</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                              <tr v-for="f in patientReceivedReservations">
                                                                <td>{{f.medicinePriceAndQuantityId.medicine.name}}</td>
                                                                <td>{{f.medicinePriceAndQuantityId.quantity}}kom.</td>
                                                                <td>{{f.medicinePriceAndQuantityId.price}}din.</td>  <td>{{DateSplit(f.expirationDate)}}</td>
                                                                <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                                <td>{{f.isReceived}}</td>
                                                                <td>{{f.isCanceled}}</td>
                                                               <!-- <td style="text-align:center"><button class="btnban form-control" v-on:click="Disapprove(f)">D I S A P P R O V E</button></td> --> 
                                                              </tr>
                                                            </tbody>
                                                         </table>
	                                                </div>
                                              </div>			     
		                                 </div>
		                                <div id="disapprovedF" class="container tab-pane fade"><br>
                                            <div class="container">
                                                <div class="row">
                                                    <table id="tableDisapproved" class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>Medicine</th>
                                                                <th>Quantity</th>
                                                                <th>Price</th>
                                                                <th>Expiration date</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is received</th>
                                                                <th>Is canceled</th>
                                                                <th></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr v-for="f in patientNotReceivedReservations">
                                                                <td>{{f.medicinePriceAndQuantityId.medicine.name}}</td>
                                                                <td>{{f.medicinePriceAndQuantityId.quantity}}kom.</td>
                                                                <td>{{f.medicinePriceAndQuantityId.price}}din.</td>
                                                                <td>{{DateSplit(f.expirationDate)}}</td>
                                                                <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                                <td>{{f.isReceived}}</td>
                                                                <td>{{f.isCanceled}}</td>
                                                                <template v-if="f.isCanceled == false && CanCancel(f.expirationDate) == true">
                                                                    <td style="text-align:center"><button class="btn form-control" v-on:click="Cancel(f)">Cancel</button></td> 
                                                                </template>
                                                            </tr>
                                                         </tbody>
                                                     </table> 
                                                </div>
                                            </div>			
                                        </div>
                                    </div>
                                </div>
    
        <br></br>
        <br></br>
        <br></br>
        <br></br>

    </div>
    </div>
	`,
    methods: {
        Cancel:function(f){
            axios
            .put('/reservation/cancelReservation', f)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
            })
        },
        Refresh: function () {
            location.reload();
        },
        CanCancel: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            var d = new Date(dates[0],dates[1]-1,dates[2])
            var nowDate = new Date();
            nowDate.setDate(nowDate.getDate() + 1)
            var canBeCanceled = true
            if(d <= nowDate)
                canBeCanceled = false
            return canBeCanceled
        },
        DateSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            var pom = Number(dates[2])+1
            return pom + "." + dates[1] + "." + dates[0]
        },
        // Approve: function (feedback) {
        //     axios
        //         .put('/feedback/approve', feedback, {
        //             headers: {
        //                 'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        //             }
        //         })
        //         .then(response => {
        //             this.Refresh();
        //         })
        //         .catch(error => {
        //         })
        // },
        // Disapprove: function (feedback) {
        //     axios
        //         .put('/feedback/approve', feedback, {
        //             headers: {
        //                 'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        //             }
        //         })
        //         .then(response => {
        //             this.Refresh();
        //         })
        //         .catch(error => {
        //         })
        // },
        // Refresh: function () {
        //     axios
        //         .get('/feedback/approved', {
        //             headers: {
        //                 'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        //             }
        //         })
        //         .then(response => {
        //             this.approvedFeedbacks = response.data
        //         })
        //         .catch(error => {
        //         })
        //     axios
        //         .get('/feedback/disapproved', {
        //             headers: {
        //                 'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        //             }
        //         })
        //         .then(response => {
        //             this.disapprovedFeedbacks = response.data
        //         })
        //         .catch(error => {
        //         })
        // }
    }
});