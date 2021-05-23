Vue.component("loyaltyProgramme", {
	data: function () {
		return {
			lpDTO:null,
            lpDTOtoUpdate:{}
		}
	},
	beforeMount() {
        axios
        .get('loyaltyProgramme/getLP/',{
          headers: {
            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
          }
        } )
        .then(response => {
            this.lpDTO = response.data
            
      
        })
        .catch(error => {
            alert('nesupjesnooo')
        })
    
		
	},
	template: `
	<div id="loyaltyProgramme"  class="BackendImagePhysician">
    <br><br>    <br><br> <br><br>
    <br><br>

    <p id="subTextl">Loyalty Programme</p>
    <br>   <br>   <br>   
    <button id="MyInformations" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="ChangeInfoShow()">Update informations</button>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Regular</span>
      </div>
      <input type="number"  v-model="lpDTO.regular" class="form-control" id="regular" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Regular Discount</span>
      </div>
      <input type="number"  v-model="lpDTO.regularDiscount" class="form-control" id="regularDiscount" aria-describedby="basic-addon3" disabled>
    </div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Silver</span>
      </div>
      <input type="number"  v-model="lpDTO.silver" class="form-control" id="silver" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Silver Discount</span>
      </div>
      <input type="number"  v-model="lpDTO.silverDiscount" class="form-control" id="silverDiscount" aria-describedby="basic-addon3" disabled>
</div>

    <div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Gold</span>
      </div>
      <input type="number"  v-model="lpDTO.gold" class="form-control" id="gold" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Gold Discount</span>
      </div>
      <input type="text"  v-model="lpDTO.goldDiscount" class="form-control" id="goldDiscount" aria-describedby="basic-addon3" disabled>
</div>

<div class="input-group mb-3">
      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Points for examination</span>
      </div>
      <input type="number"  v-model="lpDTO.pointsForExamination" class="form-control" id="pointsForEx" aria-describedby="basic-addon3" disabled>

        <td>&nbsp&nbsp&nbsp</td>


      <div class="input-group-prepend">
        <span class="input-group-text width" id="basic-addon3">Points for counseling</span>
      </div>
      <input type="text"  v-model="lpDTO.pointsForCounceling" class="form-control" id="pointsForC" aria-describedby="basic-addon3" disabled>
</div>
<button id="SaveInfo" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="saveInfo()" hidden>Save info</button>


  

        <td>&nbsp&nbsp&nbsp</td> 

<!--END registration info modal-->
<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

</div>
<br></br><br></br>

<button id="Close" type="button" class="btn1 btn-info btn-lg margin form-control" data-toggle="modal" v-on:click="close()" >Go back</button>

			
	</div>					
	`,
	methods: {
	
		ChangeInfoShow:function(){
            document.getElementById("SaveInfo").hidden=false;
            document.getElementById("regular").disabled=false;
            document.getElementById("regularDiscount").disabled=false;
            document.getElementById("silver").disabled=false;
            document.getElementById("silverDiscount").disabled=false;
            document.getElementById("gold").disabled=false;
            document.getElementById("goldDiscount").disabled=false;
            document.getElementById("pointsForEx").disabled=false;
            document.getElementById("pointsForC").disabled=false;

        },
        saveInfo:function(){
            document.getElementById("SaveInfo").hidden=true	;
            document.getElementById("regular").disabled=true;
            document.getElementById("regularDiscount").disabled=true;
            document.getElementById("silver").disabled=true;
            document.getElementById("silverDiscount").disabled=true;
            document.getElementById("gold").disabled=true;
            document.getElementById("goldDiscount").disabled=true;
            document.getElementById("pointsForEx").disabled=true;
            document.getElementById("pointsForC").disabled=true;

            this.lpDTOtoUpdate.id = this.lpDTO.id,
		      	this.lpDTOtoUpdate.regular = document.getElementById("regular").value,
		      	this.lpDTOtoUpdate.regularDiscount = document.getElementById("regularDiscount").value,
		      	this.lpDTOtoUpdate.silver = document.getElementById("silver").value,
		      	this.lpDTOtoUpdate.silverDiscount = document.getElementById("silverDiscount").value,
			      this.lpDTOtoUpdate.gold = document.getElementById("gold").value,
            this.lpDTOtoUpdate.goldDiscount = document.getElementById("goldDiscount").value,
            this.lpDTOtoUpdate.pointsForExamination = document.getElementById("pointsForEx").value,
            this.lpDTOtoUpdate.pointsForCounceling = document.getElementById("pointsForC").value,


			axios.put('/loyaltyProgramme/updateLP', this.lpDTOtoUpdate,{
        headers: {
          'Authorization': 'Bearer' + " " + localStorage.getItem('token')
        }
      } )
            .then(response => {
                alert('uspjesno')
            })
            .catch(error => {
                alert('nesupjesnooo')
            })
        },
        close:function(){
          this.$router.push('systemAdminHomaPage');
        }
}
});



