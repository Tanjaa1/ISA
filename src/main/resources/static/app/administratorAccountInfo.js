

Vue.component("administratorAccountInfo", {
	data: function () {
		return {
            mapLocation : {
                x : 0,
                y : 0
            },
            administrator: {},
            pharmacy: {},
            password : "",
            showLabel : -1,
            passwordRepeat : "",
            oldPassword : "",
            jwtAuthenticationRequest:{},
		}
	},
    beforeMount() {
        axios
        .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
        .then(response => {
            this.administrator = response.data
            if(this.administrator.firstTimeLogin)
                $("#firstTIme").modal('show') 
            
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
            .then(response =>{
                this.pharmacy = response.data
                localStorage.setItem('pharmacy',this.pharmacy.id)
             })

        })

	},
    mounted(){
        axios
        .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
        .then(response => {
            this.administrator = response.data
            if(this.administrator.firstTimeLogin)
                $("#firstTIme").modal('show') 
            
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
            .then(response =>{
                this.pharmacy = response.data
                axios
                .get('/pharmacyAdmin/MapLocation/' +  this.pharmacy.id,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response =>{
                    this.mapLocation = response.data
                    this.InitializeMap()
        
        
                 })
             })

        })

        



    }
		,
	template: `
	<div id="administratorAccountInfo">		

        <!-- Account Info -->
        <br>
        <h3 class="pi">Personal information</h3> &nbsp
        <br>
        <br>

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

        <button style="color:white; width : 200px; height : 70px" type="button"  class="btn btn-default inline-block" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#changePersonalInfo">Change personal informations</button>
        <button style="color:white; width : 200px; height : 70px" type="button"  class="btn btn-default inline-block" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#changePassword">Change password</button>



        <br>
        <br>
        <h3 class="pi">Pharmacy information</h3>
        </br>
        

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

        <div class="form-group" style = "width: 27%; margin-left : 36.5%">
        <label for="recipient-name" min="0" class="col-form-label">Address:</label>
        <input type="text" min = "0"class="form-control"  v-model="pharmacy.address" disabled>
        </div>
        <div id="map" class="map" style = "margin-top : 1%; margin-bottom : 1%; margin-left : 34%; width:600px; height : 400px;"></div>


        <!-- Edit info modal -->
            <div class="modal fade" id="changePersonalInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-scrollable" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Edit personal informations</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Username:</label>
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Name:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.name">
                            </div>	
                            <div align="left" style="color: red;font-size:12px">{{nameValidation}}</div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">Surname:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.surname">
                            </div>
                            <div align="left" style="color: red;font-size:12px">{{surnameValidation}}</div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">E-mail:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.email">
                            </div>
                            <div align="left" style="color: red;font-size:12px">{{mailValidation}}</div>
                            <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">City:</label>
                            <input type="text" min = "0"class="form-control"  v-model="administrator.city">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">Country:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.country">
                            </div>
                            <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Street:</label>
                            <input type="text" min = "0"class="form-control"  v-model="administrator.address">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">Phone number:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.phoneNumber">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">Additional info:</label>
                                <input type="text" min = "0"class="form-control"  v-model="administrator.description">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" min="0" class="col-form-label">Password:</label>
                                <input type="password" class="form-control" style = "background-color : white; color : black"  v-model="password">
                            </div>
                            <label v-if = "showLabel == 1" style = "color : red">Enter your password to confirm changes</label>
                            <label v-if = "showLabel == 2" style = "color : red">Passwords are not matching</label>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" v-on:click="EditInfo(administrator)">Finish</button>
                        </div>
                    </div>
                </div>
        </div>

        <!-- Edit password modal -->
        <div class="modal fade" id="changePassword" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Change password</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Password:</label>
                            <input v-if = "passwordRepeat == ''" type="password" class="form-control" style = "background-color : white; color : black"  v-model="password">
                            <input v-else type="password" class="form-control" style = "background-color : white; color : black"  @change = "ComparePasswords()" v-model="password">
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
                            <input type="password" v-if = "password == ''" class="form-control" style = "background-color : white"  v-model="passwordRepeat" disabled>
                            <input type="password" v-else  class="form-control" style = "background-color : white; color : black"  v-model="passwordRepeat" @change = "ComparePasswords()">
                        </div>
                        <label v-if = "showLabel == 4" style = "color : red">Passwords are not matching</label>
                        <div class="form-group">
                        <label for="recipient-name" min="0" class="col-form-label">Enter old password:</label>
                            <input type="password"   class="form-control" style = "background-color : white; color : black"  v-model="oldPassword"">
                        </div>
                        <label v-if = "showLabel == 5" style = "color : red">Old password is not valid</label>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button  type="button" class="btn btn-primary" v-on:click="ChangePassword(administrator)">Finish</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- Edit password modal -->
        <div class="modal fade" id="firstTIme" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Change password</h5>
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Password:</label>
                            <input v-if = "passwordRepeat == ''" type="password" class="form-control" style = "background-color : white; color : black"  v-model="password">
                            <input v-else type="password" class="form-control" style = "background-color : white; color : black"  @change = "ComparePasswords()" v-model="password">
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Repeat password:</label>
                            <input type="password" v-if = "password == ''" class="form-control" style = "background-color : white"  v-model="passwordRepeat" disabled>
                            <input type="password" v-else  class="form-control" style = "background-color : white; color : black"  v-model="passwordRepeat" @change = "ComparePasswords()">
                        </div>
                        <label v-if = "showLabel == 4" style = "color : red">Passwords are not matching</label>
                    </div>
                    <div class="modal-footer">
                        <button  type="button" class="btn btn-primary" v-on:click="ChangePasswordFirstTime(administrator)">Finish</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
	`
	,
    computed : {
		nameValidation: function () {
			if (this.administrator.name != undefined && this.administrator.name.length > 0) {
				let nameMatch = this.administrator.name.match('[A-Za-z ]*');
				if (nameMatch != this.administrator.name) return 'The name may contain only letters';
				else if (this.administrator.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.administrator.name === '') return 'Name is a required field';
			else return null;
		},
		surnameValidation: function () {
			if (this.administrator.surname != undefined && this.administrator.surname.length > 0) {
				let surnameMatch = this.administrator.surname.match('[A-Za-z ]*');
				if (surnameMatch != this.administrator.surname) return 'The surname may contain only letters';
				else if (this.administrator.surname[0].match('[A-Z]') === null) return 'The surname must begin with a capital letter';
			}
			else if (this.administrator.surname === '') return 'Surname is a required field';
			else return null;
		},
		mailValidation: function () {
			if (this.administrator.email != undefined && this.administrator.email.length > 0) {
				let mailMatch = this.administrator.email.match("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$");
				if (mailMatch != this.administrator.email) return 'Please insert correct email form';
			}
			else if (this.administrator.email === '') return 'Email is a required field';
			else return null;
		},
    },
	methods:{
        EditInfo:function(administrator){
            if(administrator.username != "" && administrator.email != "" && administrator.name != "" && administrator.surname != "" && administrator.phoneNumer != "" && administrator.address != "" && administrator.city != "" && administrator.country != "")
                if(this.password.valueOf() == ""){
                    this.showLabel = 1;
                    alert("Enter password")
                }
                else if(this.password.valueOf() != administrator.password.valueOf()){
                    this.showLabel = 2;
                    alert("Passwords are not matching")
                }
                else{
                    axios
                    .put('/pharmacyAdmin/updateAdmin',administrator,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        axios
                        .put('api/updateUserByPharmacyAdmin',this.administrator,{
                            headers: {
                                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                            }
                        }) 
                        .then(response => {

                        })
                        var r = response.data
                        if(r.valueOf() == "OK"){
                            $('#changePersonalInfo').modal('hide');
                            axios
                            .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							}) 
                            .then(response => {
                                this.administrator = response.data
                                this.showLabel = -1;
                                this.password = "";
                            })
                        }
                        else if(r.valueOf() == "USERNAME")
                            alert("This username is already taken")
                        else if(r.valueOf() == "EMAIL")
                            alert("This e-mail is already taken")
                        else if(r.valueOf() == "EMAILUSERNAME")
                            alert("E-mail and username are already taken")
                    })
                    
                }
            else{
                alert("No fields except \"Additional info\" can be empty")
            }
        },
        ComparePasswords : function(){
            if(this.password.valueOf() != this.passwordRepeat.valueOf())
                this.showLabel = 4
            else
                this.showLabel = -2
        },
        ChangePassword : function(administrator){
             if(this.password.valueOf() != this.passwordRepeat.valueOf()){
                this.showLabel = 4

            }
           else if(this.oldPassword.valueOf() != this.administrator.password.valueOf()){
                this.showLabel = 5
            }

            else {
                    this.administrator.password = this.password
                    axios
                    .put('/pharmacyAdmin/updateAdmin',this.administrator,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        axios
                        .put('api/updateUserByPharmacyAdmin',this.administrator,{
                            headers: {
                                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                            }
                        }) 
                        .then(response => {

                        })
                        var r = response.data
                        if(r.valueOf() == "OK"){
                            $('#changePersonalInfo').modal('hide');
                            axios
                            .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							}) 
                            .then(response => {
                                this.administrator = response.data
                                this.showLabel = -1;
                                this.password = "";
                                this.passwordRepeat = "";
                                this.oldPassword = "";
                                $('#changePassword').modal('hide');

                            })
                        }
                    })
                                   
            }

        },
        ChangePasswordFirstTime : function(administrator){


            if(this.password.valueOf() != this.passwordRepeat.valueOf()){
               this.showLabel = 4

           }
           else {
            this.administrator.password = this.password
            this.administrator.firstTimeLogin = false
                   axios
                   .put('/pharmacyAdmin/updateAdmin',this.administrator,{
                       headers: {
                           'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                       }
                   })
                   .then(response =>{

                        
                       var r = response.data
                       if(r.valueOf() == "OK"){
                           
                        
                            axios
                            .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
								headers: {
									'Authorization': 'Bearer' + " " + localStorage.getItem('token')
								}
							}) 
                            .then(response => {
                                this.administrator = response.data
                                this.showLabel = -1;
                                this.password = "";
                                this.passwordRepeat = "";
                                this.oldPassword = "";
                                $('#firstTIme').modal('hide');

                            })

                            axios
                            .put('api/updateUserByPharmacyAdmin',this.administrator,{
                                headers: {
                                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                                }
                            }) 
                            .then(response => {
                                this.administrator = response.data
                                this.showLabel = -1;
                                this.password = "";
                                this.passwordRepeat = "";
                                this.oldPassword = "";
                                $('#firstTIme').modal('hide');
    
                            })
    
                       }
                   })
                                  
           }

       },
       InitializeMap : function(){


        var attribution = new ol.control.Attribution({
            collapsible: false
        });
       
        var map = new ol.Map({
            controls: ol.control.defaults({attribution: false}).extend([attribution]),
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.OSM()
                })
            ],
            target: 'map',
            view: new ol.View({
                center: ol.proj.fromLonLat([ this.mapLocation.xaxis, this.mapLocation.yaxis]),
                maxZoom: 20,
                zoom: 18
            })
        });

        var layer = new ol.layer.Vector({
            source: new ol.source.Vector({
                features: [
                    new ol.Feature({
                        geometry: new ol.geom.Point(ol.proj.fromLonLat([this.mapLocation.xaxis, this.mapLocation.yaxis]))
                    })
                ]
            })
        });
        map.addLayer(layer);


       }
	}
});




