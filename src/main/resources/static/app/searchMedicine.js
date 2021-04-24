Vue.component("searchMedicine", {
	data: function () {
		return {
			pharmacies:null
		}
	},
	beforeMount() {
		
	},
	template: `
	<div id="Search"  class="BackendImagePhysician">
		<br><br>	
		<p>Search Medicine</p>
			
		<div class="row search">
		  	<div class="col-sm-5"><input id="idText" placeholder="Enter medicine" type="text" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
			</div>
		<br><br>
		<br><br>

		<br><br>

		<div >
			<span class="prvi">
			<div>
			<form action="/action_page.php">
				<label for="cars">On prescription:</label>
					<select name="onPrescription" id="onPrescription">
						<option value="Y">YES</option>
						<option value="N">NO</option>
					</select>
			</form>
			</div>
	<br><br><br><br>
			<div>
			<form action="/action_page.php">
				<label for="cars">Type:</label>
					<select name="type" id="type">
						<option value=" "> </option>
						<option value="Antipyretic">Antipyretic</option>
						<option value="Analgesic">Analgesic</option>
						<option value="AntimalarialDrug">Antimalarial Drug</option>
						<option value="Antibiotic">Antibiotic</option>
						<option value="Antiseptic">Antiseptic</option>
						<option value="MoodStabilizer">Mood Stabilizer</option>
						<option value="HormoneReplacements">Hormone Replacements</option>
						<option value="OralContraceptive">OralContraceptive</option>
						<option value="Stimulants">Stimulants</option>
						<option value="Tranquilizer">Tranquilizer</option>
						<option value="Statin">Statin</option>
					</select>
			</form>
			</div>
	<br><br><br><br>
			<form action="/action_page.php">
				<label for="form">Form:</label>
					<select name="form" id="form">
						<option value=" "> </option>
						<option value="Powder">Powder</option>
						<option value="Capsule">Capsule</option>
						<option value="Tablet">Tablet Drug</option>
						<option value="Paste">Paste</option>
						<option value="Gel">Gel</option>
						<option value="Solution">Solution</option>
						<option value="Syrup">Syrup</option>
						<option value="Ointment">Ointment</option>
					</select>
			</form>
		
		<br><br><br><br>
	
			<form action="/action_page.php">
				<label for="form">Mark:</label>
					<select name="mark" id="mark">
						<option value=" "> </option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
			</form>
			</span>

		</div>
		

		
		<br><br><br><br>
		<br><br><br><br>


			<div><button type="button" style="color:white" class="btn btn-default" data-dismiss="modal" v-on:click="Search()"><i class="fa fa-search"></i></button>
			</div>
		</div><br>
		





		
			  				
		<div class="tab-content">
				<div id="profil" class="container tab-pane active"><br>
					<div class="container">
						<div class="row">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>Name</th>
										<th>Type</th>
										<th>Mark</th>
										<th>Pharmacy</th>
										<th>Price</th>
										<th>Composition</th>
									</tr>
								</thead>
								<tbody>
									<tr v-for="a in this.pharmacies">
										<td>{{a.name}}</td>
										<td>{{a.type}}</td>
										<td>{{a.mark}}</td>
										<td>{{a.pharmacy}}</td>
										<td>{{a.price}}</td>
										<td><button type="button" class="btn btn-info btn-lg" v-on:click="ShowComposition(a.composition)">Composition</button></td>									
									</tr>
								</tbody>
							</table>
						</div>
					</div>		
				</div>
			</div>

			



			
			
	</div>					
	`,
	methods: {
		Search:function(){
			var text=document.getElementById("idText").value
			var onPrescriptionText=document.getElementById("onPrescription").value
			var type=document.getElementById("type").value
			var form=document.getElementById("form").value
			var mark=document.getElementById("mark").value
		
		
				axios
				.get('medicine/combinedSearch/'+text+'x'+type+'x'+form+'x'+mark+'x'+onPrescriptionText)
				.then(response => {
					this.pharmacies = response.data
			  
				})
				.catch(error => {
					alert('nesupjesnooo')
				})
			

		
		},

		ShowComposition:function(composition){

			alert('Composition:' + composition)

		}
		
	}
});

