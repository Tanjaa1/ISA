const Browse = { template: '<browse></browse>' }
const Registration = { template: '<registration></registration>' }
const Login = { template: '<login></login>' }
const PatientHomePage = { template: '<patientHomePage></patientHomePage>' }
const Search = { template: '<search></search>' }
const DermatologistHomePage = { template: '<dermatologistHomePage></dermatologistHomePage>' }
const PharmacistHomePage = { template: '<pharmacistHomePage></pharmacistHomePage>' }
const Reservation = { template: '<reservation></reservation>' }
const PatientInfo = { template: '<patientInfo></patientInfo>' }
const PatientHeader = { template: '<patientHeader></patientHeader>' }
const PageHeader = { template: '<pageHeader></pageHeader>' }
const ChangePatientInfo = { template: '<changePatientInfo></changePatientInfo>' }

const DermatologistsPreview = { template: '<dermatologistsPreview></dermatologistsPreview>'}
const PharmacistsPreview = { template: '<pharmacistsPreview></pharmacistsPreview>'}

const PharmaciesShow = { template: '<pharmaciesShow></pharmaciesShow>' }
const PatientExamination = { template: '<patientExamination></patientExamination>' }
const PatientCounceling = { template: '<patientCounceling></patientCounceling>' }

const DermatologistInfo = { template: '<dermatologistInfo></dermatologistInfo>' }
const ChangeDermatologistInfo = { template: '<changeDermatologistInfo></changeDermatologistInfo>' }
const PharmacistHeader = { template: '<pharmacistHeader></pharmacistHeader>' }

const PharmacistInfo = { template: '<pharmacistInfo></pharmacistInfo>' }
const ChangePharmacistInfo = { template: '<changePharmacistInfo></changePharmacistInfo>' }
const DermatologistHeader = { template: '<dermatologistHeader></dermatologistHeader>' }


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
	    	path: '/search', 
	    	name : 'search', 
			components: {
				pageHeader: PatientHeader,
				content: Search
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
	},		{ 
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
	}
	    
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});