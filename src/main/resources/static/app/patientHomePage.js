Vue.component("patientHomePage", {
    data: function () {
		return {
			users:{},
			phycian:{}
		}
	},
	beforeMount() {
		axios
			.get('/dermatologist/getDermatologistById/' + '6') 
			.then(response => {
				this.phycian = response.data
				if(!this.phycian.firstTimeLogin)
					$('#Show').modal('show');
			})
			.catch(error => {
			})
	},
	template: `
	<div id="DermatologistHomePage"  class="BackendImagePhysician">		
			<br></br><br></br>
			<br></br><br></br>
				<div>
				  <div class="row">
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Pharmacy" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="PharmaciesShow"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="dermatologistExamination" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="PatientExamination"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="pharmacistExaminatio" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="pharmacistExamination()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Account" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="medicineReservation" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="medicineReservation()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="actionAndPromotion" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="ActionAndPromotionShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>  
					<div class="col-sm">
					</div>
				  </div>				
		</div>
		<br></br><br></br>
		<!--MODAL-->
		<div class="modal fade" tabindex="-1" role="dialog" id="Show" >
		<div class="modal-dialog search" role="document">
		  <div class="modal-content">
			<div class="modal-header">
			  <h5 class="modal-title">Change password</h5>
			</div>
			<div class="modal-body search">
						New password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input id="np" type="password" minlength="8"></br></br>
						
						Confirm password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input type="password" id="cp" name="password" minlength="8"></br>
			</div>
			<div class="modal-footer">
			  	<button type="button" class="btn btn-info btn-lg" v-on:click="Yes()">Confirm</button>
			</div>
		  </div>
		  </div>
		</div>
	  </div>
	</div>					
				
	`,
	methods: {
		AccountShow: function () {
            this.$router.push('patientInfo');
        },
        PharmaciesShow: function () {
            this.$router.push('pharmaciesShow');
        },
        PatientExamination: function () {
            this.$router.push('patientExamination');
        },
        pharmacistExamination: function () {
            this.$router.push('patientCounceling');
        },
        medicineReservation: function () {     
            this.$router.push('patientReservations');    
        },
		ActionAndPromotionShow: function () {     
            this.$router.push('actonAndPromotion');    
        },
		Yes:function(){
			if(document.getElementById("np").value==document.getElementById("cp").value && document.getElementById("np").value.trim()!="" && document.getElementById("cp").value.trim()!=""){
				$('#Show').modal('hide');
				this.phycian.firstTimeLogin=true
					axios.put('/dermatologist/update', this.phycian)
						.then(function (response) {
						})
						.catch(function (error) {
						});
			}else{
				alert('Comfire password!')
			}
		}
	}

});
