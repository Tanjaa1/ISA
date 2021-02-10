const Browse = { template: '<browse></browse>' }
const Registration = { template: '<registration></registration>' }
const Login = { template: '<login></login>' }
const PatientHomePage = { template: '<patientHomePage></patientHomePage>' }
const DermatologistSearch = { template: '<dermatologistSearchPatients></dermatologistSearchPatients>' }
const PharmacistSearch = { template: '<pharmacistSearchPatients></pharmacistSearchPatients>' }
const DermatologistHomePage = { template: '<dermatologistHomePage></dermatologistHomePage>' }
const PharmacistHomePage = { template: '<pharmacistHomePage></pharmacistHomePage>' }
const Reservation = { template: '<reservation></reservation>' }
const PatientInfo = { template: '<patientInfo></patientInfo>' }
const PatientHeader = { template: '<patientHeader></patientHeader>' }
const PageHeader = { template: '<pageHeader></pageHeader>' }
const ChangePatientInfo = { template: '<changePatientInfo></changePatientInfo>' }
const PatientActionsOrPromotions = { template: '<patientActionsOrPromotions></patientActionsOrPromotions>' }
const ReserveMedicine = { template: '<reserveMedicine></reserveMedicine>' }

const DermatologistsPreview = { template: '<dermatologistsPreview></dermatologistsPreview>'}
const PharmacistsPreview = { template: '<pharmacistsPreview></pharmacistsPreview>'}

const PharmaciesShow = { template: '<pharmaciesShow></pharmaciesShow>' }
const PatientExamination = { template: '<patientExamination></patientExamination>' }
const PatientCounceling = { template: '<patientCounceling></patientCounceling>' }
const PatientReservations = { template: '<patientReservations></patientReservations>' }
const PatientEPrescriptions = { template: '<patientEPrescriptions></patientEPrescriptions>' }

const DermatologistInfo = { template: '<dermatologistInfo></dermatologistInfo>' }
const ChangeDermatologistInfo = { template: '<changeDermatologistInfo></changeDermatologistInfo>' }
const PharmacistHeader = { template: '<pharmacistHeader></pharmacistHeader>' }

const PharmacistInfo = { template: '<pharmacistInfo></pharmacistInfo>' }
const ChangePharmacistInfo = { template: '<changePharmacistInfo></changePharmacistInfo>' }
const DermatologistHeader = { template: '<dermatologistHeader></dermatologistHeader>' }

const RegistrationPatient = { template: '<registrationPatient></registrationPatient>' }
const RegistrationSupplier = { template: '<registrationSupplier></registrationSupplier>' }
const RegistrationDermatologist = { template: '<registrationDermatologist></registrationDermatologist>' }
const RegistrationPharmacy = { template: '<registrationPharmacy></registrationPharmacy>' }
const RegistrationSystemAdmin = { template: '<registrationSystemAdmin></registrationSystemAdmin>' }
const RegistrationMedicine = { template: '<registrationMedicine></registrationMedicine>' }
const RegistrationPharmacyAdmin = { template: '<registrationPharmacyAdmin></registrationPharmacyAdmin>' } 
const RegistrationPharmacist= { template: '<registrationPharmacist></registrationPharmacist>' } 
const Complaints= { template: '<complaints></complaints>' } 
const PatientComplaints= { template: '<complaintPatient></complaintPatient>' } 



const EmailConfirmation = { template: '<emailConfirmation></emailConfirmation>' } 
const SuccessfulRegistration = { template: '<successfulRegistration></successfulRegistration>' } 
const emailConfirmationSupplier = { template: '<emailConfirmationSupplier></emailConfirmationSupplier>' } 
const emailConfirmationDermatologist = { template: '<emailConfirmationDermatologist></emailConfirmationDermatologist>' } 
const emailConfirmationPharmacist = { template: '<emailConfirmationPharmacist></emailConfirmationPharmacist>' } 
const emailConfirmationSystemAdmin = { template: '<emailConfirmationSystemAdmin></emailConfirmationSystemAdmin>' } 
const emailConfirmationPharmacyAdmin = { template: '<emailConfirmationPharmacyAdmin></emailConfirmationPharmacyAdmin>' } 




const ExaminationDermatologist = { template: '<examinationDermatologist></examinationDermatologist>' }
const CounselingPharmacist = { template: '<counselingPharmacist></counselingPharmacist>' }

const OrderMedicinePharmacyAdmin = { template: '<orderMedicinePharmacyAdmin></orderMedicinePharmacyAdmin>' }
const NewEmptyExamination = { template: '<newEmptyExamination></newEmptyExamination>' }


const PharmacistVacationRequest = { template: '<pharmacistVacationRequest></pharmacistVacationRequest>' }
const DermatologistVacationRequest = { template: '<dermatologistVacationRequest></dermatologistVacationRequest>' }

