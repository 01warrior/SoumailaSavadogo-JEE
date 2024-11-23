package extension;

import dao.IDao;

//une extention
public class ImpleDao2 implements IDao {
    @Override
    public double getDate() {
        System.out.println("Avec les capteur version etendu");
        return 100;
    }
}
