Vue.component("pharmacyMedicine", {
	data: function () {
		return {
            pharmacy : {},
            patient : null,
            pharmacy: {},
            displayedMedicine : [],
            selectedMedicine : {},
            medicine : {},
            newReservation : {
                id : null,
                medicine : null,
                expirationDate : null,
                isRecieved : null,
                patient : null,
                pharmacy : null,
                isRecieved : null,
            }
		}
	},
	beforeMount() {
        axios
        .get('/patient/getPatientById/' + 88,{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
        .then(response =>{
            this.patient = response.data
            this.newReservation.patient = this.patient
        })

        axios
        .get('/pharmacy/getByName/' + "Feniks",{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
        .then(response =>{
            this.pharmacy = response.data
            this.newReservation.pharmacy = this.pharmacy

            this.displayedMedicine = this.pharmacy.pricelist

         })
	},
	template: `
	<div id="pharmacyEmployees">
	<div id="mySidenav" class="sidenav d-inline" style = "width : 10%; background-color : GoldenRod; " >
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "EmployeesShow()">Appoint now</button>
			<button href="#" class = "form-control" style = "width : 100%; background-color : GoldenRod; height : 90px" v-on:click = "HomeShow()">Home</button>
		</div>

		<div  class = "d-inline" style = "">	
        <h1></h1>
        <h1></h1>
        <h1></h1>
        <h1>Select medicine to reserve</h1>
        <h1></h1>

        <!-- Medicine -->
        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col" v-if = "patient != null"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for = "(medicine,index) in displayedMedicine">
                    <td>{{medicine.medicine.name}}</td>
                    <td>{{medicine.price}} rsd</td>
                    <td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SelectMedicine(medicine)" data-toggle="modal" data-target="#selectQuantity"><i class="fa fa-shopping-cart"></i></button></td>
                </tr>
            </tbody>
        </table>

        <div class="input-group mb-3" style = "width : 50%; margin-left:33%">
            <div class="col-sm-6"><input id="medicineName" placeholder="Search by medicine name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div> &nbsp
            <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SearchMedicine()"><i class="fa fa-search"></i></button></div> &nbsp
            <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetMedicineSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
        </div>

        <!-- Modal -->
        <div class="modal fade" id="selectQuantity" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Select quantity to order</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                <br>
                <label style = "margin-right:80%">Select date:</label>
                <input id="date" v-model = "newReservation.expirationDate" type="date" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default" @change = "compareDate(newReservation.expirationDate)">
                <br>
               </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" v-on:click = "MakeReservation">Finish reservation</button>
                </div>
                </div>
            </div>
        </div>


        </div>
	</div>					
	`,
	methods: {
       
        HomeShow : function(){
            this.$router.push('pharmacyHomePage');
        },
        EmployeesShow : function(){
            this.$router.push('pharmacyEmployees');
        },
        SearchMedicine: function(){

			this.displayedMedicine = this.pharmacy.pricelist

			var name=document.getElementById("medicineName").value
			var newMedicine = []
			for (const med of this.displayedMedicine) {
					if(med.medicine.name.toLowerCase().includes(name.toLowerCase()))
						newMedicine.push(med)
			  }
			this.displayedMedicine = newMedicine
		},
        ResetMedicineSearch: function(){
			document.getElementById("medicineName").value = ""

			this.displayedMedicine = this.pharmacy.pricelist
		},
        SelectMedicine: function(medicine){
			this.newReservation.medicine = medicine
		},
        MakeReservation: function(){
            if(this.newReservation.expirationDate != null){
                this.newReservation.expirationDate = this.newReservation.expirationDate + "T00:00:00"
                axios
                .post('/reservation/makeNewReservation', this.newReservation,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                })
                .then(response => {
                    this.pharmacies = response.data
                    this.newReservation.expirationDate = null;

                    alert("Reservation sucessfuly created")
                    $("#selectQuantity").modal('hide');
                })
                .catch(error => {
                })
            }
            else alert("Please select date")
        },
        compareDate: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.newReservation.expirationDate = null;
            }
        },
    }
});

