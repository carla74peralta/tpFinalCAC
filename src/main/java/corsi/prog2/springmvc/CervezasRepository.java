package corsi.prog2.springmvc;

import java.util.List;

public interface CervezasRepository {
    
    public List<Cerveza> getCervezasByColor(String color);
    public List<String> getColores();
    
}
