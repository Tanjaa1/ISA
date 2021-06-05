Vue.component("patientHeader", {
    data: function () {
        return {
           patient:null,
           brPenalty:0,
        }
    },
    beforeMount(){
        axios
			.get('/patient/getPatientById/' + '88') 
			.then(response => {
				this.patient = response.data
                for(i = 0; i < this.patient.penalty.length; i++){
					if(this.patient.penalty[i].isDeleted == false){
						this.brPenalty++;
					}
				}
			})
			.catch(error => {
			})
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
                            <a class="dropdown-item" v-on:click="PatientEPrescriptions()">My EPrescriptions</a>
                            <a class="dropdown-item" v-on:click="PharmaciesShow()">Pharmacies</a>
                            <a class="dropdown-item" v-on:click="ExaminationsByDermatologist()">Examinations by dermatologist</a>
                            <a class="dropdown-item" v-on:click="ConsultationWithPharmacist()">Consultation with pharmacist</a>
                            <a class="dropdown-item" v-on:click="PatientReservations()">Medicin reservation</a>
                            <a class="dropdown-item" v-on:click="ActionsOrPromotions()">Actions and promotions</a>
                            <a class="dropdown-item" v-on:click="PatientEvaluates()">Patient evaluates</a>
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
        PatientShow: function () {
            this.$router.push('patientHomePage');
        },
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
        ActionsOrPromotions: function () {
            this.$router.push('patientActionsOrPromotions');
        },
        PatientReservations: function () {
            this.$router.push('patientReservations');
        },
        PatientEPrescriptions: function () {
            if(this.brPenalty < 3){
                this.$router.push('patientEPrescriptions');
                $('#notReservation').modal('hide');
            }else{
                $('#notReservation').modal('show');
            }
        },
        PatientEvaluates: function () {
            this.$router.push('patientEvaluates');
        },
        RegistrationShow: function () {
           
        },
        Logout: function () {
            localStorage.setItem('userId', "");
            localStorage.setItem('token', "");
            localStorage.setItem('role',"")
            this.$router.push("/")

        }
    }


});
