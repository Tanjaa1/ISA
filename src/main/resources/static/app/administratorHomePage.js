

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
						<label>Employees</label>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="CalendarAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="ExaminationsShow()"></button>
						<label>Examinations</label>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
					  	<button id="AdminMedicine" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedicineShow()"></button>
						  <label>Medicine and promotions</label>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="AccountAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountInfoShow()"></button>
						<label>My account</label>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="OrderAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="OrdersShow()"></button>
						<label>Orders and requests</label>
						</h3><br/> 
					</div>
					<div class="col-sm">
					<h3>
					  <button id="SearchMed" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedSearch()"></button>
					  <label>Search medicine</label>
					  </h3><br/> 
				  </div>
					<div class="col-sm">
					<button id="ReportsAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="ReportsShow()"></button>
					<label style= "font-size : 29px">Reports</label>

					</h3><br/> 
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

            this.$router.push('administratorEmployed');
        },
		MedSearch:function(){
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
		   this.$router.push('searchMedicine');    
	    },
        ExaminationsShow : function(){
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
            this.$router.push('administratorExaminations');
        },
		MedicineShow : function(){
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
            this.$router.push('administratorMedicine');
        },
		OrdersShow : function(){
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
            this.$router.push('orderMedicinePharmacyAdmin');
        },
		ReportsShow : function(){
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
            this.$router.push('reportAdministrator');
        },
	}
});




