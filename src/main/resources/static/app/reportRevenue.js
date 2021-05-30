

Vue.component("reportRevenue", {
	data: function () {
		return {
            graphs : 1,
            year : null,
            month :null,
            show : {},
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



    <h1   class="col-form-label">Revenue report:</h1>

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
<button type="button" class="btn btn-info btn-lg d-inline" v-on:click="GetRevenuoGraph()">Generate revenue graph </button>&nbsp


<h1></h1>
    <label v-if = "show == 1" for="recipient-name" min="0"  class="col-form-label">Revenue for month:</label>
    <canvas id="daily" style ="width:20%;height:20%"></canvas>




</div>	




    
	</div>			



	`
	,
	methods:{


            GetRevenuoGraph : function(){
                            
                if(this.year == null || this.month == null){
                    alert("Year and month must not be empty.") 
                    return
                }
                this.show = 1
                axios
                .get('/pharmacyAdmin/RevenueDaily/'+ this.pharmacy.id + '/' + this.month + '/' + this.year ,{
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
    
                    var ctx = document.getElementById('daily').getContext('2d');
                    var myChart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: xAxis,
                            datasets: [{
                                label: '[REVENUE FOR SELECTED MONTH] Y - RSD X - Day',
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

            }
        }
});




