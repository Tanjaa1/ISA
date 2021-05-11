

Vue.component("administratorEmployed", {
	data: function () {
		return {
            existingDermatologist : {},
			passwordSame : false,
			administrator: {},
            pharmacy: {},
			pharmacists : [],
			dermatologists : [],
			selectedDermatologist : {},
			newDermatologist : {
				vacationSchedule : [],
				workingSchedule : [],
				pharmacies : [],
				marks : [] ,
				id : null ,
				email : null ,
				password : null ,
				name : null ,
				surname : null ,
				address : null ,
				city : null ,
				country : null ,
				phoneNumber : null ,
				description : null ,
				emailComfirmed : false ,
				firstTimeLogin : true ,
				username : null 
			},
			allDermatologists : [],
			allPharmacists : [],
			unemployedDermatologists : [],
		}
	},
	beforeMount() {
		axios
			.get('/pharmacyAdmin/getById/' + '8') 
			.then(response => {
				this.administrator = response.data
				axios
				.get('/pharmacy/getByName/' + this.administrator.pharmacy.name) 
				.then(response => {
					this.pharmacy = response.data
					this.newDermatologist.pharmacies.push(response.data)
					axios
					.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id) 
					.then(response => {
						this.pharmacists = response.data
						this.allPharmacists = response.data
					})
					.catch(error => {
					})
					axios
					.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id) 
					.then(response => {
						this.dermatologists = response.data
						this.allDermatologists = response.data
					})
					.catch(error => {
					})
					axios
					.get('/dermatologist/getUnemployedDermatolgoists/' + this.pharmacy.id) 
					.then(response => {
						this.unemployedDermatologists = response.data
					})
					.catch(error => {
					})
				})
				.catch(error => {
				})
			})
			.catch(error => {
			})
	}
    
		,
	template: `
	<div id="administratorEmployed">

		</br>		

		<h1>Pharmacists</h1>

		<!-- Pharmacists -->
		<table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
			<thead class="thead-light">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Surname</th>
					<th scope="col">Avg. rating</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for = "(pharmacist) in pharmacists">
					<td scope="row">{{pharmacist.id}}</td>
					<td>{{pharmacist.name}}</td>
					<td>{{pharmacist.surname}}</td>
					<td>{{pharmacist.grade}}</td>
				</tr>
			</tbody>
		</table>
		<div class="input-group mb-3" style = "width : 80%; margin-left:27%">
			<div><input id="pharmacistName" placeholder="Search by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><input id="pharmacistSurname" placeholder="Search by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div ><input id="pharmacistId" placeholder="Search by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>

			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchPharmacists()"><i class="fa fa-search"></i></button></div> &nbsp
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetPharmacistsSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addDermatologistModal"><i class="fa fa-user-plus"></i></button></div> &nbsp
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addExistingDermatologist"><i class="fa fa-plus-square"></i></button></div> &nbsp
		</div>
		</br>		

		<h1>Dermatologists</h1>

		<!-- Dermatologists -->
		<table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
					<thead class="thead-light">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Name</th>
							<th scope="col">Surname</th>
							<th scope="col">Avg. rating</th>
						</tr>
					</thead>
					<tbody>
						<tr v-for = "(dermatologist) in dermatologists">
							<td scope="row">{{dermatologist.id}}</td>
							<td>{{dermatologist.name}}</td>
							<td>{{dermatologist.surname}}</td>
							<td v-if = "dermatologist.grade != null">{{dermatologist.grade}}</td>
							<td v-else>N/A</td>
						</tr>
					</tbody>
				</table>
				<div class="input-group mb-3" style = "width : 80%; margin-left:27%">
					<div><input id="dermatologistName" placeholder="Search by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div><input id="dermatologistSurname" placeholder="Search by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input id="dermatologistId" placeholder="Search by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>

					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchDermatologist()"><i class="fa fa-search"></i></button></div> &nbsp
					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetDermatologistSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addDermatologistModal"><i class="fa fa-user-plus"></i></button></div> &nbsp
					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addExistingDermatologist"><i class="fa fa-plus-square"></i></button></div> &nbsp
				</div>

				<!-- Add Dermatologist modal -->
				<div class="modal fade" id="addDermatologistModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-scrollable" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Add new dermatologist</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								 <div class="form-group">
								   <label for="recipient-name" min="0" class="col-form-label">Username:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.username">
								 </div>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Name:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.name">
								</div>	
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Surname:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.surname">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">E-mail:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.email">
								  </div>
								<div class="form-group">
								  <label for="recipient-name" min="0" class="col-form-label">City:</label>
								  <input type="text" min = "0"class="form-control"  v-model="newDermatologist.city">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Country:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.country">
								</div>
								<div class="form-group">
								  <label for="recipient-name" min="0" class="col-form-label">Street:</label>
								  <input type="text" min = "0"class="form-control"  v-model="newDermatologist.address">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Phone number:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.phoneNumber">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Additional info:</label>
									<input type="text" min = "0"class="form-control"  v-model="newDermatologist.description">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Password:</label>
									<input type="password" min = "0"class="form-control"  v-model="newDermatologist.password">
								  </div>
								  <span v-if="newDermatologist.repeatPassword != null && passwordSame == false" style = "color : red" class="label">Passwords are not matching</span>
								  <span v-if="newDermatologist.repeatPassword != null && passwordSame == true" style = "color : green" class="label">Passwords are matching</span>
							   <div class="form-group" v-if = "newDermatologist.password == null">
								  <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
								  <input type="password" min = "0"class="form-control"  v-model="newDermatologist.repeatPassword" disabled>
							   </div>
							   <div class="form-group" v-else>
								   <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
								   <input type="password" min = "0" id = "repeatPassword" class="form-control"  v-model="newDermatologist.repeatPassword" @change = "ValidatePassword()">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" v-on:click="NewDermatologist()">Finish</button>
							</div>
						</div>
					</div>
			  </div>
  
			  <!-- Add existing dermatologist -->
			  <div class="modal fade" id="addExistingDermatologist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
				  <div class="modal-content">
				  <div class="modal-header">
					  <h5 class="modal-title" id="exampleModalLabel">Add existing dermatologist</h5>
					  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					  </button>
				  </div>
				  <div class="modal-body">
					  <div>
					  <label for="recipient-name" min="0" class="col-form-label">Select username:</label>
						  <select class="form-control" aria-label="Default select example" id = "existingDermatologist" v-model = "existingDermatologist" @change = "SelectExistingDermatologist(existingDermatologist)" >
							  <option   v-bind:value="dermatologist" v-for = "dermatologist in unemployedDermatologists" >
								  <label>{{dermatologist.name}} {{dermatologist.surname}} - {{dermatologist.username}}</label>
							  </option>
						  </select>
					  </div>
				  </div>
				  <div class="modal-footer">
					  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					  <button type="button" class="btn btn-primary"  v-on:click="AddExistingDermatologist()">Finish</button>
				  </div>
				  </div>
			  </div>
			  </div>

    </div>
	`
	,
	methods:{
		ValidatePassword : function(){
			var password = document.getElementById("repeatPassword").value
			if(password.valueOf() == this.newDermatologist.password.valueOf())
				this.passwordSame = true
			else
				this.passwordSame = false
		},
		NewDermatologist: function () {
			if(this.passwordSame == true){
				axios
				.get('/dermatologist/checkUserAndEmail/' + this.newDermatologist.username + '/' + this.newDermatologist.email)
				.then(response => {
					var responseMessage = response.data
					if(responseMessage.valueOf() == "OK")
						axios
						.post('dermatologist/addNewDermatologistToPharmacy',this.newDermatologist)
						.then(response =>{
							axios
							.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id) 
							.then(response => {
								this.dermatologists = response.data
								this.allDermatologists = response.data
								this.newDermatologist.vacationSchedule = []
								this.newDermatologist.workingSchedule = []
								this.newDermatologist.pharmacies = []
								this.newDermatologist.marks = [] 
								this.newDermatologist.id = null 
								this.newDermatologist.email = null 
								this.newDermatologist.password = null 
								this.newDermatologist.name = null 
								this.newDermatologist.surname = null 
								this.newDermatologist.address = null 
								this.newDermatologist.city = null 
								this.newDermatologist.country = null 
								this.newDermatologist.phoneNumber = null 
								this.newDermatologist.description = null 
								this.newDermatologist.emailComfirmed = false 
								this.newDermatologist.firstTimeLogin = true 
								this.newDermatologist.username = null 
								$('#addDermatologistModal').modal('hide');
							})
							.catch(error => {
							})
						})
					else if(responseMessage.valueOf() == "Username")
						alert("Username is already taken")
					else if(responseMessage.valueOf() == "Email")
						alert("Email is already taken")
				})
				.catch(error => {
				})
			}
		},
		SearchDermatologist: function(){
			this.dermatologists = this.allDermatologists 
			var name=document.getElementById("dermatologistName").value
			var surname=document.getElementById("dermatologistSurname").value
			var id=document.getElementById("dermatologistId").value
			var newDermatologists = []
			if(name != "" && surname == "" && id == "")
				for (const dermatologist of this.dermatologists) {
						if(dermatologist.name.includes(name))
							newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname != "" && id == "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.includes(surname))
						newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname == "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname != "" && id == "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.name.includes(name) && dermatologist.surname.includes(surname))
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname == "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.name.includes(name) && dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname != "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.includes(surname) &&  dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname != "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.includes(surname) &&  dermatologist.id == id && dermatologist.name.includes(name))
						newDermatologists.push(dermatologist)
				}
			this.dermatologists = newDermatologists
		},
		SearchPharmacists: function(){
			this.pharmacists = this.allPharmacists 
			var name=document.getElementById("pharmacistName").value
			var surname=document.getElementById("pharmacistSurname").value
			var id=document.getElementById("pharmacistId").value
			var newPharmacists = []
			if(name != "" && surname == "" && id == "")
				for (const pharmacist of this.pharmacists) {
						if(pharmacist.name.includes(name))
						newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname != "" && id == "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.includes(surname))
						newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname == "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname != "" && id == "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.name.includes(name) && pharmacist.surname.includes(surname))
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname == "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.name.includes(name) && pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname != "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.includes(surname) &&  pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname != "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.includes(surname) &&  pharmacist.id == id && pharmacist.name.includes(name))
						newPharmacists.push(pharmacist)
				}
			this.pharmacists = newPharmacists
		},
		ResetPharmacistsSearch: function(){
			axios
			.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id) 
			.then(response => {
				this.pharmacists = response.data
			})
			.catch(error => {
			})
			document.getElementById("pharmacistName").value = ""
			document.getElementById("pharmacistSurname").value = ""
			document.getElementById("pharmacistId").value = ""
		},
		ResetDermatologistSearch: function(){
			axios
			.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id) 
			.then(response => {
				this.dermatologists = response.data
			})
			.catch(error => {
			})
			document.getElementById("dermatologistName").value = ""
			document.getElementById("dermatologistSurname").value = ""
			document.getElementById("dermatologistId").value = ""
		},
		SelectExistingDermatologist: function(dermatologist){
			this.existingDermatolgoist = dermatologist
		},
		AddExistingDermatologist: function(){
			if(this.existingDermatolgoist != null){
				axios
				.put('/dermatologist/addExistingDermatologistToPharmacy/' + this.existingDermatolgoist.id  + '/' + this.pharmacy.id, this.existingDermatolgoist) 
				.then(response => {
					this.dermatologists = response.data
					axios
					.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id) 
					.then(response => {
						this.dermatologists = response.data
						this.allDermatologists = response.data
						$('#addExistingDermatologist').modal('hide');
						axios
						.get('/dermatologist/getUnemployedDermatolgoists/' + this.pharmacy.id) 
						.then(response => {
							this.unemployedDermatologists = response.data
						})
					})
					.catch(error => {
					})
				})
				.catch(error => {
				})
				this.existingDermatolgoist = null
			}
			else{
				alert("Please select username")
			}

		},
	}
});




