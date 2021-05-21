Vue.component("registrationSupplier", {
	data: function () {
		return {
			password_confirmed:null,
			supplierDTO: {
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
				penalty: null,
				description:null
			},
		}
	},
	mounted() {
	},
	template: 
	`
	<div id="RegistrationSupplier">
    <div class="container">
        <br/><h2 class="text5551"> Supplier Registration</h2>
		<br><br><br>
		<table class="t">
			<colgroup>
                 <col style="width: 50%;">
                 <col style="width: 50%;">
            </colgroup>
			<tr>
				<td><label>Name</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="supplierDTO.name"/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
			</tr>
			<tr>
				<td><label>Surname</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="supplierDTO.surname"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{surnameValidation}}</td>
			</tr>
			<tr>
				<td><label>Address</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="supplierDTO.address"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{addressValidation}}</td>
				<td></td>
			</tr>
			<tr>
				<td><label>City</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="supplierDTO.city"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td align="left" style="color: red;font-size:12px">{{cityValidation}}</td>
			</tr>
			<tr>
				<td><label>State</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="supplierDTO.country"/></td><br/>
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
				<td><input type="number" class = "form-control input" v-model="supplierDTO.phoneNumber"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
		
			</tr>
			<tr>
				<td><label>Email</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="supplierDTO.email"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{mailValidation}}</td>
			</tr>
			<tr>
				<td><label>Username</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="supplierDTO.username"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{usernameValidation}}</td>
			</tr>
			<tr>
				<td><label>Password</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input"  v-model="supplierDTO.password"/></td><br/>
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
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" v-on:click="AddSupplier(supplierDTO)">Submit</button>
			<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

			<br/>
			<br/>
    </div>
    </div>
	`,
	computed : {
		nameValidation: function () {
			if (this.supplierDTO.name != undefined && this.supplierDTO.name.length > 0) {
				let nameMatch = this.supplierDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.supplierDTO.name) return 'The name may contain only letters';
				else if (this.supplierDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.supplierDTO.name === '') return 'Name is a required field';
			else return null;
		},
		surnameValidation: function () {
			if (this.supplierDTO.surname != undefined && this.supplierDTO.surname.length > 0) {
				let surnameMatch = this.supplierDTO.surname.match('[A-Za-z ]*');
				if (surnameMatch != this.supplierDTO.surname) return 'The surname may contain only letters';
				else if (this.supplierDTO.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
			}
			else if (this.supplierDTO.surname === '') return 'Surname is a required field';
			else return null;
		},
		mailValidation: function () {
			if (this.supplierDTO.email != undefined && this.supplierDTO.email.length > 0) {
				let mailMatch = this.supplierDTO.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
				if (mailMatch != this.supplierDTO.email) return 'Please insert correct email form';
			}
			else if (this.supplierDTO.email === '') return 'Mail name is a required field';
			else return null;
		},
		cityValidation: function () {
			if (this.supplierDTO.city != undefined && this.supplierDTO.city.length > 0) {
				let cityMatch = this.supplierDTO.city.match('[A-Za-z ]*');
				if (cityMatch != this.supplierDTO.city) return 'The city may contain only letters';
				else if (this.supplierDTO.city[0].match('[A-Z]') === null) return 'The city must begin with a capital letter';
			}
			else if (this.supplierDTO.city === '') return 'City is a required field';
			else return null;
		},	
		stateValidation: function () {
			if (this.supplierDTO.country != undefined && this.supplierDTO.country.length > 0) {
				let countryMatch = this.supplierDTO.country.match('[A-Za-z ]*');
				if (countryMatch != this.supplierDTO.country) return 'The country may contain only letters';
				else if (this.supplierDTO.country[0].match('[A-Z]') === null) return 'The country must begin with a capital letter';
			}
			else if (this.supplierDTO.country === '') return 'Country is a required field';
			else return null;
		},
		usernameValidation: function () {
			if (this.supplierDTO.username != undefined && this.supplierDTO.username.length > 0) {
				let usernameMatch = this.supplierDTO.username.match('[A-Za-z1-9 ]*');
				if (usernameMatch != this.supplierDTO.username) return 'The username may contain only letters and numbers';
			}
			else if (this.supplierDTO.username === '') return 'Username is a required field';
			else return null;
		},
		addressValidation: function () {
			if (this.supplierDTO.address != undefined && this.supplierDTO.address.length > 0) {
				let usernameMatch = this.supplierDTO.address.match('[A-Za-z1-9 ]*');
				if (usernameMatch != this.supplierDTO.address) return 'The Address may contain only letters and numbers';
				else if (this.supplierDTO.address[0].match('[A-Z]') === null) return 'The address must begin with a capital letter';

			}
			else if (this.supplierDTO.address === '') return 'Address is a required field';
			else return null;
		},
		
    },
	methods: {
		close:function(){
			this.$router.push('systemAdminHomaPage');
		  },
		AddSupplier: function (supplierDTO) {
			if(this.password_confirmed!=this.supplierDTO.password){
					alert( 'Passwords did not match!');	
					return	
			}else if(this.supplierDTO.name==null || this.supplierDTO.surname==null || this.supplierDTO.address==null || 
				this.supplierDTO.city==null || this.supplierDTO.country==null || this.supplierDTO.phoneNumber==null || 
				this.supplierDTO.email==null || this.supplierDTO.password==null){
				alert('All fields must be filled!')
				return
			}else{
				axios
				.get('/supplier/isUsernameValid/'+ supplierDTO.username,{
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
						supplierDTO.emailComfirmed=false
						supplierDTO.firstTimeLogin=false
						supplierDTO.points=0
						supplierDTO.penalty=0
						supplierDTO.description="/"
					
						axios
							.post('/api/saveUserBySupplier' , supplierDTO,{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							})
							.then(response => {
								alert("DODAT U BAZU user");
								axios
								.post('/supplier/saveSupplier' , supplierDTO,{
									headers: {
										'Authorization': 'Bearer' + " " + localStorage.getItem('token')
									}
								})
								.then(response => {
									alert("DODAT U BAZU supplier");
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