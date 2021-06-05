Vue.component("giveOffers", {
	data: function () {
		return {
			orders:null,
			offersList:null
		}
	},
	beforeMount() {
		axios
				.get('order/getAll',{
          headers: {
            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
          }
        })
				.then(response => {
					this.orders = response.data
			  
				})
				.catch(error => {
          alert("Something went wront, please try again later!")
          this.$router.push('supplierProfile')				})
	},
	template: `
	<div id="GiveOffers"  class="BackendImagePhysician">
		<br><br>	
			<p><h1>Active orders:</h1></p>
        <br><br>
		<div>
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
									<th>Order</th>
									<th>DueDate</th>
									<th>Pharmacy</th>
									<th>Pharmacy admin</th>
                 <th>Give offer</th>
								</tr>
							</thead>
							<tbody>
								<tr v-for="a in this.orders">
									<td>{{a.id}}</td>
									<td><button type="button" class="btn btn-info btn-lg" v-on:click="Orders(a.id)">Orders</button></td>
									<td>{{DateSplit(a.dueDate)}}</td>
									<td>{{a.pharmacyAdmin.pharmacy.name}}</td>
                                    <td>{{a.pharmacyAdmin.name + ' '  + a.pharmacyAdmin.surname}}</td>
									<td><button type="button" class="btn btn-info btn-lg" v-on:click="Offers(a.id)">Give offer</button></td>			
    							<td>{{a.offerPrice}}</td>									
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
<div class="modal" id="myModalOrders">
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
<div class="modal" id="myModalOffers">
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
  <label for="fname">Price:</label>
  <input type="number" id="fname" name="fname"><br><br>
  <label for="lname">DueDate:</label>
  <input type="date" id="birthday" name="birthday">
  <button type="button" class="btn btn-danger" v-on:click='AddOffer()'>Add Offer</button>
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
		
		close:function(){
			this.$router.push('supplierProfile');
		  },
		Orders:function(id){
           
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
        alert("Something went wront, please try again later!")
        this.$router.push('supplierProfile')	
			})
			$('#myModalOrders').modal('show');

		  },Offers:function(id){
            axios
			.get('supplierOffer/isOfferGivenToOrder/'+id+'/'+localStorage.getItem('userId'),{
        headers: {
          'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        }
      })
			.then(response => {
				var result1 = response.data
                if(result1==false){
                    localStorage.setItem('orderId',id)
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
                      alert("Something went wront, please try again later!")
                      this.$router.push('supplierProfile')	
                                        })
                    $('#myModalOffers').modal('show');
                }else{
                    alert('you have already made an offer on this order')

                }
            			})
			.catch(error => {
        alert("Something went wront, please try again later!")
        this.$router.push('supplierProfile')				})


           

		  },DateSplit: function (date) {
        var dates = (date.split("T")[0]).split("-")
        var times = (date.split("T")[1]).split("")
        return dates[2] + "." + dates[1] + "." + dates[0]
      }
          ,AddOffer:function(){ 
            var price = document.getElementById("fname").value
            var dueDate = document.getElementById("birthday").value
            var orderId=localStorage.getItem('orderId')
            //var supplierId=localStorage.getItem('supplierId')
            if(price.length == 0 || dueDate == ""){
                alert('Please fill both filds!')
            }else{
                axios
			.get('supplierOffer/giveOfferToOrder/'+orderId+'/'+localStorage.getItem('userId')+'/'+price +'/'+dueDate,{
        headers: {
          'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        }
      })
			.then(response => {
				var result = response.data
                if(result==false){
                    alert('you do not have a sufficient supply of this medicine')
                }else{
                    alert('offer successfully sent')
                    location.reload()
                                  }
            			})
			.catch(error => {
        alert("Something went wront, please try again later!")
        this.$router.push('supplierProfile')	
      			})
            }

            
        }
		
	}
});

