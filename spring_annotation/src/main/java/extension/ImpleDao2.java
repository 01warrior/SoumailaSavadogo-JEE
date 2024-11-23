package extension;

import dao.IDao;
import org.springframework.stereotype.Component;

//une extention
@Component("dao2")
public class ImpleDao2 implements IDao {
    @Override
    public double getDate() {
        System.out.println("Avec les capteur version etendu");
        return 100;
    }
}
