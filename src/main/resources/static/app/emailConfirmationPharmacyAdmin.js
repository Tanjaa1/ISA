Vue.component("emailConfirmationPharmacyAdmin", {
	data: function () {
		return {
			name: null,
		}
	},
	template: `
	<div class="confirmEmail">
		<h5>Please complete your registration by clicking this button</h5>
		<button class="conf" v-on:click="Confirm(); SuccessfulRegistration();">Confirm</button>
		
	</div>
	`,
	methods: {
		Confirm: function () {
			var queryString = location.href
			var id = queryString.split("=");
			var id1 = id[1];
			axios
				.put("/pharmacyAdmin/confirmationEmailPharmacyAdmin/" + id[1])
				.then(response => {
				})

				.catch(error => {
				})
		},
		SuccessfulRegistration: function () {
			this.$router.push('successfulRegistration');
        }
	},
});