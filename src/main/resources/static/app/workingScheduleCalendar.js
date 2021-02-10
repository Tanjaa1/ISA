
Vue.component("calendar",{
  data :function(){
    return {
      ar:['07:00','08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00'],
      dates:[],
      today:null,
      col:null,
      phycian:{
        vacationSchedule:[],
        workingSchedule:[]
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
			.get('/dermatologist/getDermatologistById/' + '6/') 
			.then(response => {
				this.phycian = response.data
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
              <td style="text-align:center;width:200px" v-for="c in col" class="cellColorRegular">{{c.getDate()}}.{{c.getMonth() + 1}}.{{c.getFullYear()}}.</td>
          </tr>
            <tr v-for="i in ar" style="text-align:center;height:100px">
                <td style="text-align:center" class="cellColorRegular">{{i}}</td>
                <td id="cell0" v-if="CompareDate(i,0)" class="changeCellColor"></td><td v-else-if="Vacation(i,0)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell1" v-if="CompareDate(i,1)" class="changeCellColor"></td><td v-else-if="Vacation(i,1)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell2" v-if="CompareDate(i,2)" class="changeCellColor"></td><td v-else-if="Vacation(i,2)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell3" v-if="CompareDate(i,3)" class="changeCellColor"></td><td v-else-if="Vacation(i,3)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell4" v-if="CompareDate(i,4)" class="changeCellColor"></td><td v-else-if="Vacation(i,4)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell5" v-if="CompareDate(i,5)" class="changeCellColor"></td><td v-else-if="Vacation(i,5)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
                <td id="cell6" v-if="CompareDate(i,6)" class="changeCellColor"></td><td v-else-if="Vacation(i,6)" class="changeCellColorVacation">vacation</td></td><td v-else class="cellColorRegular"></td>
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
          for (i = 0; i < this.phycian.workingSchedule.length; i++)
              if(this.phycian.workingSchedule[i].timeStart.split('T')[0]==date){
                if(parseInt(this.phycian.workingSchedule[i].timeStart.split('T')[1].split(':')[0])>=parseInt(time.split(':')[0]) && parseInt(this.phycian.workingSchedule[i].timeEnd.split('T')[1].split(':')[0])<parseInt(time.split(':')[0]))
                  return true
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

   }
}
});