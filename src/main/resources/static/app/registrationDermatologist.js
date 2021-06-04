Vue.component("registrationDermatologist", {
	data: function () {
		return {
			isValid:null,
			pharmaciesList:{},
			password_confirmed:null,
			pharmaciesForChoose:[],
			dermatologistDTO: {
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
				points: null,
				pharmacies:null,
				pharmacyId:null
				
			}
		}
	},
	beforeMount(){
		axios
		.get('/pharmacy/getAll')
		.then(response => {
			this.pharmaciesForChoose = response.data

		})
		.catch(error => {
		})
	},
	mounted() {
	},
	template: 
	`
	<div id="RegistrationDermatologist">
    <div class="container">
        <br/><h2 class="text11"> Dermatologist Registration</h2>
		<br><br><br>
		<table class="t">
			<tr>
				<td><label>Name</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="dermatologistDTO.name"/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
			</tr>
			<tr>
				<td><label>Surname</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="dermatologistDTO.surname"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{surnameValidation}}</td>
			</tr>
			<tr>
				<td><label>Address</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="dermatologistDTO.address"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>			
					<td align="left" style="color: red;font-size:12px">{{addressValidation}}</td>
				<td></td>
			</tr>
			<tr>
				<td><label>City</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="dermatologistDTO.city"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{cityValidation}}</td>
			</tr>
			<tr>
				<td><label>State</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="dermatologistDTO.country"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{stateValidation}}</td>
			</tr>
	
			<tr>
				<td><label>Contact number</label><a class="star">*</a></td>
				<td><input type="number" class = "form-control input" v-model="dermatologistDTO.phoneNumber"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{numberValidation}}</td>

			</tr>
			<tr>
				<td><label>Email</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="dermatologistDTO.email"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{mailValidation}}</td>
			</tr>
			<tr>
				<td><label>Password</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="dermatologistDTO.password"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
			</tr>
			<tr>
				<td><label>Password</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="password_confirmed"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>

			</tr>
			<tr>
				<td><label>Pharmacy</label><a class="star">*</a></td>
				<td><select class="select" v-model="this.pharmaciesList">
				<option disabled selected="selected">Please select one</option>
				<option v-for="p in pharmaciesForChoose" v-bind:value="p">{{p.name}}</option>                                        
		   </select></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
			</tr>
			<tr>
				<td><label>Username</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="dermatologistDTO.username"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{usernameValidation}}</td>
			</tr>
			
			
		</table>
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" v-on:click="AddDermatologist(dermatologistDTO,this.pharmaciesList.id)">Submit</button>
			<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

			<br/>
			<br/>
    </div>
    </div>
	`,
	computed : {nameValidation: function () {
		if (this.dermatologistDTO.name != undefined && this.dermatologistDTO.name.length > 0) {
			let nameMatch = this.dermatologistDTO.name.match('[A-Za-z ]*');
			if (nameMatch != this.dermatologistDTO.name) return 'The name may contain only letters';
			else if (this.dermatologistDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
		}
		else if (this.dermatologistDTO.name === '') return 'Name is a required field';
		else return null;
	},
	surnameValidation: function () {
		if (this.dermatologistDTO.surname != undefined && this.dermatologistDTO.surname.length > 0) {
			let surnameMatch = this.dermatologistDTO.surname.match('[A-Za-z ]*');
			if (surnameMatch != this.dermatologistDTO.surname) return 'The surname may contain only letters';
			else if (this.dermatologistDTO.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
		}
		else if (this.dermatologistDTO.surname === '') return 'Surname is a required field';
		else return null;
	},
	mailValidation: function () {
		if (this.dermatologistDTO.email != undefined && this.dermatologistDTO.email.length > 0) {
			let mailMatch = this.dermatologistDTO.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
			if (mailMatch != this.dermatologistDTO.email) return 'Please insert correct email form';
		}
		else if (this.dermatologistDTO.email === '') return 'Mail name is a required field';
		else return null;
	},
	cityValidation: function () {
		if (this.dermatologistDTO.city != undefined && this.dermatologistDTO.city.length > 0) {
			let cityMatch = this.dermatologistDTO.city.match('[A-Za-z ]*');
			if (cityMatch != this.dermatologistDTO.city) return 'The city may contain only letters';
			else if (this.dermatologistDTO.city[0].match('[A-Z]') === null) return 'The city must begin with a capital letter';
		}
		else if (this.dermatologistDTO.city === '') return 'City is a required field';
		else return null;
	},	
	numberValidation: function () {
		if (this.dermatologistDTO.phoneNumber != undefined && this.dermatologistDTO.phoneNumber.length > 0) {
			if ( this.dermatologistDTO.phoneNumber.length==0 || this.dermatologistDTO.phoneNumber.length<9 || this.dermatologistDTO.phoneNumber.length>11) return 'The number may contain at least 9 digits and max 11 digits';
		}
		else if (this.dermatologistDTO.name === '') return 'Number is a required field';
		else return null;
	},
	stateValidation: function () {
		if (this.dermatologistDTO.country != undefined && this.dermatologistDTO.country.length > 0) {
			let countryMatch = this.dermatologistDTO.country.match('[A-Za-z ]*');
			if (countryMatch != this.dermatologistDTO.country) return 'The country may contain only letters';
			else if (this.dermatologistDTO.country[0].match('[A-Z]') === null) return 'The country must begin with a capital letter';
		}
		else if (this.dermatologistDTO.country === '') return 'Country is a required field';
		else return null;
	},
	usernameValidation: function () {
		if (this.dermatologistDTO.username != undefined && this.dermatologistDTO.username.length > 0) {
			let usernameMatch = this.dermatologistDTO.username.match('[A-Za-z1-9 ]*');
			if (usernameMatch != this.dermatologistDTO.username) return 'The username may contain only letters and numbers';
		}
		else if (this.dermatologistDTO.username === '') return 'Username is a required field';
		else return null;
	},addressValidation: function () {
		if (this.dermatologistDTO.address != undefined && this.dermatologistDTO.address.length > 0) {
			let addressMatch = this.dermatologistDTO.address.match('[A-Za-z1-9 ]*');
			if (addressMatch != this.dermatologistDTO.address) return 'The address may contain only letters and numbers';
			else if (this.dermatologistDTO.address[0].match('[A-Z]') === null) return 'The address must begin with a capital letter';
		}
		else if (this.dermatologistDTO.address === '') return 'Address is a required field';
		else return null;
	}
	
},
methods: {
	close:function(){
		this.$router.push('systemAdminHomaPage');
	  },
	AddDermatologist: function (dermatologistDTO,idDe) {
		if(this.password_confirmed!=this.dermatologistDTO.password){
				alert( 'Passwords did not match!');	
				return	
		}else if(this.dermatologistDTO.name==null || this.dermatologistDTO.surname==null || this.dermatologistDTO.address==null || 
			this.dermatologistDTO.city==null || this.dermatologistDTO.country==null || this.dermatologistDTO.phoneNumber==null || 
			this.dermatologistDTO.email==null || this.dermatologistDTO.password==null){
			alert('All fields must be filled!')
			return
		}
		else{
			axios
				.get('/dermatologist/isUsernameValid/' + dermatologistDTO.username,{
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
						dermatologistDTO.emailComfirmed=false
						dermatologistDTO.firstTimeLogin=false
						dermatologistDTO.description="/"
						dermatologistDTO.id="1"
						axios
						.post('/api/saveUserByDermatologist' , dermatologistDTO,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response => {
							axios
							.post('/dermatologist/saveDermatologist/'+idDe , dermatologistDTO,{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							})
							.then(response => {
								alert("Successfully registered user");
								this.$router.push('systemAdminHomaPage');
							})
	
							.catch(error => {
								alert("Something went wrong,please try later");
								this.$router.push('systemAdminHomaPage');
							})
						})
					}
				})

				.catch(error => {
					alert("Something went wrong,please try later");
					this.$router.push('systemAdminHomaPage');
				})			
			}
		}
	},
});