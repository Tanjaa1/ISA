Vue.component("systemAdminHeader", {
    data: function () {
        return {
         
        }
    },
    beforeMount(){
    },
    
    template: `
	<div>
		<div id="temp">
        <nav class="navbar navbar-expand-lg navbar-custom " id="navigationBar">
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >System Admin menu</button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" v-on:click="PharmacyRegistrationShow()">Pharmacy Registration</a>
                            <a class="dropdown-item" v-on:click="DermatologistRegistrationShow()">Dermatologist Registration</a>
                            <a class="dropdown-item" v-on:click="SupplierRegistrationShow()">Supplier Registration</a>
                            <a class="dropdown-item" v-on:click="MedicineRegistrationShow()">Medicine Registration</a>
                            <a class="dropdown-item" v-on:click="SystemAdminRegistrationShow()">SystemAdmin Registration</a>
                            <div class="dropdown-divider"></div>

                            <a class="dropdown-item" v-on:click="Complaints()">Complaints</a>
                            <div class="dropdown-divider"></div>

                            <a class="dropdown-item" v-on:click="LoyaltyProgramme()">Loyalty Programme</a>
                            <div class="dropdown-divider"></div>
 
                            <a class="dropdown-item" v-on:click="Logout()">Log out</a>
                        </div>     
                    </li>
                    <!--<li class="nav-item">
                        <h1 class="navbar-brand" id="clinicLogoTxt">Health Clinic</h1>
                        <img src="pictures/logInverted.png" id="clinicLogoPic">
                    </li>-->
                </ul>
            </div>
        </nav>
    </div>
    <!--Modal for create examination-->
                    <div class="modal fade" id="notReservation"  tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" style="width: 100%;" role="document">
                           <div class="modal-content steps">
                          <div class="container" align="center">
                              <br/><h4 class=""></h4><br/>
                              <h3>You have 3 or more penalty so you are not allowed to go on page for ePrescription</h3>
                              </div>
                            </div>
                    </div>	
                </div>
	</div>

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
        },
    }


});
