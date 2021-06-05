Vue.component("reservation", {
	data: function () {
		return {
			reservation:null,
			get:false,
			pharmacy:null
		}
	},
	beforeMount() {
		
		if(localStorage.getItem('role')=='ROLE_PHARMACIST'){ 
		axios
			.get('/pharmacist/getPharmacistById/' + localStorage.getItem('userId'),{
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  }) 
			.then(response => {
				this.pharmacy = response.data.pharmacy.id
			})
			.catch(error => {
			})
		}else{
			this.$router.push('forbidden');
		  }
			
	},
	template: `
	<div id="Reservation"  class="BackendImagePhysician">
		<br><br><br><br><br><br>				
		<div class="row reservation">
		  	<div class="col-sm-5"><input id="id" placeholder="Enter code" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>				
		<div v-if="get" class="row reservation">
		  	<div class="col-sm-5">Patient:</div>
		  	<div class="col-sm-4">{{this.reservation.patient.name}} {{this.reservation.patient.surname}}</div><br><br>
		  	<div class="col-sm-5">Medicine:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.medicine.name}}</div>
		  	<div class="col-sm-5">Quantity:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.quantity}}</div>
		  	<div class="col-sm-5">Price:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.price}}din</div><br><br>
		<button  v-if="get" type="button" style="color:white" class="btn btn-default issue" data-dismiss="modal" v-on:click="Update()">Issue medicine</button>	
		</div>
	</div>					
	`,
	methods: {
		Search:function(){
			alert(localStorage.getItem('token'))
			var id=Number(document.getElementById("id").value)
			axios
			.get('/reservation/getReservationById/' + id+'/'+this.pharmacy,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.reservation=response.data
				if(this.reservation=="")
					alert("Reservation does not found!")
				else
					this.get=true
			})
			.catch(error => {
			})
		},
		Update:function(){
			axios.put('/reservation/update', this.reservation,{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			})
				.then(function (response) {
					alert("RESERVATION HAS BEEN TAKEN OVER!")
					location.reload()
				})
				.catch(function (error) {
				});
				this.get=false
				this.reservation=null
		}
	}
});

