Vue.component("patientReservations", {
    data: function () {
        return {
            patientReceivedReservations:null,
            patientNotReceivedReservations:null,
            medicines:null,
            pharmacies:null,
            id:1
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
                <button type="button" class="btn2 btn-primary" style="width:23%; height:35px;" data-toggle="modal" v-on:click="PatientsReservation">Schedule an examinationt</button>&nbsp&nbsp&nbsp&nbsp


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
        PatientsReservation: function () {
            this.$router.push('reserveMedicine');
        },
        NextStep: function () {
            if (this.Validation()) {
                if(this.id == 1)
                    //this.GetPharmacies()
                if (this.id == 2)
                   // this.SpecialistForChoose()
                if (this.id == 3) {
                    //this.GetTimeIntervals()
                }
                this.id += 1
                this.Steps()
            }
        },
        Steps: function () {
            if (this.id == 1) {
                document.getElementById("step1").className = "circleStep circleStepDone"
                document.getElementById("step2").className = "circleStep circlesStepDisabled"
            }
            else if (this.id == 2) {
                document.getElementById("step1").className = "circleStep circleStepDone"
                document.getElementById("step2").className = "circleStep circleStepDone"
            }
        },
        PreviousStep: function () {
            //this.Event()
            this.id -= 1
            this.Steps()
        },
        Validation: function () {
            if (this.id == 1 && document.getElementById("name").value != "") {
                return true
            }
            else if (this.id == 2/* && this.choosenSpecialization != null*/) {
                return true
            }
            else if (this.id == 3/* && this.choosenPhysician != null*/) {
                return true
            }
            return false
        },
        Search: function(){
			var name=document.getElementById("name").value
			if(name=="") name='%20'
			axios
			.get('/pharmacy/getMedicineFromPharmacy/' + name) 
			.then(response => {
				this.pharmacies = response.data
                this.NextStep()
			})
			.catch(error => {
			})
		},
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
            return dates[2] + "." + dates[1] + "." + dates[0]
        },
        DateSplit1: function (date) {
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



Vue.component("reserveMedicine", {
    data: function () {
        return {
            patientReceivedReservations:null,
            patientNotReceivedReservations:null,
            medicines:null,
            pharmacies:null,
            id:1,
            chooseDate:null,
            reservation:{},
            choosenMedicineName:null,
            medicine:null
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
                    
                    <br/><h3 class="te">Reserve medicine</h3><br/>
                    <div class="row search">
                    <label>Choose medicine:</label>
                    <div class="col-sm-5"><input id="name" placeholder="Enter medicine name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                   <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
                   </div>
            
                   <div class="row search"><label>Choose date:</label>       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                   <div class="col-sm-5"><input id="date" v-model="chooseDate" placeholder="Enter medicine name" type="date" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                 
              </div><br>
                                
                                       <template v-for="p in pharmacies">
                                             <div class="">
                                                <div class="card">
                                                     <div class="card-header" style="font-size:30px">{{p.name}}</div>
                                                     <div class="card-body" style="font-size:20px">Address: &nbsp{{p.address}}<br> Grade: &nbsp{{p.grade}}<br> Consultation price:&nbsp{{p.counselingPrice}}&nbspdin.</div>
                                                     <button class="btn btnPrev btnChoose" v-on:click="MakeReservation(p)">Make reservation</button></br>
                                                 </div></br>
                                             </div>
                                     </template>
                                   </div>
                                  </div>
                                
                             </div>
                          </div>
                      </div>
                  </div>
            </div>
             
               <!--End modal for create examination-->
                              
                                  
                            


               
        <br></br>
        <br></br>
        <br></br>
        <br></br>

    </div>
    </div>
	`,
    methods: {
        PatientsReservation: function () {
            this.$router.push('patientReservations');
        },
        Search: function(){
			var name=document.getElementById("name").value
            this.choosenMedicineName = name
			if(name=="") name='%20'
			axios
			.get('/medicine/findMedicine/' + name) 
			.then(response => {
                this.medicine  = response.data
                alert(this.medicine)
				this.Search1()
			})
			.catch(error => {
			})
		},
        Search1: function(){
			var name=document.getElementById("name").value
            this.choosenMedicineName = name
			if(name=="") name='%20'
			axios
			.get('/pharmacy/getMedicineFromPharmacy/' + name) 
			.then(response => {
				this.pharmacies = response.data
			})
			.catch(error => {
			})
		},
        Refresh: function () {
            location.reload();
        },
        DateSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            var pom = Number(dates[2])+1
            return pom + "." + dates[1] + "." + dates[0]
        },
        MakeReservation: function(p){
            var ob = {}
            for(i in p.pricelist){
                if(p.pricelist[i].medicine.name.includes(this.medicine.name)){
                    ob= p.pricelist[i]
                    break   
                }
            }
            this.reservation.medicine = ob
            alert(this.reservation.medicine)
            this.reservation.isReceived = false
            this.reservation.pharmacy = p
            this.reservation.isCanceled = false
            this.reservation.expirationDate = this.chooseDate
             axios
			 .post('/reservation/makeReservation', this.reservation) 
			 .then(response => {
			 	this.pharmacies = response.data
                 this.PatientsReservation()
			 })
			 .catch(error => {
			 })
        }
    }
});