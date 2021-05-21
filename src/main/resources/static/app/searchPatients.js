Vue.component("dermatologistSearchPatients", {
	data: function () {
		return {
			users:null
		}
	},
	beforeMount() {
		axios
			.get('/patient/getPatientByDermatologistExamination/' + '61') 
			.then(response => {
				this.users = response.data
			})
			.catch(error => {
			})
	},
	template: `
	<div id="Search"  class="BackendImagePhysician">				
		<div class="row search">
		  	<div class="col-sm-5"><input id="name" placeholder="Enter name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div class="col-sm-6"><input id="surname" placeholder="Enter surname" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>
		<div class="row search">
			Sort by&nbsp&nbsp
			<div>
				<select class="col" id="sort" v-on:change="Sort()">
					<option selected="selected" disabled>Please select one</option>
	                	<option>Name assceding</option>
	                	<option>Name descending</option>
	                    <option>Surname assceding</option>
	                    <option>Surname descending</option>
	            </select>
	        </div>  	
		</div>
		<table id="tableApproved" class="table table-bordered search">
        	<thead>
        		<tr>
                	<th style="text-align:center">Name</th>
                	<th style="text-align:center">Surname</th>
                </tr>
            </thead>
            <tbody class="tbodyPatient">
	            <tr v-for="u in users">
	            	<td style="text-align:center">{{u.name}}</td>
	                <td style="text-align:center">{{u.surname}}</td>
	            </tr>
           </tbody>
        </table>
	</div>					
	`,
	methods: {
		Search: function(){
			var name=document.getElementById("name").value
			var surname=document.getElementById("surname").value
			if(name=="") name='%20'
			if(surname=="") surname='%20'

			axios
			.get('/patient/getPatientByDermatologistExaminationSearch/' + '61/'+name+'/'+surname) 
			.then(response => {
				this.users = response.data
			})
			.catch(error => {
			})
		},
		Sort:function(){
			if(document.getElementById("sort").value=="Name assceding"){
				this.users.sort (
					function (a, b) {
						if (a["name"] < b["name"]){
							return -1;
						} else if (a["name"] > b["name"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else if(document.getElementById("sort").value=="Surname assceding"){
				this.users.sort (
					function (a, b) {
						if (a["surname"] < b["surname"]){
							return -1;
						} else if (a["surname"] > b["surname"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else if(document.getElementById("sort").value=="Name descending"){
				this.users.sort (
					function (a, b) {
						if (a["name"] > b["name"]){
							return -1;
						} else if (a["name"] < b["name"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else{
				this.users.sort (
					function (a, b) {
						if (a["surname"] > b["surname"]){
							return -1;
						} else if (a["surname"] < b["surname"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}
		}
	}
});



Vue.component("pharmacistSearchPatients", {
	data: function () {
		return {
			users:null
		}
	},
	beforeMount() {
		axios
			.get('/patient/getPatientByPharmacistCouseling/' + '41') 
			.then(response => {
				this.users = response.data
			})
			.catch(error => {
			})
	},
	template: `
	<div id="Search"  class="BackendImagePhysician">				
		<div class="row search">
		  	<div class="col-sm-5"><input id="name" placeholder="Enter name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div class="col-sm-6"><input id="surname" placeholder="Enter surname" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>
		<div class="row search">
			Sort by&nbsp&nbsp
			<div>
				<select class="col" id="sort" v-on:change="Sort()">
					<option selected="selected" disabled>Please select one</option>
	                	<option>Name assceding</option>
	                	<option>Name descending</option>
	                    <option>Surname assceding</option>
	                    <option>Surname descending</option>
	            </select>
	        </div>  	
		</div>
		<table id="tableApproved" class="table table-bordered search">
        	<thead>
        		<tr>
                	<th style="text-align:center">Name</th>
                	<th style="text-align:center">Surname</th>
                </tr>
            </thead>
            <tbody class="tbodyPatient">
	            <tr v-for="u in users">
	            	<td style="text-align:center">{{u.name}}</td>
	                <td style="text-align:center">{{u.surname}}</td>
	            </tr>
           </tbody>
        </table>
	</div>					
	`,
	methods: {
		Search: function(){
			var name=document.getElementById("name").value
			var surname=document.getElementById("surname").value
			if(name=="") name='%20'
			if(surname=="") surname='%20'

			axios
			.get('/patient/getPatientByPharmacistCounselingSearch/' + '41/'+name+'/'+surname) 
			.then(response => {
				this.users = response.data
			})
			.catch(error => {
			})
		},
		Sort:function(){
			if(document.getElementById("sort").value=="Name assceding"){
				this.users.sort (
					function (a, b) {
						if (a["name"] < b["name"]){
							return -1;
						} else if (a["name"] > b["name"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else if(document.getElementById("sort").value=="Surname assceding"){
				this.users.sort (
					function (a, b) {
						if (a["surname"] < b["surname"]){
							return -1;
						} else if (a["surname"] > b["surname"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else if(document.getElementById("sort").value=="Name descending"){
				this.users.sort (
					function (a, b) {
						if (a["name"] > b["name"]){
							return -1;
						} else if (a["name"] < b["name"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}else{
				this.users.sort (
					function (a, b) {
						if (a["surname"] > b["surname"]){
							return -1;
						} else if (a["surname"] < b["surname"]){
							return 1;
						} else {
							return 0;   
						}
					}
				);
			}
		}
	}
});

