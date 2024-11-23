package dao;

//création d'une implementation de l'interface

public class ImpleDao implements IDao{
    //respecter le contrat en implementant les methodes
    @Override
    public double getDate() {
        System.out.println(" de la Base de données");
        return 20;
    }
}
