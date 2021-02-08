Vue.component("patientExamination", {
    data: function () {
        return {
            patientPastExaminations:null,
            patientFutureExaminations:null,
            past:false,
            future:false
        }
    },
    beforeMount() {

        axios
            .get('/examination/getPastExaminationByPatientId/' + '88')
            .then(response => {
                this.patientPastExaminations = response.data
            })
            .catch(error => {
            })
        axios
            .get('/examination/getFutureExaminationByPatientId/' + '88')
            .then(response => {
                this.patientFutureExaminations = response.data
            })
            .catch(error => {
            })
    },
    template: `
    <div id = "parmaciesShowPatient">
        <div class= "container">
                <br/><h3 class="tex">Examinations by a dermatologist</h3><br/>
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
                                                                <th>Dermatologist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                              <tr v-for="f in patientPastExaminations">
                                                                <td>{{f.dermatologist.name}}&nbsp&nbsp{{f.dermatologist.surname}}</td>
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
                                                                <th>Dermatologist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr v-for="f in patientFutureExaminations">
                                                                <td>{{f.dermatologist.name}}&nbsp&nbsp{{f.dermatologist.surname}}</td>
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
                    this.patientPastExaminations.sort (
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
                    this.patientFutureExaminations.sort (
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
                    this.patientPastExaminations.sort (
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
                    this.patientFutureExaminations.sort (
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
                    this.patientPastExaminations.sort (
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
                    this.patientFutureExaminations.sort (
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
                    this.patientPastExaminations.sort (
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
                    this.patientFutureExaminations.sort (
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