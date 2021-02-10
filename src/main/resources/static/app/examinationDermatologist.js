
Vue.component("createExaminationDermatologist", {
	data: function () {
		return {
			patients:null,
            newExamination: {
                startTime:null,
                endTime:null,
                patient:null,
                dermatologist:null,
                id:null,
                idDone:false,
                pharmacy:null,
                report:"",
                price:1000.00             
            },
            patient:null,
            future:null
		}
	},
	beforeMount() {
            axios
            .get('/patient/getPatientByDermatologistExamination/' + '6') 
            .then(response => {
                this.patients = response.data
            })
            .catch(error => {
            })
            axios
            .get('/examination/getFreeExaminationByDermatologist/' + '6')
            .then(response => {
                this.future = response.data
            })
            .catch(error => {
            })
	},
	template: `
	<div id="ExaminationDermatologist" class="BackendImagePhysician"> 
        <div class="container search">
            <div class="md-form mx-5 my-5">
                Choose patient</br>
                <select class="col" id="sort" v-model="patient">
                    <option selected="selected" disabled>Please select one</option>
                    <option v-for="p in patients">{{p.name}} {{p.surname}}</option>
                </select>		
            </div>		
        </div>
            <!--SCHEDULE-->
                    <!--BODY-->
                        <div class= "container"></br></br></br>
                                        <ul class="nav nav-tabs" role="tablist">
                                            <li class="nav-item">
                                                <a id="existingTab" class="nav-link active .cards" data-toggle="tab" href="#existing">EXISTING</a>
                                            </li>
                                            <li class="nav-item">
                                                <a id="newTab" class="nav-link .cards" data-toggle="tab" href="#new">NEW</a>
                                            </li>
                                        </ul>
                                        <div>
                                            <div class="tab-content">
                                                <div id="existing" class="container tab-pane active"><br>
                                                    <div class="container">
                                                            <div class="row">
                                                                <table id="tableApproved" class="table table-bordered">
                                                                    <thead>
                                                                    <tr>
                                                                        <th>Date</th>
                                                                        <th>Start</th>
                                                                        <th>End</th>
                                                                        <th>Price</th>
                                                                        <th>Schedule</th>
                                                                    </tr>
                                                                    </thead>
                                                                    <tbody class="tbodyPatient">
                                                                    <tr v-for="f in future">
                                                                        <td>{{f.startTime.split('T')[0]}}</td>
                                                                        <td>{{f.startTime.split('T')[1]}}</td>
                                                                        <td>{{f.endTime.split('T')[1]}}</td>
                                                                        <td>{{f.price}}</td>
                                                                        <td><button class=" btn btn-info btn-lg" v-on:click="Schedule(f)">Schedule</button></td>
                                                                    </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                    </div>			     
                                                </div>
                                                <div id="new" class="container tab-pane fade"><br>
                                                    <div class="container">
                                                        <div class="md-form mx-5 my-5">
                                                            Choose date:</br>
                                                            <input style="height:25px" id="date" type="date"></input>
                                                        </div>
                                                        <div class="md-form mx-5 my-5">
                                                            Choose start time
                                                            <input type="time" id="start" class="form-control">
                                                        </div>
                                                        <div class="md-form mx-5 my-5">
                                                            Choose end time
                                                            <input type="time" id="end" class="form-control">
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <button id="cancelF" type="button" class="btn btn-info btn-lg " v-on:click="NewEx()">Schedule</button>
                                                </div>
                                            </div>
                                        </div></br>
                                    </div>
    </div>			
	`,
	methods: {
        Schedule: async function(f){
            f.patient=this.examination.patient
            var fut=[]
            await axios.put('/examination/schedule',f)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
                axios
                .get('/examination/getFreeExaminationByDermatologist/' + '6')
                .then(function (odg){
                    this.future=odg.response
                    location.reload()
                })
                .catch(error => {
                })
            })
            .catch(function (error) {
            });  
        },
        NewEx:function(){
            this.newExamination.startTime=document.getElementById("date").value+'T'+document.getElementById("start").value
            this.newExamination.endTime=document.getElementById("date").value+'T'+document.getElementById("end").value
            this.newExamination.patient=this.patient
            //this.newExamination.dermatologist=this.examination.dermatologist 
            //this.newExamination.pharmacy=this.examination.pharmacy
            axios.post('/examination/add',this.newExamination)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
            })
            .catch(function (error) {
            });
        }
	}
});