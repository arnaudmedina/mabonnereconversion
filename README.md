README
===================

----------


Pré requis
-------------
**Installation de JDK 8 (si ce n'est pas déjà fait)**

 - Aller sur :
   http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html
 - Accepter la licence Choisir le téléchargment de
   jdk-8u131-windows-x64.exe Lancer l'exécutable en tant
   qu'administrateur pour installer JDK

**Lancer Eclipse avec le JDK**
- On peut indiquer à Eclipse la version du JDK avec laquelle travailler.
- Dans le dossier d'installation d'Eclipse, ouvrir le fichier eclipse.ini
- Ajouter les 2 lignes suivantes :
> -vm
< chemin du dossier du JDK>\bin\javaw.exe

**Installation de Tomcat (si ce n'est pas déjà fait)**

- Télécharger Tomcat 9 ici : http://mirror.vorboss.net/apache/tomcat/tomcat-9/v9.0.0.M21/bin/apache-tomcat-9.0.0.M21.zip
- Unzip le fichier zip dans un dossier de votre poste de travail.
  
 **Vérifier la bonne version d'Eclipse (si ce n'est pas déjà fait)**
 > - Aller dans "Windows" puis "Show views" puis "Servers"; si "Servers" ne vous est pas proposé, choisir "Others...", puis choisir dans la liste l'item "Server" puis "Servers";
> >- Si rien de tout cela ne vous est proposé, cela veut dire que vous n'avez pas la bonne version d'Eclipse (ou bien une version mal installée). Il faut dans ce cas installer la bonne version --> cf. Installer la bonne version Eclipse
 - Si vous avez accès à l'item Servers : Un onglet s'affiche avec un lien qui permet de créer un nouveau serveur. Cliquer sur ce lien.
Une liste s'affiche : ouvrir l'item "Apache" et sélectionner "Tomcat V9...". 
 - Si vous avez cet item --> vous avez la bonne version d'Eclipse. Aller à "Configuer Tomcat dans Eclipse"
 - Si aucun Tomcat ne vous est proposé, cela veut dire que vous n'avez pas    la bonne version d'Eclipse (ou bien une version mal  installée). Il    faut dans ce cas installer la bonne version --> cf. Installer la    bonne version Eclipse.

**Configurer Tomcat dans Eclipse (si ce n'est pas déjà fait)**
- Vous avez choisi "Tomcat V9..." dans la liste des serveurs. Clicker sur "Next" et configurer l'emplacement du Tomcat préalablement installé.
- Clicker sur "Finish"


Configurer le projet
-------------

**GitHub - Fork du projet exemple (si ce n'est pas déjà fait)** 
> - **Cette opération doit être faite une seule fois par une seule personne de l'équipe**
> - Aller sur GitHub avec le lien du projet qui vous concerne (lien déjà transmis)
> - Login
> - Clicker sur "Fork"
> Remarques : les 2 projets sont déjà "forkés" : Ma bonne reconversion par Arnaud et Référentiel des tiers par Anne-Marie. Donc cette opération n'est plus à faire.

**GitHub - Partage du projet  pour le travail collaboratif**
> - **Cette opération est à faire uniquement par la personne qui a fait le fork (Arnaud / Anne-Marie)**
> - Login sur GitHub avec votre compte.
> - Dans le repository "Forké", aller sur l'onglet "Settings". Clicker sur "Collaborators"  (à gauche).
> Il vous sera demander de confirmer votre login.
> Inviter vos coéquipiers en saisissant leur login GitHub puis click sur "Add collaborator"
> - Les coéquipiers invités recevront chacun un mail (celui utilisé pour créer le compte GitHub) demandant l'acceptation de collaborer au projet.

**Importer le projet dans Eclipse**
> - Cloner le projet avec son URL
> - Importer le projet cloné : "File" > "Import", puis sélectionner l'item "Maven" > Existing Maven Project. Clicker sur "Next"
> Parcourir pour indiquer le dossier du projet cloné.

**Compiler le projet**
> - Se positionner sur l'item du projet dans l'onglet "Project Explorer" d'Eclipse.
> Click droit, sélectionner "Run as" puis "Maven build"
> Saisir "clean compile" puis clicker sur "Run"

**Déployer le projet dans le serveur Tomcat**
> - Se positionner sur l'item du projet dans l'onglet "Project Explorer" d'Eclipse.
> Click droit, sélectionner "Run as" puis "Run on server"
