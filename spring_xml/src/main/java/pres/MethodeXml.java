package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MethodeXml {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //chercher un objet de type Imetier dans les bean qui sappel metier
        IMetier metier= (IMetier) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}
