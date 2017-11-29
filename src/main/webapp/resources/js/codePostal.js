$(function(){
	var liste = [
		{value :'93001', label : '93001 Aubervilliers'},
		{value :'93005', label : '93005 Aulnay-sous-Bois'},
		{value :'93006', label : '93006 Bagnolet'},
		{value :'93007', label : '93007 Le Blanc-Mesnil'},
		{value :'93008', label : '93008 Bobigny'},
		{value :'93010', label : '93010 Bondy'},
		{value :'93013', label : '93013 Le Bourget'},
		{value :'93014', label : '93014 Clichy-sous-Bois'},
		{value :'93015', label : '93015 Coubron'},
		{value :'93027', label : '93027 La Courneuve'},
		{value :'93029', label : '93029 Drancy'},
		{value :'93030', label : '93030 Dugny'},
		{value :'93031', label : '93031 EPinay-sur-Seine'},
		{value :'93032', label : '93032 Gagny'},
		{value :'93033', label : '93033 Gournay-sur-Marne'},
		{value :'93039', label : '93039 L\'Île-Saint-Denis'},
		{value :'93045', label : '93045 Les Lilas'},
		{value :'93046', label : '93046 Livry-Gargan'},
		{value :'93047', label : '93047 Montfermeil'},
		{value :'93048', label : '93048 Montreuil'},
		{value :'93049', label : '93049 Neuilly-Plaisance'},
		{value :'93050', label : '93050 Neuilly-sur-Marne'},
		{value :'93051', label : '93051 Noisy-le-Grand'},
		{value :'93053', label : '93053 Noisy-le-Sec'},
		{value :'93055', label : '93055 Pantin'},
		{value :'93057', label : '93057 Les Pavillons-sous-Bois'},
		{value :'93059', label : '93059 Pierrefitte-sur-Seine'},
		{value :'93061', label : '93061 Le Pré-Saint-Gervais'},
		{value :'93062', label : '93062 Le Raincy'},
		{value :'93063', label : '93063 Romainville'},
		{value :'93064', label : '93064 Rosny-sous-Bois'},
		{value :'93066', label : '93066 Saint-Denis'},
		{value :'93070', label : '93070 Saint-Ouen'},
		{value :'93071', label : '93071 Sevran'},
		{value :'93072', label : '93072 Stains'},
		{value :'93073', label : '93073 Tremblay-en-France'},
		{value :'93074', label : '93074 Vaujours'},
		{value :'93077', label : '93077 Villemomble'},
		{value :'93078', label : '93078 Villepinte'},
		{value :'93079', label : '93079 Villetaneuse'},
		{value :'94001',label : '94001 Ablon-sur-Seine'},
		{value :'94002',label : '94002 Alfortville'},
		{value :'94003',label : '94003 Arcueil'},
		{value :'94004',label : '94004 Boissy-Saint-Lèger'},
		{value :'94011',label : '94011 Bonneuil-sur-Marne'},
		{value :'94015',label : '94015 Bry-sur-Marne'},
		{value :'94016',label : '94016 Cachan'},
		{value :'94017',label : '94017 Champigny-sur-Marne'},
		{value :'94018',label : '94018 Charenton-le-Pont'}

	];

	$('#recherche').autocomplete({
        minLength : 2,
        max: 5,
	    source : liste,

	    select : function(event, ui){ // lors de la sélection d'une proposition

//	        $('#description').val( ui.item.desc ); // on ajoute la description de l'objet dans un bloc

	    }

	});
	$( "#recherche" ).autocomplete("widget").addClass("fixedHeight");
});
