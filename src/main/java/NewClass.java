
import farma.DaoFactory;
import farma.Pole;
import farma.Zviera;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tomas
 */
public class NewClass {

    public static void main(String[] args) {
        /*List<Pole> list = DaoFactory.INSTANCE.getPoleDao().getAll();
        for (Pole pole : list) {
            System.out.println(pole.getTypPozemku());
        }*/

        List<Zviera> list = DaoFactory.INSTANCE.getZvieraDao().getAll();
        for (Zviera zviera : list) {
            System.out.println(zviera.getId() + "  " + zviera.getRegistracneCislo());
        }
    }
}
