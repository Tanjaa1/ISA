

Vue.component("administratorHomePage", {
	data: function () {
		return {
	
		}
	},
	mounted() {
		axios
        .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
		.then(response =>{
			var pAdmin = response.data
			if(pAdmin.firstTimeLogin)
            	this.$router.push('administratorAccountInfo');
		})

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
						<button id="EmployedAdmin" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="AdministratorEmployedShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="CalendarAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="ExaminationsShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
					  	<button id="AdminMedicine" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedicineShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="AccountAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountInfoShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="OrderAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="OrdersShow()"></button>
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
		

	`
	,
	methods:{
        AccountInfoShow : function(){
            this.$router.push('administratorAccountInfo');
        },
        AdministratorEmployedShow : function(){
            this.$router.push('administratorEmployed');
        },
		MedSearch:function(){
		   this.$router.push('searchMedicine');    
	    },
        ExaminationsShow : function(){
            this.$router.push('administratorExaminations');
        },
		MedicineShow : function(){
            this.$router.push('administratorMedicine');
        },
		OrdersShow : function(){
            this.$router.push('orderMedicinePharmacyAdmin');
        },
	}
});




