

Vue.component("administratorEmployed", {
	data: function () {
		return {
			reason : "",
			vacationIntervals : [],
			selectedEmployee : {},
            existingDermatologist : {},
			existingPharmacist : {},
			passwordSame : false,
			administrator: {},
            pharmacy: {},
			dermatologistWT : {},
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
			newPharmacist : {
				vacationSchedule : [],
				workingSchedule : [],
				pharmacy : {},
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
			unemployedPharmacists : [],
			pharmacistWT : {},
			WT : {
				date : "",
				id : null,
				pharmacy : {},
				endTime : "",
				startTime : "",
			}
		}
	},
	mounted() {
		axios
			.get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.administrator = response.data
				axios
				.get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.pharmacy = response.data
					this.newDermatologist.pharmacies.push(response.data)
					this.newPharmacist.pharmacy = response.data

					axios
					.get('/vacation/getByPharmacy/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.vacationIntervals = response.data
					})

					axios
					.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.pharmacists = response.data
						this.allPharmacists = response.data
					})
					.catch(error => {
					})
					axios
					.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.dermatologists = response.data
						this.allDermatologists = response.data
					})
					.catch(error => {
					})
					axios
					.get('/dermatologist/getUnemployedDermatolgoists/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.unemployedDermatologists = response.data
					})
					.catch(error => {
					})
					axios
					.get('/pharmacist/getUnemployedPharmacists/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.unemployedPharmacists = response.data
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
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr v-for = "(pharmacist) in pharmacists">
					<td scope="row">{{pharmacist.id}}</td>
					<td>{{pharmacist.name}}</td>
					<td>{{pharmacist.surname}}</td>
					<td v-if = "pharmacist.grade != null">{{pharmacist.grade}}</td>
					<td v-else>N/A</td>
					<td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SelectPharmacistWT(pharmacist)" data-toggle="modal" data-target="#addWorktimePharmacist"><i class="fa fa-calendar"></i></button>
					<button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="DeletePharmacist(pharmacist)" data-toggle="modal" data-target="#"><i class="fa fa-trash"></i></button>
					<button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetRequests(pharmacist)" data-toggle="modal" data-target="#vacationRequestsPharmacist"><i class="fa fa-bed"></i></button>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="input-group mb-3" style = "width : 80%; margin-left:15%">
			<div><input id="pharmacistName" placeholder="Filter by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><input id="pharmacistSurname" placeholder="Filter by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div ><input id="pharmacistId" placeholder="Filter by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div ><input @change = "ValidateGradeP()" id="pharmacistMin" placeholder="Min rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div ><input @change = "ValidateGradeP()" id="pharmacistMax" placeholder="Max rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>

			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchPharmacists()"><i class="fa fa-search"></i></button></div> &nbsp
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetPharmacistsSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
			<div><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addPharmacistModal"><i class="fa fa-user-plus"></i></button></div> &nbsp
			<div><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addExistingPharmacist"><i class="fa fa-plus-square"></i></button></div> &nbsp
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
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<tr v-for = "(dermatologist) in dermatologists">
							<td scope="row">{{dermatologist.id}}</td>
							<td>{{dermatologist.name}}</td>
							<td>{{dermatologist.surname}}</td>
							<td v-if = "dermatologist.grade != null">{{dermatologist.grade}}</td>
							<td v-else>N/A</td>
							<td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SelectDermatologistWT(dermatologist)" data-toggle="modal" data-target="#addWorktimeDermatolgist"><i class="fa fa-calendar"></i></button>
							<button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="DeleteDermatologist(dermatologist)" data-toggle="modal" data-target="#"><i class="fa fa-trash"></i></button>
							<button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetRequests(dermatologist)" data-toggle="modal" data-target="#vacationRequests"><i class="fa fa-bed"></i></button>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="input-group mb-3" style = "width : 80%; margin-left:15%">
					<div><input id="dermatologistName" placeholder="Filter by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div><input id="dermatologistSurname" placeholder="Filter by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input id="dermatologistId" placeholder="Filter by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input @change = "ValidateGradeD()" id="dermatologistMin" placeholder="Min rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input @change = "ValidateGradeD()" id="dermatologistMax" placeholder="Max rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		

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
			
			  <!-- Add Pharmacist modal -->
				<div class="modal fade" id="addPharmacistModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-dialog-scrollable" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Add new pharmacist</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								 <div class="form-group">
								   <label for="recipient-name" min="0" class="col-form-label">Username:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.username">
								 </div>
								<div class="form-group">
									<label for="recipient-name" class="col-form-label">Name:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.name">
								</div>	
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Surname:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.surname">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">E-mail:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.email">
								  </div>
								<div class="form-group">
								  <label for="recipient-name" min="0" class="col-form-label">City:</label>
								  <input type="text" min = "0"class="form-control"  v-model="newPharmacist.city">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Country:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.country">
								</div>
								<div class="form-group">
								  <label for="recipient-name" min="0" class="col-form-label">Street:</label>
								  <input type="text" min = "0"class="form-control"  v-model="newPharmacist.address">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Phone number:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.phoneNumber">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Additional info:</label>
									<input type="text" min = "0"class="form-control"  v-model="newPharmacist.description">
								</div>
								<div class="form-group">
									<label for="recipient-name" min="0" class="col-form-label">Password:</label>
									<input type="password" min = "0"class="form-control"  v-model="newPharmacist.password">
								  </div>
								  <span v-if="newPharmacist.repeatPassword != null && passwordSame == false" style = "color : red" class="label">Passwords are not matching</span>
								  <span v-if="newPharmacist.repeatPassword != null && passwordSame == true" style = "color : green" class="label">Passwords are matching</span>
							   <div class="form-group" v-if = "newPharmacist.password == null">
								  <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
								  <input type="passwordPharmacist" min = "0"class="form-control"  v-model="newPharmacist.repeatPassword" disabled>
							   </div>
							   <div class="form-group" v-else>
								   <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
								   <input type="password" min = "0" id = "repeatPasswordPharmacist" class="form-control"  v-model="newPharmacist.repeatPassword" @change = "ValidatePasswordPharmacist()">
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary" v-on:click="NewPharmacist()">Finish</button>
							</div>
						</div>
					</div>
			  </div>
  
			  <!-- Add existing pharmacist -->
			  <div class="modal fade" id="addExistingPharmacist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add existing pharmacist</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div>
						<label for="recipient-name" min="0" class="col-form-label">Select username:</label>
							<select class="form-control" aria-label="Default select example" id = "existingPharmacist" v-model = "existingPharmacist" @change = "SelectExistingPharmacist(existingPharmacist)" >
								<option   v-bind:value="pharmacist" v-for = "pharmacist in unemployedPharmacists" >
									<label>{{pharmacist.name}} {{pharmacist.surname}} - {{pharmacist.username}}</label>
								</option>
							</select>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"  v-on:click="AddExistingPharmacist()">Finish</button>
					</div>
					</div>
				</div>
			  </div>

			  <!-- Add worktime pharmacist -->
			  <div class="modal fade" id="addWorktimePharmacist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add worktime</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set date:</label>
							<div><input id="pharmacistDate"  @change = "compareDate(WT.date)" placeholder="Set date" style = "width : 50% ; margin-left : 25%" type="date" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.date"></div>
						</div>
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set start time:</label>
							<div><input id="pharmacistStart" placeholder="" style = "width : 50%; margin-left : 25%" type="time" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.startTime"></div>
						</div>
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set end time:</label>
							<div><input id="pharmacistEnd" placeholder="" style = "width : 50%; margin-left : 25%" type="time" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.endTime"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"  v-on:click="AddWorktimePharmacist()">Finish</button>
					</div>
					</div>
				</div>
			  </div>

			  <!-- Add worktime dermatologist -->
			  <div class="modal fade" id="addWorktimeDermatolgist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add worktime</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set date:</label>
							<div><input id="dermatolgistDate" @change = "compareDate(WT.date)" placeholder="Set date" style = "width : 50% ; margin-left : 25%" type="date" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.date"></div>
						</div>
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set start time:</label>
							<div><input id="dermatologistStart" placeholder="Set date" style = "width : 50%; margin-left : 25%" type="time" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.startTime"></div>
						</div>
						<div>
							<label for="recipient-name" min="0" class="col-form-label">Set end time:</label>
							<div><input id="dermatologisttEnd" placeholder="Set date" style = "width : 50%; margin-left : 25%" type="time" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" v-model = "WT.endTime"></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary"  v-on:click="AddWorktimeDermatologist()">Finish</button>
					</div>
					</div>
				</div>
			  </div>



		
			  <!-- Vacations requests review -->
			  <div class="modal fade" id="vacationRequests" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
				<div class="modal-content">
				  <div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Vacation requests</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					</button>
				  </div>
				  <div class="modal-body">
						  <table class="table" style = "width : 50%;  margin-left : 30%;color :  #515a5a ">
							  <thead class="thead-light">
								  <tr>
									  <th scope="col">Start Date</th>
									  <th scope="col">End Date</th>	
									  <th scope="col"></th>
									  <th scope="col"></th>		  	  	  	  
								  </tr>
							  </thead>
							  <tbody>
								  <tr v-for = "(vacation) in vacationIntervals"  >
									  <td ><div >{{vacation.dateStart}}</div></td>				
									  <td ><div >{{vacation.dateEnd}}</div></td>				
									  <td ><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="AcceptRequestDermatologist(vacation)" data-toggle="modal" data-target="#"><i class="fa fa-check"></i></button></td>
									  <td ><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="RejectRequestDermatologist(vacation)" data-toggle="modal" data-target="#"><i class="fa fa-times-circle"></i></button></td>		
								  </tr>
							  </tbody>
						  </table>
						  <div class="form-group">
						  	<label for="exampleInputPassword1">Reason for rejecting (enter only when rejecting)</label>
						  	<input type="text" class="form-control" v-model="reason" id="exampleInputPassword1" placeholder="">
						</div>
				  </div>
				  
				  <div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				  </div>
				</div>
			  </div>
			</div>

			<!-- Vacations requests review -->
			<div class="modal fade" id="vacationRequestsPharmacist" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
			  <div class="modal-content">
				<div class="modal-header">
				  <h5 class="modal-title" id="exampleModalLabel">Vacation requests</h5>
				  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				  </button>
				</div>
				<div class="modal-body">
						<table class="table" style = "width : 50%;  margin-left : 30%;color :  #515a5a ">
							<thead class="thead-light">
								<tr>
									<th scope="col">Start Date</th>
									<th scope="col">End Date</th>	
									<th scope="col"></th>
									<th scope="col"></th>		  	  	  	  
								</tr>
							</thead>
							<tbody>
							  <tr v-for = "(vacation) in vacationIntervals"  >
									  <td><div >{{vacation.dateStart}}</div></td>				
									  <td ><div >{{vacation.dateEnd}}</div></td>				
									  <td ><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="AcceptRequestPharmacist(vacation)" data-toggle="modal" data-target="#"><i class="fa fa-check"></i></button></td>
									  <td ><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="RejectRequestPharmacist(vacation)" data-toggle="modal" data-target="#"><i class="fa fa-times-circle"></i></button></td>		
								  </tr>
							</tbody>
						</table>
						<div class="form-group">
							<label for="exampleInputPassword1">Reason for rejecting (enter only when rejecting)</label>
							<input type="text" class="form-control" v-model="reason" id="exampleInputPassword1" placeholder="">
					  	</div>
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
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
				.get('/dermatologist/checkUserAndEmail/' + this.newDermatologist.username + '/' + this.newDermatologist.email,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				})
				.then(response => {
					var responseMessage = response.data
					if(responseMessage.valueOf() == "OK")
						axios
						.post('dermatologist/addNewDermatologistToPharmacy',this.newDermatologist,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response =>{
							axios
							.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							}) 
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
								this.passwordSame = false
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
		ValidateGradeD: function(){
			var minD=document.getElementById("dermatologistMin").value
			var maxD=document.getElementById("dermatologistMax").value

			if(minD > maxD && minD != "" && maxD != ""){
				alert("Maximum rating can't be lower than min")
				document.getElementById("dermatologistMin").value = ""
				document.getElementById("dermatologistMax").value = ""
			}
		},
		ValidateGradeP: function(){
			var minP=document.getElementById("pharmacistMin").value
			var maxP=document.getElementById("pharmacistMax").value

			if(minP > maxP  && minP != "" && maxP != ""){
				alert("Maximum rating can't be lower than min")
				document.getElementById("pharmacistMin").value = ""
				document.getElementById("pharmacistMax").value = ""
			}
		},
		SearchDermatologist: function(){
			this.dermatologists = this.allDermatologists 
			var name=document.getElementById("dermatologistName").value.toLowerCase()
			var surname=document.getElementById("dermatologistSurname").value.toLowerCase()
			var id=document.getElementById("dermatologistId").value

			var min=document.getElementById("dermatologistMin").value
			var max=document.getElementById("dermatologistMax").value

			var newDermatologists = []
			if(name != "" && surname == "" && id == "")
				for (const dermatologist of this.dermatologists) {
						if(dermatologist.name.toLowerCase().includes(name))
							newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname == "" && id == "")
				for (const dermatologist of this.dermatologists) {
							newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname != "" && id == "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.toLowerCase().includes(surname))
						newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname == "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname != "" && id == "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.name.toLowerCase().includes(name) && dermatologist.surname.toLowerCase().includes(surname))
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname == "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.name.toLowerCase().includes(name) && dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name == "" && surname != "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.toLowerCase().includes(surname) &&  dermatologist.id == id)
						newDermatologists.push(dermatologist)
				}
			else if(name != "" && surname != "" && id != "")
				for (const dermatologist of this.dermatologists) {
					if(dermatologist.surname.toLowerCase().includes(surname) &&  dermatologist.id == id && dermatologist.name.toLowerCase().includes(name))
						newDermatologists.push(dermatologist)
				}
			this.dermatologists = newDermatologists

			if(min != "" || max != ""){
				newDermatologists = []
				if(min != "" && max == ""){
					for (const dermatologist of this.dermatologists) {
						if(dermatologist.grade >= min)
							newDermatologists.push(dermatologist)
					}
				}
				else if(min == "" && max != ""){
					for (const dermatologist of this.dermatologists) {
						if(dermatologist.grade <= max)
							newDermatologists.push(dermatologist)
					}
				}
				else if(min != "" && max != ""){
					for (const dermatologist of this.dermatologists) {
						if(dermatologist.grade <= max && dermatologist.grade >= min)
							newDermatologists.push(dermatologist)
					}
				}
				this.dermatologists = newDermatologists
			}
		},
		SearchPharmacists: function(){
			this.pharmacists = this.allPharmacists 
			var name=document.getElementById("pharmacistName").value.toLowerCase()
			var surname=document.getElementById("pharmacistSurname").value.toLowerCase()
			var id=document.getElementById("pharmacistId").value

			var min=document.getElementById("pharmacistMin").value
			var max=document.getElementById("pharmacistMax").value

			var newPharmacists = []
			if(name != "" && surname == "" && id == "")
				for (const pharmacist of this.pharmacists) {
						if(pharmacist.name.toLowerCase().includes(name))
							newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname == "" && id == "")
				for (const pharmacist of this.pharmacists) {
							newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname != "" && id == "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.toLowerCase().includes(surname))
						newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname == "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname != "" && id == "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.name.toLowerCase().includes(name) && pharmacist.surname.toLowerCase().includes(surname))
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname == "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.name.toLowerCase().includes(name) && pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name == "" && surname != "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.toLowerCase().includes(surname) &&  pharmacist.id == id)
						newPharmacists.push(pharmacist)
				}
			else if(name != "" && surname != "" && id != "")
				for (const pharmacist of this.pharmacists) {
					if(pharmacist.surname.toLowerCase().includes(surname) &&  pharmacist.id == id && pharmacist.name.toLowerCase().includes(name))
						newPharmacists.push(pharmacist)
				}
			this.pharmacists = newPharmacists

			
			if(min != "" || max != ""){
				newPharmacists = []
				if(min != "" && max == ""){
					for (const pharmacist of this.pharmacists) {
						if(pharmacist.grade >= min)
							newPharmacists.push(pharmacist)
					}
				}
				else if(min == "" && max != ""){
					for (const pharmacist of this.pharmacists) {
						if(pharmacist.grade <= max)
							newPharmacists.push(pharmacist)
					}
				}
				else if(min != "" && max != ""){
					for (const pharmacist of this.pharmacists) {
						if(pharmacist.grade <= max && pharmacist.grade >= min)
							newPharmacists.push(pharmacist)
					}
				}
				this.pharmacists = newPharmacists
			}
		},
		ResetPharmacistsSearch: function(){
			axios
			.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.pharmacists = response.data
			})
			.catch(error => {
			})
			document.getElementById("pharmacistName").value = ""
			document.getElementById("pharmacistSurname").value = ""
			document.getElementById("pharmacistId").value = ""
			document.getElementById("pharmacistMin").value = ""
			document.getElementById("pharmacistMax").value = ""
		},
		ResetDermatologistSearch: function(){
			axios
			.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.dermatologists = response.data
			})
			.catch(error => {
			})
			document.getElementById("dermatologistName").value = ""
			document.getElementById("dermatologistSurname").value = ""
			document.getElementById("dermatologistId").value = ""
			document.getElementById("dermatologistMin").value = ""
			document.getElementById("dermatologistMax").value = ""
		},
		SelectExistingDermatologist: function(dermatologist){
			this.existingDermatolgoist = dermatologist
		},
		AddExistingDermatologist: function(){
			if(this.existingDermatolgoist != null){
				axios
				.put('/dermatologist/addExistingDermatologistToPharmacy/' + this.existingDermatolgoist.id  + '/' + this.pharmacy.id, this.existingDermatolgoist,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.dermatologists = response.data
					axios
					.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.dermatologists = response.data
						this.allDermatologists = response.data
						$('#addExistingDermatologist').modal('hide');
						axios
						.get('/dermatologist/getUnemployedDermatolgoists/' + this.pharmacy.id,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						}) 
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
		NewPharmacist: function () {
			if(this.passwordSame == true){
				axios
				.get('/pharmacist/checkUserAndEmail/' + this.newPharmacist.username + '/' + this.newPharmacist.email,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				})
				.then(response => {
					var responseMessage = response.data
					if(responseMessage.valueOf() == "OK")
						axios
						.post('pharmacist/addNewPharmacistToPharmacy',this.newPharmacist,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						})
						.then(response =>{
							axios
							.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							}) 
							.then(response => {
								this.pharmacists = response.data
								this.allPharmacists = response.data
								this.newPharmacist.vacationSchedule = []
								this.newPharmacist.workingSchedule = []
								this.newPharmacist.pharmacies = {}
								this.newPharmacist.marks = [] 
								this.newPharmacist.id = null 
								this.newPharmacist.email = null 
								this.newPharmacist.password = null 
								this.newPharmacist.name = null 
								this.newPharmacist.surname = null 
								this.newPharmacist.address = null 
								this.newPharmacist.city = null 
								this.newPharmacist.country = null 
								this.newPharmacist.phoneNumber = null 
								this.newPharmacist.description = null 
								this.newPharmacist.emailComfirmed = false 
								this.newPharmacist.firstTimeLogin = true 
								this.newPharmacist.username = null 
								this.passwordSame = false
								$('#addPharmacistModal').modal('hide');
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
		ValidatePasswordPharmacist : function(){
			var password = document.getElementById("repeatPasswordPharmacist").value
			if(password.valueOf() == this.newPharmacist.password.valueOf())
				this.passwordSame = true
			else
				this.passwordSame = false
		},
		AddExistingPharmacist: function(){
			if(this.existingPharmacist != null){
				axios
				.put('/pharmacist/addExistingPharmacistToPharmacy/' + this.existingPharmacist.id  + '/' + this.pharmacy.id, this.existingPharmacist,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.pharmacist = response.data
					axios
					.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.pharmacists = response.data
						this.allPharmacists = response.data
						$('#addExistingPharmacist').modal('hide');
						axios
						.get('/pharmacist/getUnemployedPharmacists/' + this.pharmacy.id,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						}) 
						.then(response => {
							this.unemployedPharmacists = response.data
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
	compareDate: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.WT.date = null;
            }
        },
	SelectExistingPharmacist: function(pharmacist){
			this.existingPharmacist = pharmacist
		},
	SelectPharmacistWT: function(pharmacist){
			this.pharmacistWT = pharmacist
		},
	AddWorktimePharmacist: function(){
			var startHour = parseInt(this.WT.startTime.split(":")[0])
			var startMinute = parseInt(this.WT.startTime.split(":")[1])
			var endHour = parseInt(this.WT.endTime.split(":")[0])
			var endMinute = parseInt(this.WT.endTime.split(":")[1])
			if(startHour > endHour || startHour == endHour && startMinute > endMinute || startHour == endHour && startMinute == endMinute){
				alert("Please select valid time")
			}
			else{
				if(this.WT.startTime != "" && this.WT.endTime != "" && this.WT.date != ""){
					this.WT.timeStart = this.WT.date + "T" +this.WT.startTime
					this.WT.timeEnd = this.WT.date + "T" + this.WT.endTime
					this.WT.pharmacy = this.pharmacy
					this.pharmacistWT.workingSchedule.push(this.WT)
					axios
					.put('/pharmacist/addWorktimeToPharmacist/' + this.pharmacistWT.id,this.WT,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						if(response.data != false){
							$('#addWorktimePharmacist').modal('hide');
							this.WT.endTime = ""
							this.WT.startTime = ""
							this.WT.timeStart = ""
							this.WT.timeEnd = ""
						}
						else
							alert("Selected time is already taken")
					})
				}
			}
		},
	SelectDermatologistWT: function(dermatologist){
			this.dermatologistWT = dermatologist
		},
	AddWorktimeDermatologist: function(WT){
			var startHour = parseInt(this.WT.startTime.split(":")[0])
			var startMinute = parseInt(this.WT.startTime.split(":")[1])
			var endHour = parseInt(this.WT.endTime.split(":")[0])
			var endMinute = parseInt(this.WT.endTime.split(":")[1])
			if(startHour > endHour || startHour == endHour && startMinute > endMinute || startHour == endHour && startMinute == endMinute){
				alert("Please select valid time")
			}
			else{
					if(this.WT.startTime != "" && this.WT.endTime != "" && this.WT.date != ""){
					this.WT.timeStart = this.WT.date + "T" +this.WT.startTime
					this.WT.timeEnd = this.WT.date + "T" + this.WT.endTime
					this.WT.pharmacy = this.pharmacy
					axios
					.put('/dermatologist/addWorktimeToDermatologist/' + this.dermatologistWT.id,this.WT,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						if(response.data != false){
							$('#addWorktimeDermatolgist').modal('hide');
							this.WT.endTime = ""
							this.WT.startTime = ""
							this.WT.timeStart = ""
							this.WT.timeEnd = ""
						}
						else
							alert("Selected time is already taken")
					})
				}
			}
		},
	DeletePharmacist: function(pharmacist){
		axios
			.put('/pharmacist/removeFromPharmacy' + '/' +  pharmacist.id ,pharmacist,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			})
			.then(response=>{
				if(!response.data)
					alert("Pharmacist has upcoming counseling")
				else{
					axios
					.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})
					.then(response => {
						this.pharmacists = response.data
						this.allPharmacists = response.data
					})
					.catch(error => {
					})
				}
			})
		},
	DeleteDermatologist: function(dermatologist){
			axios
				.put('/dermatologist/removeDermatologistFromPharmacy' + '/' +  dermatologist.id + '/' + this.pharmacy.id,dermatologist,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				})
				.then(response=>{
					if(!response.data)
						alert("Dermatologist has upcoming examination")
					else{
						axios
						.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
							headers: {
								'Authorization': 'Bearer' + " " + localStorage.getItem('token')
							}
						}) 
						.then(response => {
							this.dermatologists = response.data
							this.allDermatologists = response.data
						})
						.catch(error => {
					})
				}
			})
		},
		GetRequests : function(employee){
			this.vacationIntervals = []
			for(var vi of employee.vacationSchedule){
				if(vi.pharmacyId == this.pharmacy.id && !vi.approved){
					vi.dateStart = vi.dateStart.split('T')[0]
					vi.dateEnd = vi.dateEnd.split('T')[0]
					this.vacationIntervals.push(vi)
				}
			}
			this.selectedEmployee = employee
		},
		RejectRequestDermatologist : function(request){
			if(this.reason == ""){
				alert("Please state reason and try again")
				return
			}
				request.dateStart = request.dateStart + 'T' + '00:00:00.000+00:00'
				request.dateEnd = request.dateEnd + 'T' + '00:00:00.000+00:00'
				axios
				.delete('/vacation/rejectVacationDermatologist' + '/' + this.selectedEmployee.id + '/' + request.id + '/' + this.reason,{
					data: {
					  source: request
					},
					headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  })
				.then(response => {
					axios
					.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					}) 
					.then(response => {
						this.dermatologists = response.data
						this.allDermatologists = response.data
						this.reason = ""
					})
				})
		},
		RejectRequestPharmacist : function(request){
			if(this.reason == ""){
				alert("Please state reason and try again")
				return
			}
			request.dateStart = request.dateStart + 'T' + '00:00:00.000+00:00'
			request.dateEnd = request.dateEnd + 'T' + '00:00:00.000+00:00'
			axios
			.delete('/vacation/rejectVacationPharmacist' + '/' + this.selectedEmployee.id + '/' + request.id + '/' + this.reason,{
				data: {
				  source: request
				},
				headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
			.then(response => {
				axios
				.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.pharmacists = response.data
					this.allPharmacists = response.data
					this.reason = ""
				})
			})
		},
		AcceptRequestPharmacist : function(request){
			request.dateStart = request.dateStart + 'T' + '00:00:00.000+00:00'
			request.dateEnd = request.dateEnd + 'T' + '00:00:00.000+00:00'
			axios
			.put('/vacation/acceptVacationPharmacist' + '/' + this.selectedEmployee.id + '/' + request.id,this.employee,{
				headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
			.then(response => {
				axios
				.get('/pharmacist/getByPharmacyId/' + this.pharmacy.id,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.pharmacists = response.data
					this.allPharmacists = response.data
				})
			})
		},
		AcceptRequestDermatologist : function(request){
			
			request.dateStart = request.dateStart + 'T' + '00:00:00.000+00:00'
			request.dateEnd = request.dateEnd + 'T' + '00:00:00.000+00:00'
			axios
			.put('/vacation/acceptVacationDermatologist' + '/' + this.selectedEmployee.id + '/' + request.id,this.employee,{
				headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
			.then(response => {
				axios
				.get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				}) 
				.then(response => {
					this.dermatologists = response.data
					this.allDermatologists = response.data
				})
			})
		},
	}
});




