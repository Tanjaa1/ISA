Vue.component("pharmacistsPreview", {
	data: function () {
		return {
            pharmacists:[],
            pharmacies:{},
            filterInfo:{
                pharmacy : null,
                minRating : null,
                maxRating : null,
                name : null,
                surname : null
            },
            displayedPharmacists : {}
		}
	},
	beforeMount() {
        axios.get('/pharmacist/getAll', {
            headers: {
                'Authorization': 'Bearer' + " " + localStorage.getItem('token')
            }
        })
            .then(response => {
                this.pharmacists = response.data
                this.displayedPharmacists = response.data
                for (var i = 0; i < (Object.keys(this.pharmacists)).length; i++) {
                    var rating = 0
                    var d = this.pharmacists[i]
                    for (var r of d.marks) {   
                        rating = rating + r;
                    }
                    rating = rating / d.marks.length
                    this.pharmacists[i].rating = rating.toFixed(2);
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
    },
	template: `
	<div id="DermatologistHomePage">		
			<br></br><br></br>
            <br></br><br></br>

            <div class = "sameLinePharmacistsPreview"  style ="margin-left : 35%;">
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
                <button  class = "form-control" style = "width:10%; background-color : lightgray;"  v-on:click = "filterpharmacists(pharmacists)" >Apply filters</button>
            </div>

            <div class = "sameLinePharmacistsPreview"  style ="margin-left : 35%;">
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

            <div class = "sameLinePharmacistsPreview"  style ="margin-left : 35%;">
                <div class="input-group mb-3" style = "width : 15%;">
                    <div class="input-group-prepend">
                        <span class="input-group-text " id="basic-addon3">Filter by name</span>
                    </div>
                    <input type = "text" class="form-control"  aria-describedby="basic-addon3" v-model = "filterInfo.name">
                </div>
                &nbsp&nbsp    
                <div class="input-group mb-3" style = "width : 15%;">
                <div class="input-group-prepend">
                    <span class="input-group-text " id="basic-addon3">Filter by surname</span>
                </div>
                <input type = "text" class="form-control"  aria-describedby="basic-addon3" v-model = "filterInfo.surname">
            </div>  
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
                <tr v-for = "(value, index) in displayedPharmacists">
                    <th scope="row">{{index + 1}}</th>
                    <td>{{value.name}}</td>
                    <td>{{value.surname}}</td>
                    <td>{{value.rating}}</td>
                    <td>{{value.pharmacy.name}}</td>
                </tr>
                </tbody>
          </table>       
		<br></br><br></br>
	</div>					
				
	`,
	methods: {
        filterpharmacists: function (pharmacistsParam) {
            if(this.filterInfo.name != null && this.filterInfo.surname != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.name == this.filterInfo.name && this.filterInfo.surname == d.surname)     
                            this.displayedPharmacists.push(d);
                }
                pharmacistsParam = this.displayedPharmacists
            }
            else if(this.filterInfo.name == null && this.filterInfo.surname != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if( this.filterInfo.surname == d.surname)     
                            this.displayedPharmacists.push(d);
                }
                pharmacistsParam = this.displayedPharmacists
            }
            else if(this.filterInfo.name != null && this.filterInfo.surname == null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.name == this.filterInfo.name)     
                            this.displayedPharmacists.push(d);
                }
                pharmacistsParam = this.displayedPharmacists
            }

            if(this.filterInfo.minRating == null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.pharmacy.name == this.filterInfo.pharmacy)     
                            this.displayedPharmacists.push(d);
                }
            }
            else if(this.filterInfo.minRating == null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy == null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.rating <= this.filterInfo.maxRating)     
                            this.displayedPharmacists.push(d)
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy == null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.rating >= this.filterInfo.minRating)     
                            this.displayedPharmacists.push(d);
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy == null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                  
                        if(d.rating >= this.filterInfo.minRating && d.rating <= this.filterInfo.maxRating )     
                            this.displayedPharmacists.push(d);
                    }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                 
                        if(d.rating >= this.filterInfo.minRating && d.rating <= this.filterInfo.maxRating && d.pharmacy.name == this.filterInfo.pharmacy)     
                            this.displayedPharmacists.push(d);                   
                }
            }
            else if(this.filterInfo.minRating != null && this.filterInfo.maxRating == null && this.filterInfo.pharmacy != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {               
                        if(d.rating >= this.filterInfo.minRating  && d.pharmacy.name == this.filterInfo.pharmacy)     
                            this.displayedPharmacists.push(d);
                }
            }
            else if(this.filterInfo.minRating == null && this.filterInfo.maxRating != null && this.filterInfo.pharmacy != null){
                this.displayedPharmacists = [];
                for (var d of pharmacistsParam) {                 
                        if(d.rating <= this.filterInfo.maxRating  && d.pharmacy.name == this.filterInfo.pharmacy)     
                            this.displayedPharmacists.push(d);
                }
            }
        },
        resetFilter: function () {
            this.displayedPharmacists = this.pharmacists
            this.filterInfo.pharmacy = null;
            this.filterInfo.minRating = null;
            this.filterInfo.maxRating = null;
            this.filterInfo.name = null;
            this.filterInfo.surname = null;
        },
	}
});