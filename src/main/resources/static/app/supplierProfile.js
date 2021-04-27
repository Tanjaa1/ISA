Vue.component("supplierProfile", {
	data: function () {
		return {
			pharmacies:null
		}
	},
	beforeMount() {
		
	},
	template: `
	<div id="SupplierProfile"  class="BackendImagePhysician">
    <br></br><br></br>
    <br></br><br></br>
        <div>
          <div class="row">
            <div class="col-sm">
            </div>
            <div class="col-sm">
            </div>
            <div class="col-sm">
            </div>
         
            <div class="col-sm">
              <h3>
                <button id="personalInfo" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="personalInfo()"></button>
                </h3><br/> 
            </div>
            <div class="col-sm">
              <h3>
                <button id="MyOffers" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="AccountShow()"></button>
                </h3><br/> 
            </div>
            <div class="col-sm">
              <h3>
                <button id="giveOffers" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="medicineReservation()"></button>
                </h3><br/> 
            </div>
         
            <div class="col-sm">
            </div>
            <div class="col-sm">
            </div>  
            <div class="col-sm">
            </div>
          </div>				
</div>
<br></br><br></br>

			
			
	</div>					
	`,
	methods: {
    personalInfo:function(){
      this.$router.push('supplierInfo');

    },
		Search:function(){
			var text=document.getElementById("idText").value
			var onPrescriptionText=document.getElementById("onPrescription").value
			var type=document.getElementById("type").value
			var form=document.getElementById("form").value
			var mark=document.getElementById("mark").value
		
		
				axios
				.get('medicine/combinedSearch/'+text+'x'+type+'x'+form+'x'+mark+'x'+onPrescriptionText)
				.then(response => {
					this.pharmacies = response.data
			  
				})
				.catch(error => {
					alert('nesupjesnooo')
				})
			

		
		},

		ShowComposition:function(composition){

			alert('Composition:' + composition)

		}
		
	}
});

