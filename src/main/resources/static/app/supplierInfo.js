Vue.component("supplierInfo", {
	data: function () {
		return {
			supplierDTO:null,
            supplierToUpdate:{}
		}
	},
	beforeMount() {
        axios
        .get('supplier/getById/'+'10')
        .then(response => {
            this.supplierDTO = response.data
      
        })
        .catch(error => {
            alert('nesupjesnooo')
        })
    
		
	},
	template: `
	<div id="SupplierInfo"  class="BackendImagePhysician">
    <p id="subText">My Personal Info</p>
    <br>   <br>   <br>   <br>   <br>   <br>   <br>   <br>
    <button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="ChangeAccountInfoShow()">Update informations</button>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Name</span>
      </div>
      <input type="text"  v-model="supplierDTO.name" class="form-control" id="name" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Surname</span>
      </div>
      <input type="text"  v-model="supplierDTO.surname" class="form-control" id="surname" aria-describedby="basic-addon3" disabled>
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Address</span>
      </div>
      <input type="text"  v-model="supplierDTO.address" class="form-control" id="address" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Country</span>
      </div>
      <input type="text"  v-model="supplierDTO.country" class="form-control" id="country" aria-describedby="basic-addon3" disabled>
</div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">City</span>
      </div>
      <input type="text"  v-model="supplierDTO.city" class="form-control" id="city" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Phone number</span>
      </div>
      <input type="text"  v-model="supplierDTO.phoneNumber" class="form-control" id="phoneNumber" aria-describedby="basic-addon3" disabled>
</div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Email</span>
      </div>
      <input type="text"  v-model="supplierDTO.email" class="form-control" id="email" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Username</span>
      </div>
      <input type="text"  v-model="supplierDTO.username" class="form-control" id="username" aria-describedby="basic-addon3" disabled>
</div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Password</span>
      </div>
      <input type="text"  v-model="supplierDTO.password" class="form-control" id="password" aria-describedby="basic-addon3" disabled>
        <br><br><br>
      <button id="SaveInfo" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="saveInfo()" hidden>Save info</button>


        <td>&nbsp&nbsp&nbsp</td> 

<!--END registration info modal-->

</div>
<br></br><br></br>

			
			
	</div>					
	`,
	methods: {
	
		ChangeAccountInfoShow:function(){
            document.getElementById("SaveInfo").hidden=false;
            document.getElementById("name").disabled=false;
            document.getElementById("surname").disabled=false;
            document.getElementById("address").disabled=false;
            document.getElementById("country").disabled=false;
            document.getElementById("city").disabled=false;
            document.getElementById("phoneNumber").disabled=false;
            document.getElementById("email").disabled=false;
            document.getElementById("username").disabled=false;
            document.getElementById("password").disabled=false;
        },
        saveInfo:function(){
            document.getElementById("SaveInfo").hidden=true	;
            document.getElementById("name").disabled=true;
            document.getElementById("surname").disabled=true;
            document.getElementById("address").disabled=true;
            document.getElementById("country").disabled=true;
            document.getElementById("city").disabled=true;
            document.getElementById("phoneNumber").disabled=true;
            document.getElementById("email").disabled=true;
            document.getElementById("username").disabled=true;
            document.getElementById("password").disabled=true;

            this.supplierToUpdate.id = this.supplierDTO.id,
			this.supplierToUpdate.name = document.getElementById("name").value,
			this.supplierToUpdate.surname = document.getElementById("surname").value,
			this.supplierToUpdate.address = document.getElementById("address").value,
			this.supplierToUpdate.city = document.getElementById("city").value,
			this.supplierToUpdate.country = document.getElementById("country").value,
			this.supplierToUpdate.phoneNumber = document.getElementById("phoneNumber").value,
			this.supplierToUpdate.email = document.getElementById("email").value,
			this.supplierToUpdate.password = document.getElementById("password").value,
			this.supplierToUpdate.username = document.getElementById("username").value,
      this.supplierToUpdate.firstTimeLogin = this.supplierDTO.firstTimeLogin,
      this.supplierToUpdate.description = this.supplierDTO.description,
      this.supplierToUpdate.emailComfirmed = this.supplierDTO.emailComfirmed,
		
		alert(this.supplierToUpdate.name)

			axios.put('/supplier/update',this.supplierToUpdate)
            .then(response => {
                alert('uspjesno')
            })
            .catch(error => {
                alert('nesupjesnooo')
            })
        }
}
});



