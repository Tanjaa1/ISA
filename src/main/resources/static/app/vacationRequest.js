Vue.component("pharmacistVacationRequest", {
	data: function () {
		return {
			user:null,
            vacation:{
                dateStart:null,
                dateEnd:null               
            }
		}
	},
	beforeMount() {
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
				.post("/vacation/addPharmacistVacation/"+'4',this.vacation)
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
                DateEnd:null               
            }
		}
	},
	beforeMount() {
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
				.post("/vacation/addDermatologistVacation/"+'6',this.vacation)
				.then(response => {
                    alert("Your request has been sent!")
				})
				.catch(error => {
				})
		}
	}
});

