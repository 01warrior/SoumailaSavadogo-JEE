package dao;

import org.springframework.stereotype.Component;

//création d'une implementation de l'interface

//a chaque fois quil vois une class qui commence par lannonation componnent il va linstancier et lui donner le nom dao
@Component("dao")
public class ImpleDao implements IDao{
    //respecter le contrat en implementant les methodes
    @Override
    public double getDate() {
        System.out.println(" de la Base de données");
        return 20;
    }
}
