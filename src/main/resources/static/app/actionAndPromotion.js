Vue.component("actionAndPromotion", {
	data: function () {
		return {
			allActionsAndPromotions:null
		}
	},
	beforeMount(){
		axios
		.get('/patient/getAllActionsAndPromotionByPatientId/88')
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
										<td>{{a.startTime}}</td>
										<td>{{a.endTime}}</td>
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
	


	</div>
</div>
	`,
	computed : {
    },
	methods: {
		CancelActionOrPromotion : function(id){
			
			 axios
			.get('/patient/cancelActionOrPromotion/88/'+id
			 )
		
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