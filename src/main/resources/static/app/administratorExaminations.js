

Vue.component("administratorExaminations", {
	data: function () {
		return {
        existingDermatologist : {},
        passwordSame : false,
        administrator: {},
        pharmacy: {},
        dermatologists : [],
        selectedDermatologist : {},
        upcomingExaminations : [],
        newExamination : {
            Date : null,
            dermatologist : null,
            startTime : null,
            endTime : null,
            price : null,
            pharmacy : null,
            patient : null,
            isDone : null,
            report : null,
            isCanceled : null,
            id : null
        },
        allDermatologists : [],
        unemployedDermatologists : [],
		}
	},
	beforeMount() {
        axios
        .get('/pharmacyAdmin/getById/' +  localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        }) 
        .then(response => {
            this.administrator = response.data
            var pAdmin = response.data
			if(pAdmin.firstTimeLogin)
            	this.$router.push('administratorAccountInfo');
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
            .then(response =>{
                this.pharmacy = response.data
                this.newExamination.pharmacy = response.data
                axios
                .get('/dermatologist/getByPharmacyId/' + this.pharmacy.id,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                .then(response => {
                    this.dermatologists = response.data
                    this.allDermatologists = response.data
                })
                .catch(error => {
                })
                axios
                .get('/dermatologist/getUnemployedDermatolgoists/' + this.pharmacy.id,{
                    headers: {
                        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                }) 
                .then(response => {
                    this.unemployedDermatologists = response.data
                })
                .catch(error => {
                })
             })
        })
	}
    
		,
	template: `
	<div id="administratorExaminations">		
    <br>
    <h1>Select dermatologist to see free appointments</h1>
    <div>
    <div class="input-group mb-3" style = "width:25%; margin-left:37%;">
            <div class="input-group-prepend">
                <span class="input-group-text width" id="basic-addon3">Select dermatologist</span>
    </div>
        <select class="form-control" aria-label="Default select example"  v-model="selectedDermatologist" @change = "GetUpcomingFreeExaminations(selectedDermatologist.id)">
            <option v-bind:value="dermatologist" v-for = "dermatologist in dermatologists">
                <label>{{dermatologist.name}} {{dermatologist.surname}}</label>
            </option>
        </select>
    </div>
    </div>


<div v-if = "upcomingExaminations.length != 0">
    <table class="table" style = "width : 50%; margin-left:25%; color :  #515a5a   ">
        <thead class="thead-light">
            <tr>
                    <th scope="col">Free Appointments</th>
                    <th scope="col">Start time</th>
                    <th scope="col">End time</th>
                    <th scope="col">Price</th>
            </tr>
        </thead>
        <tbody>
                <tr v-for = "(examination,index) in upcomingExaminations">
                    <td scope="row">{{index+1}}</td>
                    <td>{{examination.startTime}}</td>
                    <td>{{examination.endTime}}</td>
                    <td>{{examination.price}}</td>
                </tr>
        </tbody>
    </table>
</div>
    <button id="MyInformations" type="button" style="margin-left:42%" class="btn1 btn-info btn-lg  form-control" data-toggle="modal" data-target="#newAppointment" v-on:click="">Add new free appointment</button>

  
    <!-- New Fee Appointment modal -->
        <div class="modal fade" id="newAppointment" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add appointment</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Date:</label>
                                <input type="date" class="form-control" id="recipient-name" v-model = "newExamination.Date" @change="compareDate(newExamination.Date)">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Start Time:</label>
                                <input type="time" class="form-control" id="recipient-name" v-model = "newExamination.startTime">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">End Time:</label>
                                <input type="time" class="form-control" id="recipient-name" v-model = "newExamination.endTime">
                            </div>
                            <div class="form-group">
                                <label for="recipient-name" class="col-form-label">Price:</label>
                                <input type="number" min = "0"class="form-control" id="recipient-name" v-model="newExamination.price">
                            </div>
                            <div class="form-group">
                                <label for="message-text" class="col-form-label">Dermatologist:</label>
                                <select class="form-control" aria-label="Default select example" v-model="newExamination.dermatologist">
                                    <option v-bind:value="dermatologist" v-for = "dermatologist in dermatologists">
                                        <label>{{dermatologist.name}} {{dermatologist.surname}}</label>
                                    </option>
                                </select>									
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" v-on:click="CreateNewExamination()">Finish</button>
                    </div>
                </div>
            </div>
    </div>
       
    </div>
	`
	,
	methods:{
        compareDate: function (date) {
            var day = parseInt(date.split("-")[2])
            var month = parseInt(date.split("-")[1])
            var year = parseInt(date.split("-")[0])
            var today = new Date();
            if(year < parseInt(today.getFullYear) || year == parseInt(today.getFullYear()) && month < (parseInt(today.getMonth()) + 1) ||  year == parseInt(today.getFullYear()) && month == (parseInt(today.getMonth())+1) && day <= parseInt(today.getDate())){
                alert("Please select valid date")
                this.newExamination.Date = null;
            }
        },
        CreateNewExamination: function () {
            for(var vi of this.newExamination.dermatologist.vacationSchedule){
                var dayS = parseInt(vi.dateStart.split('T')[0].split("-")[2])
                var monthS = parseInt(vi.dateStart.split('T')[0].split("-")[1])
                var yearS = parseInt(vi.dateStart.split('T')[0].split("-")[0])

                var dayE = parseInt(vi.dateEnd.split('T')[0].split("-")[2])
                var monthE = parseInt(vi.dateEnd.split('T')[0].split("-")[1])
                var yearE = parseInt(vi.dateEnd.split('T')[0].split("-")[0])

                var yearEx =  parseInt(this.newExamination.Date.split('-')[0])
                var monthEx =  parseInt(this.newExamination.Date.split('-')[1])
                var dayEx =  parseInt(this.newExamination.Date.split('-')[2])
                if(vi.approved && this.pharmacy.id == vi.pharmacyId){
                    if(yearS == yearEx && monthEx == monthS && monthE == monthS && dayS <= dayEx && dayE >= dayEx || yearS == yearEx && monthE > monthS && monthS <= monthE && dayE >= dayEx)
                    {
                        alert("Dermatologist is on vacation from " + dayS + '.' + monthS +  '.' + yearS + " to " + dayE + '.' + monthE +  '.' + yearE)
                        return                    
                    }
                }         
             }
			var startHour = parseInt(this.newExamination.startTime.split(":")[0])
            var startMinute = parseInt(this.newExamination.startTime.split(":")[1])
			var endHour = parseInt(this.newExamination.endTime.split(":")[0])
            var endMinute = parseInt(this.newExamination.endTime.split(":")[1])
			if(startHour > endHour || startHour == endHour && startMinute > endMinute || startHour == endHour && startMinute == endMinute){
				alert("Please select valid time")
			}
			else{
				this.newExamination.startTime = this.newExamination.Date + "T" +this.newExamination.startTime
				this.newExamination.endTime = this.newExamination.Date + "T" + this.newExamination.endTime
				if(this.newExamination.startTime != null && this.newExamination.endTime != null && this.newExamination.price != null && this.newExamination.dermatologist != null && this.newExamination.Date != null){
                    axios
					.post('/examination/addEmptyExamination',this.newExamination,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
					.then(response => {
                        var flag = response.data 
                        if(flag == ""){
                            alert("Dermatologist is not free for given time")
                            return
                        }
                        axios
                        .get('/examination/getUpcomingFreeExaminations/' + this.pharmacy.id +"/" +  this.newExamination.dermatologist.id,{
                            headers: {
                                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                            }
                        })
                        .then(response => {
                            this.upcomingExaminations = response.data
                            for (var i = 0; i < this.upcomingExaminations.length; i++) {
                                this.upcomingExaminations[i].endTime = this.upcomingExaminations[i].endTime.replace("T", "/");
                                this.upcomingExaminations[i].startTime = this.upcomingExaminations[i].startTime.replace("T", "/");
                              } 
                        })
                        .catch(error => {
                        })
					})
					.catch(error => {
					})
					$('#newAppointment').modal('hide');
				}
				else{
					alert("Please check parameters.")
				}
			}
		},
        GetUpcomingFreeExaminations: function (DermatologistID) {
            localStorage.setItem('selectedDermatologist',DermatologistID);
			axios
			.get('/examination/getUpcomingFreeExaminations/' + this.pharmacy.id +"/" + DermatologistID,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
			.then(response => {
				this.upcomingExaminations = response.data
                for (var i = 0; i < this.upcomingExaminations.length; i++) {
                    this.upcomingExaminations[i].endTime = this.upcomingExaminations[i].endTime.replace("T", "/");
                    this.upcomingExaminations[i].startTime = this.upcomingExaminations[i].startTime.replace("T", "/");
                  } 
			})
			.catch(error => {
			})
		},
	}
});




