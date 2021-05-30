

Vue.component("reportAdministrator", {
	data: function () {
		return {
            graphs : 1,
            pharmacists : [],
            dermatologists : [],
            administrator : {},
            pharmacy : {},
            report : {
                medicine : {},
                daily : {},
                quartal : {},
                monthly : {},
                yearly : {},
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
            if(this.administrator.firstTimeLogin)
                $("#firstTIme").modal('show') 
            
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
            .then(response =>{
                this.pharmacy = response.data
                localStorage.setItem('pharmacy',this.pharmacy.id)
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

        })
	}
		,
	template: `
	<div id="administratorEmployed">

        <h1></h1>
        <h1></h1>

        <div class="input-group mb-3"  style = "width : 40%; margin-left:30%">

        <div class="input-group-prepend">
            <span class="input-group-text width" id="basic-addon3">Pharmacy</span>
        </div>

        <input type="text" v-model="this.pharmacy.name" class="form-control" id="basic-url" aria-describedby="basic-addon3"  disabled>

        <td>&nbsp&nbsp&nbsp</td>


    </div>

    <div class="input-group mb-3" style = "width : 40%; margin-left:30%">
        <div class="input-group-prepend">
            <span class="input-group-text width" id="basic-addon3">Average grade</span>
        </div>

        <input type="text" v-model="this.pharmacy.grade" class="form-control" id="basic-url" aria-describedby="basic-addon3"  disabled>

        <td>&nbsp&nbsp&nbsp</td>

    </div>

        <button type="button" style = "width: 15%; height:10%;" class="btn btn-info btn-lg " v-on:click="Medicine()">Medicine reports</button>&nbsp
        <button type="button" style = "width: 15%;height: 15%;" class="btn btn-info btn-lg " v-on:click="Examination()">Examiantion reports</button>&nbsp
        <button type="button" style = "width: 15%;height: 15%;" class="btn btn-info btn-lg " v-on:click="Revenue()">Revenue reports</button>&nbsp

      <h1></h1>

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
					<td v-if = "pharmacist.grade != null">{{pharmacist.grade}}</td>
					<td v-else>N/A</td>
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
				<div class="input-group mb-3" style = "width : 80%; margin-left:15%">
					<div><input id="dermatologistName" placeholder="Filter by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div><input id="dermatologistSurname" placeholder="Filter by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input id="dermatologistId" placeholder="Filter by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input @change = "ValidateGradeD()" id="dermatologistMin" placeholder="Min rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
					<div ><input @change = "ValidateGradeD()" id="dermatologistMax" placeholder="Max rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		

					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchDermatologist()"><i class="fa fa-search"></i></button></div> &nbsp
					<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetDermatologistSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
				</div>
    
	</div>			



	`
	,
	methods:{
        Medicine : function(){
            this.$router.push('reportMedicine');
        },
        Examination : function(){
            this.$router.push('reportExamination');
        },
        Revenue : function(){
            this.$router.push('reportRevenue');
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

            },
           
});




