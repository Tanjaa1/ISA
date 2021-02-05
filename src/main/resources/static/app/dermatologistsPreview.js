Vue.component("dermatologistsPreview", {
	data: function () {
		return {
            dermatologists:[],
            pharmacies:{},
            filterInfo:{
                pharmacy : null,
                minRating : null,
                maxRating : null
            },
            displayedDermatologists : {}
		}
	},
	beforeMount() {
        axios.get('/dermatologist/getAllDermatologists', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.dermatologists = response.data
                this.displayedDermatologists = response.data
                for (var i = 0; i < (Object.keys(this.dermatologists)).length; i++) {
                    var rating = 0
                    var d = this.dermatologists[i]
                    for (var r of d.marks) {   
                        rating = rating + r;
                    }
                    rating = rating / d.marks.length
                    this.dermatologists[i].rating = rating 
                }
            })
     axios.get('/pharmacy/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.pharmacies = response.data
            })     
            
    },
    mounted(){
        this.calculateRatings(this.dermatologists)
    },
	template: `
	<div id="DermatologistHomePage">		
			<br></br><br></br>
            <br></br><br></br>

            <div class = "sameLineDermatologistsPreview"  style ="margin-left : 35%;">
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Filter by pharmacy</span>
                    </div>
                    <select class="form-control" v-model = "filterInfo.pharmacy" aria-describedby="basic-addon3" >
                        <option value="Select pharmacy name" disabled selected></option>
                        <option v-for = "pharmacy in pharmacies" >{{pharmacy.name}}</option>
                    </select>
                </div>
                &nbsp&nbsp
                <button  class = "form-control" style = "width:10%; background-color : lightgray;"  v-on:click = "filterDermatologists(dermatologists)" >Apply filters</button>
            </div>

            <div class = "sameLineDermatologistsPreview"  style ="margin-left : 35%;">
                <div class="input-group mb-3" style = "width : 20%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Filter by rating (from-to)</span>
                    </div>
                    <input type = "text" class="form-control"  aria-describedby="basic-addon3" v-model = "filterInfo.minRating">
                    <input type = "text" class="form-control"  aria-describedby="basic-addon3" v-model = "filterInfo.maxRating">
                </div>
                &nbsp&nbsp               
                <button class = "form-control" style = "width:10%; background-color : lightgray;" v-on:click = "resetFilter()">Reset filters</button>
            </div>

            <table class="table" style = "margin-left : 18%; margin-right : 18%; width : 64%; ">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">First</th>
                    <th scope="col">Last</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Pharmacy</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for = "(value, index) in displayedDermatologists">
                    <th scope="row">{{index + 1}}</th>
                    <td>{{value.name}}</td>
                    <td>{{value.surname}}</td>
                    <td>{{value.rating}}</td>
                    <td><div  v-for = "p in value.pharmacies">{{p.name}}</div></td>
                </tr>
                </tbody>
          </table>       
		<br></br><br></br>
	</div>					
				
	`,
	methods: {
        filterDermatologists: function (dermathologists) {
            if(this.filterInfo.minRating == null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy != null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {                  
                    for(var p of d.pharmacies){
                        if(p.name == this.filterInfo.pharmacy)     
                            this.displayedDermatologists.push(d);
                    }
                }
            }
            else if(this.filterInfo.minRating == null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy == null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {                  
                        if(d.rating <= this.filterInfo.maxRating)     
                            this.displayedDermatologists.push(d)
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy == null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {                  
                        if(d.rating >= this.filterInfo.minRating)     
                            this.displayedDermatologists.push(d);
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy == null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {                  
                        if(d.rating >= this.filterInfo.minRating && d.rating <= this.filterInfo.maxRating )     
                            this.displayedDermatologists.push(d);
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy != null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {      
                    for(var p of d.pharmacies){            
                        if(d.rating >= this.filterInfo.minRating && d.rating <= this.filterInfo.maxRating && p.name == this.filterInfo.pharmacy)     
                            this.displayedDermatologists.push(d);
                    }
                }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy != null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {      
                    for(var p of d.pharmacies){            
                        if(d.rating >= this.filterInfo.minRating  && p.name == this.filterInfo.pharmacy)     
                            this.displayedDermatologists.push(d);
                    }
                }
            }
            else if(this.filterInfo.minRating == null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy != null){
                this.displayedDermatologists = [];
                for (var d of dermathologists) {      
                    for(var p of d.pharmacies){            
                        if(d.rating <= this.filterInfo.maxRating  && p.name == this.filterInfo.pharmacy)     
                            this.displayedDermatologists.push(d);
                    }
                }
            }
        },
        resetFilter: function () {
            this.displayedDermatologists = this.dermatologists
            this.filterInfo.pharmacy = null;
            this.filterInfo.minRating = null;
            this.filterInfo.maxRating = null;
        },
	}
});