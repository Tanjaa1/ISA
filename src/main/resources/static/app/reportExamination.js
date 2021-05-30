

Vue.component("reportExamination", {
	data: function () {
		return {
            show : 0,
            administrator : {},
            pharmacy : {},
            report : {
                medicine : {},
                daily : {},
                quartal : {},
                monthly : {},
                yearly : {},
            },
            months : ['JANUARY','FEBRUARY','MARCH','APRIL','MAY','JUNE','JULY','AUGUST','SEPTEMBER','OCTOBER','NOVEMBER','DECEMBER'],
            years : ['2014','2015','2016','2017','2018','2019','2020','2021'],
            month : null,
            year : null
		}
	},
	mounted() {
		axios
        .get('/pharmacyAdmin/getById/' + localStorage.getItem('userId'),{
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
		.then(response =>{
            this.administrator = response.data
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name,{
                headers: {
                    'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                }
            })
            .then(response =>{
                this.pharmacy = response.data
             })
		})
        


        
      

	}
		,
	template: `
	<div id="administratorEmployed">


            <h1   class="col-form-label">Examinations:</h1>

            <label for="recipient-name" min="0"  class="col-form-label">Select year:</label>
            <select class="form-control" style="width : 20%; margin-left : 40%" aria-label="Default select example" v-model="year">
            <option v-bind:value="year" v-for = "(year,index) in years" >
                <label>{{year}}</label>
            </option>
        </select>

        <div >
            <label for="recipient-name" min="0"  class="col-form-label">Select month:</label>
            <select class="form-control" style="width : 20%; margin-left : 40%" aria-label="Default select example" v-model="month">
                <option v-bind:value="index + 1" v-for = "(month,index) in months" >
                    <label>{{month}}</label>
                </option>
            </select>
        </div>

        <h1></h1>
        <button type="button" class="btn btn-info btn-lg d-inline" v-on:click="GenerateChartsEx()">Generate examiantions graphs </button>&nbsp


        <h1></h1>
            <label v-if = "show == 1" for="recipient-name" min="0"  class="col-form-label">Daily examiantions:</label>
            <canvas id="dailyEx" style ="width:20%;height:20%"></canvas>
            <label v-if = "show == 1" for="recipient-name" min="0"  class="col-form-label">Monthly examiantions:</label>
            <canvas id="monthlyEx" style ="width:20%;height:20%"></canvas>
            <label v-if = "show == 1" for="recipient-name" min="0"  class="col-form-label">Quartaly examiantions:</label>
            <canvas id="quartalEx" style ="width:20%;height:20%"></canvas>
            <label  v-if = "show == 1" for="recipient-name" min="0"  class="col-form-label">Yearly examiantions:</label>
            <canvas id="yearlyEx" style ="width:20%;height:20%"></canvas>


    
	</div>			



	`
	,
	methods:{
    
            GenerateChartsEx : function(){
                if(this.year == null || this.month == null){
                    alert("Year and month must not be empty.") 
                    return
                }
                this.show = 1
                    axios
                    .get('/examination/ExaminationsDaily/' + this.pharmacy.id + '/' + this.month + '/' + this.year ,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        this.report.daily = response.data
                        var xAxis = []
                        var yAxis = []
        
                        for(var xy of this.report.daily){
                            xAxis.push(String(xy.xaxis))
                            yAxis.push(xy.yaxis)
                        }
        
                        var ctx = document.getElementById('dailyEx').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: xAxis,
                                datasets: [{
                                    label: '[DAILY CONSUMPTION] Y - number of examinations spent X - day of selected month',
                                    data: yAxis,
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 4
                                }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });
                    })
     
                    axios
                    .get('/examination/ExaminationsYearly/' + this.pharmacy.id + '/' + this.year ,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        this.report.yearly = response.data
                        var xAxis = []
                        var yAxis = []
        
                        for(var xy of this.report.yearly){
                            xAxis.push(String(xy.xaxis))
                            yAxis.push(xy.yaxis)
                        }
        
                        var ctx = document.getElementById('yearlyEx').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: xAxis,
                                datasets: [{
                                    label: '[YEARLY CONSUMPTION] Y - number of examinations spent X - year',
                                    data: yAxis,
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 4
                                }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });
                    })
     
                    axios
                    .get('/examination/ExaminationsQuartaly/' + this.pharmacy.id + '/' + this.year ,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        this.report.quartal = response.data
                        var xAxis = []
                        var yAxis = []
        
                        for(var xy of this.report.quartal){
                            xAxis.push(String(xy.xaxis))
                            yAxis.push(xy.yaxis)
                        }
        
                        var ctx = document.getElementById('quartalEx').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'bar',
                            data: {
                                labels: xAxis,
                                datasets: [{
                                    label: '[QUARTAL CONSUMPTION] Y - number of examinations spent X -quartal',
                                    data: yAxis,
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 4
                                }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });
                    })
     
                    axios
                    .get('/examination/ExaminationsMonthly/'  + this.pharmacy.id + '/' + this.year ,{
                        headers: {
                            'Authorization': 'Bearer' + " " + localStorage.getItem('token')
                        }
                    })
                    .then(response =>{
                        this.report.daily = response.data
                        var xAxis = []
                        var yAxis = []
        
                        for(var xy of this.report.daily){
                            xAxis.push(String(xy.xaxis))
                            yAxis.push(xy.yaxis)
                        }
        
                        var ctx = document.getElementById('monthlyEx').getContext('2d');
                        var myChart = new Chart(ctx, {
                            type: 'line',
                            data: {
                                labels: xAxis,
                                datasets: [{
                                    label: '[YEARLY CONSUMPTION] Y - number of examinations spent X - year',
                                    data: yAxis,
                                    backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                                    ],
                                    borderColor: [
                                        'rgba(255, 99, 132, 1)',
                                        'rgba(54, 162, 235, 1)',
                                        'rgba(255, 206, 86, 1)',
                                        'rgba(75, 192, 192, 1)',
                                        'rgba(153, 102, 255, 1)',
                                        'rgba(255, 159, 64, 1)'
                                    ],
                                    borderWidth: 4
                                }]
                            },
                            options: {
                                scales: {
                                    y: {
                                        beginAtZero: true
                                    }
                                }
                            }
                        });
                    })
     

                },
        }
});




