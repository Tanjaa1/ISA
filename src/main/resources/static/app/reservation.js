Vue.component("reservation", {
	data: function () {
		return {
			reservation:null,
			get:false
		}
	},
	beforeMount() {
	},
	template: `
	<div id="Reservation">
		<br><br><br><br><br><br>				
		<div class="row reservation">
		  	<div class="col-sm-5"><input id="id" placeholder="Enter code" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>				
		<div v-if="get" class="row reservation">
		  	<div class="col-sm-5">Patient:</div>
		  	<div class="col-sm-4">{{this.reservation.patient}}</div><br><br>
		  	<div class="col-sm-5">Medicine:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.medicine.name}}</div>
		  	<div class="col-sm-5">Quantity:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.quantity}}</div>
		  	<div class="col-sm-5">Price:</div>
		  	<div class="col-sm-4">{{this.reservation.medicinePriceAndQuantityId.price}}din</div><br><br>
	  	</div>
		<button  v-if="get" type="button" style="color:white" class="btn2 btn-default issue" data-dismiss="modal" v-on:click="Update()">Issue medicine</button>	
	</div>					
	`,
	methods: {
		Search:function(){
			var id=Number(document.getElementById("id").value)
			axios
			.get('/reservation/getReservationById/' + id) 
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
			axios.post('/reservation/update', this.reservation)
				.then(function (response) {
					alert("RESERVATION HAS BEEN TAKEN OVER!");
				})
				.catch(function (error) {
				});
				this.get=false
				this.reservation=null
		}
	}
});

