Vue.component("RegistrationPharmacist", {
	data: function () {
		return {
			isValid:null,
			pharmaciesList:{},
			pharmaciesForChoose:[],
			pharmacyName:null,
			password_confirmed:null,
			pharmacistDTO: {
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
			},pharmacyDTO: {
				name: null,
				id: null,
				address:  null
			},
		}
	},beforeMount(){
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
	<div id="RegistrationPharmacist">
    <div class="container">
    		<br><br><br>
    		<br><br><br>
		
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
					<td><input type="text" class = "form-control input" v-model="pharmacistDTO.name"/></td><br/>
				<tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
				</tr>
				<tr>
					<td><label>Surname</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacistDTO.surname"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{surnameValidation}}</td>
				</tr>
				<tr>
					<td><label>Address</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacistDTO.address"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{addressValidation}}</td>
					<td></td>
				</tr>
				<tr>
					<td><label>City</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacistDTO.city"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{cityValidation}}</td>
				</tr>
				<tr>
					<td><label>State</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input" v-model="pharmacistDTO.country"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="left" style="color: red;font-size:12px">{{stateValidation}}</td>
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
					</table>
				<table class="t">
				<tr>
				<tr>
					<td><label>Contact number</label><a class="star">*</a></td>
					<td><input type="number" class = "form-control input" v-model="pharmacistDTO.phoneNumber"/></td><br/>
				</tr>
				<tr>
					<td>&nbsp;</td>
			
				</tr>
				<tr>
					<td><label>Email</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacistDTO.email"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{mailValidation}}</td>
				</tr>
				<tr>
					<td><label>Username</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacistDTO.username"/></td><br/>
				</tr>
				<tr><td>&nbsp;</td>
					 <td align="left" style="color: red;font-size:12px">{{usernameValidation}}</td>
				</tr>
				<tr>
					<td><label>Password</label><a class="star">*</a></td>
					<td><input type="text" class = "form-control input"  v-model="pharmacistDTO.password"/></td><br/>
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
				
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" data-target="#registrationInfo" v-on:click="AddPharmacist(pharmacistDTO,this.pharmaciesList.name)" >Submit</button>
			<br/>
			<br/>


			
    </div>
    </div>
	`,
	computed : {
		nameValidation: function () {
			if (this.pharmacistDTO.name != undefined && this.pharmacistDTO.name.length > 0) {
				let nameMatch = this.pharmacistDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.pharmacistDTO.name) return 'The name may contain only letters';
				else if (this.pharmacistDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.pharmacistDTO.name === '') return 'Name is a required field';
			else return null;
		},
		surnameValidation: function () {
			if (this.pharmacistDTO.surname != undefined && this.pharmacistDTO.surname.length > 0) {
				let surnameMatch = this.pharmacistDTO.surname.match('[A-Za-z ]*');
				if (surnameMatch != this.pharmacistDTO.surname) return 'The surname may contain only letters';
				else if (this.pharmacistDTO.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
			}
			else if (this.pharmacistDTO.surname === '') return 'Surname is a required field';
			else return null;
		},
		mailValidation: function () {
			if (this.pharmacistDTO.email != undefined && this.pharmacistDTO.email.length > 0) {
				let mailMatch = this.pharmacistDTO.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
				if (mailMatch != this.pharmacistDTO.email) return 'Please insert correct email form';
			}
			else if (this.pharmacistDTO.email === '') return 'Mail name is a required field';
			else return null;
		},
		cityValidation: function () {
			if (this.pharmacistDTO.city != undefined && this.pharmacistDTO.city.length > 0) {
				let cityMatch = this.pharmacistDTO.city.match('[A-Za-z ]*');
				if (cityMatch != this.pharmacistDTO.city) return 'The city may contain only letters';
				else if (this.pharmacistDTO.city[0].match('[A-Z]') === null) return 'The city must begin with a capital letter';
			}
			else if (this.pharmacistDTO.city === '') return 'City is a required field';
			else return null;
		},	
		stateValidation: function () {
			if (this.pharmacistDTO.country != undefined && this.pharmacistDTO.country.length > 0) {
				let countryMatch = this.pharmacistDTO.country.match('[A-Za-z ]*');
				if (countryMatch != this.pharmacistDTO.country) return 'The country may contain only letters';
				else if (this.pharmacistDTO.country[0].match('[A-Z]') === null) return 'The country must begin with a capital letter';
			}
			else if (this.pharmacistDTO.country === '') return 'Country is a required field';
			else return null;
		},
		usernameValidation: function () {
			if (this.pharmacistDTO.username != undefined && this.pharmacistDTO.username.length > 0) {
				let usernameMatch = this.pharmacistDTO.username.match('[A-Za-z1-9 ]*');
				if (usernameMatch != this.pharmacistDTO.username) return 'The username may contain only letters and numbers';
			}
			else if (this.pharmacistDTO.username === '') return 'Username is a required field';
			else return null;
		},
		addressValidation: function () {
			if (this.pharmacistDTO.address != undefined && this.pharmacistDTO.address.length > 0) {
				let addressMatch = this.pharmacistDTO.address.match('[A-Za-z1-9 ]*');
				if (addressMatch != this.pharmacistDTO.address) return 'The address may contain only letters and numbers';
				else if (this.pharmacistDTO.address[0].match('[A-Z]') === null) return 'The address must begin with a capital letter';
			}
			else if (this.pharmacistDTO.address === '') return 'Address is a required field';
			else return null;
		}
    },
	methods: {
		AddPharmacist: function (pharmacistDTO,pharmaciesList) {
			if (this.pharmacistDTO.name!=null || this.pharmacistDTO.surname!=null || this.pharmacistDTO.address!=null || 
				this.pharmacistDTO.city!=null || this.pharmacistDTO.country!=null || this.pharmacistDTO.phoneNumber!=null || 
				this.pharmacistDTO.email!=null || this.pharmacistDTO.password!=null || this.pharmacistDTO.username!=null) 
				{
					alert(pharmaciesList)
					axios
					.get('/pharmacy/getByName/'+pharmaciesList)
					.then(response => {
						this.pharmacyDTO=response.data
						alert("pronadjena");
					})

					.catch(error => {
						
						alert("GRESKA");
					})
				axios
					.get('/pharmacist/isUsernameValid/' + pharmacistDTO.username)
					.then(response => {
						this.isValid=response.data;
						if(this.isValid==false){
							alert('username  already exists, please choose another one!')
							return	
						}else{
						
									pharmacistDTO.emailComfirmed=false
									pharmacistDTO.firstTimeLogin=false
									pharmacistDTO.description=""
									pharmacistDTO.pharmacy=this.pharmacyDTO
									//yythis.pharmacyName=pharmaciesList
										
									axios
										.post('/pharmacist/savePharmacist' , pharmacistDTO)
										.then(response => {

											alert("Apotekar  U BAZi");
										})
										.catch(error => {		
											alert("GRESKA");
										})
							}
						})
						.catch(error => {	
							alert("greska");
							})
                        }
                  else 
                    alert("All fields are required.")
                    }   
	},
});