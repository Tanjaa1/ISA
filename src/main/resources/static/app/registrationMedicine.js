Vue.component("registrationMedicine", {
	data: function () {
		return {
			rep:[],
			isValid:null,
			medicineDTO: {
                id:null,
				code:null,
				name: null,
				type: null,
				form: null,
				composition: null,
				manufacturer: null,
				onPrescription: null,
				replacement: null,
                note: null,
                contraindications:null,
                dailyDose:null
			},
		}
	},
	mounted() {
	},
	template: 
	`
	<div id="RegistrationMedicine">
    <div class="container">
        <br/><h2 class="text1">Medicine Registration</h2>
		<br><br><br>
		<table class="t">
			<colgroup>
                 <col style="width: 50%;">
                 <col style="width: 50%;">
            </colgroup>
			<tr>
				<td><label>Code</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="medicineDTO.code"/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{codeValidation}}</td>
			</tr>
			<tr>
				<td><label>Name</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="medicineDTO.name"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{nameValidation}}</td>
			</tr>
			<tr>
            <td><label>Type </label><a class="star">*</a></td>
            <td><select  class="combo form-control input" v-model="medicineDTO.type">
                <option>Antipyretic</option>
                <option>Analgesic</option>
                <option>AntimalarialDrug</option>
                <option>Antibiotic</option>
                <option>Antiseptic</option>
                <option>MoodStabilizer</option>
                <option>HormoneReplacements</option>
                <option>OralContraceptive</option>
                <option>Stimulants</option>
                <option>Tranquilizer</option>
                <option>Statin</option>

            </select></td><br/>
			</tr>
			<tr>
                <td>&nbsp;</td>
                      <td align="left" style="color: red;font-size:12px">{{typeValidation}}</td>
				<td></td>
			</tr>
			<tr>
            <tr>
            <td><label>Form </label><a class="star">*</a></td>
            <td><select  class="combo form-control input" v-model="medicineDTO.form">
                <option>Powder</option>
                <option>Capsule</option>
                <option>TabletDrug</option>
                <option>Paste</option>
                <option>Gel</option>
                <option>Solution</option>
                <option>Syrup</option>
                <option>Ointment</option>
            </select></td><br/>
			</tr>
			<tr>
                <td>&nbsp;</td>
                <td align="left" style="color: red;font-size:12px">{{formValidation}}</td>
			</tr>
        </table>
        

        
			<table class="t">
			<tr>
			<tr>
				<td><label>Manufacturer</label><a class="star">*</a></td>
				<td><input type="text" class = "form-control input" v-model="medicineDTO.manufacturer"/></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
                <td align="left" style="color: red;font-size:12px">{{manufacturerValidation}}</td>

            </tr>
            

			<tr>
            <td><label>On Prescription </label><a class="star">*</a></td>
            <td><select  class="combo form-control input" v-model="medicineDTO.onPrescription">
                <option>Yes</option>
                <option>No</option>
            </select></td><br/>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td><label>Replacement</label><a class="star"></a></td>
				<td><input type="text" class = "form-control input"  v-model="medicineDTO.replacement "/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
            </tr>
        
			<tr>
				<td><label>Note</label><a class="star"></a></td>
				<td><input type="text" class = "form-control input"  v-model="medicineDTO.note"/></td><br/>
			</tr>
			<tr><td>&nbsp;</td>
			</tr>
            </table>

            <br></br>
        <br><br><br>
        <table class="t">
			<colgroup>
                 <col style="width: 50%;">
                 <col style="width: 50%;">
            </colgroup>
			<tr>
				<td><label>Composition</label><a class="star">*</a></td>
				<td><textarea id="myTextarea1"  v-model="medicineDTO.composition"></textarea/></td><br/>
			<tr>
			<tr><td>&nbsp;</td>
				 <td align="left" style="color: red;font-size:12px">{{compositionValidation}}</td>
			</tr>
		
			<tr>
            <td><label>Daily dose </label><a class="star">*</a></td>
             <td><input type="text" class = "form-control input"  v-model="medicineDTO.dailyDose"/></td><br/>
            </select></td><br/>
			</tr>
			<tr>
                <td>&nbsp;</td>
                      <td align="left" style="color: red;font-size:12px">{{dDoseValidation}}</td>
				<td></td>
			</tr>
			
        </table>
        

        <table class="t">
			<tr>
            <tr>
            <td><label>Contraindications</label><a class="star">*</a></td>
            <td><textarea id="myTextarea"  v-model="medicineDTO.contraindications"></textarea/></td><br/>
        </tr>
        <tr><td>&nbsp;</td>
             <td align="left" style="color: red;font-size:12px">{{contraindicationsValidation}}</td>
        </tr>
			
            </table>
			<button  type="button" class="btn2 btn-info btn-lg margin1" data-toggle="modal" v-on:click="AddMedicine(medicineDTO)">Submit</button>
			<br/>
			<br/>
    </div>
    </div>
	`,
	computed : {
        codeValidation: function () {
			if (this.medicineDTO.code != undefined && this.medicineDTO.code.length > 0) {
				let codeMatch = this.medicineDTO.code.match('[A-Za-z0-9]*');
                if (codeMatch != this.medicineDTO.code) return 'The code may contain only letters and numbers';
                else if(this.medicineDTO.code.length>10) return 'Th code can only contain 10 characters';
			}
			else if (this.medicineDTO.name === '') return 'Name is a required field';
			else return null;
		},
		nameValidation: function () {
			if (this.medicineDTO.name != undefined && this.medicineDTO.name.length > 0) {
				let nameMatch = this.medicineDTO.name.match('[A-Za-z ]*');
				if (nameMatch != this.medicineDTO.name) return 'The name may contain only letters';
				else if (this.medicineDTO.name[0].match('[A-Z]') === null) return 'The name must begin with a capital letter';
			}
			else if (this.medicineDTO.name === '') return 'Name is a required field';
			else return null;
        },
        typeValidation: function () {
		 if (this.medicineDTO.type === '') return 'Type is a required field,select one of the offered options!';
			else return null;
        },
        formValidation: function () {
            if (this.medicineDTO.form === '') return 'Form is a required field,select one of the offered options!';
               else return null;
           },
		compositionValidation: function () {
			if (this.medicineDTO.composition != undefined && this.medicineDTO.composition.length > 0) {
				let compositionMatch = this.medicineDTO.composition.match('[A-Za-z ]*');
				if (compositionMatch != this.medicineDTO.composition) return 'The composition may contain only letters';
				else if (this.medicineDTO.composition[0].match('[A-Z]') === null) return 'The composition must begin with a capital letter';
			}
			else if (this.medicineDTO.composition === '') return 'Composition is a required field';
			else return null;
		},
		manufacturerValidation: function () {
			if (this.medicineDTO.manufacturer != undefined && this.medicineDTO.manufacturer.length > 0) {
				let manufacturerMatch = this.medicineDTO.manufacturer.match('[A-Za-z ]*');
				if (manufacturerMatch != this.medicineDTO.manufacturer) return 'The manufacturer may contain only letters';
				else if (this.medicineDTO.manufacturer[0].match('[A-Z]') === null) return 'The manufacturer must begin with a capital letter';
			}
			else if (this.medicineDTO.manufacturer === '') return 'manufacturer is a required field';
			else return null;
		},	
		dDoseValidation: function () {
			if (this.medicineDTO.dailyDose != undefined && this.medicineDTO.dailyDose.length > 0) {
				let dailyDoseMatch = this.medicineDTO.dailyDose.match('[A-Za-z 0-9]*');
				if (dailyDoseMatch != this.medicineDTO.dailyDose) return 'The DailyDose may contain only letters and numbers';
				
			}
			else if (this.medicineDTO.dailyDose === '') return 'DailyDose is a required field';
			else return null;
		},contraindicationsValidation: function () {
			if (this.medicineDTO.contraindications != undefined && this.medicineDTO.contraindications.length > 0) {
				let dailyDoseMatch = this.medicineDTO.contraindications.match('[A-Za-z 0-9]*');
				if (dailyDoseMatch != this.medicineDTO.contraindications) return 'The Contraindications may contain only letters and numbers';
				else if (this.medicineDTO.contraindications[0].match('[A-Z]') === null) return 'The contraindications must begin with a capital letter';

			}
			else if (this.medicineDTO.contraindications === '') return 'Contraindications is a required field';
			else return null;
		}
		
    },
	methods: {
		AddMedicine: function (medicineDTO) {
			if(this.password_confirmed!=this.medicineDTO.password){
					alert( 'Passwords did not match!');	
					return	
			}else if(this.medicineDTO.code==null || this.medicineDTO.name==null || this.medicineDTO.type==null || 
				this.medicineDTO.form==null || this.medicineDTO.manufacturer==null || this.medicineDTO.onPrescription==null || this.medicineDTO.composition==null || this.medicineDTO.contraindications==null || this.medicineDTO.dailyDose==null){
				alert('All fields must be filled!')
				return
			}else{

				axios
				.get('/medicine/isCodeValid/' +medicineDTO.code)
				.then(response => {
					this.isValid=response.data;
					if(this.isValid==false){
						alert('code already exists, please choose another one!')
						return
					}else{
						if(this.medicineDTO.onPrescription=='YES')
					medicineDTO.onPrescription=true
				else 
					medicineDTO.onPrescription=false
/*
				rep=medicineDTO.replacement.split(",")
				for(r in rep)
				{
					medicineDTO.replacement[r]=rep[r]
					alert(medicineDTO.rep[r])
				}
				*/
				axios
					.post('/medicine/saveMedicine' ,medicineDTO  )
					.then(response => {
						alert("DODAT U BAZU");
					})

					.catch(error => {
						
						alert("GRESKA");
					})
					}
				})

				.catch(error => {
					
					alert("GRESKA");
				})		
			}
		},
	},
});