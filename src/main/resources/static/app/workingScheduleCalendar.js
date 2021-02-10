
Vue.component("calendar",{
  data :function(){
    return {
      ar:['07:00','08:00','09:00','10:00','11:00','12:00','13:00','14:00','15:00','16:00','17:00','18:00','19:00','20:00'],
      dates:[],
      today:null,
      col:null
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
	},
	template: `
  <div id="Search"  class="BackendImagePhysician">
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
              <td></td>
              <td style="text-align:center;width:200px" v-for="c in col">{{c.getDate()}}.{{c.getMonth() + 1}}.{{c.getFullYear()}}</td>
          </tr>
            <tr v-for="i in ar" style="text-align:center;height:100px">
              <td style="text-align:center">{{i}}</td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
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

    }
	}
});