const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControleCompetence = {
		niveau: false,
		duree: false,
		annee1: false
},
//Pour réduire la taille de mon code,j'ai réuni tous les noms de champsCompetences dans ce tableau
champsCompetences = ['annee1','duree','niveau' ];
var ladate=new Date();

//Fonction unique de vérification du formulaire
function changeListenerCompetences(event, firstCall) {
//	debugger;

	let OK = false;

	if ("niveau" ==  this.name) {
		for (let index = 0; index <5; index++){
			if (document.getElementsByName("niveau")[index].checked)
				OK = true;
		}

		if ((!OK)) { 
			valeursControleCompetence["niveau"] = false;
		}
		else { 
			valeursControleCompetence["niveau"]= true;
		}
	}
	else {

		if ("duree" ==  this.id) {
			if ((1 < parseInt(this.value)) && (41 > parseInt(this.value))) {
				OK = true;	
			}
		}
		
		if ("annee1" == this.id) {
			if ((1970 < parseInt(this.value)) && (ladate.getFullYear() > parseInt(this.value))) {
				OK = true;	
			}
		}

		if ((!OK)) { 
			valeursControleCompetence[this.id] = false;
		}
		else { 
			valeursControleCompetence[this.id]= true;
			//window.alert("Merci, votre mail est : " + OK[0]);
		}
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
	let valeursControleesDansTableau = Object.values(valeursControleCompetence),
	positionFalse = valeursControleesDansTableau.indexOf(false);
	document.getElementById('validation').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
//document.onreadystatechange = function () {
//Ici j'attends que le document me dise qu'il est complètement chargé
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
		if (inputTmp === null)
		{
			for (let index = 0; index <5; index++){
				inputTmp = document.getElementsByName(champ)[index];
				inputTmp.addEventListener('change', changeListenerCompetences);
				changeListenerCompetences.call(inputTmp, undefined, true);
			}
		}
		else
		{
			inputTmp.addEventListener('change', changeListenerCompetences);
			changeListenerCompetences.call(inputTmp, undefined, true);
		}
	};
};
//}