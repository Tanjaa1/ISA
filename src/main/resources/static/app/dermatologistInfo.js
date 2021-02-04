Vue.component("dermatologistInfo", {
	data: function () {
		return {
			dermatologist: null,
			idDermatologist: ""
		}
	},
	beforeMount() {
			axios
			.get('/dermatologist/getDermatologistById/' + '6') 
			.then(response => {
				this.dermatologist = response.data
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div id=""></br>

<!-- Registration Info -->
							<h3 class="pi">Personal information</h3>
							<button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="ChangeAccountInfoShow()">Update informations</button>
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.name" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.surname" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.address" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">City</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.city" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Country</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.country" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Phone number</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.phoneNumber" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Email</span>
							 </div>
							  <input type="text" v-model="this.dermatologist.email" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Pharmacy</span>
							  </div>
							  <input type="text" v-model="this.dermatologist.pharmacies" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>	
	<!--END registration info modal-->

	</div>

	`,
	methods:{
		ChangeAccountInfoShow: function () {
			this.$router.push('changeDermatologistInfo');
		}
	}
});




Vue.component("changeDermatologistInfo", {
	data: function () {
		return {
			dermatologist: null,
			dermatologistUpdated:{},
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
			emailComfirmed:null,
			firstTimeLogin:null,
			pharmacies:null

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
			})
			.catch(error => {
			})
	}
		,
	template: `
	<div id=""></br>

<!-- Registration Info -->
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

							  </div>
							  <div class="input-group mb-3">
							  <div class="input-group-prepend">
								 <span class="input-group-text width" id="basic-addon3">Pharmacy</span>
							  </div>
							   <input type="text" v-model="pharmacies" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>			 
								 <td>&nbsp&nbsp&nbsp</td>
 
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

			axios.post('/dermatologist/update', this.dermatologistUpdated)
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
