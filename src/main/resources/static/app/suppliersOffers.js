Vue.component("suppliersOffers", {
	data: function () {
		return {
			offers:null,
			offersList:null,
			offer:null
		}
	},
	beforeMount() {
		
		axios
		.get('supplierOffer/getOfferBySupplierId/'+localStorage.getItem('userId'),{
			headers: {
			  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
			}
		  })
		.then(response => {
			this.offers = response.data
	  
		})
		.catch(error => {
			alert('Something went wront, please refresh page!')
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
									<th>Update</th>
								</tr>
							</thead>
							<tbody>
								<tr v-for="a in this.offers">
									<td>{{a.id}}</td>
									<td>{{a.status}}</td>
									<td><button type="button" class="btn btn-info btn-lg" v-on:click="Offers(a.order.id)">Orders</button></td>
									<td>{{a.dueDate}}</td>
									<td>{{a.order.pharmacyAdmin.pharmacy.name}}</td>						
									<td>{{a.offerPrice}}</td>			
									<td><button type="button" class="btn btn-info btn-lg" v-on:click="Update(a.order.dueDate,a.id,a.offerPrice,a.dueDate)">Update</button></td>						
								</tr>
							</tbody>
						</table>
						<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>
					</div>
				</div>		
			</div>
        </div>



		<div class="container">
  <br>
  <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Orders:</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
          <table class="table table-striped">
    <thead>
      <tr>
        <th>Id</th>
        <th>Medicine</th>
        <th>Quantity</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="a in this.offersList">
        <td>{{a.id}}</td>
        <td>{{a.medicine.name}}</td>
        <td>{{a.quantity}}</td>
      </tr>
      
      
    </tbody>
  </table>
  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</div>






	<div class="container">
	<br>
	<!-- The Modal -->
	<div class="modal" id="myModalOffersUpdate">
	<div class="modal-dialog">
	  <div class="modal-content">
	
		<!-- Modal Header -->
		<div class="modal-header">
		  <h4 class="modal-title">My Offer:</h4>
		  <button type="button" class="close" data-dismiss="modal">&times;</button>
		</div>
	
		<!-- Modal body -->
		<div class="modal-body">
		  
	
	<form action="/action_page.php">
	<label for="fname">Current Price:</label>
	  <input    type="text" id="fname" name="fname">
	  <label for="lname">Current DueDate:</label>
	  <input   type="text" id="birthday" name="birthday">
	  <br><br>
	  <label for="fname"> New Price:</label>
	  <input  type="number" id="fname1" name="fname"><br><br>
	  <label for="lname">New DueDate:</label>
	  <input  type="date" id="birthday1" name="birthday">
	  <button type="button" class="btn btn-danger" v-on:click='UpdateOffer()'>Add Offer</button>
	  <button type="button" class="btn btn-danger"  data-dismiss="modal">Cancel</button>
	  </form>
	
	</div>
	
		<!-- Modal footer -->
		<div class="modal-footer">
	
		  <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
				.get('supplierOffer/filtrateOfferByStatus/'+statusOffer+'/'+localStorage.getItem('userId'),{
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  })
				.then(response => {
					this.offers = response.data

				})
				.catch(error => {
					alert('Something went wront, please refresh page!')
				})
		},
		Update:function(dueDate,offerId,price,datee){
			document.getElementById('fname').value=price
			document.getElementById('birthday').value=datee
			localStorage.setItem('offerId',offerId)
			var date = new Date(),
			  mnth = ("0" + (date.getMonth() + 1)).slice(-2),
			  day = ("0" + date.getDate()).slice(-2);
		var today=[date.getFullYear(), mnth, day].join("-");
		var dueDateDTO=dueDate.split('T')[0]
		
			if(dueDate<today){
				alert('DueDate for updating your offer  has expired !')
			}else{
				axios
				.get('supplierOffer/getOffersById/'+offerId,{
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  })
				.then(response => {
					this.offer = response.data
				

				})
				.catch(error => {
					alert('Something went wrong, please refresh page!')
				})
				$('#myModalOffersUpdate').modal('show');

			}

		},
		UpdateOffer:function(){
			var price = document.getElementById("fname1").value
            var dueDate = document.getElementById("birthday1").value
            if(price.length == 0 || dueDate == ""){
                alert('Please fill both filds!')
            }else{
                axios
			.get('supplierOffer/updateOffer/'+localStorage.getItem('offerId')+'/'+price +'/'+dueDate,{
        headers: {
          'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        }
      })
			.then(response => {
                    alert('offer successfully updated')
					location.reload()

				})
			.catch(error => {
				alert('Something went wrong, please refresh page!')
			})
            }
		},
		ShowComposition:function(composition){

			alert('Composition:' + composition)

		},
		close:function(){
			this.$router.push('supplierProfile');
		  },
		Offers:function(id){
			axios
			.get('supplierOffer/getOrdersByOrderId/'+id,{
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  })
			.then(response => {
				this.offersList = response.data
			})
			.catch(error => {
				alert('Something went wrong, please refresh page!')
			})
			$('#myModal').modal('show');

		  }
		
	}
});

