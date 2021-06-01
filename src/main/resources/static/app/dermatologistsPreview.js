Vue.component("dermatologistsPreview", {
	data: function () {
		return {
            dermatologists:[],
            pharmacies:{},
            filterInfo:{
                pharmacy : null,
                minRating : null,
                maxRating : null,
                name : null,
                surname : null
            },
            displayedDermatologists : {}
		}
	},
	beforeMount() {
        axios.get('/dermatologist/getAllDermatologists', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.dermatologists = response.data
                this.allDermatologists = response.data
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
	<div id="administratorMedicine">	
    <h1></h1>
    <h1></h1>

    <h1></h1>

    <!-- Dermatologists -->
        <h1>Dermatologists</h1>

        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Surname</th>
                            <th scope="col">Avg. rating</th>
                            <th scope="col">Pharmacies</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for = "(dermatologist) in dermatologists">
                            <td>{{dermatologist.name}}</td>
                            <td>{{dermatologist.surname}}</td>
                            <td v-if = "dermatologist.grade != null">{{dermatologist.grade}}</td>
                            <td v-else>N/A</td>
                            <td><div  v-for = "p in dermatologist.pharmacies">{{p.name}}</div></td>
                        </tr>
                    </tbody>
            </table>
            <div class="input-group mb-3" style = "width : 80%; margin-left:11%">
                <div><input id="dermatologistName" placeholder="Filter by  name" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                <div><input id="dermatologistSurname" placeholder="Filter by  surname" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                <div ><input id="dermatologistPharmacy" placeholder="Filter by  pharmacy" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                <div ><input id="dermatologistId" placeholder="Filter by  id" style = "width : 80%" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                <div ><input @change = "ValidateGradeD()" id="dermatologistMin" placeholder="Min rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
                <div ><input @change = "ValidateGradeD()" id="dermatologistMax" placeholder="Max rating" min = "0" max = "5" style = "width : 80%" type="number" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>


                <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal"  v-on:click="SearchDermatologist()"><i class="fa fa-search"></i></button></div> &nbsp
                <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetDermatologistSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
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

            var pharmacy=document.getElementById("dermatologistPharmacy").value.toLowerCase()

			var newDermatologists = []
            if(pharmacy != ''){
                for (const dermatologist of this.dermatologists) {
                    for(const p of dermatologist.pharmacies){
                    if(p.name.toLowerCase().includes(pharmacy))
                        newDermatologists.push(dermatologist)
                    }
            }

            this.dermatologists = newDermatologists 

            newDermatologists = []
            }

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
		ResetDermatologistSearch: function(){
			axios
			.get('/dermatologist/getAllDermatologists',{
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
            document.getElementById("dermatologistPharmacy").value = ""

		},
	}
});