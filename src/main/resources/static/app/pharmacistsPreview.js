Vue.component("pharmacistsPreview", {
	data: function () {
		return {
            pharmacists:[],
            pharmacies:{},
            allPharmacists : {},
            filterInfo:{
                pharmacy : null,
                minRating : null,
                maxRating : null,
                name : null,
                surname : null
            },
            displayedPharmacists : {}
		}
	},
	beforeMount() {
        axios.get('/pharmacist/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.pharmacists = response.data
                this.allPharmacists = response.data
                
            })
     axios.get('/pharmacy/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.pharmacies = response.data
            })     
            
    },
    mounted(){
    },
	template: `
        <div id="pharmacyEmployees">		
        <h1></h1>
        <h1>Our pharmacists</h1>
        <h1></h1>
        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
        <thead class="thead-light">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Avg. rating</th>
                <th scope="col">Pharmacy</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for = "(pharmacist) in pharmacists">
                <td>{{pharmacist.name}}</td>
                <td>{{pharmacist.surname}}</td>
                <td v-if = "pharmacist.grade != null">{{pharmacist.grade}}</td>
                <td v-else>N/A</td>
                <td >{{pharmacist.pharmacy.name}}</td>
                </td>
            </tr>
        </tbody>
    </table>
    <div class="input-group mb-3" style = "width : 80%; margin-left:12%">
    <div><input id="pharmacistName" placeholder="Filter by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
    <div><input id="pharmacistSurname" placeholder="Filter by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
    <div ><input id="pharmacistId" placeholder="Filter by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
    <div><input id="pharmacistPharmacy" placeholder="Filter by  pharmacy" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
    <div ><input @change = "ValidateGradeP()" id="pharmacistMin" placeholder="Min rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
    <div ><input @change = "ValidateGradeP()" id="pharmacistMax" placeholder="Max rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>

    <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchPharmacists()"><i class="fa fa-search"></i></button></div> &nbsp
    <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetPharmacistsSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
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
		SearchPharmacists: function(){
			this.pharmacists = this.allPharmacists 
			var name=document.getElementById("pharmacistName").value.toLowerCase()
			var surname=document.getElementById("pharmacistSurname").value.toLowerCase()
			var id=document.getElementById("pharmacistId").value

			var min=document.getElementById("pharmacistMin").value
			var max=document.getElementById("pharmacistMax").value

			var pharmacy=document.getElementById("pharmacistPharmacy").value.toLowerCase()

			var newPharmacists = []

            if(pharmacy != ''){
                for (const pharmacist of this.pharmacists) {
                    if(pharmacist.pharmacy.name.toLowerCase().includes(pharmacy))
                        newPharmacists.push(pharmacist)
                }
                this.pharmacists = newPharmacists

            }

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
			.get('/pharmacist/getAll',{
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
            document.getElementById("pharmacistPharmacy").value = ""
		},
	}
});