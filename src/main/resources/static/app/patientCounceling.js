Vue.component("patientCounceling", {
    data: function () {
        return {
            patientPastCounceling:null,
            patientFutureECounceling:null,
            past:false,
            future:false
        }
    },
    beforeMount() {

        axios
            .get('/counseling/getPastCounselingByPatientId/' + '88')
            .then(response => {
                this.patientPastCounceling = response.data
            })
            .catch(error => {
            })
        axios
            .get('/counseling/getFutureCounselingByPatientId/' + '88')
            .then(response => {
                this.patientFutureECounceling = response.data
            })
            .catch(error => {
            })
    },
    template: `
    <div id = "parmaciesShowPatient">
        <div class= "container">
                <br/><h3 class="tex">Consulting a pharmacist</h3><br/>
                <div class="row search">
                &nbsp&nbsp&nbsp&nbsp&nbsp&nbspSort by&nbsp&nbsp
                   <div>
                       <select class="col" id="sort" v-on:change="Sort()">
                           <option selected="selected" disabled>Please select one</option>
                               <option>Date assceding</option>
                               <option>Date descending</option>
                               <option>Price assceding</option>
                               <option>Price descending</option>
                       </select>
                   </div>  
           </div>
	                            <ul class="nav nav-tabs" role="tablist">
    	                            <li class="nav-item">
    		                            <a id="tabApprovedF" class="nav-link active .cards" data-toggle="tab" v-on:click="Past()" href="#approvedF">Past</a>
    	                            </li>
    	                            <li class="nav-item">
    		                            <a id="tabDisapprovedF" class="nav-link .cards" data-toggle="tab" v-on:click="Future()" href="#disapprovedF">Future</a>
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
                                                                <th>Pharmacist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                              <tr v-for="f in patientPastCounceling">
                                                                <td>{{f.pharmacist.name}}&nbsp&nbsp{{f.pharmacist.surname}}</td>
                                                                <td>{{DateSplit(f.startTime)}}</td>
                                                                <td>{{TimeSplit(f.startTime)}}</td>
                                                                <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                                <td>{{f.isDone}}</td>
                                                                <td>{{f.price}}&nbspdin.</td>
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
                                                                <th>Pharmacist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr v-for="f in patientFutureECounceling">
                                                                <td>{{f.pharmacist.name}}&nbsp&nbsp{{f.pharmacist.surname}}</td>
                                                                <td>{{DateSplit(f.startTime)}}</td>
                                                                <td>{{TimeSplit(f.startTime)}}</td>
                                                                <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                                <td>{{f.isDone}}</td>
                                                                <td>{{f.price}}&nbspdin.</td>
                                                                <!--<td style="text-align:center"><button class="btnapprove form-control" v-on:click="Approve(f)">A P P R O V E</button></td>-->
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
        DateSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            return dates[2] + "." + dates[1] + "." + dates[0]
        },
        TimeSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            return times[0] + ":" + times[1] + "h"
        },
        Approve: function (feedback) {
            axios
                .put('/feedback/approve', feedback, {
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.Refresh();
                })
                .catch(error => {
                })
        },
        Disapprove: function (feedback) {
            axios
                .put('/feedback/approve', feedback, {
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.Refresh();
                })
                .catch(error => {
                })
        },
        Refresh: function () {
            axios
                .get('/feedback/approved', {
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.approvedFeedbacks = response.data
                })
                .catch(error => {
                })
            axios
                .get('/feedback/disapproved', {
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.disapprovedFeedbacks = response.data
                })
                .catch(error => {
                })
        },
        Past:function(){
            this.past=false
        },
        Future:function(){
            this.past=true
        },
        Sort:function(){
			if(document.getElementById("sort").value=="Date assceding"){
                if(this.past == false){
                    this.patientPastCounceling.sort (
                        function (a, b) {
                            if (a.startTime < b.startTime){
                                return -1;
                            } else if (a.startTime > b.startTime){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else{
                    this.patientFutureECounceling.sort (
                        function (a, b) {
                            if (a.startTime < b.startTime){
                                return -1;
                            } else if (a.startTime > b.startTime){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }
			}else if(document.getElementById("sort").value=="Date descending"){
                if(this.past == false){
                    this.patientPastCounceling.sort (
                        function (a, b) {
                            if (a.startTime > b.startTime){
                                return -1;
                            } else if (a.startTime < b.startTime){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else{
                    this.patientFutureECounceling.sort (
                        function (a, b) {
                            if (a.startTime > b.startTime){
                                return -1;
                            } else if (a.startTime < b.startTime){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }
			}else if(document.getElementById("sort").value=="Price assceding"){
                if(this.past == false){
                    this.patientPastCounceling.sort (
                        function (a, b) {
                            if (a.price < b.price){
                                return -1;
                            } else if (a.price > b.price){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else{
                    this.patientFutureECounceling.sort (
                        function (a, b) {
                            if (a.price < b.price){
                                return -1;
                            } else if (a.price > b.price){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }
			}else{
                if(this.past == false){
                    this.patientPastCounceling.sort (
                        function (a, b) {
                            if (a.price > b.price){
                                return -1;
                            } else if (a.price < b.price){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else{
                    this.patientFutureECounceling.sort (
                        function (a, b) {
                            if (a.price > b.price){
                                return -1;
                            } else if (a.price < b.price){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }
			}
		}
    }
});