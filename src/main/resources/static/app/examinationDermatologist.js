Vue.component("examinationDermatologist", {
	data: function () {
		return {
			patient:{},
            examination:null,
            medicines:[],
            med:null,
            prescriptionDTO:{
                medicine:null,
                therapyDuration:0,
                issuingDate:new Date().now,
            },
            medicineChoose:null
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
                    for(m in this.med){
                        var find=false
                        for(a in this.examination.patient.drugAllargies){
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
            <button type="button" style="color:white" class="btn2 btn-default" data-dismiss="modal" v-on:click="Schedule()">Schedule the next review</button>&nbsp&nbsp&nbsp&nbsp&nbsp
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
		</div>
    </div>			
	`,
	methods: {
        Finish:function(){    
            axios.post('/examination/update', this.examination)
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
                        this.prescriptionDTO.medicine=this.medicineChoose
                        axios.post('/eprescription/add/'+this.examination.patient.id, this.prescriptionDTO)
                            .then(function (response) {
                            })
                            .catch(function (error) {
                            });
                        }else{
                            axios.post('/pharmacyAdmin/sendingMail/'+this.examination.pharmacy.name,this.medicineChoose)
                            .then(function (response) {
                            })
                            .catch(function (error) {
                            });
                        }
                    }
                }
        }
	}
});