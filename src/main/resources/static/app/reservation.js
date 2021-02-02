Vue.component("reservation", {
	data: function () {
		return {
		}
	},
	beforeMount() {
	},
	template: `
	<div id="Reservation">
		<br><br><br><br><br><br>				
		<div class="row reservation">
		  	<div class="col-sm-5"><input placeholder="Enter code" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>				
		<div class="row reservation">
		  	<div class="col-sm-5">Patient:</div>
		  	<div class="col-sm-4">Patient</div><br><br>
		  	<div class="col-sm-5">Medicine:</div>
		  	<div class="col-sm-4">Patient</div>
	  	</div>
		<button type="button" style="color:white" class="btn btn-default issue" data-dismiss="modal" v-on:click="">Issue medicine</button>	
	</div>					
	`,
	methods: {
	}
});

