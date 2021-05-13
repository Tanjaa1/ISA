

Vue.component("administratorMedicine", {
	data: function () {
		return {
        administrator: {},
        pharmacy: {},
        newMPQ : {
            id : null,
            medicine : null,
            quantity : null,
            price : null
        },
        displayedMedicine : [],
        updateMedicine : {
            price : null,
            quantity : null
        },
        selectedMedicine : {},
        allMedicine : [],
		}
	},
	beforeMount() {
        axios
        .get('/pharmacyAdmin/getById/' + '8') 
        .then(response => {
            this.administrator = response.data
            axios
            .get('/pharmacy/getByName/' + this.administrator.pharmacy.name)
            .then(response =>{
                this.pharmacy = response.data
                this.newExamination.pharmacy = response.data

             })
        })
	}
    
		,
	template: `
	<div id="administratorMedicine">		
       
    </div>
	`
	,
	methods:{
  
	}
});




