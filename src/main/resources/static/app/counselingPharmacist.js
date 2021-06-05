
Vue.component("createCounselingPharmacist", {
	data: function () {
		return {
			patients:{},
            newExamination: {
                startTime:null,
                endTime:null,
                patient:null,
                dermatologist:null,
                id:null,
                idDone:false,
                pharmacy:null,
                report:"",
                price:1000.00   ,
            },
            patient:{},
            physician:{}
		}
	},
	beforeMount() {
    
		if(localStorage.getItem('role')=='ROLE_PHARMACIST'){ 
            axios
            .get('/patient/getPatientByPharmacistCouseling/' + localStorage.getItem('userId'),{
                headers: {
                  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
              }) 
            .then(response => {
                this.patients = response.data
            })
            .catch(error => {
            })

            axios
              .get('/pharmacist/getPharmacistById/' + localStorage.getItem('userId'),{
                headers: {
                  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
              }) 
              .then(response => {
                  this.physician = response.data
              })
              .catch(error => {
              })
            }else{
              this.$router.push('forbidden');
              }
	},
	template: `
	<div id="ExaminationDermatologist" class="BackendImagePhysician"> 
        <div class="container search">
            <div class="md-form mx-5 my-5">
                Choose patient</br>
                <select class="col" id="sort" v-model="patient">
                    <option selected="selected" disabled>Please select one</option>
                    <option v-for="p in this.patients" v-bind:value="p">{{p.name}} {{p.surname}}</option>
                </select>		
            </div>		
        </div>
            <!--SCHEDULE-->                
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
                    </div><hr>
                <button id="cancelF" type="button" class="btn btn-info btn-lg " v-on:click="NewEx()">Schedule</button>
            </div>
    </div>			
	`,
	methods: {
        Schedule: async function(f){
            f.patient=this.examination.patient
            var fut=[]
            await axios.put('/counseling/schedule',f,{
                headers: {
                  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
              })
            .then(function (response) {
                alert("The counseling was successfully scheduled!")
                axios
                .get('/counseling/getFreeCounselingByPharmacist/' + localStorage.getItem('userId'),{
                    headers: {
                      'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                    }
                  })
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
           // this.newExamination.dermatologist=this.examination.dermatologist 
            //this.newExamination.pharmacy=this.examination.pharmacy
            this.newExamination.pharmacist=this.physician 
            this.newExamination.pharmacy=this.physician.pharmacy
            axios.post('/counseling/add',this.newExamination,{
                headers: {
                  'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
              })
            .then(function (response) {
                alert("The counseling was successfully scheduled!")
            })
            .catch(function (error) {
                alert(error)
            });
        }
	}
});