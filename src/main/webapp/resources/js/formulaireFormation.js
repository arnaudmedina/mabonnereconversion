const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControleFormation = {
		annee: false,
		ecole: false
},
//On réunit tous les noms de champs dans ce tableau
champsFormation = ['annee','ecole'];

//Fonction unique de vérification du formulaire
function changeListenerFormation(event, firstCall) {
	// debugger ;
	if (this.id=="annee")
	{
		if ((this.value >1900) &&(this.value <2030))
			valeursControleFormation[this.id] = true;
		else
			valeursControleFormation[this.id] = false;
	}
	if (this.id=="ecole")
	{
		if (this.value.length>3)
			valeursControleFormation[this.id] = true;
		else
			valeursControleFormation[this.id] = false;
	}


	// Changer la classe en fonction du résultat
	if (!firstCall) {
		if (valeursControleFormation[this.id]) {
			this.classList.add('valide');
			this.classList.remove('error');
		} else {
			this.classList.add('error');
			this.classList.remove('valide');
		}
	}

//	Grise (ou pas) mon bouton submit
	let valeursControleFormationDansTableau = Object.values(valeursControleFormation),
	positionFalse = valeursControleFormationDansTableau.indexOf(false);
	document.getElementById('validation').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
//document.onreadystatechange = function () {
//Ici j'attends que le document me dise qu'il est complètement chargé
//if ('complete' === document.readyState) {
/**
 * Ici je parcours tous mes champs les uns après les autres sans avoir besoin de recopier x fois le même code
 * Moins de code dupliqué
 *  = moins de code à maintenir
 *  = moins de risque de bug dans le temps
 */
function initEventListenerFormation(){

	for (let champ of champsFormation) {
		//debugger;
		let inputTmp = document.getElementById(champ);
		let evenement = "";
		if (champ=="annee")
			evenement = "keyup";
		if (champ=="ecole")
			evenement = "change";
		changeListenerFormation.call(inputTmp, undefined, true);
		inputTmp.addEventListener(evenement, changeListenerFormation);
	}
};