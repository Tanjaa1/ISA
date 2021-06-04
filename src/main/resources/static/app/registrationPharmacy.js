Vue.component("registrationPharmacy", {
	data: function () {
		return {
			isValidPharmacy:null,
			isValid:null,
			password_confirmed:null,
			pharmacyDTO: {
				name: null,
				id: null,
				address:  null
			},
			pharmacyAdminDTO: {
				id:null,
				name: null,
				surname: null,
				address: null,
				city: null,
				country: null,
				email: null,
				password: null,
				phoneNumber: null,
				emailComfirmed: null,
                firstTimeLogin: null,
                description:null,
				username:null,
				pharmacy:null
			}
		}
	},
	mounted() {
	},
	template: 
	`
	<div id="RegistrationPharmacy">
    <div class="container">
    		<br><br><br>
    		<br><br><br>
    
        <br/><h2 class="text1777">Pharmacy registration</h2>
		<br><br><br>
		<table class="t">
			<tr>
				<td><label>Name</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="pharmacyDTO.name"/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{nameValidationPharmacy}}</td>
			</tr>
		</table>
		<table class="t">
			<tr>
				<td><label>Address</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="pharmacyDTO.address"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{addressValidationPharmacy}}</td>
			</tr>
		</table>

			<br></br>
			<br></br>
			<br></br>
			<br></br>

			
			<br/><h2 class="text122">Pharmacy Admin Registration</h2>
			<br><br><br>
			<table class="t">
				<colgroup>
					 <col style="width: 50%;">
					 <col style="width: 50%;">
				</colgroup>
				<tr>
					<td><label>Name</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacyAdminDTO.name"/></td><br/>
				<tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
				</tr>
				<tr>
					<td><label>Surname</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacyAdminDTO.surname"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{surnameValidation}}</td>
				</tr>
				<tr>
					<td><label>Address</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacyAdminDTO.address"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{addressValidation}}</td>
					<td></td>
				</tr>
				<tr>
					<td><label>City</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacyAdminDTO.city"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{cityValidation}}</td>
				</tr>
				<tr>
					<td><label>State</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacyAdminDTO.country"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{stateValidation}}</td>
				</tr>
			</table>
				<table class="t">
				<tr>
				<tr>
					<td><label>Contact number</label><a class="star">*</a></td>
					<td><input type="number" class = "form-control input" v-model="pharmacyAdminDTO.phoneNumber"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{numberValidation}}</td>

				</tr>
				<tr>
					<td><label>Email</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacyAdminDTO.email"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{mailValidation}}</td>
				</tr>
				<tr>
					<td><label>Username</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacyAdminDTO.username"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{usernameValidation}}</td>
				</tr>
				<tr>
					<td><label>Password</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacyAdminDTO.password"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
				</tr>
				<tr>
					<td><label>Password</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="password_confirmed"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
	
				</tr>
				</table>
				
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" data-target="#registrationInfo" v-on:click="AddPharmacy(pharmacyDTO,pharmacyAdminDTO)" >Submit</button>
			<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

			<br/>
			<br/>


			
    </div>
    </div>
	`,
	computed : {
		nameValidationPharmacy: function () {
			if (this.pharmacyDTO.name != undefined && this.pharmacyDTO.name.length > 0) {
				let nameMatch = this.pharmacyDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.pharmacyDTO.name) return 'The name may contain only letters';
				else if (this.pharmacyDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.pharmacyDTO.name === '') return 'Name is a required field';
			else return null;
		},
		addressValidationPharmacy: function () {
			if (this.pharmacyDTO.address != undefined && this.pharmacyDTO.address.length > 0) {
				let surnameMatch = this.pharmacyDTO.address.match('[A-Za-z0-9 ]*');
				if (surnameMatch != this.pharmacyDTO.address) return 'The Address may contain only letters and numbers';
				else if (this.pharmacyDTO.address[0].match('[A-Z]') === null) return 'The Address must begin with a capital letter';
			}
			else if (this.pharmacyDTO.address === '') return 'Address is a required field';
			else return null;
		},



		nameValidation: function () {
			if (this.pharmacyAdminDTO.name != undefined && this.pharmacyAdminDTO.name.length > 0) {
				let nameMatch = this.pharmacyAdminDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.pharmacyAdminDTO.name) return 'The name may contain only letters';
				else if (this.pharmacyAdminDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.pharmacyAdminDTO.name === '') return 'Name is a required field';
			else return null;
		},
		surnameValidation: function () {
			if (this.pharmacyAdminDTO.surname != undefined && this.pharmacyAdminDTO.surname.length > 0) {
				let surnameMatch = this.pharmacyAdminDTO.surname.match('[A-Za-z ]*');
				if (surnameMatch != this.pharmacyAdminDTO.surname) return 'The surname may contain only letters';
				else if (this.pharmacyAdminDTO.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
			}
			else if (this.pharmacyAdminDTO.surname === '') return 'Surname is a required field';
			else return null;
		},
		mailValidation: function () {
			if (this.pharmacyAdminDTO.email != undefined && this.pharmacyAdminDTO.email.length > 0) {
				let mailMatch = this.pharmacyAdminDTO.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
				if (mailMatch != this.pharmacyAdminDTO.email) return 'Please insert correct email form';
			}
			else if (this.pharmacyAdminDTO.email === '') return 'Mail name is a required field';
			else return null;
		},
		cityValidation: function () {
			if (this.pharmacyAdminDTO.city != undefined && this.pharmacyAdminDTO.city.length > 0) {
				let cityMatch = this.pharmacyAdminDTO.city.match('[A-Za-z ]*');
				if (cityMatch != this.pharmacyAdminDTO.city) return 'The city may contain only letters';
				else if (this.pharmacyAdminDTO.city[0].match('[A-Z]') === null) return 'The city must begin with a capital letter';
			}
			else if (this.pharmacyAdminDTO.city === '') return 'City is a required field';
			else return null;
		},	
		stateValidation: function () {
			if (this.pharmacyAdminDTO.country != undefined && this.pharmacyAdminDTO.country.length > 0) {
				let countryMatch = this.pharmacyAdminDTO.country.match('[A-Za-z ]*');
				if (countryMatch != this.pharmacyAdminDTO.country) return 'The country may contain only letters';
				else if (this.pharmacyAdminDTO.country[0].match('[A-Z]') === null) return 'The country must begin with a capital letter';
			}
			else if (this.pharmacyAdminDTO.country === '') return 'Country is a required field';
			else return null;
		},numberValidation: function () {
			if (this.pharmacyAdminDTO.phoneNumber != undefined && this.pharmacyAdminDTO.phoneNumber.length > 0) {
				if ( this.pharmacyAdminDTO.phoneNumber.length==0 || this.pharmacyAdminDTO.phoneNumber.length<9 || this.pharmacyAdminDTO.phoneNumber.length>11) return 'The number may contain at least 9 digits and max 11 digits';
			}
			else if (this.pharmacyAdminDTO.phoneNumber === '') return 'Number is a required field';
			else return null;
		},
		usernameValidation: function () {
			if (this.pharmacyAdminDTO.username != undefined && this.pharmacyAdminDTO.username.length > 0) {
				let usernameMatch = this.pharmacyAdminDTO.username.match('[A-Za-z1-9 ]*');
				if (usernameMatch != this.pharmacyAdminDTO.username) return 'The username may contain only letters and numbers';
			}
			else if (this.pharmacyAdminDTO.username === '') return 'Username is a required field';
			else return null;
		},
		addressValidation: function () {
			if (this.pharmacyAdminDTO.address != undefined && this.pharmacyAdminDTO.address.length > 0) {
				let addressMatch = this.pharmacyAdminDTO.address.match('[A-Za-z1-9 ]*');
				if (addressMatch != this.pharmacyAdminDTO.address) return 'The address may contain only letters and numbers';
				else if (this.pharmacyAdminDTO.address[0].match('[A-Z]') === null) return 'The address must begin with a capital letter';
			}
			else if (this.pharmacyAdminDTO.address === '') return 'Address is a required field';
			else return null;
		}
    },
	methods: {
		close:function(){
			this.$router.push('systemAdminHomaPage');
		  },
		AddPharmacy: function (pharmacyDTO,pharmacyAdminDTO) {
			if (pharmacyDTO.name != null && pharmacyDTO.address != null || this.pharmacyAdminDTO.name!=null || this.pharmacyAdminDTO.surname!=null || this.pharmacyAdminDTO.address!=null || 
				this.pharmacyAdminDTO.city!=null || this.pharmacyAdminDTO.country!=null || this.pharmacyAdminDTO.phoneNumber!=null || 
				this.pharmacyAdminDTO.email!=null || this.pharmacyAdminDTO.password!=null || this.pharmacyAdminDTO.username!=null) 
				{
				axios
					.get("/pharmacy/isNameValid/" +pharmacyDTO.name,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})
					.then(response => {
						this.isValidPharmacy=response.data;
				axios
					.get('/systemAdmin/isUsernameValid/' + pharmacyAdminDTO.username,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})
					.then(response => {
						this.isValid=response.data;
						if(this.isValid==false || this.isValidPharmacy==false){
							alert('username or pharmacyname already exists, please choose another one!')
							return	
						}else{
							axios
								.post("/pharmacy/savePharmacy", pharmacyDTO,{
									headers: {
										'Authorization': 'Bearer' + " " + localStorage.getItem('token')
									}
								})
								.then(response => {
									alert("Successfully registered pharmacy!");
								})
									.catch(error => {
										alert("Something went wrong,please try again later!");
										this.$router.push('systemAdminHomaPage');

									})
									pharmacyAdminDTO.emailComfirmed=false
									pharmacyAdminDTO.firstTimeLogin=false
									pharmacyAdminDTO.description=""
									pharmacyAdminDTO.pharmacy=pharmacyDTO.name
									
									axios
									.post('/api/saveUserByPharmacyAdmin' , pharmacyAdminDTO,{
										headers: {
											'Authorization': 'Bearer' + " " + localStorage.getItem('token')
										}
									})
									.then(response => {
										axios
										.post('/pharmacyAdmin/savePharmacyAdmin' , pharmacyAdminDTO,{
											headers: {
												'Authorization': 'Bearer' + " " + localStorage.getItem('token')
											}
										})
										.then(response => {
											alert("Successfully registered user");
											this.$router.push('systemAdminHomaPage');
										})
				
										.catch(error => {
											
											alert("Something went wrong,please try again later!");
											this.$router.push('systemAdminHomaPage');

										})
									})
							}
						})
						.catch(error => {	
							alert("Something went wrong,please try again later!");
							this.$router.push('systemAdminHomaPage');

						})
					})
				}
			else 
				alert("All fields are required.");
		},
	},
});