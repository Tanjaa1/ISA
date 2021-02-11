
Vue.component("newActionOrPromotion", {
    data: function () {
    return {
        medicine : {},
        newAOP : {
            id: 222,
            startDate : null,
            endDate : null, 
            text: "",
            medicine: {
                name : null,
            },
            pharmacy: {
                id: 111,
            },
        },

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
                <div class = "sameLineOMPA"  style ="margin-left : 5%; margin-top : 0.5%;" >
                    <div class="input-group mb-3" style = "width : 20%;">
                        <div class="input-group-prepend">
                            <span class="input-group-text " id="basic-addon3">Select medicine to for promotion</span>
                        </div>
                        <select class="form-control"  v-model="newAOP.medicine.name" aria-describedby="basic-addon3" >
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
                                                
            </div>

            <div class="input-group mb-3" style = "width : 35%; margin-left : 5%;">
                <div class="input-group-prepend" >
                    <span class="input-group-text " id="basic-addon3">Action start date</span>
                </div>
                <div  style = "width : 25%;">
                    <input type = "date" min="1" class="form-control" v-model="newAOP.startDate" aria-describedby="basic-addon3" v-on:change = "compareDates(newAOP.startDate)">
                </div>
                <button type="button" class="btn btn-primary" style = "background-color : darkgrey; width : 25%; margin-left :24%;" v-on:click = "completeAction()">Add</button>            
            </div>
            <div class="input-group mb-3" style = "width : 35%; margin-left : 5%;">
                <div class="input-group-prepend" >
                    <span class="input-group-text " id="basic-addon3">Action end date</span>
                </div>
                <div  style = "width : 25%;">
                    <input type = "date" min="1" class="form-control" v-model="newAOP.endDate" aria-describedby="basic-addon3" v-on:change = "compareDates(newAOP.endDate)">
                </div>
            </div>
            <div class="input-group mb-3" style = "width : 41%; margin-left : 5%;">
                <div class="input-group-prepend" >
                    <span class="input-group-text " id="basic-addon3">Action text</span>
                </div>
                <div  style = "width : 25%;">
                    <input type = "text" min="1" class="form-control" v-model="newAOP.text" aria-describedby="basic-addon3"">
                </div>
            </div>
            
        </div>
	` ,   
    methods: {
        compareDates: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.newAOP.startDate = null;
                this.newAOP.endDate = null;
            }
        },
        completeAction: function(){
            if(this.newAOP.startDate != null && this.newAOP.endDate != null && this.newAOP.text != ""){
                axios.post('/actionOrPromotion/add',this.newAOP)
                .then(response => {
                    if(response.data == null)
                        alert("Error")
                    else
                        alert("The action successfully added!")
                })
            }
            else{
                alert("Check input data")
            }
        }   
    }
});


