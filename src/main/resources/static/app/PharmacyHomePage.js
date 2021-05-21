Vue.component("pharmacyHomePage", {
	data: function () {
		return {
            pharmacy : {},
            patient : {},
			ePerscriptions : [],
			actionsOrPromotions : [],
		}
	},
	beforeMount() {
        axios
        .get('/patient/getPatientById/' + 88)
        .then(response =>{
            this.patient = response.data

        })

        axios
        .get('/pharmacy/getByName/' + "Feniks")
        .then(response =>{
            this.pharmacy = response.data
			axios
			.get('/actionOrPromotion/getCurrentByPharmacyId/' + this.pharmacy.id)
			.then(response =>{
				this.actionsOrPromotions	= response.data	
				var temp = []
				for(var x of this.actionsOrPromotions){
					x.endDateTime = x.endDateTime.split('T')[0]
					temp.push(x)
				}
				this.actionsOrPromotions = temp
			})			   			
         })
	},
	mounted() {

	},

	template: `
	<div id="pharmacyHomePage" >

		<div id="mySidenav" class="sidenav d-inline" style = "width : 10%; background-color : GoldenRod; " >
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "EmployeesShow()">Appoint now</button>
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "MedicineShow()">Reserve medicine</button>
		</div>

		<div id="pharmacyHomePage" class = "d-inline">	
			<h1><i></i></h1>
			<h1><i></i></h1>
			<h1><i></i></h1>
			<h1><i></i></h1>

			<h3><b></b></h3>
			<h3>Welcome to <i>{{pharmacy.name}} </i> pharmacy</h3>
			<h1><u>{{pharmacy.address}}</u></h1>
			<h1><i></i></h1>

			<button v-if = "patient != null" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" v-on:click = "getePerscriptions()">
					Check your ePerscriptions
			</button>

			<button v-else type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" disabled>
					Check your ePerscriptions
			</button>

			<!-- ePerscriptions -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
				<div class="modal-content">
				  <div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">ePerscriptions</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					</button>
				  </div>
				  <div class="modal-body">
					

				  <!-- ePerscriptions -->
					<table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
						<thead class="thead-light">
							<tr>
								<th scope="col">Medicine</th>
								<th scope="col">Issuing date</th>
								<th scope="col">On stock</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for = "(ePerscription,index) in ePerscriptions">
								<td>{{ePerscription.medicine.medicine.name}}</td>
								<td>{{ePerscription.issuingDate}}</td>
								<td v-if = "ePerscription.medicine.quantity != 0">✔</td>
								<td v-else >✖</td>
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

				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style = "margin-top : 10%; margin-left : 15%; width : 70%">
					<div class="carousel-inner">
						<div class="carousel-item active">

							<h1><i>Our patients are our priority and our average rating of {{pharmacy.grade}} is best proof</i></h1>
						</div>
					<div class="carousel-item" v-for = "aop in actionsOrPromotions" >
							<h1><b>{{aop.medicine.name}}</b></h1>
							<h1><i>{{aop.text}}</i></h1>
							<label>Active until {{aop.endDateTime}}</label>
					</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
					</a>
				</div>

				<h1></h1>
				<h1></h1>
				<h1></h1>
				<h1></h1>
				<h1></h1>
				<h1></h1>

				<button v-if = "patient != null" type="button" class="btn btn-primary" data-toggle="modal"  v-on:click = "Subscribe()">
					Subscribe now!
				</button>

		</div>

	</div>		

	`,
	methods: {
        EmployeesShow : function(){
            this.$router.push('pharmacyEmployees');
        },
		MedicineShow : function(){
            this.$router.push('pharmacyMedicine');
        },
		getePerscriptions : function(){
			if(this.ePerscriptions.length == 0)
				for(var ePerscription of this.patient.eprescriptions){
					if(ePerscription.pharmacy.id == this.pharmacy.id){
						ePerscription.issuingDate = ePerscription.issuingDate.split('T')[0]
						this.ePerscriptions.push(ePerscription)
					}
				}

        },
		Subscribe : function(){
			axios
			.put('/pharmacy/subscribeUser/' + this.patient.id,this.pharmacy)
			.then(response =>{
				if(response.data)
					alert("Subscribed sucessfully")
				else alert("Already subscribed")

			})

        },
    }
});

