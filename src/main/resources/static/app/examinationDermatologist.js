Vue.component("examinationDermatologist", {
	data: function () {
		return {
			patient:{},
            examination:null,
            medicines:null,
            getMedicine:null,
            prescriptionDTO:{
                medicine:null,
                therapyDuration:0,
                issuingDate:new Date().now,
            }
		}
	},
	beforeMount() {
        axios
            .get('/eprescription/findMedicines/' + '111')
            .then(response => {
                this.medicines = response.data
            })
            .catch(error => {
            })
	},
	template: `
	<div id="ExaminationDermatologist">
        <br><br>	
        <div class="row search">
            <div class="col-sm-5">Patient:</div>
            <div class="col-sm-4">Mila Milic</div><br><br>
            <div class="col-sm-5">Alergies:</div>
            <div class="col-sm-4">Alergije</div><br><br>          
            <div class="col-sm-5">Report:</div>
            <textarea id="report" class="form-control" rows="4" cols="50" style="height:200px" v-model="examination"></textarea>
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
                            <select class="col" id="sort" v-for="m in medicines"  v-on:change="Medicine(m)">
                                <option selected="selected" disabled>Please select one</option>
                                    <option>{{m.medicine.name}}</option>
                            </select>
                        </div></br>
                        Composition:</br>
                        <div v-if="this.getMedicine!=null">
                        {{getMedicine.medicine.composition}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Type:</br>
                        <div v-if="this.getMedicine!=null">
                        {{getMedicine.medicine.type}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Note:</br>
                        <div v-if="this.getMedicine!=null">
                        {{getMedicine.medicine.note}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Therapy duration:</br>
                        <input type="number" :disabled="this.getMedicine==null" class = "form-control input" v-model="prescriptionDTO.therapyDuration"/><br/>
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
        },
        Prescription:function(){
            
        },
        Medicine:function(m){
            this.getMedicine=m
        },
        AddPrescritpion:function(){
            this.prescriptionDTO.medicine=this.getMedicine.medicine      
            axios.post('/eprescription/add', this.prescriptionDTO)
				.then(function (response) {
				})
				.catch(function (error) {
				});

        }
	}
});