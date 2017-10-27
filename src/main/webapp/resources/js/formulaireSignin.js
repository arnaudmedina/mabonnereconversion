const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControle = {
		inputEmail: false,
		inputPassword: false

},
//Par fainénantise et pour reduire la taille de mon code,j'ai réuni tous les noms de champs dans ce tableau
champs = ['inputEmail', 'inputPassword'];

//Fonction unique de vérification du formulaire
function changeListener(event, firstCall) {
	//debugger
	if ("inputEmail" == this.id ) {
		// var re = /(?:\d{2}|\+\d{2}[ ]\d)([- ])\d{2}\1\d{2}\1\d{2}\1\d{2}/; pour n° tel
		var re=  /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/i ;

	}
	if ("inputPassword" == this.id ) {
		// var re = /(?:\d{2}|\+\d{2}[ ]\d)([- ])\d{2}\1\d{2}\1\d{2}\1\d{2}/; pour n° tel
		//pour mail	//var re=  /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/i
		var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/i ;
//		(/^
//		(?=.*\d)                //should contain at least one digit
//		(?=.*[a-z])             //should contain at least one lower case
//		(?=.*[A-Z])             //should contain at least one upper case
//		[a-zA-Z0-9]{8,}         //should contain at least 8 from the mentioned characters
//		$/)	;

	}
	var OK = re.exec(this.value);
	if (!OK) { 
		valeursControle[this.id] = false;
	}
	else { 
		valeursControle[this.id]= true;
		//window.alert("Merci, votre mail est : " + OK[0]);
	}

	if (!firstCall) {
		if (valeursControle[this.id]) {
			this.classList.add('valide');
			this.classList.remove('error');
		} else {
			this.classList.add('error');
			this.classList.remove('valide');
		}
	}


//	Grise (ou pas) mon bouton submit
	let valeursControleDansTableau = Object.values(valeursControle),
	positionFalse = valeursControleDansTableau.indexOf(false);
	document.getElementById('connexion').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
document.onreadystatechange = function () {
	// Ici j'attends que le document me dise qu'il est complétement chargé
	if ('complete' === document.readyState) {
		/**
		 * Ici je parcours tous mes champs les uns après les autres sans avoir besoin de recopier x fois le même code
		 * Moins de code dupliqué
		 *  = moins de code à maintenir
		 *  = moins de risque de bug dans le temps
		 */
		for (let champ of champs) {
			let inputTmp = document.getElementById(champ);

			inputTmp.addEventListener('change', changeListener);
			changeListener.call(inputTmp, undefined, true);
		}
	}
};