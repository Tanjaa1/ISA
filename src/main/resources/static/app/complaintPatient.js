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
		.get('/complaint/getAllSubjects/'+ localStorage.getItem('userId'),{
			headers: {
			  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		  } )
		.then(response => {
			this.subjects = response.data	
			if(this.subjects==null || this.subjects==''){
				alert("There is currently no entity for which you could file a complaint")
				this.$router.push('patientHomePage');
			}
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
				<td><textarea type="textarea" id="textComplaint" class="textarea"  v-model="complaintDTO.text""/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
			</tr>
		</table>
		<table class="t">
			<tr>
				<td><label>Subject</label><a class="star"></a></td>
				<td> 
                    <select class="select" id="subjectComplaint" v-model="complaintDTO.subject">
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
			
			if(this.complaintDTO.text=="" || this.complaintDTO.subject=="" || this.complaintDTO.text==undefined || this.complaintDTO.subject==undefined){
				alert('All fields must be filled')
				return
			}else{
				await axios
				.get('/patient/getPatientById/'+ localStorage.getItem('userId'),{
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
				.then(response => {
					this.complaintDTO.patient= response.data	  
				})
				.catch(error => {
				})
		
				
				
				await axios
				.post('/complaint/saveComplaint/',this.complaintDTO,{
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
				.then(response => {
						alert('complaint successfully sent')
						this.$router.push('patientHomePage');

				})
				.catch(error => {
					alert('Something went wrong, please try again later!')
					this.$router.push('patientHomePage');				})
		
			}
		

		}
	}
});