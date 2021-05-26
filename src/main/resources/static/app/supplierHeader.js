Vue.component("supplierHeader", {
    data: function () {
        return {
         
        }
    },
    beforeMount(){
    },
    
    template: `
	<div>
		<div id="temp">
        <nav class="navbar navbar-expand-lg navbar-custom " id="navigationBar">
            <div class="collapse navbar-collapse " id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >Supplier menu</button>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" v-on:click="personalInfo()">My info</a>
                            <a class="dropdown-item" v-on:click="OffersShow()"> Offers</a>
                            <a class="dropdown-item" v-on:click="GiveOffer()">Give offers</a>
                         
                            <div class="dropdown-divider"></div>
 
                            <a class="dropdown-item" v-on:click="Logout()">Log out</a>
                        </div>     
                    </li>
                    <!--<li class="nav-item">
                        <h1 class="navbar-brand" id="clinicLogoTxt">Health Clinic</h1>
                        <img src="pictures/logInverted.png" id="clinicLogoPic">
                    </li>-->
                </ul>
            </div>
        </nav>
    </div>
    <!--Modal for create examination-->
                    <div class="modal fade" id="notReservation"  tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" style="width: 100%;" role="document">
                           <div class="modal-content steps">
                          <div class="container" align="center">
                              <br/><h4 class=""></h4><br/>
                              <h3>You have 3 or more penalty so you are not allowed to go on page for ePrescription</h3>
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
      OffersShow:function(){
        this.$router.push('suppliersOffers');
      }
          ,
      GiveOffer:function(){
        this.$router.push('giveOffers');
      },
      Logout:function(){
        localStorage.setItem('userId', "");
        localStorage.setItem('token', "");
        localStorage.setItem('role', "");

        this.$router.push("/")
      }
    }


});
