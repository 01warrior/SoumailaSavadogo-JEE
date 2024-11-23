package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VersionAnnotation {
    //scanner les package dao et metier si le tout etait dans un meme dossier parent je donne le nom du dossier
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier");

        //AnnotationConfigApplicationContext est une classe de Spring qui recherche les
        //annotations dans les packages dao et metier pour y trouver des beans (objets Spring gérés).

        //Spring va scanner ces packages à la recherche des classes annotées avec @Component
        // , @Autowired, etc., et les enregistrer en tant que beans dans son conteneur.

        IMetier metier = (IMetier) context.getBean("metier"); // ou IMetier metier = context.getBean(IMetier.class); sans cast
        //Spring donne l'objet qui a été créé pour cette classe

        System.out.println(metier.calcul());
    }
}
