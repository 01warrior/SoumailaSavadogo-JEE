package pres;

import dao.ImpleDao;
import metier.ImpleIMetier;

public class MethodeStatique {

    public static void main(String[] args) {

        //instanciation statique vue que j'utilise new encore pour instancier les class
        ImpleIMetier metier=new ImpleIMetier();

        //----erreur nullCheckerExecption : Dependance non satisfait

        //créer un objet pour avoir acces a la methode getdate vue que la methode n'est pas static
        //et pourtant Implemetier utiliser un objet dao pour avoir la methode pour avoir les donnée
        ImpleDao dao = new ImpleDao();

        //injecter l'objet dao créé ici dans l'implementation metier afin de
        //l'utiliser pour avoir les donnée (injection de dependance) par instanciation
        //static vue que jai utilisé new pour créer dio couplage fort
        metier.setDao(dao);

        System.out.println("Resultat :: "+metier.calcul());


        //créer un fichier texte
        //Pour avoir une application configurable
        //y declarer les Nom des classe dans mon app

    }
}
