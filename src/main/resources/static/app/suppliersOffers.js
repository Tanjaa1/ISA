Vue.component("suppliersOffers", {
	data: function () {
		return {
			offers:null
		}
	},
	beforeMount() {
		axios
				.get('supplierOffer/getOfferBySupplierId/'+'10')
				.then(response => {
					this.offers = response.data
			  
				})
				.catch(error => {
					alert('nesupjesnooo')
				})
	},
	template: `
	<div id="SuppliersOffers"  class="BackendImagePhysician">
		<br><br>	
		<p><h1>My offers:</h1></p>
        <br><br>
		<div>
                <span>
                    <form action="/action_page.php">
                        <label for="cars">Status:</label>
                            <select name="offerStatus" id="offerStatus">
                                <option value="All">All</option>
                                <option value="Accepted">Accepted</option>
                                <option value="Denided">Denided</option>
                                <option value="Waiting_for_answer">Waiting for answer</option>
                            </select>
                    </form>
                    <div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
                </span>
        	<br><br>
			


	</div><br>			
		<div class="tab-content">
				<div id="profil" class="container tab-pane active"><br>
					<div class="container">
						<div class="row">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Status</th>
										<th>Order</th>
										<th>DueDate</th>
										<th>Pharmacy</th>
										<th>My Price</th>
									</tr>
								</thead>
								<tbody>
									<tr v-for="a in this.offers">
										<td>{{a.id}}</td>
										<td>{{a.status}}</td>
										<td><button type="button" class="btn btn-info btn-lg" v-on:click="">Orders</button></td>
										<td>{{a.dueDate}}</td>
										<td>{{a.order.pharmacyAdmin.pharmacy}}</td>
										<td>{{a.offerPrice}}</td>									
									</tr>
								</tbody>
							</table>
						</div>
					</div>		
				</div>
            </div>
            </div>
		
        </div>
	</div>					
	`,
	methods: {
		Search:function(){
			var statusOffer=document.getElementById("offerStatus").value
				axios
				.get('supplierOffer/filtrateOfferByStatus/'+statusOffer+'/10')
				.then(response => {
					this.offers = response.data

				})
				.catch(error => {
					alert('nesupjesnooo')
				})
		},

		ShowComposition:function(composition){

			alert('Composition:' + composition)

		}
		
	}
});

