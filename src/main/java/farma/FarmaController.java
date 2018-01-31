package farma;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmaController {

    private PoleDao poleDao = DaoFactory.INSTANCE.getPoleDao();
    private ZvieraDao zvieraDao = DaoFactory.INSTANCE.getZvieraDao();

    @CrossOrigin
    @RequestMapping("/polia")
    public List<Pole> getPolia() {
        return poleDao.getAll();
    }

    @CrossOrigin
    @RequestMapping("/polia/{poleId}")
    public Pole getPoleById(@PathVariable int poleId) {
        Pole pole = poleDao.findById(poleId);
        if (pole == null) {
            throw new PoleNotFoundExeption();
        }
        return pole;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/polia", method = RequestMethod.POST)
    public void ulozPole(@RequestBody Pole pole) {
        poleDao.add(pole);
    }

    @CrossOrigin
    @RequestMapping("/zvierata")
    public List<Zviera> getZvierata() {
        return zvieraDao.getAll();
    }

    @CrossOrigin
    @RequestMapping("/zvierata/{rc}")
    public Zviera getZvieraByRegistracneCislo(@PathVariable String rc) {
        Zviera zviera = zvieraDao.findByRegistracneCislo(rc);
        if (zviera == null) {
            throw new PoleNotFoundExeption();
        }
        return zviera;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/zvierata", method = RequestMethod.POST)
    public void ulozPrezencka(@RequestBody Zviera zviera) {
        zvieraDao.add(zviera);
    }
}
