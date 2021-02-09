Vue.component("patientExamination", {
    data: function () {
        return {
            patientPastExaminations:null,
            patientFutureExaminations:null,
            past:false,
            future:false,
            id: 1,
            date: null,
            time:null,
            canBeCanceled:true
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
    },
    template: `
    <div id = "parmaciesShowPatient">
    <div>
        <div class= "container">
                <br/><h3 class="tex">Examinations by a dermatologist</h3><br/>
                <button type="button" class="btn2 btn-primary" style="width:23%; height:35px;" data-toggle="modal" data-target="#createAppointment">Schedule an examinationt</button>&nbsp&nbsp&nbsp&nbsp
             
             
                <!--Modal for create examination-->
                <div class="modal fade" id="createAppointment" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                       <div class="modal-content steps">
                      <div class="container" align="center">
                          <br/><h4 class="text">Create new appointment</h4><br/>
                          <ul class="nav" role="tablist">
                              <li class="nav-item">
                                  <button disabled id="step1" class="circleStep circleStepDone">1</button>
                                  <h3 class="text">Step 1</h3><br/>
                              </li><h6>______</h6>
                              <li class="nav-item">
                                  <button disabled id="step2" disabled class="circleStep circlesStepDisabled">2</button>
                                  <h3 class="text">Step 2</h3><br/>
                              </li><h6>______</h6>
                              <li class="nav-item">
                                  <button disabled id="step3" disabled class="circleStep circlesStepDisabled">3</button>
                                  <h3 class="text">Step 3</h3><br/>
                              </li><h6>______</h6>
                              <li class="nav-item">
                                  <button disabled id="step4" disabled class="circleStep circlesStepDisabled">4</button>
                                  <h3 class="text">Step 4</h3><br/>
                              </li>
                          </ul></br>
                        </div>                   
                          <div>
                              <div class="tab-content">
                                  <div id="step1" class="container tab-pane active" v-if="id==1"></br>
                                  &nbsp<label class="chDate">Choose date:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                      <label>Choose time:</label></br>
                                      <input id="date" type="date" v-model ="date" class="inDate"></input>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                      <input id="time" type="time" v-model ="time"></input>
                                      </br></br></br></br>
                                      <button class="btn btnNext" v-on:click="NextStep()">Next</button></br></br>
                                   </div>
                                  <div id="step2" class="container tab-pane active" v-if="id==2"></br>
                                      <label>Choose  specialization:</label></br>
                                      <select class="select">
                                          <option disabled>Please select one</option>
                                          <option></option>
                                      </select>
                                      </br></br></br></br>
                                      <button class="btn btnPrev" v-on:click="PreviousStep()">Previous</button>
                                      <button class="btn btnNext" v-on:click="NextStep()">Next</button></br></br>
                                   </div>
                                  <div id="step3" class="container tab-pane active" v-if="id==3"></br>
                                      <label>Choose physician:</label></br>
                                      <select class="select" >
                                           <option disabled >Please select one</option>
                                           <option ></option>                                        
                                      </select>
                                      </br></br></br></br>
                                      <button class="btn btnPrev" v-on:click="PreviousStep()">Previous</button>
                                      <button class="btn btnNext" v-on:click="NextStep()">Next</button></br></br>
                                  </div>
                                  <div id="step4" class="container tab-pane active" v-if="id==4"></br>                                 
                                      <label>Choose  time:</label></br>
                                      <select class="select" >
                                          <option div  ></option>
                                      </select>
                                      </br></br></br></br>
                                      <button class="btn btnPrev" v-on:click="PreviousStep()">Previous</button>
                                      <button class="btn btnNext" v-on:click="MakeAppointment()">Submit</button></br></br>
                                  </div>
                             </div>
                          </div>
                      </div>
                  </div>
            </div>
             
               <!--End modal for create examination-->
            
            
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
		}
    }
});