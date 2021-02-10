Vue.component("newEmptyExamination", {
	data: function () {
		return {
            examination : {
                    isDone: true,
                    id: 1,
                    startTime: {},
                    patient: null,                                                                                 
                    isCanceled: false,
                    pharmacy: {
                        name: "Feniks",
                        id: 111,
                        address: "Stanoja Stanojevica 4,Novi Sad,Srbija",
                    },
                    endTime: {},
                    dermatologist: {
                        id: 6,                   
                    },
                    report: null,
                    price: null,
            }
        }
	},
	beforeMount() {
        axios
            .get('/examination/getFreeExaminationByDermatologist/' + '6')
            .then(response => {
                this.future = response.data
            })
            .catch(error => {
            })
	},
	template: `
	<div id="ExaminationDermatologist">
            <div class= "container">
                <div>
                        <div id="new"><br>
                            <div class="container">
                                <div class="md-form mx-5 my-5">
                                    <label>Choose date:</label></br>
                                    <input style="height:1%; width:25%" class = "form-control" id="date" type="date"></input>
                                </div>
                                <div class="md-form mx-5 my-5">
                                    <label>Choose start time</label>
                                    <input type="time" id="start" style="height:1%; width:25%" class = "form-control">
                                </div>
                                <div class="md-form mx-5 my-5">
                                    <label>Choose end time</label>
                                    <input type="time" id="end" style="height:1%; width:25%" class = "form-control">
                                </div>
                                <div class="md-form mx-5 my-5">
                                    <label>Set price</label>
                                    <input type="number" id="end" style="height:1%; width:25%" class = "form-control" min = "0" v-model="examination.price">
                                </div>
                            </div>
                            <button id="cancelF" style = "margin-left : 5.5%;" type="button" class="btn btn-info btn-lg " v-on:click="NewEx()">Schedule</button>			
                        </div>
                    </div>
                </div></br>
            </div>
        </div>			
	`,
	methods: {
        NewEx:function(){
            if(document.getElementById("date").value == null 
            || Object.keys(document.getElementById("start").value).length === 0 
            || Object.keys(document.getElementById("end").value).length === 0 
            || this.examination.price == null ){
                alert("Please select all values")
            }   
            else{       
                this.examination.startTime=document.getElementById("date").value+'T'+document.getElementById("start").value
                this.examination.endTime=document.getElementById("date").value+'T'+document.getElementById("end").value
                this.examination.patient=this.examination.patient
                this.examination.dermatologist=this.examination.dermatologist 
                this.examination.pharmacy=this.examination.pharmacy
                axios.post('/examination/addEmptyExamination',this.examination)
                .then(response => {
                    if(response.data == null)
                        alert("Error check date and time")
                    else
                        alert("The examination was successfully scheduled!")
                })

                .catch(function (error) {
                    alert("Error!")
                });
            }
        }
	}
});