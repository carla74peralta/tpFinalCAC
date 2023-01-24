package cerveceria.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Los controladores se indican con @Controller
public class IndexController {

    @Autowired  // Inyección de atributo (field injection)
    private CervezasRepository cr; 

    @GetMapping("/")    // GET Request de "/"
    public String index(Model model) {
        
        // El parámetro del tipo Model se le pasa a la vista para mostrar atributos
        model.addAttribute("colores", cr.getColores());
        
        return "index";
    }

}
