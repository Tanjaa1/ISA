Vue.component("examinationDermatologist", {
	data: function () {
		return {
			patient:null,
            examination:null,
            medicines:[],
            med:null,
            prescriptionDTO:{
                medicine:null,
                therapyDuration:0,
                issuingDate:new Date().now,
            },
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
            medicineChoose:null,
            future:null
		}
	},
	beforeMount() {
        axios
            .get('/examination/getPastExaminationByPatientId/' + '88')
            .then(response => {
                this.examination = response.data[0]
                axios
                .get('/eprescription/findMedicines/' + '111')
                .then(response => {       
                    this.med=response.data
                    for(var m in this.med){
                        var find=false
                        for(var a in this.examination.patient.drugAllargies){
                            if(this.examination.patient.drugAllargies[a].toUpperCase()==this.med[m].medicine.name.toUpperCase())
                                find=true
                        }
                        if(!find)
                            this.medicines.push(this.med[m].medicine)
                    }
                })
                .catch(error => {
                })
            })
            .catch(error => {
            })

            axios
            .get('/examination/getFreeExaminationByDermatologist/' + '6')
            .then(response => {
                this.future = response.data
            })
            .catch(error => {
            })
	},
	template: `
	<div id="ExaminationDermatologist">
        <br><br>	
        <div class="row search">
            <div class="col-sm-5">Patient:</div>
            <div class="col-sm-4">{{this.examination.patient.name}} {{this.examination.patient.surname}}</div><br><br>
            <div class="col-sm-5">Alergies:</div>
            <div class="col-sm-4"><a v-for="a in this.examination.patient.drugAllargies">{{a}}</br></a></div><br><br>          
            <div class="col-sm-5">Report:</div>
            <textarea id="report" class="form-control" rows="4" cols="50" style="height:200px" v-model="examination.report"></textarea>
        </div>
        <div class="row search">
            <button type="button" style="color:white" class="btn2 btn-default" data-dismiss="modal"  data-toggle="modal" data-target="#PrescriptionModal">Prescription</button>&nbsp&nbsp&nbsp&nbsp&nbsp
            <button type="button" style="color:white" class="btn2 btn-default" data-dismiss="modal" data-toggle="modal" data-target="#Schedule">Schedule the next review</button>&nbsp&nbsp&nbsp&nbsp&nbsp
            <button type="button" style="color:white" class="btn2 btn-default" data-dismiss="modal" v-on:click="Finish()">Finish</button>	
        </div>
        <div>
			<div class="modal fade" tabindex="-1" role="dialog" id="PrescriptionModal">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">EPrescription</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body search">
                        
                        <div class="row">Medicine:
                            <select class="col" id="sort" v-model="medicineChoose" >
                                <option selected="selected" disabled>Please select one</option>
                                    <option v-for="m in medicines" v-bind:value="m">{{m.name}}</option>
                            </select>
                        </div></br>
                        Composition:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{this.medicineChoose.composition}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Type:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{medicineChoose.type}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Note:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{medicineChoose.note}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Therapy duration:</br>
                        <input type="number" :disabled="this.medicineChoose==null" class = "form-control input" v-model="prescriptionDTO.therapyDuration"/><br/>
						<div class="modal-footer">
							<button id="addF" type="button" class="btn btn-info btn-lg " v-on:click="AddPrescritpion()">Create</button>
							<button id="cancelF" type="button" class="btn btn-info btn-lg " data-dismiss="modal">Cancel</button>
						</div>
					</div>
					</div>
				</div>
			</div>
            <!--SCHEDULE-->
            <div class="modal fade" tabindex="-1" role="dialog" id="Schedule">
            <div class="modal-dialog" role="document" style="max-width: 60%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Schedule the next examination</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <!--BODY-->
                        <div class= "container">
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li class="nav-item">
                                                <a id="existingTab" class="nav-link active .cards" data-toggle="tab" href="#existing">EXISTING</a>
                                            </li>
                                            <li class="nav-item">
                                                <a id="newTab" class="nav-link .cards" data-toggle="tab" href="#new">NEW</a>
                                            </li>
                                        </ul>
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
                                                                        <th>Price</th>
                                                                        <th>Schedule</th>
                                                                    </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <tr v-for="f in future">
                                                                        <td>{{f.startTime.split('T')[0]}}</td>
                                                                        <td>{{f.startTime.split('T')[1]}}</td>
                                                                        <td>{{f.endTime.split('T')[1]}}</td>
                                                                        <td>{{f.price}}</td>
                                                                        <td><button btn btn-info btn-lg v-on:click="Schedule(f)">Schedule</button></td>
                                                                    </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                    </div>			     
                                                </div>
                                                <div id="new" class="container tab-pane fade"><br>
                                                    <div class="container">
                                                        <div class="md-form mx-5 my-5">
                                                            <label>Choose date:</label></br>
                                                            <input style="height:25px" id="date" type="date"></input>
                                                        </div>
                                                        <div class="md-form mx-5 my-5">
                                                            <label>Choose start time</label>
                                                            <input type="time" id="start" class="form-control">
                                                        </div>
                                                        <div class="md-form mx-5 my-5">
                                                            <label>Choose end time</label>
                                                            <input type="time" id="end" class="form-control">
                                                        </div>
                                                    </div>
                                                    <button id="cancelF" type="button" class="btn btn-info btn-lg " v-on:click="NewEx()">Schedule</button>			
                                                </div>
                                            </div>
                                        </div></br>
            </div>
                    <div class="modal-footer">
                    </div>
                </div>
                </div>
            </div>
        </div>  
		</div>
    </div>			
	`,
	methods: {
        Finish:function(){    
            axios.put('/examination/update', this.examination)
				.then(function (response) {
				})
				.catch(function (error) {
				});    
        },
        Prescription:function(){
            
        },
        AddPrescritpion:function(){
            var pharmacyMedicines=this.examination.pharmacy.pricelist
            for(m in pharmacyMedicines){
                if(pharmacyMedicines[m].medicine.name==this.medicineChoose.name){
                    if(pharmacyMedicines[m].quantity>0){
                        this.prescriptionDTO.medicine=pharmacyMedicines[m]
                        axios.post('/eprescription/add/'+this.examination.patient.id, this.prescriptionDTO)
                            .then(function (response) {
                                alert("The prescription was successfully issued!")
                                location.reload()
                            })
                            .catch(function (error) {
                            });
                        }else{
                            alert("Medicine is put of stock!")
                            axios.post('/pharmacyAdmin/sendingMail/'+this.examination.pharmacy.name,this.medicineChoose)
                            .then(function (response) {
                            })
                            .catch(function (error) {
                            });
                        }
                    }
                }
        },
        Schedule: async function(f){
            f.patient=this.examination.patient
            var fut=[]
            await axios.put('/examination/schedule',f)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
                axios
                .get('/examination/getFreeExaminationByDermatologist/' + '6')
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
        NewEx:function(){
            this.newExamination.startTime=document.getElementById("date").value+'T'+document.getElementById("start").value
            this.newExamination.endTime=document.getElementById("date").value+'T'+document.getElementById("end").value
            this.newExamination.patient=this.examination.patient
            this.newExamination.dermatologist=this.examination.dermatologist 
            this.newExamination.pharmacy=this.examination.pharmacy
            axios.post('/examination/add',this.newExamination)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
            })
            .catch(function (error) {
            });
        }
	}
});