Vue.component("administratorHeader", {
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
                            <button type="button" class="btn btn-info btn-lg nav-link navbar-brand dropdown-toggle" href="#" id="navbarDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >MENU</button>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" v-on:click="AdministratorHome()">Home</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" v-on:click="MyAccount()">My account</a>
                                <a class="dropdown-item" v-on:click="Employees()">Pharmacy employees</a>
                                <a class="dropdown-item" v-on:click="NewExamination()">Create new examination</a>
                                <a class="dropdown-item" v-on:click="MedicineShow()">Medicine overview and promotions</a>
                                <a class="dropdown-item" v-on:click="OrdersAndRequests()">Orders and requests</a>
                                <a class="dropdown-item" v-on:click="SearchMedicine()">Search medicine</a>
                                <a class="dropdown-item" v-on:click="Reports()">Reports overview</a>
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
	</div>

	`,
    methods: {
        AdministratorHome: function () {
            this.$router.push('administratorHomePage');
        },
        MyAccount: function () {
            this.$router.push('administratorAccountInfo');
        },
        NewExamination: function () {
            this.$router.push('administratorExaminations');
        },
        MedicineShow: function () {
            this.$router.push('administratorMedicine');
        },
        OrdersAndRequests: function () {
            this.$router.push('orderMedicinePharmacyAdmin');
        },
        SearchMedicine: function () {
            this.$router.push('searchMedicine');
        },
        Reports: function () {
            this.$router.push('reportAdministrator');
        },
        Employees: function () {
            this.$router.push('administratorEmployed');
        },
        Logout: function () {
            localStorage.setItem('userId', "");
            localStorage.setItem('token', "");

            this.$router.push("/")

        }
    }


});
