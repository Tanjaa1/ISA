Vue.component("dermatologistHomePage", {
	data: function () {
		return {
			users:{},
			phycian:{}
		}
	},
	mounted() {
		
		if(localStorage.getItem('role')=='ROLE_DERMATOLOGIST'){ 
		axios
			.get('/dermatologist/getDermatologistById/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.phycian = response.data
				if(!this.phycian.firstTimeLogin)
					$('#Show').modal('show');
			})
			.catch(error => {
			})
		}else{
			this.$router.push('forbidden');
			}
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
					  <h3>
						<button id="Users" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="PatientsShow"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Calendar" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="CalendarShow"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Vacation" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="VacationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Account" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Scheduling" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MakingExaminationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="SearchMed" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedSearch()"></button>
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
            this.$router.push('dermatologistInfo');
        },
        PatientsShow: function () {
            this.$router.push('dermatologistSearchPatients');
        },
        CalendarShow: function () {
            this.$router.push('calendarD');
        },
        MedSearch:function(){
            this.$router.push('searchMedicine');    
        },
        VacationShow: function () {
            this.$router.push('dermatologistVacationRequest');
        },
        MakingExaminationShow: function () {     
            this.$router.push('createExaminationDermatologist');     
        },
		Yes:function(){
			if(document.getElementById("np").value==document.getElementById("cp").value && document.getElementById("np").value.trim()!="" && document.getElementById("cp").value.trim()!=""){
				$('#Show').modal('hide');
				this.phycian.firstTimeLogin=true
				this.phycian.password=document.getElementById("np").value
					axios.put('/dermatologist/update', this.phycian,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})
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