const
    /**
     * Dans cet objet on conserve l'état de validité de chaque donnée
     */
    valeursControle = {
        identite: false,
        adresse: false,
        courriel: false,
        civilite: false,
        cpville: false,
        ville: false,
        pays: false,
    },
    // Par fainénantise et pour reduire la taille de mon code,j'ai réuni tous les noms de champs dans ce tableau
    champs = ['identite', 'adresse', 'courriel', 'mlle', 'mme', 'm', 'cpville', 'ville', 'pays'];

// Fonction unique de vérification du formulaire
function changeListener(event, firstCall) {
    if (-1 === ['mme', 'm'].indexOf(this.id)) {
        // Cas où on n'est pas dans la civilité
        valeursControle[this.id] = ('' !== this.value);

        // Changer la classe en fonction du résultat
        if (!firstCall) {
            if (valeursControle[this.id]) {
                this.classList.add('valid');
                this.classList.remove('error');
            } else {
                this.classList.add('error');
                this.classList.remove('valid');
            }
        }
    } else {
        // Cas de la civilité
        valeursControle.civilite = true;
    }

    // Grise (ou pas) mon bouton submit
    let valeursControleDansTableau = Object.values(valeursControle),
        positionFalse = valeursControleDansTableau.indexOf(false);
    document.getElementById('valider').disabled = (-1 !== positionFalse);
}

// Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
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