Vue.component("supplierProfile", {
	data: function () {
		return {
			pharmacies:null,
      supplier:{},
      supplier1:{}
		}
	},
	beforeMount() {},
  Mount(){

      axios.get('supplier/getById/'+ localStorage.getItem('userId'),
            {
            headers: {
              'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
          })
      .then(response => {
      supplier=response.data
      if(supplier.firstTimeLogin==true){
        $('#Show').modal('show');    
      }else{
        alert("uspjesno")
      }
      })
      .catch(error => {
        alert('nesupjesnooo jee')
      })
         
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
                <button id="MyOffers" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="OffersShow()"></button>
                </h3><br/> 
            </div>
            <div class="col-sm">
              <h3>
                <button id="giveOffers" type="button" class="btn btn-info btn-lg margin form-control" v-on:click="GiveOffer()"></button>
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

<!--MODAL-->
<div class="modal fade" tabindex="-1" role="dialog" id="Show" >
<div class="modal-dialog search" role="document">
  <div class="modal-content">
  <div class="modal-header">
    <h5 class="modal-title">Please change password</h5>
  </div>
  <div class="modal-body search">
        New password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input id="np" type="password" minlength="8"></br></br>
        
        Confirm password:\xa0\xa0\xa0\xa0\xa0\xa0\xa0<input type="password" id="cp" name="password" minlength="8"></br>
  </div>
  <div class="modal-footer">
      <button type="button" class="btn btn-info btn-lg" v-on:click="Yes()">Confirm</button>
  </div>
  </div>
  </div>
</div>
			
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
    OffersShow:function(){
      this.$router.push('suppliersOffers');
    }
		,
    GiveOffer:function(){
      this.$router.push('giveOffers');
    },
    Yes:function(){
			if(document.getElementById("np").value==document.getElementById("cp").value && document.getElementById("np").value.trim()!="" && document.getElementById("cp").value.trim()!=""){
				$('#Show').modal('hide');
			

        axios
        .get('supplier/getById/'+ localStorage.getItem('userId'),
              {
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
        .then(response => {
        supplier=response.data
        supplier.firstTimeLogin=false
				supplier.password=document.getElementById("np").value
        axios.put('/supplier/update', supplier,{
          headers: {
            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
          }
        })
          .then(function (response) {
            axios.put('/api/updateUserBySupplier', supplier,{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
              .then(function (response) {
              })
              .catch(function (error) {
              });
          })
          .catch(function (error) {
          });
        })
        .catch(error => {
          alert('nesupjesnooo')
        })


					
			}else{
				alert('Comfire password!')
			}
		}
	}
});

