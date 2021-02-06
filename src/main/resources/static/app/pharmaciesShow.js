Vue.component("pharmaciesShow", {
	data: function () {
		return {
			pharmacies:null,
			pharmaciesHelp:null,
			lista:[],
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
				 this.pharmaciesHelp = response.data
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
		<div class="row search">
		  	<div class="col-sm-5"><input id="name" placeholder="Enter name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div class="col-sm-6"><input id="place" placeholder="Enter place" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>
		<div class="row search">
		Filtration by grades:&nbsp&nbsp
		<div>
			<select class="col" id="sort" v-on:change="Sort()">
				<option selected="selected" disabled>Please select grade:</option>
					<option>0</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
			</select>
		</div>  	
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
		Search: function(){
			var name=document.getElementById("name").value
			var place=document.getElementById("place").value
			if(name=="") name='%20'
			if(place=="") place='%20'
			axios
			.get('/pharmacy/searchPharmacyByNameAndPlace/' + name+'/'+place) 
			.then(response => {
				this.pharmacies = response.data
				this.pharmaciesHelp = response.data
			})
			.catch(error => {
			})
		},
		Sort:function(){
			if(document.getElementById("sort").value=="0"){
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 0)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}else if(document.getElementById("sort").value=="1"){
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 1)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}else if(document.getElementById("sort").value=="2"){
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 2)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}else if(document.getElementById("sort").value=="3"){
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 3)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}else if(document.getElementById("sort").value=="4"){
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 4)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}else{
				for(i in this.pharmaciesHelp){
					if(this.pharmaciesHelp[i].grade == 5)
					this.lista.push(this.pharmaciesHelp[i])
				}
				this.pharmacies = this.lista
				this.lista = []
			}
		}
	}
});
