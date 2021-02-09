Vue.component("complaints", {
    data: function () {
        return {
            complaintsList:null,
            complaintsListNotAnswered:null,
            complaintAnswerDTO:{
              id:null,
              complaint:null,
              text:null
            },
            idCom:null,
            textComplaint:null,
            complaint:{},
            complaint1:{
              id:null,
              text:null,
              subject:null,
            },
            patients:null,
            
            }
    },
    beforeMount() {
        axios
            .get('/complaint/getAllComplaintsAnswered')
            .then(response => {
                this.complaintsList = response.data
            })
            .catch(error => {
            })

            axios
            .get('/complaint/getAllComplaintsNotAnswered')
            .then(response => {
                this.complaintsListNotAnswered = response.data
            })
            .catch(error => {
            })

            

        
    },
    template: `
    <div id = "Complaints">
        <div class= "container">
                <br/><h3 class="text">Complaints</h3><br/>
                                <div>
                                    <div class="tab-content">
    	                                <div id="approvedF" class="container tab-pane active"><br>
    		                                <div class="container">
	                                                <div class="row">
                                                   
                                                        <table id="tableComplaints" class="table table-bordered">
                                                            <thead>
                                                              <tr>
                                                                <th>Id</th>
                                                                <th>Subject</th>
                                                                <th>Text</th>
                                                                <th>Patient Name</th>
                                                                <th>Answer</th>

                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                              <tr v-for="f in complaintsListNotAnswered">
                                                                <td >{{f.id}}</td>
                                                                <td>{{f.subject}}</td>
                                                                <td style="text-align:center"><button class="btnban form-control" v-on:click="Text(f.id)">Text</button></td>  
                                                                <td >{{f.patient.name}} {{f.patient.surname}}</td>
                                                                <td style="text-align:center"><button class="btnban form-control" v-on:click="Answer(f.id)">Answer</button></td>  
                                                              </tr>
                                                            </tbody>
                                                         </table>


                                                         <table id="tableComplaints2" class="table table-bordered">
                                                         <thead>
                                                           <tr>
                                                             <th>Id</th>
                                                             <th>Subject</th>
                                                             <th>Text</th>
                                                             <th>Patient Name</th>

                                                           </tr>
                                                         </thead>
                                                         <tbody>
                                                           <tr v-for="s in complaintsList">
                                                             <td >{{s.id}}</td>
                                                             <td>{{s.subject}}</td>
                                                             <td style="text-align:center"><button class="btnban form-control" v-on:click="Text(s.id)">Text</button></td>  
                                                             <td >{{s.patient.name}} {{s.patient.surname}}</td>
                                                           </tr>
                                                         </tbody>
                                                      </table>
	                                                </div>
                                              </div>			     
		                                 </div>  
                                    </div>
                                </div>




                                <div class="modal fade" id="myModalText" role="dialog">
                                <div class="modal-dialog">
                                      <!-- Modal content-->
                                      <div class="modal-content">
                                            <div class="modal-header">
                                                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            </div>
                                      <div class="modal-body" style  = "color : black;">
                                      <p ></br>
                                       <div>{{this.complaint.text}}
                                       </div>
                                        </p>
                                     </div>
                                     <div class="modal-footer">
                                      <button type="button" class="btn btn-default" data-dismiss="modal" >Ok</button>
                                     </div>
                                  </div>
                                </div>
                            </div>



                            <div class="modal fade" id="myModalAnswer" role="dialog">
                            <div class="modal-dialog">
                                  <!-- Modal content-->
                                  <div class="modal-content">
                                        <div class="modal-header">
                                              <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                  <div class="modal-body" style  = "color : black;">
                                  <p ></br>
                                  <input type="textarea" id="textAnswer" name="textAnswer" v-model="textComplaint"><br><br>
                                    </p>
                                 </div>
                                 <div class="modal-footer">
                                  <button type="button" class="btn btn-default" data-dismiss="modal" v-on:click=SendComplaimentAnswer()>Ok</button>
                                 </div>
                              </div>
                            </div>
                        </div>
    
        <br></br>
        <br></br>
        <br></br>
        <br></br>

    </div>
    </div>
	`,
    methods: {
       
        Text: function (id) {
            axios
            .get('/complaint/getById/' + id)
            .then(response => {
                this.complaint = response.data
            })
            .catch(error => {
            })
            this.idCom=id
            $('#myModalText').modal('show');


        },
        Answer:function(id){
          $('#myModalAnswer').modal('show');


          axios
          .get('/complaint/getById/' + id)
          .then(response => {
            this.complaint1 = response.data
          })
          .catch(error => {
          })
          this.idCom=id

        },

        SendComplaimentAnswer:async function(){
        
          this.complaintAnswerDTO.id=this.idCom,
          this.complaintAnswerDTO.text=this.textComplaint
          this.complaintAnswerDTO.complaint=this.complaint1
          alert(this.complaintAnswerDTO.complaint.text)

/*
          axios
          .get('/complaintAndAnswer/getComplaint/'+this.idCom)
          .then(response => {
          })
          .catch(error => {
          })
*/
/*
          await axios
          .put('/complaint/updateComplaint/',this.complaintAnswerDTO.complaint)
          .then(response => {
          })
          .catch(error => {
          })
*/
          await axios
          .post('/complaintAndAnswer/saveComplaintAndAnswer/',this.complaintAnswerDTO)
          .then(response => {
              this.complaint = response.data
              location.reload();
            
          })
          .catch(error => {
          })

         

        }
    }
});