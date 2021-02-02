const Browse = { template: '<browse></browse>' }
const Registration = { template: '<registration></registration>' }
const Login = { template: '<login></login>' }



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
	    }
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});