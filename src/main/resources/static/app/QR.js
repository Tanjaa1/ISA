Vue.component("QR", {
	data: function () {
		return {
			pharmacies:null
	}
	},
	beforeMount() {
	},
	template: `
	<div id="QR"  class="BackendImagePhysician">
		<br><br>	
			<p><h1>Medicine search by QR code</h1></p>
		<br><br>
			<div class="rowSearch">
				<div>
					<input id="idText" placeholder="Enter full path to QR code:" type="text" class="qrPath" aria-label="Default" aria-describedby="inputGroup-sizing-default">
					<br>
					<button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button>
				</div>		    
			</div>
			<br>

			<div class="sorting">
		
			<div id="labels" hidden>
			<p>Sort by:</p>
				<form>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId1" value="priceDesc">Price desc     
				</label>
				<br>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId2" value="priceAsc">Price asc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId3" value="markDesc">Pharmacy's mark desc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId4" value="markAsc">Pharmacy's mark asc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId5" value="nameDesc">Pharmacy's name desc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId6" value="nameAsc">Pharmacy's name asc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId7" value="addressDesc">Pharmacy's address desc     
				</label>
				<label class="radio-inline">
				<input type="radio" name="radio" id="radioId8" value="addressAsc">Pharmacy's address asc     
				</label>
				<button type="button" class="btn btn-info btn-lg" v-on:click="Sort">Sort</button>								

			</form>	  
			</div>  
			</div>

			<br>

			<div id="pharmaciesTable" hidden>
				<div id="profil" class="container tab-pane active"><br>
					<div class="container">
						<div class="row">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Pharmacy</th>
										<th>Address</th>
										<th>Mark</th>
										<th>Total price</th>
										<th>Price with discount</th>
										<th>Buy</th>
									</tr>
								</thead>
								<tbody>
									<tr v-for="a in this.pharmacies">
										<td>{{a.name}}</td>
										<td>{{a.address}}</td>
										<td>{{a.grade}}</td>
										<td>{{a.priceofMedicines}}</td>
										<td>{{a.priceofMedicinesWithDiscount}}</td>
										<td><button type="button" class="btn btn-info btn-lg" v-on:click="Buy(a.id)">Buy</button></td>									
									</tr>
								</tbody>
							</table>
						</div>
					</div>		
				</div>
			</div>










	</div>
   					
	`,
	methods: {
		Search:function(){
			var text=document.getElementById("idText").value
			var patientId=localStorage.getItem('userId')

			if(text==null || text==undefined || text=="Enter full path to QR code:" || text==""){
				alert('Please enter full path to QR code!')
			}else{
				axios
				.get('medicine/getPharmaciesByQR/'+localStorage.getItem('userId'),{ params: { par: text } ,
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  } )
				.then(response => {
					this.pharmacies = response.data
					document.getElementById("pharmaciesTable").hidden=false;
					document.getElementById("labels").hidden=false;
					if(this.pharmacies === undefined || this.pharmacies.length == 0){
						alert('Sorry, there is no pharmacy that has all the medicines you need!')
						location.reload();
					}

			  
				})
				.catch(error => {
					alert('QR code not found!Please enter full path to QR code!')	
				})
			}
		},
		Sort:function(){
			var x;
			var text=document.getElementById("idText").value
			var patientId=localStorage.getItem('userId')

			if(text==null || text==undefined || text=="Enter full path to QR code:" || text==""){
				alert('Please enter full path to QR code!')
			}else{
				if(document.getElementById('radioId1').checked == true) {   
					x=document.getElementById('radioId1').value
				   }else if(document.getElementById('radioId2').checked == true) {   
					x=document.getElementById('radioId2').value
				   }else if(document.getElementById('radioId3').checked == true) {   
					x=document.getElementById('radioId3').value
				   }else if(document.getElementById('radioId4').checked == true) {   
					x=document.getElementById('radioId4').value
				   }else if(document.getElementById('radioId5').checked == true) {   
					x=document.getElementById('radioId5').value
				   }else if(document.getElementById('radioId6').checked == true) {   
					x=document.getElementById('radioId6').value
				   }else if(document.getElementById('radioId7').checked == true) {   
					x=document.getElementById('radioId7').value
				   }else {
					x=document.getElementById('radioId8').value
				   }
				  
				if(x=="priceDesc"){
					axios
					.get('medicine/sortByPharmacyPriceQRDESC/'+patientId,{ params: { path: text } ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="priceAsc"){
					axios
					.get('medicine/sortByPharmacyPriceQRACS/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="markDesc"){
					axios
					.get('medicine/sortByPharmacyGradeQRDESC/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="markAsc"){
					axios
					.get('medicine/sortByPharmacyGradeQRASC/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="nameDesc"){
					axios
					.get('medicine/sortByPharmacyNameDESC/'+patientId,{ params: { path: text } ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="nameAsc"){
					axios
					.get('medicine/sortByPharmacyNameQRASC/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
	
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else if(x=="addressDesc"){
					axios
					.get('medicine/sortByPharmacyAddressQRDESC/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}else{
					axios
					.get('medicine/sortByPharmacyAddressQRASC/'+patientId,{ params: { path: text }  ,
					headers: {
					  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
					}
				  } )
					.then(response => {
						this.pharmacies = response.data
	
					})
					.catch(error => {
						alert('Sorry,something went wrong, please try again later!')	
						this.$router.push('patientHomePage');					})
				}
			}
			
		},
			Buy:function(id){
				var text=document.getElementById("idText").value

				var pharmacyId=id;
				var patientId=localStorage.getItem('userId')
				axios
				.get('patient/changePharmacySupplies/'+pharmacyId +'/'+patientId,{ params: { path: text } ,
				headers: {
				  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			  } )
				.then(response => {
					alert('Successful')
					location.reload()

				})
				.catch(error => {
					alert('Sorry,something went wrong, please try again later!')	
					this.$router.push('patientHomePage');				})
			}
		
	}
});

