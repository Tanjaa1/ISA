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
		.get('/actionOrPromotion/getAllByPatient/'+localStorage.getItem('userId'),{
			headers: {
			  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		  })
		.then(response => {
			this.allActionsAndPromotions = response.data
			if(this.allActionsAndPromotions.length === 0){
				alert('there is no avaliable actions or promotions')
				this.$router.push('patientHomePage');    
			}
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
										<td>{{DateSplit(a.startTime)}}</td>
										<td>{{DateSplit(a.endDateTime)}}</td>
										<td><button type="button" name="btnS" class="btn btn-info btn-lg" v-on:click="Subscribe(a.id,a.endDateTime)">Subscribe</button></td>									
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
		DateSplit: function (date) {
			var dates = (date.split("T")[0]).split("-")
			var times = (date.split("T")[1]).split(":")
			return dates[2] + "." + dates[1] + "." + dates[0]
		},
		Subscribe : async function(id,dateww){
			var dates = (dateww.split("T")[0]).split("-")

			
			var dateToChek=new Date( dates[0],dates[1], dates[2])
			if(dateToChek<new Date()){
				alert('Action or promotion has expired')
			}else{
				
            await axios
			.get('/actionOrPromotion/getById/'+id,{
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
		
			.then(response => {
                this.actionOrPromotion = response.data

            })
			.catch(error => {
				alert("neuspjesno")
			})

            await axios
            .post('/patient/saveActionOrPromotion/'+localStorage.getItem('userId'),this.actionOrPromotion,{
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
            .then(response => {
                    alert('uspjesno dodat')
					this.$router.push('patientHomePage');    

            })
            .catch(error => {
                alert('neuspjesno uradjen posao jadnoooo')
            })
			}
        }
    }
        
});