Vue.component("actionAndPromotion", {
	data: function () {
		return {
			allActionsAndPromotions:null
		}
	},
	beforeMount(){
		axios
		.get('/patient/getAllActionsAndPromotionByPatientId/'+localStorage.getItem('userId'),{
			headers: {
			  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		  })
		.then(response => {
			this.allActionsAndPromotions = response.data
	  
		})
		.catch(error => {
		})

	},
	mounted() {
        
	},
	template: 
	`<div id="appointments">
	</br>
		</br>
	<div class="container"><br/>
		
		<p>Actions and promotions<p>
		<div>
			<div class="tab-content">
				<div id="profil" class="container tab-pane active"><br>
					<div class="container">
						<div class="row">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Pharmacy</th>
										<th>Medicine</th>
										<th>Text</th>
										<th>StartTime</th>
										<th>EndTime</th>
										<th>Subsrciption</th>
									</tr>
								</thead>
								<tbody>
									<tr v-for="a in this.allActionsAndPromotions">
										<td>{{a.pharmacy.name}}</td>
										<td>{{a.medicine.name}}</td>
										<td>{{a.text}}</td>
										<td>{{DateSplit(a.startTime)}}</td>
										<td>{{DateSplit(a.endDateTime)}}</td>
										<td><button type="button" class="btn btn-info btn-lg" v-on:click="CancelActionOrPromotion(a.id)">Cancel</button></td>									
									</tr>
								</tbody>
							</table>
						</div>
					</div>		
				</div>
			</div>
		</div>
	<br></br>
	<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>



	</div>
</div>
	`,
	computed : {
    },
	methods: {
		close:function(){
			this.$router.push('patientHomePage');
		  },
	DateSplit: function (date) {
		var dates = (date.split("T")[0]).split("-")
		var times = (date.split("T")[1]).split(":")
		return dates[2] + "." + dates[1] + "." + dates[0]
	},
		CancelActionOrPromotion : function(id){
			
			 axios
			.get('/patient/cancelActionOrPromotion/'+localStorage.getItem('userId')+"/"+id,{
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  } )
		
			.then(response => {
				alert("uspjesno")
				location.reload()
			})
			.catch(error => {
				alert("neuspjesno")
			})
		}
	}
});