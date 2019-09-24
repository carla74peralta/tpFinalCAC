package corsi.prog2.springmvc;

import java.util.List;

public interface CervezasRepository {
    
    List<Cerveza> getCervezasByColor(String color);
    List<String> getColores();
    
}
