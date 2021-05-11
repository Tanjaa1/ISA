

Vue.component("administratorAccountInfo", {
	data: function () {
		return {
            administrator: {},
            pharmacy: {},
		}
	},
	beforeMount() {
        axios
        .get('/pharmacyAdmin/getById/' + '8') 
        .then(response => {
            this.administrator = response.data
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name)
            .then(response =>{
                this.pharmacy = response.data
             })
        })
	}
    
		,
	template: `
	<div id="administratorAccountInfo">		

        <!-- Account Info -->
        </br>
        <h3 class="pi">Personal information</h3>

        <div class="input-group mb-3" style = "width : 60%; margin-left : 20%">
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Name</span>
            </div>

            <input type="text" v-model="this.administrator.name" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

            <td>&nbsp&nbsp&nbsp</td>

            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Surname</span>
            </div>

            <input type="text" v-model="this.administrator.surname" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

        </div>

    



        <div class="input-group mb-3" style = "width : 60%; margin-left : 20%">
            <div class="input-group-prepend ">
                <span class="input-group-text width" id="basic-addon3">Address</span>
            </div>
            <input type="text" v-model="this.administrator.address" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
            <td>&nbsp&nbsp&nbsp</td>
            
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">City</span>
            </div>
            <input type="text" v-model="this.administrator.city" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

        </div>

        <div class="input-group mb-3" style = "width : 60%; margin-left : 20%">
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Country</span>
            </div>
            <input type="text" v-model="this.administrator.country" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

                <td>&nbsp&nbsp&nbsp</td>


            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Phone number</span>
            </div>
            <input type="text" v-model="this.administrator.phoneNumber" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

        </div>

        <div class="input-group mb-3" style = "width : 60%; margin-left : 20%">
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Email</span>
            </div>
            <input type="text" v-model="this.administrator.email" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>

            <td>&nbsp&nbsp&nbsp</td>

            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Description</span>
            </div>

            <input type="text" v-model="this.administrator.description" class="form-control" id="basic-url" aria-describedby="basic-addon3" disabled>
        </div>

        <h3 class="pi">Pharmacy information</h3>


        <div class="input-group mb-3"  style = "width : 40%; margin-left:30%">

            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Pharmacy</span>
            </div>

            <input type="text" v-model="this.pharmacy.name" class="form-control" id="basic-url" aria-describedby="basic-addon3"  disabled>

            <td>&nbsp&nbsp&nbsp</td>


        </div>

        <div class="input-group mb-3" style = "width : 40%; margin-left:30%">
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Average grade</span>
            </div>

            <input type="text" v-model="this.pharmacy.grade" class="form-control" id="basic-url" aria-describedby="basic-addon3"  disabled>

            <td>&nbsp&nbsp&nbsp</td>

        </div>

		
    </div>
	`
	,
	methods:{
	
	}
});




