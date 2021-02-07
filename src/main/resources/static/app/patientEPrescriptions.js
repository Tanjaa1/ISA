Vue.component("patientEPrescriptions", {
	data: function () {
		return {
            patientEPrescriptions:null
		}
	},
	beforeMount() {
		axios
		 	.get('/patient/getPatientById/' + '88')
		 	.then(response => {
				 this.patientEPrescriptions = response.data
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

<!--Show eprescriptions -->
	<template v-for="p in patientEPrescriptions.eprescriptions">
			<div class="container">
			  <div class="card">
					<div class="card-header" style="font-size:30px">EPrescription</div>
					<div class="card-body" style="font-size:20px">{{p.medicine.name}}<br> Date: &nbsp{{DateSplit(p.issuingDate)}}<br>Time:&nbsp{{TimeSplit(p.issuingDate)}}<br> Status: &nbsp{{p.status}}</div>
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
