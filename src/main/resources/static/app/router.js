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
				pageHeader: PatientHeader,
				content: DermatologistHomePage
			}
	    },
	    { 
	    	path: '/pharmacistHomePage', 
	    	name : 'pharmacistHomePage', 
	    	component: PharmacistHomePage
	    },
	    { 
			path: '/reservation', 
            name : 'reservation', 
            component: Reservation
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
	    }
	    
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});