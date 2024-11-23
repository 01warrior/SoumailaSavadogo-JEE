package metier;

import dao.IDao;

//Une implementation de l'interface metier (les traitement de données)
//les class qui font des traitement doivent avoir des interface
public class ImpleIMetier implements IMetier {

    //besoin de dependance pour les calcul
    //ne pas innitialiser "= new" car ca va appeler une class pour couplage fort

    private IDao dao; //couplage faible fait reference a l'interface

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
