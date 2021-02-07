Vue.component("patientEPrescriptions", {
	data: function () {
		return {
            patientEPrescriptions:null,
			lista:[],
			l:null
		}
	},
	beforeMount() {
		axios
		 	.get('/patient/getPatientById/' + '88')
		 	.then(response => {
				 this.patientEPrescriptions = response.data
				 this.l = this.patientEPrescriptions.eprescriptions
		 	})
		 	.catch(error => {
		 	})
	},
	template: `
	<div id="parmaciesShowPatient">
<br>
		<div class="container">
            <br/><h3 class="text">EPrescriptions</h3><br/><br/>
			       <!-- <button type="button" class="btn btn-info btn-lg form-control" style="width:30%;height:80px; margin-bottom:5%" data-toggle="modal" data-target="#CommentModal">Leave feedback</button>-->
		</div>

		<div class="row search">
		Filtration by status:&nbsp&nbsp
		<div>
			<select class="col" id="filter" v-on:change="Filter()">
				<option selected="selected" disabled>Please select status:</option>
					<option>New</option>
					<option>Processed</option>
					<option>Rejected</option>
					<option>None</option>
			</select>
		</div>  
		&nbsp&nbsp&nbspSort by date:&nbsp&nbsp
			<div>
				<select class="col" id="sort" v-on:change="Sort()">
					<option selected="selected" disabled>Please select one</option>
	                	<option>Date assceding</option>
	                	<option>Date descending</option>
	            </select>
	        </div>  
	</div>
<!--Show eprescriptions -->
	<template v-for="p in patientEPrescriptions.eprescriptions">
			<div class="container">
			  <div class="card">
					<div class="card-header" style="font-size:30px">EPrescription</div>
					<div class="card-body" style="font-size:20px">{{p.medicine.medicine.name}}&nbsp--&nbsp{{p.medicine.price}}&nbspdin.<br> Date: &nbsp{{DateSplit(p.issuingDate)}}<br>Time:&nbsp{{TimeSplit(p.issuingDate)}}<br>Therapy duration:&nbsp{{p.therapyDuration}}&nbspday/s<br> Status: &nbsp{{p.status}}</div>
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
		DateSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            return dates[2] + "." + dates[1] + "." + dates[0]
        },
        TimeSplit: function (date) {
            var dates = (date.split("T")[0]).split("-")
            var times = (date.split("T")[1]).split(":")
            return times[0] + ":" + times[1] + "h"
        },
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
		Filter:function(){
			if(document.getElementById("filter").value=="New"){
				for(i in this.l){
					if(this.l[i].status == "New")
					this.lista.push(this.l[i])
				}
				this.patientEPrescriptions.eprescriptions = this.lista
				this.lista = []
			}else if(document.getElementById("filter").value=="Processed"){
				for(i in this.l){
					if(this.l[i].status == "Processed")
					this.lista.push(this.l[i])
				}
				this.patientEPrescriptions.eprescriptions = this.lista
				this.lista = []
			}else if(document.getElementById("filter").value=="Rejected"){
				for(i in this.l){
					if(this.l[i].status == "Rejected")
					this.lista.push(this.l[i])
				}
				this.patientEPrescriptions.eprescriptions = this.lista
				this.lista = []
			}else{
				for(i in this.l){
					this.lista.push(this.l[i])
				}
				this.patientEPrescriptions.eprescriptions = this.lista
				this.lista = []
			}
		},
		Sort:function(){
			if(document.getElementById("sort").value=="Date assceding"){
				this.patientEPrescriptions.eprescriptions.sort (
					function (a, b) {
						if (a.issuingDate < b.issuingDate){
							return -1;
						} else if (a.issuingDate > b.issuingDate){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else{
				this.patientEPrescriptions.eprescriptions.sort (
					function (a, b) {
						if (a.issuingDate > b.issuingDate){
							return -1;
						} else if (a.issuingDate < b.issuingDate){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}
		}
	}
});
