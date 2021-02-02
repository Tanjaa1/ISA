Vue.component("search", {
	data: function () {
		return {
			users:{}
		}
	},
	beforeMount() {
	},
	template: `
	<div id="Search">				
		<div class="row search">
		  	<div class="col-sm-5"><input placeholder="Enter name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
		  	<div class="col-sm-6"><input placeholder="Enter surname" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div>
			<div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button></div>
		</div><br>
		<div class="row search">
			Sort by
			<div class="col-sm-4">
				<select class="col" id="sort" v-on:change="Sort()">
					<option selected="selected" disabled>Please select one</option>
	                	<option>Name</option>
	                    <option>Surname</option>
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
            <tbody>
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
			alert("search")
		},
		Sort:function(){
			alert("sort")
		}
	}
});

