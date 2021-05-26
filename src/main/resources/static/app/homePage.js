Vue.component("HomePage", {
	data: function () {
		return {
			
	}
	},
	beforeMount() {
	},
	template: `
	<div id="HomePage"  class="BackendImagePhysician">		
			<br></br><br></br>
			<br></br><br></br>
            <p><h1>WELCOME</h1></p>

				<div>
				  <div class="row">
					
					<div class="col-sm">
					</div>
                    

					<div class="col-sm">
				
					  <h3>
						<button id="LoginL" type="button" class="btn btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="Login()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					  <h3>
						<button id="SearchMed" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="MedSearch()"></button>
						</h3><br/> 
					</div>
					<div class="col-sm">
					</div>
				
				  </div>				
		</div>
		<br></br><br></br>
   	</div>
	`,
	methods: {
        Login:function(){
            this.$router.push('login');    

        },
        MedSearch:function(){
            this.$router.push('searchMedicine');    
        }
    }
});

