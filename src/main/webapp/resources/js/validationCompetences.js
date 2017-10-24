const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControleCompetence = {
		level1a5: false,
		duree: false,
		annee1: false

},
//Par fainénantise et pour reduire la taille de mon code,j'ai réuni tous les noms de champsCompetences dans ce tableau
champsCompetences = ['level1a5','duree','annee1' ];
var ladate=new Date();
//Fonction unique de vérification du formulaire
function changeListener(event, firstCall) {
//debugger

	var OK = false;
	if ("level1a5" ==  this.id) {
		if ((5 >= parseInt(this.value)) && (0 < parseInt(this.value))) {
			var OK = true;	
		}
	}
	if ("duree" ==  this.id) {
		if ((1 < parseInt(this.value)) && (41 > parseInt(this.value))) {
			var OK = true;	
		}
	}
	if ("annee1" == this.id) {
		if ((1970 < parseInt(this.value)) && (ladate.getFullYear() > parseInt(this.value))) {
			var OK = true;	
		}
	}

	if ((!OK)) { 
		valeursControleCompetence[this.id] = false;
	}
	else { 
		valeursControleCompetence[this.id]= true;
		//window.alert("Merci, votre mail est : " + OK[0]);
	}

	if (!firstCall) {
		if (valeursControleCompetence[this.id]) {
			this.classList.add('valide');
			this.classList.remove('error');
		} else {
			this.classList.add('error');
			this.classList.remove('valide');
		}
	}


//	Grise (ou pas) mon bouton submit
	let valeursControleDansTableau = Object.values(valeursControleCompetence),
	positionFalse = valeursControleDansTableau.indexOf(false);
	document.getElementById('connexion').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
//document.onreadystatechange = function () {
// Ici j'attends que le document me dise qu'il est complétement chargé
//if ('complete' === document.readyState) {
/**
 * Ici je parcours tous mes champsCompetences les uns après les autres sans avoir besoin de recopier x fois le même code
 * Moins de code dupliqué
 *  = moins de code à maintenir
 *  = moins de risque de bug dans le temps
 */
function pageModaleChargee (){
for (let champ of champsCompetences) {
	let inputTmp = document.getElementById(champ);

	inputTmp.addEventListener('change', changeListener);
	changeListener.call(inputTmp, undefined, true);
};
};
//}