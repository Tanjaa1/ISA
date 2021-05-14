Vue.component("systemAdminHomaPage", {
    data: function () {
		return {
		}
	},
	beforeMount() {
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

        },
    }

});
