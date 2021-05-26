Vue.component("Login", {
	data: function () {
		return {
			usernameText: null,
			passwordText: null,
			loginResponse: null,
			token: null,
			role:null,
			jwtAuthenticationRequest:{}
		}
	},
	beforeMount() {
		localStorage.setItem('isLogged', false);
		localStorage.setItem('userId', "");


	},
	template: `
	<div id="Login">
		 <div class="loginbox">
			 <img src="../pictures/avatar.jpg" class="avatar">
				<h1>Login</h1>
					<form>
						<p id="loginboxText">Username</p>
						<input type="text" name="" id="userNameId" placeholder="Enter Username" v-model="usernameText">
						<p id="loginboxText">Password</p>
						<input type="password" name="" id="passwordId" placeholder="Enter Password" v-model="passwordText">
						<input type="button" name="" id="submitId" value="Login" v-on:click="Validation()">
						<a href="/#/registrationPatient">You don't have an account?</a>
					</form>
		</div>

					<div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">
		                      <!-- Modal content-->
			                  <div class="modal-content">
					                <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
							  <div class="modal-body">
                              <p>Please enter username.</p>
							 </div>
							 <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal" >Ok</button>
                             </div>
                          </div>
                        </div>
					</div>

					<div class="modal fade" id="myModal1" role="dialog">
                        <div class="modal-dialog">
		                      <!-- Modal content-->
			                  <div class="modal-content">
					                <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
							  <div class="modal-body">
                              <p>Please enter password.</p>
							 </div>
							 <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal" >Ok</button>
                             </div>
                          </div>
                        </div>
					</div>

				<div class="modal fade" id="myModal2" role="dialog">
                        <div class="modal-dialog">
		                      <!-- Modal content-->
			                  <div class="modal-content">
					                <div class="modal-header">
								          <button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
							  <div class="modal-body">
                              <p>Wrong username or password.</p>
							 </div>
							 <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal" >Ok</button>
                             </div>
                          </div>
                        </div>
					</div>



				
	</div>
					
	`,
	methods: {
		Validation: function () {

			if (document.getElementById("userNameId").value === '') {
				$('#myModal').modal('show');
				return
			}
			else if (document.getElementById("passwordId").value === '') {
				$('#myModal1').modal('show');
				return
			}
			else {
				this.Login();

			}
		},
		
		Redirect: function (UserType) {
			if (UserType == "ROLE_PATIENT") {
				localStorage.setItem('isAdmin', false)
				localStorage.setItem('isPatient', true)
				localStorage.setItem('isSupplier', false)
				localStorage.setItem('isPharmacyAdmin', false)
				localStorage.setItem('isDermatologist', false)
				localStorage.setItem('isPharmacist', false)
				this.$router.push('patientHomePage');
			}
			else if (UserType == "ROLE_ADMIN") {
				localStorage.setItem('isAdmin', true)
				localStorage.setItem('isPatient', false)
				localStorage.setItem('isSupplier', false)
				localStorage.setItem('isPharmacyAdmin', false)
				localStorage.setItem('isDermatologist', false)
				localStorage.setItem('isPharmacist', false)
				this.$router.push('systemAdminHomaPage');
			}else if (UserType == "ROLE_PHARMACYADMIN") {
				localStorage.setItem('isAdmin', false)
				localStorage.setItem('isPatient', false)
				localStorage.setItem('isSupplier', false)
				localStorage.setItem('isPharmacyAdmin', true)
				localStorage.setItem('isDermatologist', false)
				localStorage.setItem('isPharmacist', false)
				this.$router.push('administratorHomePage');
			}else if (UserType == "ROLE_PHARMACIST") {
				localStorage.setItem('isAdmin', false)
				localStorage.setItem('isPatient', false)
				localStorage.setItem('isSupplier', false)
				localStorage.setItem('isPharmacyAdmin', false)
				localStorage.setItem('isDermatologist', false)
				localStorage.setItem('isPharmacist', true)
				this.$router.push('pharmacistHomePage');
			}else if (UserType == "ROLE_DERMATOLOGIST") {
				localStorage.setItem('isAdmin', false)
				localStorage.setItem('isPatient', false)
				localStorage.setItem('isSupplier', false)
				localStorage.setItem('isPharmacyAdmin', false)
				localStorage.setItem('isDermatologist', true)
				localStorage.setItem('isPharmacist', false)
				this.$router.push('dermatologistHomePage');
			}else if (UserType == "ROLE_SUPPLIER") {
				localStorage.setItem('isAdmin', false)
				localStorage.setItem('isPatient', false)
				localStorage.setItem('isSupplier', true)
				localStorage.setItem('isPharmacyAdmin', false)
				localStorage.setItem('isDermatologist', false)
				localStorage.setItem('isPharmacist', false)
				this.$router.push('supplierProfile');
			}
		},
		
		Login: function () {
			username = document.getElementById("userNameId").value
			password = document.getElementById("passwordId").value
			this.jwtAuthenticationRequest.username=username
			this.jwtAuthenticationRequest.password=password

			axios
				.post('/auth/login',this.jwtAuthenticationRequest)
				.then(response => {
					this.token = response.data.accessToken
					//localStorage.setItem('userId', response.data.id)

					if(this.token==undefined){
						alert("Username or password are wrong, please try again ")
					}
					alert(this.token)
					localStorage.setItem('token', this.token);
					localStorage.setItem('isLogged', true);

					if (response.data.role == "ROLE_PATIENT") {
						axios
						.get('/patient/getPatientByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idPatient = response.data
							localStorage.setItem('userId', this.idPatient.id)
							alert('pacijent')
							if(this.idPatient.emailComfirmed==false){
								alert("please confirme registration by email")
								localStorage.setItem('token', "");
								this.$router.push('/');

							}
							
						})
						.catch(error => {
							alert("Username or password are wrong, please try again !")
						})
					}
					else if (response.data.role == "ROLE_ADMIN") {
						axios
						.get('/systemAdmin/getSystemAdminByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idSystemAdmin = response.data
							localStorage.setItem('userId', this.idSystemAdmin.id)
							alert('systemAdmin')
							if(this.idSystemAdmin.emailComfirmed==false){
								alert("please confirme registration by email")
								localStorage.setItem('token', "");
								this.$router.push('/');
							}
						})
						.catch(error => {

						})
					}else if (response.data.role == "ROLE_PHARMACYADMIN") {
						axios
						.get('/pharmacyAdmin/getPharmacyAdminByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idPharmacyAdmin = response.data
							localStorage.setItem('userId', this.idPharmacyAdmin.id)
							alert('pharmacyAdmin')
							alert(this.idPharmacyAdmin.emailComfirmed)
							if(this.idPharmacyAdmin.emailComfirmed==false){
								alert("please confirme registration by email")
								localStorage.setItem('token', "");
								this.$router.push('/');

							}
						})
						.catch(error => {
							alert("Username or password are wrong, please try again !")

						})
					}else if (response.data.role == "ROLE_PHARMACIST") {
						axios
						.get('/pharmacist/getPharmacistByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idPharmacist= response.data
							localStorage.setItem('userId', this.idPharmacist.id)
							alert(localStorage.getItem('userId'))
							if(this.idPharmacist.emailComfirmed==false){
								alert("please confirme registration by email")
								localStorage.setItem('token', "");
								this.$router.push('/');

							}
						})
						.catch(error => {
							alert("Username or password are wrong, please try again! ")

						})
					}else if (response.data.role == "ROLE_DERMATOLOGIST") {
						axios
						.get('/dermatologist/getDermatologistByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idDermatologist = response.data
							localStorage.setItem('userId', this.idDermatologist.id)
							alert('dermatologist')
							if(this.idDermatologist.emailComfirmed==false){
								alert("please confirme registration by email")
								localStorage.setItem('token', "");
								this.$router.push('/');

								return
							}
						})
						.catch(error => {
							alert("Username or password are wrong, please try again!")

						})
					}else if (response.data.role == "ROLE_SUPPLIER") {
						axios
						.get('/supplier/getSupplierByCredentials/'+response.data.username,
							{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							this.idSupplier = response.data
						localStorage.setItem('userId', this.idSupplier.id)
							alert('supplier')
							if(this.idSupplier.emailComfirmed==false){
								alert("please confirme registration by email ")
								localStorage.setItem('token', "");
								this.$router.push('/');

							}
						})
						.catch(error => {
							alert("Username or password are wrong, please try again!sss")
						})
					}
					setTimeout(() => {this.Redirect(response.data.role); }, 20);
				})
				.catch(error => {
				})

		}
	},
});

