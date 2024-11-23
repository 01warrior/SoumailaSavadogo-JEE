package extension;

import dao.IDao;
import org.springframework.stereotype.Component;

public class ImpleDao2 implements IDao {
    @Override
    public double getDate() {
        System.out.println("Avec les capteur version etendu");
        return 100;
    }
}
