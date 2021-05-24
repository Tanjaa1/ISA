Vue.component("systemAdminHomaPage", {
    data: function () {
		return {
			systemAdmin:{},
			systemAdmin1:{}
		}
	},
	beforeMount() {
		 axios
			.get('systemAdmin/getById/'+ localStorage.getItem('userId'),
				  {
				  headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				  }
				})
			.then(response => {
				systemAdmin=response.data
			if(systemAdmin.firstTimeLogin==true){
			  $('#Show').modal('show');    
			  alert('modalni iskacsw')
			}else{
			  alert("uspjesno")
			}
			})
			.catch(error => {
			  alert('nesupjesnooo jee2')
			})
	},
	template: `
	<div id="SystemAdminHomaPage">		
			<br></br><br></br>
			<br></br><br></br>
				<div>
				  <div class="row">
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Pharmacy" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="PharmacyRegistrationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Dermatologist" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="DermatologistRegistrationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Supplier" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="SupplierRegistrationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="Medicine" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedicineRegistrationShow()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="SystemAdmin" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="SystemAdminRegistrationShow()"></button>
						</h3><br/> 
					</div>
				<div class="col-sm">
					<h3>
					  <button id="Complaint" type="button" class="btn btn-info btn-lg margin form-control"  v-on:click="Complaints()"></button>
					  </h3><br/> 
				  </div>
				  <div class="col-sm">
				  <h3>
					<button id="LoyaltyProgramme" type="button" class="btn btn-info btn-lg margin form-control"  v-on:click="LoyaltyProgramme()"></button>
					</h3><br/> 
				</div>  

					<div class="col-sm">
					</div>
					<div class="col-sm">
					</div>  
					<div class="col-sm">
					</div>
				  </div>
                  </div>	
				  
				  


				  <!--MODAL-->
<div class="modal fade" tabindex="-1" role="dialog" id="Show" >
<div class="modal-dialog search" role="document">
  <div class="modal-content">
  <div class="modal-header">
    <h5 class="modal-title">Please change password</h5>
  </div>
  <div class="modal-body search">
        New password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input id="np" type="password" minlength="8"></br></br>
        
        Confirm password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input type="password" id="cp" name="password" minlength="8"></br>
  </div>
  <div class="modal-footer">
      <button type="button" class="btn btn-info btn-lg" v-on:click="Yes()">Confirm</button>
  </div>
  </div>
  </div>
</div>


		</div>
		<br></br><br></br>
			
				
	`,
	methods: {
        PharmacyRegistrationShow: function () {
            this.$router.push('registrationPharmacy');
        },
        DermatologistRegistrationShow: function () {
            this.$router.push('registrationDermatologist');
        },  
        SupplierRegistrationShow: function () {
            this.$router.push('registrationSupplier');
        },  
        MedicineRegistrationShow: function () {
            this.$router.push('registrationMedicine');
        },  
        SystemAdminRegistrationShow: function () {
            this.$router.push('registrationSystemAdmin');
        },  
        PharmacistRegistrationShow: function () {
            this.$router.push('registrationPharmaciest');
        },
		Complaints: function () {
            this.$router.push('complaints');
        },
		LoyaltyProgramme: function () {
			this.$router.push('loyaltyProgramme');

        }, Yes:function(){
			if(document.getElementById("np").value==document.getElementById("cp").value && document.getElementById("np").value.trim()!="" && document.getElementById("cp").value.trim()!=""){
				$('#Show').modal('hide');
			

        axios
        .get('systemAdmin/getById/'+ localStorage.getItem('userId'),
              {
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
        .then(response => {
			systemAdmin=response.data
			systemAdmin.firstTimeLogin=false
			systemAdmin.password=document.getElementById("np").value
			
        axios.put('/systemAdmin/update', systemAdmin,{
          headers: {
            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
          }
        })
          .then(function (response) {
            axios.put('/api/updateUserBySystemAdmin', systemAdmin,{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
              .then(function (response) {
              })
              .catch(function (error) {
              });
          })
          .catch(function (error) {
          });
        })
        .catch(error => {
          alert('nesupjesnooo')
        })


					
			}else{
				alert('Comfire password!')
			}
		}
	}
});
