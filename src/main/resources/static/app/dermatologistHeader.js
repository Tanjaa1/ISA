Vue.component("dermatologistHeader", {
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
                        <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Dermatologist menu</button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" v-on:click="DermatologistShow()">Home</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" v-on:click="AccountShow()">My account</a>
                            <a class="dropdown-item" v-on:click="PatientsShow()">My patients</a>
                            <a class="dropdown-item" v-on:click="CalendarShow()">My working schedule</a>
                            <a class="dropdown-item" v-on:click="VacationShow()">Request for vacation</a>
                            <a class="dropdown-item" v-on:click="CurrentExaminationShow()">Current examination</a>
                            <a class="dropdown-item" v-on:click="MakingExaminationShow()">Making an appointment</a>
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
            this.$router.push('dermatologistInfo');
        },
        PatientsShow: function () {
            this.$router.push('dermatologistSearchPatients');
        },
        CalendarShow: function () {
        },
        VacationShow: function () {
            this.$router.push('dermatologistVacationRequest');
        },
        CurrentExaminationShow: function () {         
        },
        MakingExaminationShow: function () { 
            this.$router.push('createExaminationDermatologist');              
        },
        DermatologistShow: function () {
            this.$router.push('dermatologistHomePage');
        },
        Logout: function () {           
        }
    }


});
