const Browse = { template: '<browse></browse>' }
const Registration = { template: '<registration></registration>' }
const Login = { template: '<login></login>' }
const PatientHomePage = { template: '<patientHomePage></patientHomePage>' }



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
	    }
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});