
Vue.component("orderMedicinePharmacyAdmin", {
    data: function () {
		return {
            medicines : {},
            dueDate : {},
            medicine : {},
            pharmacy : {},
            orders : [
                {
                    medicine : {},
                    quantity : {}
                }
            ],
            priceAndQuantity : {},
            order :{
                orders : [],
                pharmacyAdmin :{
                    pharmacy: "Benu",
                    name: "Toma",
                    id: 9,
                    address: "Jovana Ducica 65",
                    country: "Srbija",
                    description: "",
                    emailComfirmed: false,
                    firstTimeLogin: false,
                    email: "toma@gmail.com",
                    phoneNumber: "06581222123",
                    surname: "Tomic",
                    city: "Novi Sad",
                    username: "toma",
                    password: "Tomic"
                },
                dueDate : null,
                id : 123
            },
            rows: ['row'],
		}
	},
    beforeMount(){
        axios.get('/medicine/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.medicines = response.data
            })   
    },
	template: ` 
    <div id="OMPA">       
            <div style = "margin-top : 14%;"/>
            <div class = "sameLineOMPA"  style ="margin-left : 5%; margin-top : 0.5%;" v-for = "(row,index) in orders">
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Select medicine to order</span>
                    </div>
                    <select class="form-control"  v-model="row.medicine.name" aria-describedby="basic-addon3" >
                        <option value=""  selected disabled> </option>
                        <option v-for = "medicine in medicines" >{{medicine.name}}</option>
                    </select>
                </div>
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                &nbsp
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Set quantitiy</span>
                    </div>
                    <div v-if = "row.medicine == null">
                        <input type = "number" min="1" class="form-control"  v-model="row.quantity" aria-describedby="basic-addon3" disabled>
                    </div>
                    <div v-else>
                        <input type = "number" min="1" class="form-control"  v-model="row.quantity" aria-describedby="basic-addon3" >
                    </div>
                </div>   
                <button class="addButtonOMPA" v-on:click="addRow(), rows[index]=false" v-if="index == 0"><i class="fa fa-plus"></i></button>     
                &nbsp
                <button class="deleteButtonOMPA" v-on:click="deleteRow(), rows[index]=false"  v-if="index == 0 && orders.length > 1"><i class="fa fa-minus"></i></button>                                             
            </div>

            <div class="input-group mb-3" style = "width : 35%; margin-left : 5%;">
                <div class="input-group-prepend" >
                    <span class="input-group-text " id="basic-addon3">Order due</span>
                </div>
                <div  style = "width : 25%;">
                    <input type = "date" min="1" class="form-control" v-model="order.dueDate" aria-describedby="basic-addon3" v-on:change = "compareDate(order.dueDate)">
                </div>
                <button type="button" class="btn btn-primary" style = "background-color : darkgrey; width : 25%; margin-left :24%;" v-on:click = "completeOrder()">Order</button>            
                </div>

    </div>
	`,
    methods: {
        compareDate: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.orderInfo.dueDate = null;
            }
        },
        addRow: function () {
            for(var med of this.medicines){
                if(this.orders[ this.orders.length-1].medicine.name == med.name){
                    this.orders[ this.orders.length-1].medicine = med
                    break;
                }
            }
            this.orders.push({
                medicine : {},
                quantity : {}
            })
        },
        deleteRow: function () {
            this.orders.pop()
        },
        completeOrder: function () {
            for(var med of this.medicines){
                for(var index in this.orders){
                    if(this.orders[index].medicine.name == med.name){
                        this.orders[index].medicine = med
                        break;
                    }
                }
            }
            for(var order of this.orders){
                if(order.quantity == null || order.medicine == null){
                    alert("Order is not complete")
                }
                if(this.order.dueDate == null){
                    alert("Order is not complete")
                }               
            }
            this.order.orders = this.orders
            axios.post('/order/add',this.order)
                .then(response => {

                })   
             
            axios.get('/pharmacy/getByName/'+ this.order.pharmacyAdmin.pharmacy)
                .then(response => {
                    this.pharmacy = response.data;
                    var names = [];
                    for(med of this.pharmacy.pricelist)
                        names.push(med.medicine.name)
                    for(med of this.order.orders){
                        if(!names.includes(med.medicine.name)){
                            this.pharmacy.pricelist.push({
                                id : null,
                                price : null,
                                medicine : med.medicine,
                                quantity : med.quantity
                            })
                            names.push(med.medicine.name)
                        }
                        else if(index in this.pharmacy.pricelist){
                            for(med of this.order.orders){
                                if(this.pharmacy.pricelist[index].medicine.name == med.medicine.name){
                                    this.pharmacy.pricelist[index].quantity = parseInt(this.pharmacy.pricelist[index].quantity) + parseInt(med.quantity)
                                }
                            }
                        }
                    }
                    axios.put('/pharmacy/update/',this.pharmacy)
                    .then(response => {
                        alert("Order successfuly set")
                    })
            })   
            


        },
    }

});

