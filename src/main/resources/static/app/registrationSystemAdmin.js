Vue.component("registrationSystemAdmin", {
	data: function () {
		return {
			isValid:null,
			password_confirmed:null,
			systemAdminDTO: {
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
				username:null
			},
		}
	},
	mounted() {
	},
	template: 
	`
	<div id="RegistrationSystemAdmin">
    <div class="container">
        <br/><h2 class="text122">System Admin Registration</h2>
		<br><br><br>
		<table class="t">
			<colgroup>
                 <col style="width: 50%;">
                 <col style="width: 50%;">
            </colgroup>
			<tr>
				<td><label>Name</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="systemAdminDTO.name"/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
			</tr>
			<tr>
				<td><label>Surname</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="systemAdminDTO.surname"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{surnameValidation}}</td>
			</tr>
			<tr>
				<td><label>Address</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="systemAdminDTO.address"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{addressValidation}}</td>
				<td></td>
			</tr>
			<tr>
				<td><label>City</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="systemAdminDTO.city"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{cityValidation}}</td>
			</tr>
			<tr>
				<td><label>State</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="systemAdminDTO.country"/></td><br/>
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
				<td><input type="number" class = "form-control input" v-model="systemAdminDTO.phoneNumber"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
		
			</tr>
			<tr>
				<td><label>Email</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="systemAdminDTO.email"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{mailValidation}}</td>
			</tr>
			<tr>
				<td><label>Username</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="systemAdminDTO.username"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{usernameValidation}}</td>
			</tr>
			<tr>
				<td><label>Password</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="systemAdminDTO.password"/></td><br/>
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
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" v-on:click="AddSystemAdmin(systemAdminDTO)">Submit</button>
			<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

			<br/>
			<br/>
    </div>
    </div>
	`,
	computed : {
		nameValidation: function () {
			if (this.systemAdminDTO.name != undefined && this.systemAdminDTO.name.length > 0) {
				let nameMatch = this.systemAdminDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.systemAdminDTO.name) return 'The name may contain only letters';
				else if (this.systemAdminDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.systemAdminDTO.name === '') return 'Name is a required field';
			else return null;
		},
		surnameValidation: function () {
			if (this.systemAdminDTO.surname != undefined && this.systemAdminDTO.surname.length > 0) {
				let surnameMatch = this.systemAdminDTO.surname.match('[A-Za-z ]*');
				if (surnameMatch != this.systemAdminDTO.surname) return 'The surname may contain only letters';
				else if (this.systemAdminDTO.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
			}
			else if (this.systemAdminDTO.surname === '') return 'Surname is a required field';
			else return null;
		},
		mailValidation: function () {
			if (this.systemAdminDTO.email != undefined && this.systemAdminDTO.email.length > 0) {
				let mailMatch = this.systemAdminDTO.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
				if (mailMatch != this.systemAdminDTO.email) return 'Please insert correct email form';
			}
			else if (this.systemAdminDTO.email === '') return 'Mail name is a required field';
			else return null;
		},
		cityValidation: function () {
			if (this.systemAdminDTO.city != undefined && this.systemAdminDTO.city.length > 0) {
				let cityMatch = this.systemAdminDTO.city.match('[A-Za-z ]*');
				if (cityMatch != this.systemAdminDTO.city) return 'The city may contain only letters';
				else if (this.systemAdminDTO.city[0].match('[A-Z]') === null) return 'The city must begin with a capital letter';
			}
			else if (this.systemAdminDTO.city === '') return 'City is a required field';
			else return null;
		},	
		stateValidation: function () {
			if (this.systemAdminDTO.country != undefined && this.systemAdminDTO.country.length > 0) {
				let countryMatch = this.systemAdminDTO.country.match('[A-Za-z ]*');
				if (countryMatch != this.systemAdminDTO.country) return 'The country may contain only letters';
				else if (this.systemAdminDTO.country[0].match('[A-Z]') === null) return 'The country must begin with a capital letter';
			}
			else if (this.systemAdminDTO.country === '') return 'Country is a required field';
			else return null;
		},
		usernameValidation: function () {
			if (this.systemAdminDTO.username != undefined && this.systemAdminDTO.username.length > 0) {
				let usernameMatch = this.systemAdminDTO.username.match('[A-Za-z1-9 ]*');
				if (usernameMatch != this.systemAdminDTO.username) return 'The username may contain only letters and numbers';
			}
			else if (this.systemAdminDTO.username === '') return 'Username is a required field';
			else return null;
		},
		addressValidation: function () {
			if (this.systemAdminDTO.address != undefined && this.systemAdminDTO.address.length > 0) {
				let addressMatch = this.systemAdminDTO.address.match('[A-Za-z1-9 ]*');
				if (addressMatch != this.systemAdminDTO.address) return 'The address may contain only letters and numbers';
				else if (this.systemAdminDTO.address[0].match('[A-Z]') === null) return 'The address must begin with a capital letter';
			}
			else if (this.systemAdminDTO.address === '') return 'Address is a required field';
			else return null;
		}
    },
	methods: {
		close:function(){
			this.$router.push('systemAdminHomaPage');
		  },
		AddSystemAdmin: function (systemAdminDTO) {
			if(this.password_confirmed!=this.systemAdminDTO.password){
					alert( 'Passwords did not match!');	
					return	
			}else if(this.systemAdminDTO.name==null || this.systemAdminDTO.surname==null || this.systemAdminDTO.address==null || 
				this.systemAdminDTO.city==null || this.systemAdminDTO.country==null || this.systemAdminDTO.phoneNumber==null || 
				this.systemAdminDTO.email==null || this.systemAdminDTO.password==null || this.systemAdminDTO.username==null){
				alert('All fields must be filled!')
				return
			}
			else{
				axios
					.get('/systemAdmin/isUsernameValid/' + systemAdminDTO.username,
						{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})
					.then(response => {
						 this.isValid=response.data;
						 if(this.isValid==false){
							alert('username already exists, please choose another one!')
							return
						}else{
							systemAdminDTO.emailComfirmed=false
							systemAdminDTO.firstTimeLogin=false
							systemAdminDTO.description=""
							
							axios
							.post('/api/saveUserBySystemAdmin' , systemAdminDTO,{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							})
							.then(response => {
								alert("DODAT U BAZU user");
								axios
								.post('/systemAdmin/saveSystemAdmin' , systemAdminDTO,{
									headers: {
										'Authorization': 'Bearer' + " " + localStorage.getItem('token')
									}
								})
								.then(response => {
									alert("DODAT U BAZU systemAdmin");
									this.$router.push('systemAdminHomaPage');

								})
		
								.catch(error => {
									
									alert("GRESKAA");
								})
							})
						}
					})
					.catch(error => {
						alert("GRESKA");
					})
				
			}
		},
	},
});