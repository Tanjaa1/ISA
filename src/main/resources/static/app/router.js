const Browse = { template: '<browse></browse>' }
const Registration = { template: '<registration></registration>' }
const Login = { template: '<login></login>' }
const PatientHomePage = { template: '<patientHomePage></patientHomePage>' }
const Search = { template: '<search></search>' }
const DermatologistHomePage = { template: '<dermatologistHomePage></dermatologistHomePage>' }
const PharmacistHomePage = { template: '<pharmacistHomePage></pharmacistHomePage>' }
const Reservation = { template: '<reservation></reservation>' }



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
	    	component: Login
	    },
	    { 
	    	path: '/patientHomePage', 
	    	name : 'patientHomePage', 
	    	component: PatientHomePage
	    },
	    { 
	    	path: '/search', 
	    	name : 'search', 
	    	component: Search
	    },
	    { 
	    	path: '/dermatologistHomePage', 
	    	name : 'dermatologistHomePage', 
	    	component: DermatologistHomePage
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
	    }
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});