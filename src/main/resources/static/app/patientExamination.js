Vue.component("patientExamination", {
    data: function () {
        return {
            patientPastExaminations:null,
            patientFutureExaminations:null,
            past:false,
            id: 1,
            date: null,
            time:null,
            canBeCanceled:true,
            newExamination: {
                startTime:null,
                endTime:null,
                patient:null,
                dermatologist:null,
                id:null,
                idDone:false,
                pharmacy:null,
                report:"",
                price:1000.00             
            },
            future:null,
            patient:null
        }
    },
    beforeMount() {
        axios
            .get('/examination/getPastExaminationByPatientId/' + '88')
            .then(response => {
                this.patientPastExaminations = response.data
                // let [month, date, year]    = new Date().toLocaleDateString("en-US").split("/")
                // let [hour, minute, second] = new Date().toLocaleTimeString("en-US").split(/:| /)
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

            axios
            .get('/examination/getFreeExaminations')
            .then(response => {
                this.future = response.data
            })
            .catch(error => {
            })

            axios
			.get('/patient/getPatientById/' + '88') 
			.then(response => {
				this.patient = response.data
			})
			.catch(error => {
			})
    },
    template: `
    <div id = "parmaciesShowPatient">
    <div>
        <div class= "container">
                <br/><h3 class="tex">Examinations by a dermatologist</h3><br/>
                <button type="button" class="btn2 btn-primary" style="width:23%; height:35px;" data-toggle="modal" data-target="#createAppointment">Schedule an examinationt</button>&nbsp&nbsp&nbsp&nbsp
             
             
                <!--Modal for create examination-->
                <div class="modal fade" id="createAppointment"  tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" style="width: 100%;" role="document">
                       <div class="modal-content steps">
                      <div class="container" align="center">
                          <br/><h4 class="">Schedule examination</h4><br/>
                          

                          <div class="row search so">
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                          &nbsp&nbsp&nbsp&nbsp&nbsp&nbspSort by&nbsp&nbsp
                             <div>
                                 <select class="col" id="sort1" v-on:change="Sort1()">
                                     <option selected="selected" disabled>Please select one</option>
                                         <option>Grade asc</option>
                                         <option>Grade desc</option>
                                         <option>Price asc</option>
                                         <option>Price desc</option>
                                 </select>
                             </div>  
                     </div>



                        </div>                   
                          <div>
                              <div>
                                  <div class="tab-content">
                                      <div id="existing" class="container tab-pane active"><br>
                                          <div class="container">
                                                  <div class="row">
                                                      <table id="tableApproved" class="table table-bordered">
                                                          <thead>
                                                          <tr>
                                                              <th>Date</th>
                                                              <th>Start</th>
                                                              <th>End</th>
                                                              <th>Dermatologist</th>
                                                              <th>Price</th>
                                                              <th>Schedule</th>
                                                          </tr>
                                                          </thead>
                                                          <tbody>
                                                          <tr v-for="f in future">
                                                              <td>{{f.startTime.split('T')[0]}}</td>
                                                              <td>{{f.startTime.split('T')[1]}}</td>
                                                              <td>{{f.endTime.split('T')[1]}}</td>
                                                              <td>{{f.dermatologist.name}}&nbsp&nbsp{{f.dermatologist.surname}}</td>
                                                              <td>{{f.price}}</td>
                                                              <td><button btn btn-info btn-lg v-on:click="Schedule(f)">Schedule</button></td>
                                                          </tr>
                                                          </tbody>
                                                      </table>
                                                  </div>
                                          </div>			     
                                      </div>
                                     
                                  </div>
                              </div></br>
                          </div>
                          </div>
                          </div>
                        </div>
                        			
          
    
                
             
               <!--End modal for create examination-->
            <!--Sort whole page-->
            
               <div class="row search so">
             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
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

        <!--End sort whole page-->

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
                                                                <th>Is canceled</th>
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
                                                                <td>{{f.isCanceled}}</td>
                                                              <!-- <td style="text-align:center"><button class="btn form-control" v-on:click="Disapprove(f)">Cancel</button></td> -->
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
                                                                <th>Is canceled</th>
                                                                <th></th>
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
                                                                <td>{{f.isCanceled}}</td>
                                                                <template v-if="f.isCanceled == false && CanCancel(f.startTime) == true">
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
        Schedule: async function(f){
            f.patient=this.patient
            var fut=[]
            await axios.put('/examination/schedule',f)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
                axios
                .get('/examination/getFreeExaminations')
                .then(function (odg){
                    this.future=odg.response
                    location.reload()
                })
                .catch(error => {
                })
            })
            .catch(function (error) {
            });
            
        },
        NextStep: function () {
            if (this.Validation()) {
                if(this.id == 1)
                    this.GetPharmacies()
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
                document.getElementById("step3").className = "circleStep circlesStepDisabled"
                document.getElementById("step4").className = "circleStep circlesStepDisabled"
            }
            else if (this.id == 2) {
                document.getElementById("step1").className = "circleStep circleStepDone"
                document.getElementById("step2").className = "circleStep circleStepDone"
                document.getElementById("step3").className = "circleStep circlesStepDisabled"
                document.getElementById("step4").className = "circleStep circlesStepDisabled"
            }
            else if (this.id == 3) {
                document.getElementById("step1").className = "circleStep circleStepDone"
                document.getElementById("step2").className = "circleStep circleStepDone"
                document.getElementById("step3").className = "circleStep circleStepDone"
                document.getElementById("step4").className = "circleStep circlesStepDisabled"
            }
            else {
                document.getElementById("step1").className = "circleStep circleStepDone"
                document.getElementById("step2").className = "circleStep circleStepDone"
                document.getElementById("step3").className = "circleStep circleStepDone"
                document.getElementById("step4").className = "circleStep circleStepDone"
            }
        },
        PreviousStep: function () {
            //this.Event()
            this.id -= 1
            this.Steps()
        },
        Validation: function () {
            if (this.id == 1 && document.getElementById("date").value != "") {
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
        GetPharmacies: function(){
            //alert(this.date)
            axios
                .get('/appointment/avaliableTimeIntervals', {
                    params: { physicianId: this.choosenPhysician.id, specializationName: this.choosenSpecialization, date: this.date },
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.timeIntervals = response.data
                })
        },
        CanCancel: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            var d = new Date(dates[0],dates[1]-1,dates[2], times[0],times[1],times[2])
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
        Cancel:function(f){
            axios
            .put('/examination/cancelExamination', f)
            .then(response => {
                this.Refresh();
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
        Refresh: function () {
            location.reload();
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
		},
        Sort1:function(){
			if(document.getElementById("sort1").value=="Grade asc"){
                    this.future.sort (
                        function (a, b) {
                            if (a.dermatologist.grade < b.dermatologist.grade){
                                return -1;
                            } else if (a.dermatologist.grade > b.dermatologist.grade){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else if(document.getElementById("sort1").value=="Grade desc"){
                    this.future.sort (
                        function (a, b) {
                            if (a.dermatologist.grade > b.dermatologist.grade){
                                return -1;
                            } else if (a.dermatologist.grade < b.dermatologist.grade){
                                return 1;
                            } else {
                                return 0;   
                            }
                        }
                    );
                }else if(document.getElementById("sort1").value=="Price asc"){
                    this.future.sort (
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
                this.future.sort (
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
});
