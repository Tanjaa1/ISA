
Vue.component("calendarP",{
    data :function(){
      return {
        ar:['07:00','08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00'],
        dates:[],
        today:null,
        col:null,
        phycian:{
          vacationSchedule:[],
          workingSchedule:[]
        },
        myExamination:{
          startTime:'',
          endTime:'',
          patient:{
            name:'',
            surname:''
          }
        }
      }
    },
      beforeMount() {    
      var twoNextYear = new Date()
      this.today=twoNextYear
      var mon=new Date()
      var sun=new Date()
      twoNextYear.setFullYear(twoNextYear.getFullYear() + 2)
      var twoPrevoiusYear = new Date()
      twoPrevoiusYear.setFullYear(twoPrevoiusYear.getFullYear() - 2)
      this.dates=dateFns.eachDay(
        twoPrevoiusYear,
        twoNextYear
      )
      this.col=dateFns.eachDay(
        mon.setDate(mon.getDate()+1-mon.getDay()),
        sun.setDate(mon.getDate()+7-mon.getDay())
      )
  
      axios
              .get('/pharmacist/getPharmacistById/' + '5') 
              .then(response => {
                  this.phycian = response.data
              })
              .catch(error => {
              })
  
      axios
              .get('/counseling/getCounselingByPharmacist/' + '5') 
              .then(response => {
                  this.myExamination = response.data
              })
              .catch(error => {
              })
      },
      template: `
    <div>
    <br>
      <button type="button" class="btn btn-info btn-lg" v-on:click="Previous()">Previous</button>
      <button type="button" class="btn btn-info btn-lg" v-on:click="Next()">Next</button>
      <br><br>
    <table id="tableApproved" class="table table-bordered">
          <thead>
            <tr>
            <th style="text-align:center">Time</th>
              <th style="text-align:center">Mon</th>
              <th style="text-align:center">Tue</th>
              <th style="text-align:center">Wed</th>
              <th style="text-align:center">Thu</th>
              <th style="text-align:center">Fri</th>
              <th style="text-align:center">Sat</th>
              <th style="text-align:center">Sun</th>
            </tr>
            </thead>
            <tbody class="tbodyPatient">
            <tr>
                <td class="cellColorRegular"></td>
                <th style="text-align:center;width:230px" v-for="c in col" class="cellColorRegular">{{c.getDate()}}.{{c.getMonth() + 1}}.{{c.getFullYear()}}.</th>
            </tr>
              <tr v-for="i in ar" style="text-align:center;">
                  <th style="text-align:center" class="cellColorRegular">{{i}}</th>
                  <td id="cell0" v-if="CompareDate(i,0)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,0)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button><br>
                  </td><td v-else-if="Vacation(i,0)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell1" v-if="CompareDate(i,1)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,1)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,1)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell2" v-if="CompareDate(i,2)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,2)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,2)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell3" v-if="CompareDate(i,3)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,3)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,3)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell4" v-if="CompareDate(i,4)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,4)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,4)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell5" v-if="CompareDate(i,5)" class="changeCellColor">
                    <button  class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,5)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,5)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                  <td id="cell6" v-if="CompareDate(i,6)" class="changeCellColor">
                    <button class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,6)" v-on:click="Start(e)">{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}}  {{e.patient.name}} {{e.patient.surname}}</button></br>
                  </td><td v-else-if="Vacation(i,6)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
              </tr>
           </tbody>
        </table>
  </div>			
      `,
      methods: {
      Previous:function(){
        this.col=dateFns.eachDay(
          this.col[0].setDate(this.col[0].getDate()-7),
          this.col[6].setDate(this.col[6].getDate()-7)
        )
      },
      Next:function(){
        this.col=dateFns.eachDay(
          this.col[0].setDate(this.col[0].getDate()+7),
          this.col[6].setDate(this.col[6].getDate()+7)
        )
      },
      CompareDate:function(time,i){
          if(this.Vacation(time,i))
            return false
  
          var date=this.col[i].getFullYear() 
          if(this.col[i].getMonth()<9)
            date+='-0'+(this.col[i].getMonth()+1)
          else
            date+='-'+(this.col[i].getMonth()+1)
          
          if(this.col[i].getDate()<10)
            date+='-0'+this.col[i].getDate()
          else
            date+='-'+this.col[i].getDate()
            for (i = 0; i < this.phycian.workingSchedule.length; i++){
              //alert(this.phycian.workingSchedule[i].timeStart.split('T')[0]+date)
                if(this.phycian.workingSchedule[i].timeStart.split('T')[0]==date){
                  //alert(time.split(':')[0]+parseInt(this.phycian.workingSchedule[i].timeStart.split('T')[1].split(':')[0])
                  if(parseInt(this.phycian.workingSchedule[i].timeStart.split('T')[1].split(':')[0])<=parseInt(time.split(':')[0]) && parseInt(this.phycian.workingSchedule[i].timeEnd.split('T')[1].split(':')[0])>parseInt(time.split(':')[0]))
                    return true
                }
              }
          return false
      },
      Vacation:function(time,i){
        var date=this.col[i].getFullYear() 
        if(this.col[i].getMonth()<9)
          date+='-0'+(this.col[i].getMonth()+1)
        else
          date+='-'+(this.col[i].getMonth()+1)
        
        if(this.col[i].getDate()<10)
          date+='-0'+this.col[i].getDate()
        else
          date+='-'+this.col[i].getDate()
          for (i = 0; i < this.phycian.vacationSchedule.length; i++){
            var startd=new Date(this.phycian.vacationSchedule[i].dateStart)
            var endd=new Date(this.phycian.vacationSchedule[i].dateEnd)
            if(!(startd.getDate()==endd.getDate() && startd.getMonth()==endd.getMonth() && startd.getFullYear()==endd.getFullYear())){
              var pom=dateFns.eachDay(
                startd,
                endd
              )
              //alert(pom[0].getDate()<10)
              for(j=0;j<pom.length;j++){
                var date1=pom[j].getFullYear() 
                if(pom[j].getMonth()<9)
                  date1+='-0'+(pom[j].getMonth()+1)
                else
                  date1+='-'+(pom[j].getMonth()+1)
                
                //alert(this.col[i].getDate())
                if(pom[j].getDate()<10)
                  date1+='-0'+pom[j].getDate()
                else
                  date1+='-'+pom[j].getDate()
                if(date1==date)
                  return true
              }
            }else{
              var date1=startd.getFullYear() 
                if(parseInt(startd.getMonth())<9)
                  date1+='-0'+(startd.getMonth()+1)
                else
                  date1+='-'+(startd.getMonth()+1)
                if(parseInt(startd.getDate())<10)
                  date1+='-0'+startd.getDate()
                else
                  date1+='-'+startd.getDate()
                if(date1==date)
                  return true
            }
          }
        return false
  
     },
     ExamDay:function(e,time,i){
      if(this.Vacation(time,i))
      return false
      //alert(e.startTime)
      var date=this.col[i].getFullYear() 
      if(this.col[i].getMonth()<9)
        date+='-0'+(this.col[i].getMonth()+1)
      else
        date+='-'+(this.col[i].getMonth()+1)
      
      if(this.col[i].getDate()<10)
        date+='-0'+this.col[i].getDate()
      else
        date+='-'+this.col[i].getDate()
        //alert(e.startTime.split('T')[0]+date)
        if(e.startTime.split('T')[0]==date){
              //alert("da")
              if(parseInt(e.startTime.split('T')[1].split(':')[0])>=parseInt(time.split(':')[0]) && parseInt(e.startTime.split('T')[1].split(':')[0])<parseInt(time.split(':')[0])+1)
              return true
          }
      return false
     },
     Start:function(e){
       ex=e
       this.$router.push('examinationDermatologist');   
     }
  }
  });
  
  var ex;

  Vue.component("counselingPharmacist", {
	data: function () {
		return {
			patient:{},
            examination:ex,
            medicines:[],
            med:null,
            prescriptionDTO:{
                medicine:null,
                therapyDuration:0,
                issuingDate:new Date().now,
            },
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
            medicineChoose:null
		}
	},
	beforeMount() {
        axios
            // .get('/counseling/getPastCounselingByPatientId/' + '88')
            // .then(response => {
            //     this.examination = response.data[0]
            //     axios
                .get('/eprescription/findMedicines/' + this.examination.pharmacy.id)
                .then(response => {       
                    this.med=response.data
                    for(m in this.med){
                        var find=false
                        for(a in this.examination.patient.drugAllargies){
                            if(this.examination.patient.drugAllargies[a].toUpperCase()==this.med[m].medicine.name.toUpperCase())
                                find=true
                        }
                        if(!find)
                            this.medicines.push(this.med[m].medicine)
                    }
                })
                .catch(error => {
                })
            // })
            // .catch(error => {
            // })

	},
	template: `
	<div id="ExaminationDermatologist" class="BackendImagePhysician">
        <br><br>	
        <div class="row search">
            <div class="col-sm-3">Date:</div>
            <div class="col-sm-5">{{this.examination.startTime.split('T')[0]}}  {{this.examination.startTime.split('T')[1]}}-{{this.examination.endTime.split('T')[1]}}</div>
        </div>
        <div class="row search">
            <div class="col-sm-3">Patient:</div>
            <div class="col-sm-5">{{this.examination.patient.name}} {{this.examination.patient.surname}}</div><br>
        
        </div>
        <div class="row search">
            <div class="col-sm-3">Alergies:</div>
            <div class="col-sm-5"><a v-for="a in this.examination.patient.drugAllargies">{{a}}</br></a></div><br>
        
        </div>
        <div class="row search">        
            <div class="col-sm-5">Report:</div>
            <textarea id="report" class="form-control" rows="4" cols="50" style="height:200px" v-model="examination.report"></textarea>
        </div>
        <div class="row search">
            <button type="button" style="color:white" class="btn btn-default" data-dismiss="modal"  data-toggle="modal" data-target="#PrescriptionModal">Prescription</button>&nbsp&nbsp&nbsp&nbsp&nbsp
            <button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" data-toggle="modal" data-target="#Schedule">Schedule the next review</button>&nbsp&nbsp&nbsp&nbsp&nbsp
            <button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Finish()">Finish</button>	
        </div>
        <div>
			<div class="modal fade" tabindex="-1" role="dialog" id="PrescriptionModal">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">EPrescription</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body search">
                        
                        <div class="row">Medicine:
                            <select class="col" id="sort" v-model="medicineChoose" >
                                <option selected="selected" disabled>Please select one</option>
                                    <option v-for="m in medicines" v-bind:value="m">{{m.name}}</option>
                            </select>
                        </div></br>
                        Composition:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{this.medicineChoose.composition}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Type:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{medicineChoose.type}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Note:</br>
                        <div v-if="this.medicineChoose!=null">
                        {{medicineChoose.note}}
                        </div>
                        <div v-else></br>
                        </div></br>
                        Therapy duration:</br>
                        <input type="number" :disabled="this.medicineChoose==null" class = "form-control input" v-model="prescriptionDTO.therapyDuration"/><br/>
						<div class="modal-footer">
							<button id="addF" type="button" class="btn btn-info btn-lg " v-on:click="AddPrescritpion()">Create</button>
							<button id="cancelF" type="button" class="btn btn-info btn-lg " data-dismiss="modal">Cancel</button>
						</div>
					</div>
					</div>
				</div>
			</div>  



            <div class="modal fade" tabindex="-1" role="dialog" id="Schedule">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">EPrescription</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="container">
                            <div class="md-form mx-5 my-5">
                                <label>Choose date:</label></br>
                                <input style="height:25px" id="date" type="date"></input>
                            </div>
                            <div class="md-form mx-5 my-5">
                                <label>Choose start time</label>
                                <input type="time" id="start" class="form-control">
                            </div>
                            <div class="md-form mx-5 my-5">
                                <label>Choose end time</label>
                                <input type="time" id="end" class="form-control">
                            </div>
                        </div>
                        <hr>
                        <button id="cancelF" type="button" class="btn btn-info btn-lg " v-on:click="NewEx()">Schedule</button>
                    </div>
                </div>
                </div>
            </div>
        </div> 
		</div>
    </div>			
	`,
	methods: {
        Finish:function(){    
            axios.put('/counseling/finish', this.examination)
				.then(function (response) {
				})
				.catch(function (error) {
				});    
        },
        Prescription:function(){
            
        },
        AddPrescritpion:function(){
            var pharmacyMedicines=this.examination.pharmacy.pricelist
            for(m in pharmacyMedicines){
                if(pharmacyMedicines[m].medicine.name==this.medicineChoose.name){
                    if(pharmacyMedicines[m].quantity>0){
                        this.prescriptionDTO.medicine=pharmacyMedicines[m]
                        axios.post('/eprescription/add/'+this.examination.patient.id, this.prescriptionDTO)
                            .then(function (response) {
                                alert("The prescription was successfully issued!")
                                location.reload()
                            })
                            .catch(function (error) {
                            });
                        }else{
                            alert("Medicine is put of stock!")
                            axios.post('/pharmacyAdmin/sendingMail/'+this.examination.pharmacy.name,this.medicineChoose)
                            .then(function (response) {
                            })
                            .catch(function (error) {
                            });
                        }
                    }
                }
        },
        NewEx:function(){
            this.newExamination.startTime=document.getElementById("date").value+'T'+document.getElementById("start").value
            this.newExamination.endTime=document.getElementById("date").value+'T'+document.getElementById("end").value
            this.newExamination.patient=this.examination.patient
            this.newExamination.pharmacist=this.examination.pharmacist 
            this.newExamination.pharmacy=this.examination.pharmacy
            axios.post('/counseling/add',this.newExamination)
            .then(function (response) {
                alert("The examination was successfully scheduled!")
            })
            .catch(function (error) {
            });
        }
	}
});