Vue.component("patientCounceling", {
    data: function () {
        return {
            patientPastCounceling:null,
            patientFutureECounceling:null,
            past:false,
            future:false,
            id: 1,
            date: null,
            time:null,
            canBeCanceled:true,
            pharmacies:null,
            pharmacists:null,
            choosenPharmacy:null,
            choosenPharmacist:null,
            dateTimeStart:null,
            consultation:{},
            brPenalty:0,
            patientt:null
        }
    },
    beforeMount() {

        axios
            .get('/counseling/getPastCounselingByPatientId/' + '90')
            .then(response => {
                this.patientPastCounceling = response.data
            })
            .catch(error => {
            })
        axios
            .get('/counseling/getFutureCounselingByPatientId/' + '90')
            .then(response => {
                this.patientFutureECounceling = response.data
            })
            .catch(error => {
            })
            axios
			.get('/patient/getPatientByIdd/' + '90') 
			.then(response => {
				this.consultation.patient = response.data
                for(i = 0; i < this.patient.penalty.length; i++){
					if(this.patient.penalty[i].isDeleted == false){
						this.brPenalty++;
					}
				}
			})
			.catch(error => {
			})
    },
    template: `
    <div id = "parmaciesShowPatient">
        <div class= "container">
                <br/><h3 class="tex">Consulting a pharmacist</h3><br/>
                <button type="button" class="btn2 btn-primary" style="width:23%; height:35px;" data-toggle="modal" data-target="#createAppointment">Schedule a consultation</button>&nbsp&nbsp&nbsp&nbsp
        
            <div v-if="this.brPenalty < 3">
                <!--Modal for create examination-->
                <div class="modal fade" id="createAppointment" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                       <div class="modal-content steps">
                      <div class="container" align="center">
                          <br/><h4 class="tex">Schedule consultation</h4><br/>
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
                          </ul>
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
                                      <button class="btn btnNext nn" v-on:click="NextStep()">Next</button></br></br>
                                   </div>
                                  <div id="step2" class="container tab-pane active" v-if="id==2"></br>
                                      <label class="chDate">Choose  pharmacy:</label></br>
                                      <!--<select class="select">
                                          <option disabled>Please select one</option>
                                          <option v-for="p in pharmacies">{{p.name}}{{p.address}}{{p.grade}}</option>
                                      </select>-->
                                      <template v-for="p in pharmacies">
                                            <div class="container">
                                            <div class="card">
                                                    <div class="card-header" style="font-size:30px">{{p.name}}</div>
                                                    <div class="card-body" style="font-size:20px">Address: &nbsp{{p.address}}<br> Grade: &nbsp{{p.grade}}<br> Consultation price:&nbsp{{p.counselingPrice}}&nbspdin.</div>
                                                    <button class="btn btnPrev" v-on:click="ScheduleConsultation(p)">Choose</button>
                                                </div></br>
                                            </div>
                                    </template>
                                      </br>
                                      <button class="btn btnPrev" v-on:click="PreviousStep()">Previous</button>
                                   </div>
                                  <div id="step3" class="container tab-pane active" v-if="id==3"></br>
                                      <label>Choose pharmacist:</label>
                                      <!--<select class="select" v-model="choosenPharmacist">
                                           <option disabled >Please select one</option>
                                           <option v-for="p in pharmacists" v-bind:value="p">{{p.name}}&nbsp&nbsp{{p.surname}}</option>                                        
                                      </select>-->
                                      <template v-for="p in pharmacists">
                                            <div class="container">
                                            <div class="card">
                                                    <div class="card-header" style="font-size:30px">{{p.name}}&nbsp&nbsp{{p.surname}}</div>
                                                    <div class="card-body" style="font-size:20px">Grade: &nbsp{{p.grade}}</div>
                                                    <button class="btn btnPrev" v-on:click="createCounseling(p)">Schedule consultation</button>
                                                </div></br>
                                            </div>
                                    </template>
                                      </br>
                                      <button class="btn btnPrev" v-on:click="PreviousStep()">Previous</button>
                                      <!--<button class="btn btnNext" v-on:click="createCounseling()">Schedule consultation</button></br></br>-->
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
            </div>
                
                    <div v-else>
                    <!--Modal for create examination-->
                    <div class="modal fade" id="createAppointment"  tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" style="width: 100%;" role="document">
                           <div class="modal-content steps">
                          <div class="container" align="center">
                              <br/><h4 class=""></h4><br/>
                              <h3>You have 3 or more penalty so you are not allowed to schedule consultation</h3>
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
                                                                <th>Pharmacist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                                <th>Is canceled</th>
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
                                                                <th>Pharmacist</th>
                                                                <th>Date</th>
                                                                <th>Time</th>
                                                                <th>Pharmacy</th>
                                                                <th>Is done</th>
                                                                <th>Price</th>
                                                                <th>Price With Discount</th>
                                                                <th>Is canceled</th>
                                                                <th></th>
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
                                                                <td>{{f.priceWithDiscount}}&nbspdin.</td>
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
            timeStart = document.getElementById("date").value+' '+document.getElementById("time").value
            this.dateTimeStart = document.getElementById("date").value+'T'+document.getElementById("time").value
             axios
                 .get('/pharmacist/getPharmacies/' + timeStart)
                 .then(response => {
                     this.pharmacies = response.data
                })
        },
        ScheduleConsultation:function(p){
            axios
                 .get('/pharmacist/getPharmacistByPharmacyId/' + p.id)
                 .then(response => {
                     this.pharmacists = response.data
                     this.choosenPharmacy=p
                     this.NextStep()
                })
        },
        createCounseling:function(p){
            this.consultation.startTime = this.dateTimeStart
            this.consultation.isDone = false
            this.consultation.pharmacist = p
            alert(this.consultation.pharmacist)
            this.consultation.pharmacy = this.choosenPharmacy
            this.consultation.price = this.choosenPharmacy.counselingPrice
            this.consultation.isCanceled = false

           
            
             axios
                  .post('/counseling/createCounseling', this.consultation)
                  .then(response => {
                      this.pharmacists = response.data
                      this.Refresh()
                 })
        },
        Cancel:function(f){
            axios
            .put('/counseling/cancelCounseling', f)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
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
        Refresh: function () {
            location.reload();
        },
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
        // },
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