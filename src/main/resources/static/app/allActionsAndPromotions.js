Vue.component("AllActionsAndPromotions", {
	data: function () {
		return {
            allActionsAndPromotions:null,
            actionOrPromotion:{
                id:null,
                text:null,
                startTime:null,
                endTime:null,
                pharmacy:{},
                medicine:{}
            }
        }
	},
	beforeMount(){
		axios
		.get('/actionOrPromotion/getAll')
		.then(response => {
			this.allActionsAndPromotions = response.data
		})
		.catch(error => {
		})

	},
	mounted() {
        
	},
	template: 
	`<div id="appointmentss">
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
										<td><button type="button" class="btn btn-info btn-lg" v-on:click="Subscribe(a.id)">Subscribe</button></td>									
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
		Subscribe : async function(id){
			
            await axios
			.get('/actionOrPromotion/getById/'+id)
		
			.then(response => {
                this.actionOrPromotion = response.data

            })
			.catch(error => {
				alert("neuspjesno")
			})

            await axios
            .post('/patient/saveActionOrPromotion/'+'90',this.actionOrPromotion)
            .then(response => {
                    alert('uspjesno dodat')
            })
            .catch(error => {
                alert('neuspjesno uradjen posao jadnoooo')
            })
    
        }
    }
        
});