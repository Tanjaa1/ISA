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
			})
			axios
			.get('/patient/getPatientById', { params: { id: '1' } }) 
			.then(response => {
				this.patient = response.data
				alert(this.patient)
			})
			.catch(error => {
			})*/
	}
		,
	template: `
	<div id="Account"></br>

<!-- Registration Info -->
	<c:url var="patient" value="/patient/getPatientById/{1}" />
							<h3 class="pi">Personal information</h3>
							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Name</span>
							  </div>
							  <input type="text"  class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Surname</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							</div>

							

						

						<div class="input-group mb-3">
							  <div class="input-group-prepend ">
								<span class="input-group-text width" id="basic-addon3">Address</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
							<td>&nbsp&nbsp&nbsp</td>
							
							<div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">City</span>
							  </div>
							  <input type="text"  class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Country</span>
							  </div>
							  <input type="text"  class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>


							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Phone number</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

						<div class="input-group mb-3">
							 <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Email</span>
							 </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
					
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Points</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Penalty</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Drug allergies</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

							<div class="input-group mb-3">
							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3">Category</span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						
								<td>&nbsp&nbsp&nbsp</td>

							  <div class="input-group-prepend">
								<span class="input-group-text width" id="basic-addon3"></span>
							  </div>
							  <input type="text"   class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
						</div>

							
	
	<!--END registration info modal-->

	</div>

	`
});
