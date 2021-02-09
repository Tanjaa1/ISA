Vue.component("pharmacistHomePage", {
	data: function () {
		return {
			users:{}
		}
	},
	beforeMount() {
	},
	template: `
	<div id="PharmacistHomePage"  class="BackendImagePhysician">		
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
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Users" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="PatientsShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Examination" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="CurrentExaminationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Calendar" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="CalendarShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Vacation" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="VacationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Account" type="button" class="btn btn-info btn-lg form-control" v-on:click="AccountShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Scheduling" type="button" class="btn btn-info btn-lg form-control" v-on:click="MakingExaminationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Medicine" type="button" class="btn btn-info btn-lg form-control" v-on:click="ReservationShow()"></button>
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
	</div>					
				
	`,
	methods: { 
	AccountShow: function () {
		this.$router.push('pharmacistInfo');
	},
	PatientsShow: function () {
		this.$router.push('pharmacistSearchPatients');
	},
	CalendarShow: function () {
	},
	VacationShow: function () {
		this.$router.push('pharmacistVacationRequest');
	},
	CurrentExaminationShow: function () { 
	},
	MakingExaminationShow: function () {
		this.$router.push('createCounselingPharmacist');               
	},
	ReservationShow:function(){
		this.$router.push('reservation');        
	}
	}
});