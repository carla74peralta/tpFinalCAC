package corsi.prog2.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResultadoController {
    
    @Autowired
    CervezasRepository cr;
    
    @PostMapping("/consulta")   // POST Request para "/consulta"
    public String resultado(
            Model model,    // Se pide el atributo color del POST (obligatorio)
            @RequestParam(value = "color",required = true) String color) {
        
        model.addAttribute("colorElegido",color);
        model.addAttribute("cervezas", cr.getCervezasByColor(color));
        
        return "resultado";
    }
    
}
