const Browse = { template: '<browse></browse>' }

const router = new VueRouter({
	  mode: 'hash',
	  routes: [
	    { 
	    	path: '/', 
	    	name : 'browse', 
	    	component: Browse
	    }
	  ]
});

var app = new Vue({
	router,
	el: '#routerMode'
});