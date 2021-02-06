

Vue.component("patientInfo", {
	data: function () {
		return {
			patient: null,
			idPatient: ""
		}
	},
	beforeMount() {
		/*axios
			.get('/patient/getPatientById', { params: { patientId: localStorage.getItem('userId') } , 
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}).then(response => {
				this.patientDTO = response.data
			})
			.catch(error => {
			})*/
			axios
			.get('/patient/getPatientById/' + '88') 
			.then(response => {
				this.patient = response.data
				//this.patient.category = "patient"
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div id="parmaciesShowPatient"></br>

<!-- Registration Info -->
							<h3 class="pi">Personal information</h3>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="ChangeAccountInfoShow()">Update informations</button>
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text" v-model="this.patient.name" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text" v-model="this.patient.surname" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text" v-model="this.patient.address" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">City</span>
							  </div>
							  <input type="text" v-model="this.patient.city" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Country</span>
							  </div>
							  <input type="text" v-model="this.patient.country" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Phone number</span>
							  </div>
							  <input type="text" v-model="this.patient.phoneNumber" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Email</span>
							 </div>
							  <input type="text" v-model="this.patient.email" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Points</span>
							  </div>
							  <input type="text" v-model="this.patient.points" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Penalty</span>
							  </div>
							  <input type="text" v-model="this.patient.penalty" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Drug allergies</span>
							  </div>
							  <!--<template v-for="p in this.patient.drugAllergies">-->
							  <input type="text" v-model="this.patient.drugAllargies" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							  <!--</template>--> 
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Category</span>
							  </div>
							  <input type="text" v-model="this.patient.category" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3"></span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

							
	
	<!--END registration info modal-->

	</div>

	`,
	methods:{
		ChangeAccountInfoShow: function () {
			this.$router.push('changePatientInfo');
		}
	}
});




Vue.component("changePatientInfo", {
	data: function () {
		return {
			patient: null,
			patientUpdated:{},
			id:null,
			name:null,
			surname:null,
			address:null,
			city:null,
			country:null,
			phoneNumber:null,
			description:null,
			email:null,
			password:null,
			points:null,
			penalty:null,
			drugAllargies:null,
			category:null,
			emailComfirmed:null,
			firstTimeLogin:null

		}
	},
	beforeMount() {
		/*axios
			.get('/patient/getPatientById', { params: { patientId: localStorage.getItem('userId') } , 
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}).then(response => {
				this.patientDTO = response.data
			})
			.catch(error => {
			})*/
			axios
			.get('/patient/getPatientById/' + '88') 
			.then(response => {
				this.patient = response.data
				//this.patient.category = "patient"
				this.id = this.patient.id
				this.name = this.patient.name
				this.surname = this.patient.surname
				this.address = this.patient.address
				this.city =this.patient.city
				this.country = this.patient.country
				this.phoneNumber = this.patient.phoneNumber
				this.email = this.patient.email
				this.password = this.patient.password
				this.points = this.patient.points
				this.penalty = this.patient.penalty
				this.drugAllargies = this.patient.drugAllargies
				this.category = this.patient.category
				this.emailComfirmed = this.patient.emailComfirmed
				this.firstTimeLogin = this.patient.firstTimeLogin
				this.description = this.patient.description
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div id="parmaciesShowPatient"></br>

<!-- Patient Info -->
							<h3 class="pi">Personal information</h3>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="AccountInfoShow()">Back</button>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="AccountInfoChange()">Save changes</button>
							
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text" v-model="name" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text" v-model="surname" class="form-control" id="basic-url" aria-describedby="basic-addon3">
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text" v-model="address" class="form-control" id="basic-url" aria-describedby="basic-addon3">
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">City</span>
							  </div>
							  <input type="text" v-model="city" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Country</span>
							  </div>
							  <input type="text" v-model="country" class="form-control" id="basic-url" aria-describedby="basic-addon3">
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Phone number</span>
							  </div>
							  <input type="text" v-model="phoneNumber" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Email</span>
							 </div>
							  <input type="text" v-model="email" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Points</span>
							  </div>
							  <input type="text" v-model="points" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Penalty</span>
							  </div>
							  <input type="text" v-model="penalty" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Drug allergies</span>
							  </div>
							  <!--<template v-for="p in this.patient.drugAllergies">-->
							  <input type="text" v-model="drugAllargies" class="form-control" id="basic-url" aria-describedby="basic-addon3">
							  <!--</template>--> 
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Category</span>
							  </div>
							  <input type="text" v-model="category" class="form-control" id="basic-url" aria-describedby="basic-addon3">
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3"></span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3">
						</div>

							
	
	<!--END registration info modal-->

	</div>

	`,
	methods:{
		AccountInfoChange: function(){
			this.patientUpdated.id = this.id,
			this.patientUpdated.name = this.name,
			this.patientUpdated.surname = this.surname,
			this.patientUpdated.address = this.address,
			this.patientUpdated.city = this.city,
			this.patientUpdated.country = this.country,
			this.patientUpdated.phoneNumber = this.phoneNumber,
			this.patientUpdated.email = this.email,
			this.patientUpdated.password = this.password,
			this.patientUpdated.points = this.points,
			this.patientUpdated.penalty = this.penalty,
			this.patientUpdated.drugAllargies = this.drugAllargies,
			this.patientUpdated.category = this.category 
			this.patientUpdated.emailComfirmed = this.emailComfirmed
			this.patientUpdated.firstTimeLogin = this.firstTimeLogin
			this.patientUpdated.description = this.description

			axios.post('/patient/update', this.patientUpdated)
				.then(function (response) {
					window.location.href = "#/patientInfo";
				})
				.catch(function (error) {
					alert("error");
				});
		},
		AccountInfoShow: function () {
			this.$router.push('patientInfo');
		}
	}
});
