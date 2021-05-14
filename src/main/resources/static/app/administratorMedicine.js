

Vue.component("administratorMedicine", {
	data: function () {
		return {
        administrator: {},
        pharmacy: {},
        newMPQ : {
            id : null,
            medicine : null,
            quantity : null,
            price : null
        },
        displayedMedicine : [],
        updateMedicine : {
            price : null,
            quantity : null
        },
        selectedMedicine : {},
        allMedicine : [],
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
                this.displayedMedicine = this.pharmacy.pricelist
                var pricelist = this.pharmacy.pricelist
                axios
                .get('/medicine/getAllAR')
                .then(response => {
                    this.allMedicine = response.data
                    var tempList = []
                    for(var medA of this.allMedicine){
                        for(var medP of pricelist){
                            if((medA.name.valueOf() !=  medP.medicine.name.valueOf())){
                                tempList.push(medA)
                                break
                            }
                        }
                    }
                    this.allMedicine = tempList
                })
                .catch(error => {
                })
             })
        })
	}
    
		,
	template: `
	<div id="administratorMedicine">		
        <br>
        <h1>Medicine</h1>
        <br>
        <!-- Medicine -->
        <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
            <thead class="thead-light">
                <tr>
                    <th scope="col">Medicine</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Id</th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for = "(medicine,index) in displayedMedicine">
                    <td scope="row">{{index+1}}</td>
                    <td>{{medicine.medicine.name}}</td>
                    <td>{{medicine.price}}</td>
                    <td>{{medicine.quantity}}</td>
                    <td>{{medicine.id}}</td>
                    <td><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="DeleteMedicine(medicine)"><i class="fa fa-trash"></i></button>
                    <button style="color:white" type="button" class="btn btn-default" data-toggle="modal" data-target="#changeMedicineModal" v-on:click = "selectMedicine(medicine)"><i class="fa fa-cog"></i></button>
                    </td>
                </tr>
            </tbody>
        </table>

        <div class="input-group mb-3" style = "width : 50%; margin-left:33%">
            <div class="col-sm-6"><input id="medicineName" placeholder="Search by medicine name" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default"></div> &nbsp
            <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="SearchMedicine()"><i class="fa fa-search"></i></button></div> &nbsp
            <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="ResetMedicineSearch()"><i class="fa fa-refresh"></i></button></div> &nbsp
            <div><button style="color:white" type="button" class="btn btn-default" data-dismiss="modal" v-on:click="" data-toggle="modal" data-target="#addMedicineModal"><i class="fa fa-plus-square"></i></button></div> &nbsp
        </div>
        </br>
        </br>

        <!-- Add medicine modal -->
        <div class="modal fade" id="addMedicineModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add medicine</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div>
                            <label for="recipient-name" min="0" class="col-form-label">Select medicine:</label>
                            <select class="form-control" aria-label="Default select example" v-model="newMPQ.medicine">
                                <option v-bind:value="medicine" v-for = "medicine in allMedicine" >
                                    <label>{{medicine.name}}</label>
                                </option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="recipient-name" class="col-form-label">Set price:</label>
                            <input type="number" min = "0"class="form-control"  v-model="newMPQ.price">
                        </div>	
                        <div class="form-group">
                            <label for="recipient-name" min="0" class="col-form-label">Set quantity:</label>
                            <input type="number" min = "0"class="form-control"  v-model="newMPQ.quantity">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" v-on:click="addNewMedicine()">Add medicine</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Change medicine Modal -->
        <div class="modal fade" id="changeMedicineModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Change medicine</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Set price:</label>
                        <input type="number" min = "0"class="form-control"  v-model="updateMedicine.price">
                    </div>	
                    <div class="form-group">
                        <label for="recipient-name" min="0" class="col-form-label">Set quantity:</label>
                        <input type="number" min = "0"class="form-control"  v-model="updateMedicine.quantity">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" v-on:click="UpdateMedicine(selectedMedicine,administrator)">Save changes</button>
                </div>
                </div>
            </div>
        </div>

    </div>
	`
	,
	methods:{
        selectMedicine : function(med){
			this.selectedMedicine = med
		},
		addNewMedicine : function(){
			if(this.newMPQ.medicine != null || this.newMPQ.quantity != null || this.newMPQ.price != null){
				axios
				.post('medicine/addToPricelist' + '/' + this.pharmacy.id,this.newMPQ)
				.then(response => { 
					this.newMPQ.medicine = null
					this.newMPQ.quantity = null
					this.newMPQ.price = null
					axios
						.get('/pharmacy/getByName/' + this.administrator.pharmacy.name) 
						.then(response => {
							this.pharmacy = response.data
							this.displayedMedicine = this.pharmacy.pricelist})
					alert("Sucessfuly added")
					})
			}
			else{
				alert("Please enter all data")
			}
			
		},
		DeleteMedicine: function (medicine) {
			axios
			.delete('/medicine/deleteFromPricelist' + '/' + medicine.id + '/' + this.pharmacy.id,{
				data: {
				  source: medicine
				}
			  })
			.then(response => {
				if(response.data == false){
					alert("Medicine is reserved")
				}
                axios
                .get('/pharmacy/getByName/' + this.administrator.pharmacy.name)
                .then(response =>{
                    this.pharmacy = response.data
                    this.displayedMedicine = this.pharmacy.pricelist
                    var pricelist = this.pharmacy.pricelist
                    axios
                    .get('/medicine/getAllAR')
                    .then(response => {
                        this.allMedicine = response.data
                        var tempList = []
                        for(var medA of this.allMedicine){
                            for(var medP of pricelist){
                                if((medA.name.valueOf() !=  medP.medicine.name.valueOf())){
                                    tempList.push(medA)
                                    break
                                }
                            }
                        }
                        this.allMedicine = tempList
                    })
                    .catch(error => {
                    })
                 })

            })
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
        UpdateMedicine: function(medicine,admin){
			if(this.updateMedicine.price != null)
				medicine.price = this.updateMedicine.price
			if(this.updateMedicine.quantity != null)
				medicine.quantity = this.updateMedicine.quantity

			if(this.updateMedicine.quantity != null && this.updateMedicine.price != null){
				axios.put('/medicine/saveMedicinePriceAndQuantity', medicine)
				.then(function (response) {
					axios
						.get('/pharmacy/getByName/' + this.administrator.pharmacy.name) 
						.then(response => {
							this.pharmacy = response.data
							this.displayedMedicine = this.pharmacy.pricelist
                            var pricelist = this.pharmacy.pricelist
                            axios
                            .get('/medicine/getAllAR')
                            .then(response => {
                                this.allMedicine = response.data
                                var tempList = []
                                for(var medA of this.allMedicine){
                                    for(var medP of pricelist){
                                        if((medA.name.valueOf() !=  medP.medicine.name.valueOf())){
                                            tempList.push(medA)
                                            break
                                        }
                                    }
                                }
                                this.allMedicine = tempList
                            })
                        })
				})
				.catch(function (error) {
					alert("error");
				});
				this.updateMedicine.quantity = null
				this.updateMedicine.price = null
			}
			$('#changeMedicineModal').modal('hide');
		},
		ResetMedicineSearch: function(){
			document.getElementById("medicineName").value = ""

			this.displayedMedicine = this.pharmacy.pricelist
		},
	}
});




