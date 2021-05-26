Vue.component("pharmacistVacationRequest", {
	data: function () {
		return {
			user:null,
            vacation:{
                dateStart:null,
                dateEnd:null,
				pharmacyId:null           
            }
		}
	},
	beforeMount() {
		axios
			.get('/pharmacist/getPharmacistById/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.user=response.data
				this.vacation.pharmacyId=this.user.pharmacy.id
			})
			.catch(error => {
			})
	},
	template: `
	<div class="BackendImagePhysician">				
    <div class="container reservation"></br></br>
    Request for vacation</br></br>
            Choose start date:</br>
            <input style="height:25px" id="dateS" type="date"></input></br></br>
            Choose end date:</br>
            <input style="height:25px" id="dateE" type="date"></input></br></br>
        <button type="button" class="btn btn-info btn-lg " v-on:click="Request()">Send</button>
    </div>
	</div>					
	`,
	methods: {
		Request: function(){
            this.vacation.dateStart=document.getElementById("dateS").value
            this.vacation.dateEnd=document.getElementById("dateE").value
			axios
				.post("/vacation/addPharmacistVacation/"+localStorage.getItem('userId'),this.vacation,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				})
				.then(response => {
                    alert("Your request has been sent!")
				})
				.catch(error => {
				})
		}
	}
});

Vue.component("dermatologistVacationRequest", {
	data: function () {
		return {
			user:null,
            vacation:{
                DateStart:null,		               
                DateEnd:null,
				pharmacyId:null 
            },
			phycian:{
			  vacationSchedule:[],
			  workingSchedule:[],
			  pharmacies:[]
			},
			pharmacy:[]
		}
	},
	beforeMount() {
		axios
			.get('/dermatologist/getDermatologistById/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.phycian = response.data
				this.pharmacy=this.phycian.pharmacies[0]
			})
			.catch(error => {
			})
	},
	template: `
	<div class="BackendImagePhysician">				
    <div class="container reservation"></br></br>
    Request for vacation</br></br>
	Choose pharmacy by&nbsp&nbsp</br>
	<select class="col" id="sort"style="width:200px;" v-model="pharmacy">
		<option v-for="p in this.phycian.pharmacies" v-bind:value="p">{{p.name}}</option>
	</select>	</br>
            Choose start date:</br>
            <input style="height:25px" id="dateS" type="date"></input></br></br>
            Choose end date:</br>
            <input style="height:25px" id="dateE" type="date"></input></br></br>
        <button type="button" class="btn btn-info btn-lg " v-on:click="Request()">Send</button>
    </div>
	</div>					
	`,
	methods: {
		Request: function(){
            this.vacation.dateStart=document.getElementById("dateS").value

            this.vacation.dateEnd=document.getElementById("dateE").value		
			this.vacation.pharmacyId=this.pharmacy.id
			axios
				.post("/vacation/addDermatologistVacation/"+localStorage.getItem('userId'),this.vacation,{
					headers: {
						'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				})
				.catch(error => {
				})
		}
	}
});

