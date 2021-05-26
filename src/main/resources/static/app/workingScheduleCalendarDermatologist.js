
Vue.component("calendarD",{
  data :function(){
    return {
      ar:['07:00','08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00'],
      dates:[],
      today:null,
      col:null,
      phycian:{
        vacationSchedule:[],
        workingSchedule:[],
        pharmacies:[]
      },
      myExamination:{
        startTime:'',
        endTime:'',
        patient:{
          name:'',
          surname:''
        }
      },
        exam:{
          startTime:'',
          endTime:'',
          patient:{
            name:'',
            surname:''
          }
    },
    pharmacy:null
  }
},
	mounted() {    
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
			.get('/dermatologist/getDermatologistById/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
			.then(response => {
				this.phycian = response.data
        this.pharmacy=this.phycian.pharmacies[0]
			})
			.catch(error => {
			})

    axios
			.get('/examination/getExaminationsByDermatologist/' + localStorage.getItem('userId'),{
				headers: {
					'Authorization': 'Bearer' + " " + localStorage.getItem('token')
				}
			}) 
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
    <br> <br>
			Choose pharmacy by&nbsp&nbsp
				<select class="col" id="sort"style="width:200px;" v-model="pharmacy">
					<option v-for="p in this.phycian.pharmacies" v-bind:value="p">{{p.name}}</option>
	            </select>	
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
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,0)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}  <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} </a></button><br>
                </td>
                <td v-else-if="Vacation(i,0)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell1" v-if="CompareDate(i,1)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,1)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} </a></button></br>
                </td>
                <td v-else-if="Vacation(i,1)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell2" v-if="CompareDate(i,2)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,2)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} </a></button></br>
                </td>
                <td v-else-if="Vacation(i,2)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell3" v-if="CompareDate(i,3)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,3)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}   <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}  </a></button></br>
                </td>
                <td v-else-if="Vacation(i,3)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell4" v-if="CompareDate(i,4)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,4)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}} </a></button></br>
                </td>
                <td v-else-if="Vacation(i,4)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell5" v-if="CompareDate(i,5)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,5)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}   <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}  </a></button></br>
                </td>
                <td v-else-if="Vacation(i,5)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
                <td id="cell6" v-if="CompareDate(i,6)" class="changeCellColor">
                  <button data-dismiss="modal"  data-toggle="modal" data-target="#ExaminationP" class="btn-info" v-for="e in myExamination" v-if="ExamDay(e,i,6)" v-on:click="Start(e)"><a v-if="e.patient!=null">{{e.startTime.split('T')[1].split(":")[0]}}:{{e.startTime.split('T')[1].split(":")[1]}}-{{e.endTime.split('T')[1].split(":")[0]}}:{{e.endTime.split('T')[1].split(":")[1]}}   <br>  {{e.patient.name}} {{e.patient.surname}}</a><a v-else>{{e.startTime.split('T')[1]}}-{{e.endTime.split('T')[1]}} </a></button></br>
                </td><td v-else-if="Vacation(i,6)" class="changeCellColorVacation">vacation</td>
                <td v-else class="cellColorRegular"></td>
            </tr>
         </tbody>
      </table>

      <!--MODAL-->
      <div class="modal fade" tabindex="-1" role="dialog" id="ExaminationP">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header nocolor">
            <h5 class="modal-title">Examination</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body nocolor">
                      Patient:</br>
                      <div >
                      {{exam.patient.name}} {{exam.patient.surname}}
                      </div></br>
                      Time:</br>
                      <div >
                      {{exam.startTime.split('T')[1]}}-{{exam.endTime.split('T')[1]}}
                      </div></br>
                      <a v-if="exam.isDone">
                      Report:</br>
                      <div>
                      {{exam.report}}
                      </div></br></a>
                      <a v-if="!exam.isDone && PastExam()">
                      <div>
                      Patient did not come.
                      </div></br></a>
                      <div class="modal-footer">
            <button v-if="See()" id="addF" type="button" class="btn btn-info btn-lg" v-on:click="No()">Did not come</button>
            <button v-if="See()" id="cancelF" type="button" class="btn btn-info btn-lg" v-on:click="Yes()"">Start</button>
          </div>
        </div>
        </div>
      </div>
    </div>
</div>			
	`,
	methods: {
    See:function(){
      if(this.exam.patient.name==null || this.exam.isDone || this.exam.isCanceled ){
        return false
      }else{
        return true
      }
    },
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
            if(this.phycian.workingSchedule[i].pharmacy.id==this.pharmacy.id){
            //alert(this.phycian.workingSchedule[i].timeStart.split('T')[0]+date)
              if(this.phycian.workingSchedule[i].timeStart.split('T')[0]==date){
                //alert(time.split(':')[0]+parseInt(this.phycian.workingSchedule[i].timeStart.split('T')[1].split(':')[0])
                if(parseInt(this.phycian.workingSchedule[i].timeStart.split('T')[1].split(':')[0])<=parseInt(time.split(':')[0]) && parseInt(this.phycian.workingSchedule[i].timeEnd.split('T')[1].split(':')[0])>parseInt(time.split(':')[0]))
                  return true
              }
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
              //alert(date1+date)
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
      if(e.startTime!=undefined){
        if(e.startTime.split('T')[0]==date){
              if(parseInt(e.startTime.split('T')[1].split(':')[0])>=parseInt(time.split(':')[0]) && parseInt(e.startTime.split('T')[1].split(':')[0])<parseInt(time.split(':')[0])+1)
              return true
          }
      }
    return false
   },
   Start:function(e){
     ex=e
     this.exam=e
     //this.$router.push('examinationDermatologist');   
   },
   Yes:function(){
    $('#ExaminationP').modal('hide');
    this.$router.push('examinationDermatologist');
   },
   No:async function(){
    $('#ExaminationP').modal('hide');
    this.exam.isDone=false
    await axios.put('/examination/notCome', this.exam,{
      headers: {
        'Authorization': 'Bearer' + " " + localStorage.getItem('token')
      }
    })
    .then(function (response) {
    })
    .catch(function (error) {
    });  
    await this.$router.push('calendarD');
   },
  PastExam:function () {
    var d = new Date();
    if(parseInt(this.exam.startTime.split('T')[0].split('-')[0])<parseInt(d.getFullYear()) || parseInt(this.exam.startTime.split('T')[0].split('-')[1])<parseInt(d.getMonth())+1 || parseInt(this.exam.startTime.split('T')[0].split('-')[2])<parseInt(d.getDate()))
      return false
    if(this.exam.startTime!=""){
      if(parseInt(this.exam.startTime.split('T')[0].split('-')[2])==parseInt(d.getDate())){
        if(parseInt(this.exam.endTime.split('T')[1].split(':')[0])<parseInt(d.getHours()) || parseInt(this.exam.endTime.split('T')[1].split(':')[1])<parseInt(d.getMinutes()))
          return false
      }
    }
    return true
  }
}
});

var ex;

Vue.component("examinationDermatologist", {
	data: function () {
		return {
			patient:null,
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
            medicineChoose:null,
            future:null
		}
	},
	mounted() {
                axios
                .get('/eprescription/findMedicines/' + this.examination.pharmacy.id,{
                  headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                  }
                })
                .then(response => {       
                    this.med=response.data
                    for(var m in this.med){
                        var find=false
                        for(var a in this.examination.patient.drugAllargies){
                            if(this.examination.patient.drugAllargies[a].toUpperCase()==this.med[m].medicine.name.toUpperCase())
                                find=true
                        }
                        if(!find)
                            this.medicines.push(this.med[m].medicine)
                    }
                })
                .catch(error => {
                })

            axios
            .get('/examination/getFreeExaminationByDermatologist/' + localStorage.getItem('userId'),{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
            .then(response => {
                this.future = response.data
            })
            .catch(error => {
            })
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
                        <input  min="0" type="number" :disabled="this.medicineChoose==null" class = "form-control input" v-model="prescriptionDTO.therapyDuration"/><br/>
						<div class="modal-footer">
							<button id="addF" type="button" class="btn btn-info btn-lg" v-on:click="AddPrescritpion()">Create</button>
							<button id="cancelF" type="button" class="btn btn-info btn-lg" data-dismiss="modal">Cancel</button>
						</div>
					</div>
					</div>
				</div>
			</div>
            <!--SCHEDULE-->
            <div class="modal fade" tabindex="-1" role="dialog" id="Schedule">
            <div class="modal-dialog" role="document" style="max-width: 30%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Schedule the next examination</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    <!--BODY-->
                        <div class= "container">
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
                                                                        <th>Pharmacy</th>
                                                                        <th>Schedule</th>
                                                                    </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                    <tr v-for="f in future">
                                                                        <td>{{f.startTime.split('T')[0]}}</td>
                                                                        <td>{{f.startTime.split('T')[1]}}</td>
                                                                        <td>{{f.endTime.split('T')[1]}}</td>
                                                                        <td>{{f.price}}</td>
                                                                        <td>{{f.pharmacy.name}}</td>
                                                                        <td><button class="btn btn-info btn-lg" v-on:click="Schedule(f)">Schedule</button></td>
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
                </div>
            </div>
        </div>  
		</div>
    </div>			
	`,
	methods: {
        Finish:async function(){    
          await axios.put('/examination/finish', this.examination,{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
              .then(function (response) {
              })
              .catch(function (error) {
              });
            await this.$router.push('calendarD');
        },
        Prescription:function(){
            
        },
        AddPrescritpion:async function(){
            var pharmacyMedicines=this.examination.pharmacy.pricelist
            for(m in pharmacyMedicines){
                if(pharmacyMedicines[m].medicine.name==this.medicineChoose.name){
                    if(pharmacyMedicines[m].quantity>0){
                      pharmacyMedicines[m].quantity=pharmacyMedicines[m].quantity-1
                        this.prescriptionDTO.medicine=pharmacyMedicines[m]
                        this.prescriptionDTO.pharmacy=this.examination.pharmacy
                        await axios.post('/eprescription/add/'+this.examination.patient.id, this.prescriptionDTO,{
                          headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                          }
                        })
                            .then(function (response) {
                                alert("The prescription was successfully issued!")
                                //location.reload()
                            })
                            .catch(function (error) {
                            });
                          await  axios
                                .get('/eprescription/findMedicines/' + this.examination.pharmacy.id,{
                                  headers: {
                                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                                  }
                                })
                                .then(response => {       
                                    this.med=response.data
                                    this.medicines=[]
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
                                await $('#PrescriptionModal').modal('hide');
                        }else{
                            alert("Medicine is put of stock!")
                            axios.post('/pharmacyAdmin/sendingMail/'+this.examination.pharmacy.name,this.medicineChoose,{
                              headers: {
                                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                              }
                            })
                            .then(function (response) {
                            })
                            .catch(function (error) {
                            });
                        }
                    }
                }
        },
        Schedule: async function(f){
            f.patient=this.examination.patient
            var fut=[]
            await axios.put('/examination/schedule',f,{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
            .then(response =>{
                alert("The examination was successfully scheduled!")
                axios
                .get('/examination/getFreeExaminationByDermatologist/' + localStorage.getItem('userId'),{
                  headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                  }
                })
                .then(response => {
                  this.future = response.data
                    //location.reload()
                    //$('#Schedule').modal('hide');
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
            this.newExamination.patient=this.examination.patient
            this.newExamination.dermatologist=this.examination.dermatologist 
            this.newExamination.pharmacy=this.examination.pharmacy
            axios.post('/examination/add',this.newExamination,{
              headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
              }
            })
            .then(function (response) {
                alert("The examination was successfully scheduled!")
                $('#Schedule').modal('hide');
            })
            .catch(function (error) {
            });
        }
	}
});