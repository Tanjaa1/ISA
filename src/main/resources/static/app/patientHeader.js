Vue.component("patientHeader", {
    data: function () {
        return {
           
        }
    },
    
    template: `
	<div>
		<div id="temp">
        <nav class="navbar navbar-expand-lg navbar-custom " id="navigationBar">
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Patient menu</button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" v-on:click="PatientShow()">Home</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" v-on:click="AccountShow()">My account</a>
                            <a class="dropdown-item" v-on:click="PharmaciesShow()">Pharmacies</a>
                            <a class="dropdown-item" v-on:click="ExaminationsByDermatologist()">Examinations by dermatologist</a>
                            <a class="dropdown-item" v-on:click="ConsultationWithPharmacist()">Consultation with pharmacist</a>
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
	</div>

	`,
    methods: {
        AccountShow: function () {
            this.$router.push('patientInfo');
        },
        PharmaciesShow: function () {
            this.$router.push('pharmaciesShow');
        },
        ExaminationsByDermatologist: function () {
            this.$router.push('patientExamination');
        },
        ConsultationWithPharmacist: function () {
            this.$router.push('patientCounceling');
        },
        SearchShow: function () {
            
        },
        StatisticsShow: function () {
            
        },
        AdminShow: function () {
            
        },
        PatientShow: function () {
            
        },
        RegistrationShow: function () {
           
        },
        Logout: function () {
            
        }
    }


});
