const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControleExperience = {
		nom: false,
		dateDebut: false,
		dateFin: false,
		
},
//Par fainénantise et pour reduire la taille de mon code,j'ai réuni tous les noms de champsEtatCivil dans ce tableau
champsEtatCivil = ['nom', 'dateDebut','dateFin'];

//Fonction unique de vérification du formulaire
function changeListenerExperience(event, firstCall) {
	if ("nom" == this.id ) {
		var re =/^([a-z]+(( |')[a-z]+)*)+([-]([a-z]+(( |')[a-z]+)*)+)*$/iu;
	};
	
	if ("dateDebut" == this.id ) {
	   var re='/^([0-9]{2})/([0-9]{2})/([0-9]{4})$/';
	}
	if ("dateFin" == this.id ) {
	var re='/^([0-9]{2})/([0-9]{2})/([0-9]{4})$/';
	;
	}
	var OK = re.exec(this.value);
	if (!OK) { 
		valeursControleExperience[this.id] = false;
	}
	else { 
		valeursControleExperience[this.id]= true;
		//window.alert("Merci, votre mail est : " + OK[0]);
	}

	if (!firstCall) {
		if (valeursControleExperience[this.id]) {
			this.classList.add('valide');
			this.classList.remove('error');
		} else {
			this.classList.add('error');
			this.classList.remove('valide');
		}
	}


//	Grise (ou pas) mon bouton submit
	let valeursControleExperienceDansTableau = Object.values(valeursControleExperience),
	positionFalse = valeursControleExperienceDansTableau.indexOf(false);
	document.getElementById('valider').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
document.onreadystatechange = function () {
	// Ici j'attends que le document me dise qu'il est complétement chargé
	if ('complete' === document.readyState) {
		/**
		 * Ici je parcours tous mes champsEtatCivil les uns après les autres sans avoir besoin de recopier x fois le même code
		 * Moins de code dupliqué
		 *  = moins de code à maintenir
		 *  = moins de risque de bug dans le temps
		 */
		for (let champ of champsExperience) {
			let inputTmp = document.getElementById(champ);

			inputTmp.addEventListener('change', changeListenerExperience);
			changeListenerExperience.call(inputTmp, undefined, true);
		}
	}
};