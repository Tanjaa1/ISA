Vue.component("dermatologistInfo", {
	data: function () {
		return {
			dermatologist: {},
			idDermatologist: "",
			pharmacies:[]
		}
	},
	beforeMount() {
			axios
			.get('/dermatologist/getDermatologistById/' + '6') 
			.then(response => {
				this.dermatologist = response.data
				for(f in this.dermatologist.pharmacies)
					this.pharmacies.push(this.dermatologist.pharmacies[f].name)
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div  class="BackendImagePhysician"></br>

<!-- Registration Info -->
							<h3 class="pi">Personal information</h3>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="ChangeAccountInfoShow()">Update informations</button>
							<button type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" data-target="#Show">Change password</button>
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.name" class="form-control" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.surname" class="form-control" aria-describedby="basic-addon3" disabled>
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.address" class="form-control" aria-describedby="basic-addon3" disabled>
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width">City</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.city" class="form-control" aria-describedby="basic-addon3" disabled>
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width">Country</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.country" class="form-control" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" >Phone number</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.phoneNumber" class="form-control" aria-describedby="basic-addon3" disabled>
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width">Email</span>
							 </div>
							  <input type="text" v-model="this.dermatologist.email" class="form-control" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" >Username</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.username" class="form-control" aria-describedby="basic-addon3" disabled>
							</div> 
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" >Pharmacy</span>
								</div>				
								<input type="text" v-model="this.pharmacies" class="form-control" aria-describedby="basic-addon3" disabled>		  
							</div>
	<!--END registration info modal-->
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
	methods:{
		ChangeAccountInfoShow: function () {
			this.$router.push('changeDermatologistInfo');
		},
		Yes:function(){
			if(document.getElementById("np").value==document.getElementById("cp").value && document.getElementById("np").value.trim()!="" && document.getElementById("cp").value.trim()!=""){
				$('#Show').modal('hide');
				this.dermatologist.password=document.getElementById("np").value
					axios.put('/dermatologist/update', this.dermatologist)
						.then(function (response) {
							$('#Show').modal('hide');
						})
						.catch(function (error) {
						});
			}else{
				alert('Comfire password!')
			}
		}
	}
});




Vue.component("changeDermatologistInfo", {
	data: function () {
		return {
			dermatologist: {},
			dermatologistUpdated:{},
			id:"",
			name:"",
			surname:"",
			address:"",
			city:"",
			country:"",
			phoneNumber:"",
			description:"",
			email:"",
			password:"",
			emailComfirmed:false,
			firstTimeLogin:false,
			pharmacies:[],
			pharmaciesString:[],
			username:""

		}
	},
	beforeMount() {
			axios
			.get('/dermatologist/getDermatologistById/' + '6') 
			.then(response => {
				this.dermatologist = response.data
				this.id = this.dermatologist.id
				this.name = this.dermatologist.name
				this.surname = this.dermatologist.surname
				this.address = this.dermatologist.address
				this.city =this.dermatologist.city
				this.country = this.dermatologist.country
				this.phoneNumber = this.dermatologist.phoneNumber
				this.email = this.dermatologist.email
				this.password = this.dermatologist.password
				this.emailComfirmed = this.dermatologist.emailComfirmed
				this.firstTimeLogin = this.dermatologist.firstTimeLogin
				this.description = this.dermatologist.description
				this.pharmacies=this.dermatologist.pharmacies
				this.username=this.dermatologist.username
				
				for(f in this.dermatologist.pharmacies)
					this.pharmaciesString.push(this.dermatologist.pharmacies[f].name)
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div class="BackendImagePhysician"></br>

<!-- Registration Info -->
							<h3 class="pi">Personal information</h3>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="AccountInfoShow()">Back</button>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="AccountInfoChange()">Save changes</button>
							
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text" v-model="name" class="form-control" aria-describedby="basic-addon3">
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text" v-model="surname" class="form-control" aria-describedby="basic-addon3">
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text" v-model="address" class="form-control" aria-describedby="basic-addon3">
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">City</span>
							  </div>
							  <input type="text" v-model="city" class="form-control aria-describedby="basic-addon3">
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Country</span>
							  </div>
							  <input type="text" v-model="country" class="form-control" aria-describedby="basic-addon3">
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Phone number</span>
							  </div>
							  <input type="text" v-model="phoneNumber" class="form-control" aria-describedby="basic-addon3">
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Email</span>
							 </div>
							  <input type="text" v-model="email" class="form-control" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Username</span>
							 </div>
							  <input type="text" v-model="username" class="form-control" aria-describedby="basic-addon3">			 
								<td>&nbsp&nbsp&nbsp</td>
						</div>
							  <div class="input-group mb-3">
							  <div class="input-group-prepend">
								 <span class="input-group-text width" id="basic-addon3">Pharmacy</span>
							  </div>
							   <input type="text" v-model="pharmaciesString" class="form-control" aria-describedby="basic-addon3" disabled>
							   </div>
	<!--END registration info modal-->

	</div>

	`,
	methods:{
		AccountInfoChange: function(){
			this.dermatologistUpdated.id = this.id,
			this.dermatologistUpdated.name = this.name,
			this.dermatologistUpdated.surname = this.surname,
			this.dermatologistUpdated.address = this.address,
			this.dermatologistUpdated.city = this.city,
			this.dermatologistUpdated.country = this.country,
			this.dermatologistUpdated.phoneNumber = this.phoneNumber,
			this.dermatologistUpdated.email = this.email,
			this.dermatologistUpdated.password = this.password,
			this.dermatologistUpdated.emailComfirmed = this.emailComfirmed
			this.dermatologistUpdated.firstTimeLogin = this.firstTimeLogin
			this.dermatologistUpdated.description = this.description
			this.dermatologistUpdated.username=this.username
			axios.put('/dermatologist/update', this.dermatologistUpdated)
				.then(function (response) {
					window.location.href = "#/dermatologistInfo";
				})
				.catch(function (error) {
					alert("error");
				});
		},
		AccountInfoShow: function () {
			this.$router.push('dermatologistInfo');
		}
	}
});
