
Vue.component("orderMedicinePharmacyAdmin", {
    data: function () {
		return {
            administrator : {},
            selectedOrder : {},
            mpq : {
                medicine : null,
                quantity : null
            },
            allOffers : [],
            medicines : {},
            dueDate : {},
            medicine : {},
            pharmacy : {},
            requests : [],
            orders : [
                {
                    medicine : {},
                    quantity : {}
                }
            ],
            priceAndQuantity : {},
            order :{
                orders : [],
                pharmacyAdmin :{
                },
                dueDate : null,
                id : 333,
                isProcessed : null
            },
            rows: ['row'],
            allOrders : [],
            filter : 0,
		}
	},
    beforeMount(){
        axios
        .get('/pharmacyAdmin/getById/' +  localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })  
			.then(response => {
				this.order.pharmacyAdmin = response.data
                this.administrator = response.data
                var pAdmin = response.data
                if(pAdmin.firstTimeLogin)
                    this.$router.push('administratorAccountInfo');
                this.order.pharmacyAdmin.pharmacy = this.order.pharmacyAdmin.pharmacy.name
                axios
                .get('/pharmacy/getByName/'+ this.order.pharmacyAdmin.pharmacy,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                .then(response => {
                    this.pharmacy = response.data
                    axios
                    .get('/order/ordersByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})  
                    .then(response => {
                        this.allOrders = response.data
                    })
                    axios
                    .get('/order/getRequestsByPharmacyUnsolved/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})  
                    .then(response => {
                        this.requests = response.data
                        for(var r of this.requests){
                            r.date = r.date.split('T')[0]
                        } 
                    })
                })
            })
        axios.get('/medicine/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.medicines = response.data
            })   
    },
	template: ` 
    <div id="OMPA">       
    <br><br>


  <!-- Modal -->
 

            <h1>Order new medicine</h1>
            <div style = "margin-top : 3%;">
            <div class = "sameLineOMPA"  style ="margin-left : 5%; margin-top : 0.5%;" v-for = "(row,index) in orders">
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Select medicine to order</span>
                    </div>
                    <select class="form-control"  v-model="row.medicine.name" aria-describedby="basic-addon3" >
                        <option value=""  selected disabled> </option>
                        <option v-for = "medicine in medicines" >{{medicine.name}}</option>
                    </select>
                </div>
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Set quantitiy</span>
                    </div>
                    <div v-if = "row.medicine == null">
                        <input type = "number" min="1" class="form-control"  v-model="row.quantity" aria-describedby="basic-addon3" disabled>
                    </div>
                    <div v-else>
                        <input type = "number" min="1" class="form-control"  v-model="row.quantity" aria-describedby="basic-addon3" >
                    </div>
                </div>   
                <button class="addButtonOMPA" v-on:click="addRow(), rows[index]=false" v-if="index == 0"><i class="fa fa-plus"></i></button>     
                &nbsp
                <button class="deleteButtonOMPA" v-on:click="deleteRow(), rows[index]=false"  v-if="index == 0 && orders.length > 1"><i class="fa fa-minus"></i></button>                                             
            </div>

            <div class="input-group mb-3" style = "width : 35%; margin-left : 5%;">
                <div class="input-group-prepend" >
                    <span class="input-group-text " id="basic-addon3">Order due</span>
                </div>
                <div  style = "width : 25%;">
                    <input type = "date" min="1" class="form-control" v-model="order.dueDate" aria-describedby="basic-addon3" v-on:change = "compareDate(order.dueDate)">
                </div>
                <button type="button" class="btn btn-primary" style = "background-color : darkgrey; width : 25%; margin-left :24%;" v-on:click = "completeOrder()">Order</button>            
            </div>

        <br><br><br><br><br>
        <h1>Orders overview</h1>

            <!-- Orders unfiltered -->
		<table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a " v-if ="filter == 0">
			<thead class="thead-light">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Medicine</th>
					<th scope="col">Quantity</th>
					<th scope="col">Status</th>
                    <th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr v-for = "(order) in allOrders">
					<td scope="row">{{order.id}}</td>
                    <td><div  v-for = "o in order.orders">{{o.medicine.name}}</div></td>				
                    <td><div  v-for = "o in order.orders">{{o.quantity}}</div></td>	
                    <td scope="row" v-if = "!order.isProcessed" >Pending offers</td>
                    <td scope="row" v-else >Processed</td>
                    <td v-if = "IsDue(order)"><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview"><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    <td v-else><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview" disabled><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    </td>
				</tr>
			</tbody>
		</table>

        <!-- Orders pending -->
        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   " v-else-if ="filter == 1">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Medicine</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for = "(order) in allOrders" v-if = "!order.isProcessed">
                    <td scope="row">{{order.id}}</td>
                    <td><div  v-for = "o in order.orders">{{o.medicine.name}}</div></td>				
                    <td><div  v-for = "o in order.orders">{{o.quantity}}</div></td>	
                    <td scope="row" v-if = "!order.isProcessed" >Pending offers</td>
                    <td scope="row" v-else >Processed</td>
                    <td v-if = "IsDue(order)"><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview"><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    <td v-else><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview" disabled><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>

 

        <!-- Orders processed -->
        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   " v-else-if ="filter == 2">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Medicine</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for = "(order) in allOrders" v-if="order.isProcessed">
                    <td scope="row">{{order.id}}</td>
                    <td><div  v-for = "o in order.orders">{{o.medicine.name}}</div></td>				
                    <td><div  v-for = "o in order.orders">{{o.quantity}}</div></td>	
                    <td scope="row" v-if = "!order.isProcessed" >Pending offers</td>
                    <td scope="row" v-else >Processed</td>
                    <td v-if = "IsDue(order)"><button  style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview"><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    <td v-else><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#OrdersReview" disabled><i class="fa fa-list"></i></button>
                    <button  v-if = "!order.isProcessed " style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder"><i class="fa fa-cog"></i></button>
                    <button  v-else style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="GetOffers(order)" data-toggle="modal" data-target="#UpdateOrder" disabled><i class="fa fa-cog"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>

        <button style="color:white; width : 300px" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="FilterPending()" data-toggle="modal" data-target="#">Filter pending</button>
        <button style="color:white; width : 300px" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="FilterProcessed()" data-toggle="modal" data-target="#">Filter processed</button>
        <button style="color:white; width : 300px" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="FilterReset()" data-toggle="modal" data-target="#">Reset filter</button>
		</br>		
    </div>
    
    <br><br><br><br><br>
    <h1>Requests overview</h1>
    <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a">
        <thead class="thead-light">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Medicine</th>
                <th scope="col">Date</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for = "(request) in requests">
                <td scope="row">{{request.id}}</td>
                <td><div >{{request.medicine.name}}</div></td>				
                <td><div>{{request.date}}</div></td>
                <td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SolveRequest(request)" data-toggle="modal" data-target="#"><i class="fa fa-check"></i></button></td>	
            </tr>
        </tbody>
    </table>


    <!-- Orders review -->
    <div class="modal fade" id="OrdersReview" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Offers</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
                <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a ">
                    <thead class="thead-light">
                        <tr>
                            <th scope="col">Supplier</th>
                            <th scope="col">Price</th>
                            <th scope="col">Date</th>
                            <th scope="col"></th>
                            <th scope="col"></th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for = "(offer) in allOffers">
                            <td><div >{{offer.supplier.name}}</div></td>				
                            <td><div >{{offer.offerPrice}}rsd</div></td>				
                            <td><div>{{offer.dueDate}}</div></td>
                            <td><button v-if = "!selectedOrder.isProcessed" style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ChoseOffer(offer,selectedOrder)" data-toggle="modal" data-target="#"><i class="fa fa-check"></i></button></td>
                            <td><button v-if = "offer.status == 'Accepted'" style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ChoseOffer(offer,selectedOrder)" data-toggle="modal" data-target="#" disabled >✔</button></td>		
                        </tr>
                    </tbody>
                </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>


    <!--UpdateOrder -->
    <div class="modal fade" id="UpdateOrder" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Update order</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">



            <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a ">
                <thead class="thead-light">
                    <tr>                       
                        <th scope="col">Medicine</th>
                        <th scope="col">Quantity</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for = "(order) in selectedOrder.orders">
                        <td><div >{{order.medicine.name}}</div></td>				
                        <td><div >{{order.quantity}}</div></td>				
                        <td><button v-if = "!selectedOrder.isProcessed" style="color:white" type="button" class="btn btn-default" v-on:click="Remove(order)"><i class="fa fa-times"></i></button></td>
                    </tr>
                </tbody>
            </table>
            &nbsp

            <div style = "margin-top : 3%;">
            <div class = "sameLineOMPA"  style =" margin-top : 0.5%;" v-for = "(row,index) in orders">
                <div class="input-group mb-3" style = "">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Select medicine to order</span>
                    </div>
                    <select class="form-control"  v-model = "mpq.medicine" aria-describedby="basic-addon3" >
                        <option value=""  selected disabled> </option>
                        <option v-for = "medicine in medicines"   v-bind:value="medicine" >{{medicine.name}}</option>
                    </select>
                </div>
                &nbsp
                &nbsp
                <div class="input-group mb-3" style = "">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Set quantitiy</span>
                    </div>
                    <div v-if = "mpq.medicine == null">
                        <input type = "number" min="1" class="form-control"  v-model="mpq.quantity" aria-describedby="basic-addon3" disabled>
                    </div>
                    <div v-else>
                        <input type = "number" min="1" class="form-control"  v-model="mpq.quantity" aria-describedby="basic-addon3" >
                    </div>
                </div>   
            </div>

            
            <button style="color:white" type="button" class="btn btn-default" v-on:click="Add(mpq)"><i class="fa fa-plus"></i></button>

            <h1></h1>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        </div>
    </div>
    </div>


</div>
	`,
    methods: {
        compareDate: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear()) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.orderInfo.dueDate = null;
            }
        },
        addRow: function () {
            for(var med of this.medicines){
                if(this.orders[ this.orders.length-1].medicine.name == med.name){
                    this.orders[ this.orders.length-1].medicine = med
                    break;
                }
            }
            this.orders.push({
                medicine : {},
                quantity : {}
            })
        },
        deleteRow: function () {
            this.orders.pop()
        },
        FilterPending: function(){
            this.filter = 1
        },
        FilterProcessed: function(){
            this.filter = 2
        },
        FilterReset: function(){
            this.filter = 0
        },
        completeOrder: function () {
            for(var med of this.medicines){
                for(var index in this.orders){
                    if(this.orders[index].medicine.name == med.name){
                        this.orders[index].medicine = med
                        break;
                    }
                }
            }
            for(var order of this.orders){
                if(order.quantity == null || order.medicine == null){
                    alert("Order is not complete")
                    return
                }
                if(this.order.dueDate == null){
                    alert("Order is not complete")
                    return
                }               
            }
            this.order.orders = this.orders
            axios
            .post('/order/add',this.order,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })  
            .then(response => {
                axios
                .post('api/saveUserByPharmacyAdmin',this.administrator,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                .then(response => {
                    axios.get('/pharmacy/getByName/'+ this.order.pharmacyAdmin.pharmacy,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    }) 
                        .then(response => {
                            this.pharmacy = response.data;
                            var names = [];
                            for(med of this.pharmacy.pricelist)
                                names.push(med.medicine.name)
                            for(var med of this.order.orders){
                                var flag = true
                                for(var medP of this.pharmacy.pricelist){
                                    if(med.medicine.name.valueOf() == medP.medicine.name.valueOf()){
                                        flag = false
                                        break
                                    }                    
                                }
                                if(flag){
                                    this.pharmacy.pricelist.push({
                                        id : null,
                                        price : 0,
                                        medicine : med.medicine,
                                        quantity : 0
                                    })
                                }
                            }
                            axios.put('/pharmacy/update/',this.pharmacy,{
                                headers: {
                                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                                }
                            }) 
                            .then(response => {
                                alert("Order successfuly set")
                                axios
                                .post('api/saveUserByPharmacyAdmin',this.administrator,{
                                    headers: {
                                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                                    }
                                }) 
                                .then(response => {

                                    axios
                                    .get('/order/ordersByPharmacyId/' + this.pharmacy.id,{
                                        headers: {
                                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                                        }
                                    })  
                                    .then(response => {
                                        this.allOrders = response.data
                                    })
                                })
                            })
                    })   
                })
            })
           
            
        },
        SolveRequest : function(request){
            axios
            .put('/order/setRequestToSolved/' + request.id,request,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            }) 
            .then(response => {
                axios
                .post('api/saveUserByPharmacyAdmin',this.administrator,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                .then(response => {
                    axios
                    .get('/order/getRequestsByPharmacyUnsolved/' + this.pharmacy.id,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    }) 
                    .then(response => {
                        this.requests = response.data
                        for(var r of this.requests){
                            r.date = r.date.split('T')[0]
                        } 
                    })
                })
            })
        },
        IsDue(order){
            var date = order.dueDate.split('T')[0]
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date()
            if(year < parseInt(today.getFullYear()) ||
            year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) || 
            year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                return true
            }
            else return false
        },
        GetOffers : function(order){
            axios
            .get('/supplierOffer/getOffersByOrder/' + order.id,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })  
            .then(response => {
                this.allOffers = response.data
                this.selectedOrder = order
            })
    
        },
        ChoseOffer : function(offer,order){
            axios
            .put('/supplierOffer/acceptOffer/' + offer.id,order,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            }) 
            .then(response => {
                
                axios
                .get('/supplierOffer/getOffersByOrder/' + this.selectedOrder.id,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })  
                .then(response => {
                    this.allOffers = response.data
                    this.selectedOrder = order
                    axios
                    .get('/order/ordersByPharmacyId/' + this.pharmacy.id,{
						headers: {
							'Authorization': 'Bearer' + " " + localStorage.getItem('token')
						}
					})  
                    .then(response => {
                        this.allOrders = response.data
                    })
                })
            })
    
        },
        Remove :function(order){
            if(this.allOffers.length != 0){
                alert("only orders without offers can be edited")
                return
            }
            var newOrders = []
            for(var o of this.selectedOrder.orders){
                if(o.id != order.id)
                    newOrders.push(o)
            }
            this.selectedOrder.orders = newOrders
            axios
            .put('/order/update', this.selectedOrder,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })  
            .then(response => {
                axios
                .post('api/saveUserByPharmacyAdmin',this.administrator,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
            })
        },
        Add :function(mpq){
            if(this.allOffers.length != 0){
                alert("only orders without offers can be edited")
                return
            }

            if(mpq.medicine == null || mpq.quantity == null){
                alert("Enter medicine and quantity first")
                return
            }
           for(var x of this.selectedOrder.orders)
                if(x.medicine.name.valueOf() == mpq.medicine.name.valueOf()){
                    alert("Medicine already exists in order")
                    return
                }

            var temp = mpq
            this.selectedOrder.orders.push(temp)
            axios
            .put('/order/update' ,this.selectedOrder,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })  
            .then(response => {
                axios
                .post('api/saveUserByPharmacyAdmin',this.administrator,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                    .then(response => {
                        axios
                        .get('/order/ordersByPharmacyId/' + this.pharmacy.id,{
                            headers: {
                                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                            }
                        })  
                        .then(response => {
                            this.allOrders = response.data
                        })
                    $('#UpdateOrder').modal('hide');
                })
                
            })
            .catch(error => {a
            })
        }
    }

});

