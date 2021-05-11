

Vue.component("administratorHomePage", {
	data: function () {
		return {
	
		}
	},
	beforeMount() {

	}
		,
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
					  <h3>
						<button id="Users" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="PatientsShow"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Calendar" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="ExaminationsShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Vacation" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="VacationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Account" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountInfoShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Scheduling" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MakingExaminationShow()"></button>
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
		

	`
	,
	methods:{
        AccountInfoShow : function(){
            this.$router.push('administratorAccountInfo');
        },
        ExaminationsShow : function(){
            this.$router.push('administratorExaminations');
        },
	}
});




