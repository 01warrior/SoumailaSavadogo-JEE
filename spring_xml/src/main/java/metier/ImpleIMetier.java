package metier;

import dao.IDao;

//Une implementation de l'interface metier (les traitement de données)
//les class qui font des traitement doivent avoir des interface

public class ImpleIMetier implements IMetier {

    //besoin de dependance pour les calcul
    //ne pas innitialiser "= new" car ca va appeler une class pour couplage fort

    private IDao dao; //couplage faible fait reference a l'interface

    //injection par le constructeur
    //Au démarrage de l'application, Spring scanne les classes annotées avec @Component dans les packages que tu
    //lui as indiqués (dao, metier, etc.).

    //Spring repère que ImpleIMetier est un bean (grâce à @Component("metier")) et qu'il a une dépendance à IDao.
    //Spring vérifie s'il existe une classe qui implémente IDao. Il trouve ImpleDao et crée une instance de ImpleDao.
    //Ensuite, Spring crée l'instance de ImpleIMetier en passant l'instance de ImpleDao au constructeur de ImpleIMetier.
    public ImpleIMetier(IDao dao) {
        this.dao = dao;
    }


    @Override
    public double calcul() {
        double data=dao.getDate();
        double result=data*20*Math.pow(2,5);
        return result;
    }

    //injecter dans la variable dao un objet d'une classe qui implemente l'interface Idao
    public void setDao(IDao dao) {
        this.dao = dao;
    }

}