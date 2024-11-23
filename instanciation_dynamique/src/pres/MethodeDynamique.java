package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodeDynamique {

    public static void main(String[] args) throws Exception{
        //deux type d'instanciation static et dynamique

        //instanciation dynamique en lisant le fichier texte pour connaitre le nom de la class
        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();

        //en java toutes les class et interface sont chargé en
        //memoire une seul fois sous forme d'un objet de  type Class
        //donc il faut charger celle la
        Class cDao=Class.forName(daoClassName);

        //ensuite créer une instance de la class (dont le nom a été lu dans le fichier)
        //throws InstantiationException : si on a pas de constructeur par defaut, IllegalAccessException : constructeur privé
        //la class utilisé doit implementer l'interface IDao
        IDao dao=(IDao) cDao.newInstance();

        System.out.println(dao.getDate());

        String metierClassName=scanner.nextLine();

        //en java toutes 
        // les class et interface sont chargé en
        //memoire une seul fois sous forme d'un objet de  type Class
        //donc il faut charger celle la
        Class cMetier=Class.forName(metierClassName);

        //ensuite créer une instance de la class (dont le nom a été lu dans le fichier)
        // throws InstantiationException : si on a pas de constructeur par defaut, IllegalAccessException : constructeur privé

        //la class utilisé doit implementer l'interface IMetier
        IMetier metier=(IMetier) cMetier.newInstance();


        //ensuite je peux appeler les methodes de la class notamment setDao qui prend un param de type IDao
        Method methode=cMetier.getMethod("setDao",IDao.class);

        //jinvoque la methode setdiao sur mon objet metier et je lui passe lobjet dao en parametre
        //donc appelation dynamique de la methode setdao : metier.setDao(dao)
        methode.invoke(metier,dao);

    }
}
