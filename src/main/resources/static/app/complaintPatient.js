Vue.component("complaintPatient", {
	data: function () {
		return {
                patientId:{},
				patientP:null,
				complaintDTO: {
				id: 88,
                text:null,
                subject:null,
				patient:{},
				isAnswered:false
				},
				subjects:null
		}
	},
	mounted() {
		axios
		.get('/complaint/getAllSubjects/'+ 88)
		.then(response => {
			this.subjects = response.data	  
		})
		.catch(error => {
		})
        
	},
	template: 
	`
	<div id="PatientComplaints">
    <div class="container">
    		<br><br><br>
    		<br><br><br>
    
        <br/><h2 class="text1777">Complaint</h2>
		<br><br><br>
		<table class="t">
			<tr>
				<td><label>Text</label><a class="star"></a></td>
				<td><textarea type="textarea" class="textarea"  v-model="complaintDTO.text""/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
			</tr>
		</table>
		<table class="t">
			<tr>
				<td><label>Subject</label><a class="star"></a></td>
				<td> 
                    <select class="select" v-model="complaintDTO.subject">
                        <option disabled>Please select one</option>
                        <option v-for="s in subjects">{{s}}</option>
                    </select>
                </td><br/>
			</tr>
			<tr><td>&nbsp;</td>
			</tr>
		</table>

				
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" data-target="#registrationInfo" v-on:click="AddComplaint()" >Submit</button>
			<br/>
			<br/>


			
    </div>
    </div>
	`,
	computed : {
    },
	methods: {
		AddComplaint :async function(){
		await axios
		.get('/patient/getPatientById/'+ 88)
		.then(response => {
			this.patientP = response.data	  
		})
		.catch(error => {
		})

		alert(this.complaintDTO.id)
		this.complaintDTO.patient=this.patientP.data
		alert(this.complaintDTO.patient)
		
		await axios
		.post('/complaint/saveComplaint/',this.complaintDTO)
		.then(response => {
				alert('uspjesno')
		})
		.catch(error => {
			alert('neuspjesno')
		})


		}
	}
});