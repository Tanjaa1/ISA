Vue.component("pharmacistHeader", {
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
                        <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Pharmacist menu</button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" v-on:click="PharmacistShow()">Home</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" v-on:click="AccountShow()">My account</a>
                        <a class="dropdown-item" v-on:click="PatientsShow()">My patients</a>
                        <a class="dropdown-item" v-on:click="CalendarShow()">My working schedule</a>
                        <a class="dropdown-item" v-on:click="VacationShow()">Request for vacation</a>
                        <a class="dropdown-item" v-on:click="MakingExaminationShow()">Making an counseling</a>
                        <a class="dropdown-item" v-on:click="ReservationShow()">EPrescription</a>
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
            this.$router.push('pharmacistInfo');
        },
        PatientsShow: function () {
            this.$router.push("pharmacistSearchPatients");
        },
        CalendarShow: function () {
            this.$router.push('calendarP');
        },
        VacationShow: function () {
            this.$router.push('pharmacistVacationRequest');
        },
        MakingExaminationShow: function () {
            this.$router.push('createCounselingPharmacist');             
        },
        ReservationShow:function(){    
            this.$router.push('reservation');         
        },
        PharmacistShow: function () {
            this.$router.push('pharmacistHomePage');
        },
        Logout: function () {
                localStorage.setItem('isLogged', false);
                localStorage.setItem('userId', "");      
                localStorage.setItem('token', "");

                this.$router.push("/")
    
        }
    }


});
