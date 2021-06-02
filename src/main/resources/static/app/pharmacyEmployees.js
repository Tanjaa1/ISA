Vue.component("pharmacyEmployees", {
	data: function () {
		return {
            pharmacy : {},
            pharmacists : [],
            dermatologists : [],
            upcomingExaminations : [],
			upcomingCounselings : [],
            patient : {},
			dermatologist : {},
		}
	},
	beforeMount() {
        axios
        .get('/patient/getPatientById/' + localStorage.getItem('userId'),{
			headers: {
				'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		})
        .then(response =>{
            this.patient = response.data
        })

        axios
        .get('/pharmacy/getByName/' + localStorage.getItem('pharmacy'),{
			headers: {
				'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		})
        .then(response =>{
            this.pharmacy = response.data
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
         })
	},
	template: `
	<div id="pharmacyEmployees">
	<div id="mySidenav" class="sidenav d-inline" style = "width : 10%; background-color : GoldenRod; " >
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "HomeShow()">Home</button>
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "MedicineShow()">Reserve medicine</button>
		</div>

		<div  class = "d-inline" style = "">	

 

        <h1></h1>
        <h1>Our pharmacists</h1>
    <h1></h1>
    <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
        <thead class="thead-light">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Avg. rating</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for = "(pharmacist) in pharmacists">
                <td>{{pharmacist.name}}</td>
                <td>{{pharmacist.surname}}</td>
                <td v-if = "pharmacist.grade != null">{{pharmacist.grade}}</td>
                <td v-else>N/A</td>
                <td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetCounselings(pharmacist)" data-toggle="modal" data-target="#pharmacistCounselingModal"><i class="fa fa-calendar"></i></button>
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
    </div>
    
    <h1></h1>
    <h1></h1>

    <h1>Our dermatologists</h1>
    <h1></h1>

    <!-- Dermatologists -->
    <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
                <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Surname</th>
                        <th scope="col">Avg. rating</th>
						<th scope="col">Pharmacies</th>
                        <th scope="col" v-if="patient != null"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for = "(dermatologist) in dermatologists">
                        <td>{{dermatologist.name}}</td>
                        <td>{{dermatologist.surname}}</td>
                        <td v-if = "dermatologist.grade != null">{{dermatologist.grade}}</td>
                        <td v-else>N/A</td>
						<td><div  v-for = "p in dermatologist.pharmacies">{{p.name}}</div></td>
                        <td><button  v-if="patient != null" style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetExaminations(dermatologist)" data-toggle="modal" data-target="#dermatologistExaminationModal"><i class="fa fa-calendar"></i></button></td>
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
            </div>


            <!-- Schedule pharmacist counseling -->
            <div class="modal fade" id="pharmacistCounselingModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
				<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Schedule counseling</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">                        
							<div v-if = "upcomingCounselings.length != 0">
							<table class="table" style = "color :  #515a5a   ">
								<thead class="thead-light">
									<tr>
											<th scope="col">Free Counselings</th>
											<th scope="col">Start time</th>
											<th scope="col">End time</th>
											<th scope="col">Price</th>
											<th  v-if="patient != null" scope="col"></th>
									</tr>
								</thead>
								<tbody>
										<tr v-for = "(counseling,index) in upcomingCounselings">
											<td scope="row">{{index+1}}</td>
											<td>{{counseling.startTime}}</td>
											<td>{{counseling.endTime}}</td>
											<td>{{counseling.price}}</td>
											<td v-if="patient != null"><button style="color:white" type="button" class="btn btn-default"  v-on:click="SchedulePharmacistCounseling(counseling)"  data-target="#">Shedule <i class="fa fa-check"></i></button></td>	
											</tr>
								</tbody>
							</table>
							</div>
							<div v-else>
                                <h1></h1>
                                <h1>No free counselings to schedule please try again later</h1>
							</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
				</div>
			</div>
            </div>

            <!-- Schedule dermatologist appointment -->
            <div class="modal fade" id="dermatologistExaminationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Schedule examination</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">                        
								<div v-if = "upcomingExaminations.length != 0">
								<table class="table" style = "color :  #515a5a   ">
									<thead class="thead-light">
										<tr>
												<th scope="col">Free Appointments</th>
												<th scope="col">Start time</th>
												<th scope="col">End time</th>
												<th scope="col">Price</th>
												<th  v-if="patient != null" scope="col"></th>
										</tr>
									</thead>
									<tbody>
											<tr v-for = "(examination,index) in upcomingExaminations">
												<td scope="row">{{index+1}}</td>
												<td>{{examination.startTime}}</td>
												<td>{{examination.endTime}}</td>
												<td>{{examination.price}}</td>
												<td v-if="patient != null"><button style="color:white" type="button" class="btn btn-default"  v-on:click="ScheduleDermatologistAppointment(examination)"  data-target="#">Shedule <i class="fa fa-check"></i></button></td>	
												</tr>
									</tbody>
								</table>
								</div>
								<div v-else>
                                    <h1></h1>

									<h1>No free examinations to schedule please try again later</h1>
								</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
					</div>
				</div>
            </div>


        </div>
	</div>					
	`,
	methods: {
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
        GetExaminations : function(dermatologist){
			this.dermatologist = dermatologist
			axios
			.get('/examination/getUpcomingFreeExaminations/' + this.pharmacy.id +"/" + dermatologist.id,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			})
			.then(response => {
				this.upcomingExaminations = response.data
                for (var i = 0; i < this.upcomingExaminations.length; i++) {
                    this.upcomingExaminations[i].endTime = this.upcomingExaminations[i].endTime.replace("T", "/");
                    this.upcomingExaminations[i].startTime = this.upcomingExaminations[i].startTime.replace("T", "/");
                  } 
			})
			.catch(error => {
			})
        },
		GetCounselings : function(pharmacist){

			axios
			.get('/counseling/getUpcomingFreeCounselingByPharmacist/' + pharmacist.id,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			})
			.then(response => {
				this.upcomingCounselings = response.data
                for (var i = 0; i < this.upcomingCounselings.length; i++) {
                    this.upcomingCounselings[i].endTime = this.upcomingCounselings[i].endTime.replace("T", "/");
                    this.upcomingCounselings[i].startTime = this.upcomingCounselings[i].startTime.replace("T", "/");
                  } 
			})
			.catch(error => {
			})
        },
        ScheduleDermatologistAppointment : function(examination){
            examination.patient = this.patient
            examination.report = ""		
			examination.dermatologist = this.dermatologist
			examination.endTime = examination.endTime.replace("/", "T");
			examination.startTime = examination.startTime.replace("/", "T");
            axios
			.put('/examination/schedule/' , examination ,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
                var newExaminations = []
                for(var ex of this.upcomingExaminations){
                    if(ex.id != examination.id)
                        newExaminations.push(ex)
                }
                this.upcomingExaminations = newExaminations
            })
			.catch(error => {
			})
        },
		SchedulePharmacistCounseling : function(counseling){
            counseling.patient = this.patient
            counseling.report = ""		
			counseling.endTime = counseling.endTime.replace("/", "T");
			counseling.startTime = counseling.startTime.replace("/", "T");
            axios
			.put('/counseling/update/' , counseling ,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
                var newCounselings = []
                for(var cs of this.upcomingCounselings){
                    if(cs.id != counseling.id)
						newCounselings.push(cs)
                }
                this.upcomingCounselings = newCounselings
            })
			.catch(error => {
			})
        },
        HomeShow : function(){
            this.$router.push('pharmacyHomePage');
        },
        MedicineShow : function(){
            this.$router.push('pharmacyMedicine');
        },
    }
});

