Vue.component("patientEvaluates", {
    data: function () {
        return {
            // patientPastExaminations:null,
            // patientFutureExaminations:null,
            // past:false,
            // id: 1,
            // date: null,
            // time:null,
            // canBeCanceled:true,
            // newExamination: {
            //     startTime:null,
            //     endTime:null,
            //     patient:null,
            //     dermatologist:null,
            //     id:null,
            //     idDone:false,
            //     pharmacy:null,
            //     report:"",
            //     price:1000.00             
            // },
            // future:null,
            //patient:null,
            pharmacies:null,
            pharmacists:null,
            medicines:null,
            dermatologists:null,
            dermatologistsMark:null,
            pharmaciesMark:null,
            pharmacistsMark:null,
            medicinesMark:null,
        }
    },
    beforeMount() {
        axios
            .get('/dermatologist/getDermatologistByPatientId/' + '88')
            .then(response => {
                this.dermatologists = response.data
            })
            .catch(error => {
            })
        axios
            .get('/medicine/getMedicineByPatientId/' + '88')
            .then(response => {
                this.medicines = response.data
            })
            .catch(error => {
            })

            axios
            .get('/pharmacist/getPharmacistByPatientId/' + '88')
            .then(response => {
                this.pharmacists = response.data
                alert(this.pharmacists)
            })
            .catch(error => {
            })

            axios
			.get('/pharmacy/getPharmacies/' + '88') 
			.then(response => {
				this.pharmacies = response.data
			})
			.catch(error => {
			})
    },
    template: `
    <div id = "parmaciesShowPatient">
    <div class= "container">
            <br/><h3 class="te">Give points</h3><br/>


                            <ul class="nav nav-tabs" role="tablist">
                                <li class="nav-item">
                                    <a id="tabApprovedF" class="nav-link active .cards" data-toggle="tab" href="#approvedF">Dermatologists</a>
                                </li>
                                <li class="nav-item">
                                    <a id="tabDisapprovedF" class="nav-link .cards" data-toggle="tab" href="#disapprovedF">Pharmacists</a>
                                </li>
                                <li class="nav-item">
                                    <a id="t1" class="nav-link .cards" data-toggle="tab" href="#f1">Medicine</a>
                                </li>
                                <li class="nav-item">
                                    <a id="t2" class="nav-link .cards" data-toggle="tab" href="#f2">Pharmacies</a>
                                </li>
                            </ul>
                            <div>
                                <div class="tab-content">
                                    <div id="approvedF" class="container tab-pane active"><br>
                                        <div class="container">
                                                <div class="row">
                                                    <table id="tableApproved" class="table table-bordered">
                                                        <thead>
                                                          <tr>
                                                          <th>Dermatologist</th>
                                                          <th>Grade</th>
                                                          <th></th>
                                                          <th></th>
                                                          <th></th>
                                                          <th></th>
                                                          <th></th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr v-for="d in dermatologists">
                                                            <td>{{d.name}}&nbsp&nbsp{{d.surname}}</td>
                                                            <td>{{d.grade}}</td>
                                                           <!-- <td style="text-align:center"> 
                                                                   <select class="col" id="d">
                                                                   <option selected="selected" disabled>Please select one</option>
                                                                           <option>1</option>
                                                                           <option>2</option>
                                                                           <option>3</option>
                                                                           <option>4</option>
                                                                           <option>5</option>
                                                                   </select>
                                                                 
                                                       </td>-->
                                                       <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkDermatologist(d,1)">1</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkDermatologist(d,2)">2</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkDermatologist(d,3)">3</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkDermatologist(d,4)">4</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkDermatologist(d,5)">5</button></td>
                                                      
                                                            <!--<td>{{f.medicinePriceAndQuantityId.price}}din.</td>  <td>{{DateSplit(f.expirationDate)}}</td>
                                                            <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                            <td>{{f.isReceived}}</td>
                                                            <td>{{f.isCanceled}}</td>-->
                                                           <!-- <td style="text-align:center"><button class="btnban form-control" v-on:click="Disapprove(f)">D I S A P P R O V E</button></td> --> 
                                                          </tr>
                                                        </tbody>
                                                     </table>
                                                </div>
                                          </div>			     
                                     </div>
                                    <div id="disapprovedF" class="container tab-pane fade"><br>
                                        <div class="container">
                                            <div class="row">
                                                <table id="tableDisapproved" class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                        <th>Pharmacist</th>
                                                        <th>Grade</th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr v-for="p in pharmacists">
                                                        <td>{{p.name}}&nbsp&nbsp{{p.surname}}</td>
                                                        <td>{{p.grade}}</td>
                                                        <!--<td style="text-align:center"> 
                                                               <select class="col" id="p">
                                                               <option selected="selected" disabled>Please select one</option>
                                                                        <option>1</option>
                                                                       <option>2</option>
                                                                       <option>3</option>
                                                                       <option>4</option>
                                                                       <option>5</option>
                                                               </select>
                                                             
                                                        </td>-->
                                                        <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacist(p,1)">1</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacist(p,2)">2</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacist(p,3)">3</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacist(p,4)">4</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacist(p,5)">5</button></td>
                                                       
                                                        <!--    <td>{{f.pharmacy.name}}&nbsp -- &nbsp{{f.pharmacy.address}}</td>
                                                            <td>{{f.isReceived}}</td>
                                                            <td>{{f.isCanceled}}</td>
                                                            <template v-if="f.isCanceled == false && CanCancel(f.expirationDate) == true">
                                                                <td style="text-align:center"><button class="btn form-control" v-on:click="Cancel(f)">Cancel</button></td> 
                                                            </template>-->
                                                        </tr>
                                                     </tbody>
                                                 </table> 
                                            </div>
                                        </div>			
                                    </div>
                                    <div id="f1" class="container tab-pane"><br>
                                        <div class="container">
                                                <div class="row">
                                                    <table id="tabl1" class="table table-bordered">
                                                        <thead>
                                                          <tr>
                                                          <th>Medicines</th>
                                                            <th>Grade</th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr v-for="f in medicines">
                                                          <td>{{f.name}}</td>
                                                          <td>{{f.grade}}</td>
                                                          <!--<td style="text-align:center"> 
                                                                 <select class="col" id="m" v-on:change="GiveMarkMedicine(f)">
                                                                 <option selected="selected" disabled>Please select one</option>
                                                                         <option>1</option>
                                                                         <option>2</option>
                                                                         <option>3</option>
                                                                         <option>4</option>
                                                                         <option>5</option>
                                                                 </select>
                                                               
                                                          </td>-->
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkMedicine1(f,1)">1</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkMedicine1(f,2)">2</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkMedicine1(f,3)">3</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkMedicine1(f,4)">4</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkMedicine1(f,5)">5</button></td>
                                                         
                                                       <!--     <td>{{f.isReceived}}</td>
                                                            <td>{{f.isCanceled}}</td>-->
                                                           <!-- <td style="text-align:center"><button class="btnban form-control" v-on:click="Disapprove(f)">D I S A P P R O V E</button></td> --> 
                                                        
                                                           </tr>
                                                        </tbody>
                                                     </table>
                                                </div>
                                          </div>			     
                                     </div>
                                     <div id="f2" class="container tab-pane"><br>
                                        <div class="container">
                                                <div class="row">
                                                    <table id="tabl2" class="table table-bordered">
                                                        <thead>
                                                          <tr>
                                                          <th>Pharmacy</th>
                                                            <th>Grade</th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                            <th></th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr v-for="ph in pharmacies">
                                                          <td>{{ph.name}}</td>
                                                          <td>{{ph.grade}}</td>
                                                      <!--    <td style="text-align:center"> 
                                                                 <select class="col" id="ph">
                                                                 <option selected="selected" disabled>Please select one</option>
                                                                         <option>1</option>
                                                                         <option>2</option>
                                                                         <option>3</option>
                                                                         <option>4</option>
                                                                         <option>5</option>
                                                                 </select>
                                                               
                                                          </td>-->
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacy(ph,1)">1</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacy(ph,2)">2</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacy(ph,3)">3</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacy(ph,4)">4</button></td>
                                                          <td style="text-align:center"><button class="btnban form-control" v-on:click="GiveMarkPharmacy(ph,5)">5</button></td>
                                                          
                                                            <!--<td>{{f.isReceived}}</td>
                                                            <td>{{f.isCanceled}}</td>-->
                                                           <!-- <td style="text-align:center"><button class="btnban form-control" v-on:click="Disapprove(f)">D I S A P P R O V E</button></td> --> 
                                                          </tr>
                                                        </tbody>
                                                     </table>
                                                </div>
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
        GiveMarkMedicine1:function(f,mm){
            axios
            .post('/medicine/giveMarkMedicine/' + mm + '/' + '88', f)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
            })
        },
        GiveMarkDermatologist:function(d,mm){
            alert(mm)
            alert(d.name)
            axios
            .post('/dermatologist/giveMarkDermatologist/'  + mm + '/' + '88' + '/' + d.id)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
            })
        },
        GiveMarkPharmacy:function(ph, mm){
            axios
            .post('/pharmacy/giveMarkPharmacy/' + mm + '/' + '88', ph)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
            })
        },
        GiveMarkPharmacist:function(p,mm){
            axios
            .post('/pharmacist/giveMarkPharmacist/' + mm + '/' + '88', p)
            .then(response => {
                this.Refresh();
            })
            .catch(error => {
            })
        },
        Refresh: function () {
            location.reload();
        },
    }
});
