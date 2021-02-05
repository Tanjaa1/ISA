Vue.component("pharmaciesShow", {
	data: function () {
		return {
			pharmacies:null,
			idPatient: null,
			approvedFeedbacks: null,
			patients: null,
			feedback: {
				text: "",
				approved: false,
				date: new Date().now,
				patientId: null
			},
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
		 	.get('/pharmacy/getAll')
		 	.then(response => {
				 this.pharmacies = response.data
		 	})
		 	.catch(error => {
		 	})
	},
	template: `
	<div id="parmaciesShowPatient">
<br>
		<div class="container">
            <br/><h3 class="text">Pharmacy</h3><br/><br/>
			       <!-- <button type="button" class="btn btn-info btn-lg form-control" style="width:30%;height:80px; margin-bottom:5%" data-toggle="modal" data-target="#CommentModal">Leave feedback</button>-->
		</div>


<!--Show pharmacy -->
	<template v-for="p in pharmacies">
			<div class="container">
			  <div class="card">
					<div class="card-header" style="font-size:30px">{{p.name}}</div>
					<div class="card-body" style="font-size:20px">Address: &nbsp{{p.address}}<br> Grade: &nbsp{{p.grade}}</div>
					<template v-for="p1 in p.ListActionsOrPromotions">
					<div class="card-body" style="font-size:20px">Promotions: {{p1.text}}</div>
					</template>
				</div></br>
			  </div>
	</template></br>
<!--END User comments -->

	</div>

	`,
	methods: {
		
		


	}
});
