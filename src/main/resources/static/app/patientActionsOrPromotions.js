Vue.component("patientActionsOrPromotions", {
	data: function () {
		return {
			patient:null
		}
	},
	beforeMount() {
		// axios
		// 	.get('/login/getUserId', {
		// 		headers: {
		// 			'Authorization': 'Bearer' + " " + localStorage.getItem('token')
		// 		}
		// 	})
		// 	.then(response => {
		// 		this.idPatient = response.data
		// 		this.patientId = response.data
		// 	})
		// 	.catch(error => {
		// 	}),
		// axios
		// 	.get('/feedback/approved', {
		// 		headers: {
		// 			'Authorization': 'Bearer' + " " + localStorage.getItem('token')
		// 		}
		// 	})
		// 	.then(response => {
		// 		this.approvedFeedbacks = response.data
		// 	})
		// 	.catch(error => {
		// 	})
		// axios
		// 	.get('/patient/all', {
		// 		params: { token: localStorage.getItem('token') }, 
		// 		headers: {
		// 			'Authorization': 'Bearer' + " " + localStorage.getItem('token')
		// 		}
		// 	})
		// 	.then(response => {
		// 		this.patients = response.data
		// 	})
		// 	.catch(error => {
		// 	})
		axios
		 	.get('/patient/getPatientById/' + '88')
		 	.then(response => {
				 this.patient = response.data
		 	})
		 	.catch(error => {
		 	})
	},
	template: `
	<div id="parmaciesShowPatient">
<br>
		<div class="container">
            <br/><h3 class="te">Actions and promotions</h3><br/><br/>
			       <!-- <button type="button" class="btn btn-info btn-lg form-control" style="width:30%;height:80px; margin-bottom:5%" data-toggle="modal" data-target="#CommentModal">Leave feedback</button>-->
		</div>


<!--Show pharmacy -->
	<template v-for="p in patient.actionOrPromotions">
			<div class="container">
			  <div class="card">
					<div class="card-header" style="font-size:30px">{{p.pharmacy.name}}</div>
					<div class="card-body" style="font-size:20px">Address: &nbsp{{p.pharmacy.address}}<br> Grade: &nbsp{{p.pharmacy.grade}}<br>{{p.text}} -- {{p.medicine.name}}</div>
					<!--<template v-for="p1 in p.ListActionsOrPromotions">
					<div class="card-body" style="font-size:20px">Promotions: {{p1.text}}</div>
					</template>-->
				</div></br>
			  </div>
	</template></br>
<!--END User comments -->

	</div>

	`,
	methods: {
		
		


	}
});