const CreateExaminationDermatologist = { template: '<createExaminationDermatologist></createExaminationDermatologist>' }
const CreateCounselingPharmacist = { template: '<createCounselingPharmacist></createCounselingPharmacist>' }


const Calendar = { template: '<calendar></calendar>' }
const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { 
	    	path: '/', 
	    	name : 'browse', 
	    	component: Browse
	    },
	     { 
	    	path: '/registration', 
	    	name : 'registration', 
	    	component: Registration
	    },
	    { 
	    	path: '/login', 
	    	name : 'login', 
			components: {
				pageHeader: PatientHeader,
				content: Login
			}
	    },
	    { 
	    	path: '/patientHomePage', 
	    	name : 'patientHomePage', 
	    	components: {
				pageHeader: PatientHeader,
				content: PatientHomePage
			}
		},
		{ 
	    	path: '/dermatologistsPreview', 
	    	name : 'dermatologistsPreview', 
	    	components: {
				pageHeader: PatientHeader,
				content: DermatologistsPreview
			}
		},
		{ 
	    	path: '/pharmacistsPreview', 
	    	name : 'pharmacistsPreview', 
	    	components: {
				pageHeader: PatientHeader,
				content: PharmacistsPreview
			}
	    },
		{ 
	    	path: '/orderMedicinePharmacyAdmin', 
	    	name : 'orderMedicinePharmacyAdmin', 
	    	components: {
				pageHeader: PatientHeader,
				content: OrderMedicinePharmacyAdmin
			}
	    },
	    { 
	    	path: '/dermatologistSearchPatients', 
	    	name : 'dermatologistSearchPatients', 
			components: {
				pageHeader: DermatologistHeader,
				content: DermatologistSearch
			}
	    },
	    { 
	    	path: '/pharmacistSearchPatients', 
	    	name : 'pharmacistSearchPatients', 
			components: {
				pageHeader: PharmacistHeader,
				content: PharmacistSearch
			}
	    },
	    { 
	    	path: '/dermatologistHomePage', 
			name : 'dermatologistHomePage', 
			components: {
				pageHeader: DermatologistHeader,
				content: DermatologistHomePage
			}
	    },
	    { 
	    	path: '/pharmacistHomePage', 
			name : 'pharmacistHomePage', 
			components: {
				pageHeader: PharmacistHeader,
				content: PharmacistHomePage
			}
	    },
	    { 
			path: '/reservation', 
            name : 'reservation', 
            components: {
				pageHeader: PharmacistHeader,
				content: Reservation
			}
	    },
	    { 
	    	path: '/patientInfo', 
	    	name : 'patientInfo', 
	    	components: {
				pageHeader: PatientHeader,
				content: PatientInfo
			}
		},
		{ 
	    	path: '/changePatientInfo', 
	    	name : 'changePatientInfo', 
	    	components: {
				pageHeader: PatientHeader,
				content: ChangePatientInfo
			}
	    },
		{ 
			path: '/dermatologistInfo', 
			name : 'dermatologistInfo', 
			components: {
				pageHeader: DermatologistHeader,
				content: DermatologistInfo
			}
		},
		{ 
			path: '/changeDermatologistInfo', 
			name : 'changeDermatologistInfo', 
			components: {
				pageHeader: DermatologistHeader,
				content: ChangeDermatologistInfo
			}
		},		
		{ 
			path: '/pharmacistInfo', 
			name : 'pharmacistInfo', 
			components: {
				pageHeader: PharmacistHeader,
				content: PharmacistInfo
			}
		},
		{ 
			path: '/changePharmacistInfo', 
			name : 'changePharmacistInfo', 
			components: {
				pageHeader: PharmacistHeader,
				content: ChangePharmacistInfo
			}
		},
		{ 
			path: '/pharmaciesShow', 
			name : 'pharmaciesShow', 
			components: {
				pageHeader: PatientHeader,
				content: PharmaciesShow
			}
		},
		{ 
			path: '/patientExamination', 
			name : 'patientExamination', 
			components: {
				pageHeader: PatientHeader,
				content: PatientExamination
			}
		},
		{ 
			path: '/patientCounceling', 
			name : 'patientCounceling', 
			components: {
				pageHeader: PatientHeader,
				content: PatientCounceling
			}
		},
		{ 
			path: '/patientActionsOrPromotions', 
			name : 'patientActionsOrPromotions', 
			components: {
				pageHeader: PatientHeader,
				content: PatientActionsOrPromotions
			}
		},
		{ 
			path: '/registrationPatient', 
			name : 'registrationPatient', 
			components: {
				content: RegistrationPatient
			}
		},
		{ 
			path: '/registrationSupplier', 
			name : 'registrationSupplier', 
			components: {
				content: RegistrationSupplier
			}
		},
		{ 
			path: '/registrationDermatologist', 
			name : 'registrationDermatologist', 
			components: {
				content: RegistrationDermatologist
			}
		},
		{ 
			path: '/registrationPharmacy', 
			name : 'registrationPharmacy', 
			components: {
				content: RegistrationPharmacy
			}
		},
		{ 
			path: '/registrationSystemAdmin', 
			name : 'registrationSystemAdmin', 
			components: {
				content: RegistrationSystemAdmin
			}
		},
		{ 
			path: '/registrationMedicine', 
			name : 'registrationMedicine', 
			components: {
				content: RegistrationMedicine
			}
		},
		{ 
			path: '/registrationPharmacist', 
			name : 'registrationPharmacist', 
			components: {
				content: RegistrationPharmacist
			}
		},
		{ 
			path: '/registrationPharmacyAdmin', 
			name : 'registrationPharmacyAdmin', 
			components: {
				content: RegistrationPharmacyAdmin
			}
		},
		{ 
			path: '/examinationDermatologist',
			name : 'examinationDermatologist', 
			components: {
				pageHeader: DermatologistHeader,
				content: ExaminationDermatologist
			}
		},
		{ 
			path: '/patientReservations', 
			name : 'patientReservations', 
			components: {
				pageHeader: PatientHeader,
				content: PatientReservations
			}
		},
		{
			path: '/counselingPharmacist',
			name : 'counselingPharmacist', 
			components: {
				pageHeader: PharmacistHeader,
				content: CounselingPharmacist
			}	
		},
		{
			path: '/emailConfirmation', 
			name : 'emailConfirmation', 
			components: {
				content: EmailConfirmation
			}
		},
		{ 
			path: '/successfulRegistration', 
			name : 'successfulRegistration', 
			components: {
				content: SuccessfulRegistration
			}
		},
		{ 
			path: '/emailConfirmationSupplier', 
			name : 'emailConfirmationSupplier', 
			components: {
				content: emailConfirmationSupplier
			}
		},
		{ 
			path: '/emailConfirmationDermatologist', 
			name : 'emailConfirmationDermatologist', 
			components: {
				content: emailConfirmationDermatologist
			}
		},
		{ 
			path: '/emailConfirmationPharmacist', 
			name : 'emailConfirmationPharmacist', 
			components: {
				content: emailConfirmationPharmacist
			}
		},
		{ 
			path: '/emailConfirmationPharmacyAdmin', 
			name : 'emailConfirmationPharmacyAdmin', 
			components: {
				content: emailConfirmationPharmacyAdmin
			}
		},
		{ 
			path: '/emailConfirmationSystemAdmin', 
			name : 'emailConfirmationSystemAdmin', 
			components: {
				content: emailConfirmationSystemAdmin
			}
		},
		{ 
			path: '/patientEPrescriptions', 
			name : 'patientEPrescriptions', 
			components: {
				pageHeader: PatientHeader,
				content: PatientEPrescriptions
			}
		},
		{ 
			path: '/newEmptyExamination', 
			name : 'newEmptyExamination', 
			components: {
				pageHeader: PatientHeader,
				content: NewEmptyExamination
			}
		},
		{ 
			path: '/complaints', 
			name : 'complaints', 
			components: {
				content: Complaints
			}
		},
		{ 
			path: '/complaintPatient', 
			name : 'complaintPatient', 
			components: {
				content: PatientComplaints
			}
		},
	    { 
	    	path: '/pharmacistVacationRequest', 
	    	name : 'pharmacistVacationRequest', 
			components: {
				pageHeader: PharmacistHeader,
				content: PharmacistVacationRequest
			}
		},
			{ 
				path: '/dermatologistVacationRequest', 
				name : 'dermatologistVacationRequest', 
				components: {
					pageHeader: DermatologistHeader,
					content: DermatologistVacationRequest
				}
	    },
		{ 
			path: '/createExaminationDermatologist', 
			name : 'createExaminationDermatologist', 
			components: {
				pageHeader: DermatologistHeader,
				content: CreateExaminationDermatologist
			}
		},
		{ 
			path: '/createCounselingPharmacist', 
			name : 'createCounselingPharmacist', 
			components: {
				pageHeader: PharmacistHeader,
				content: CreateCounselingPharmacist
			}
		},
		{ 
			path: '/calendar', 
			name : 'calendar', 
			components: {
				pageHeader: PharmacistHeader,
				content: Calendar
			}
		},
		{
			path: '/reserveMedicine', 
			name : 'reserveMedicine', 
			components: {
				pageHeader: PatientHeader,
				content: ReserveMedicine
			}
		},
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});