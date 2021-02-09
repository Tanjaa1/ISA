Vue.component("pharmacistVacatinRequest", {
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
            this.vacation.DateStart=document.getElementById("dateS").value
            alert(this.vacation.DateStart)
            this.vacation.DateEnd=document.getElementById("dateE").value
			axios
				.post("/vacation/add",this.vacation)
				.then(response => {
				})

				.catch(error => {
				})
		}
	}
});

Vue.component("dermatologistVacatinRequest", {
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
            this.vacation.DateStart=document.getElementById("dateS").value
            alert(this.vacation.DateStart)
            this.vacation.DateEnd=document.getElementById("dateE").value
			axios
				.post("/vacation/add",this.vacation)
				.then(response => {
				})

				.catch(error => {
				})
		}
	}
});

