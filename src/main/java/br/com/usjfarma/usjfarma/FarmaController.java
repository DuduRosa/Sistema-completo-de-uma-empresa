package br.com.usjfarma.usjfarma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FarmaController {

    //============================================HOME======================================//

    // Link para redirecionamento para a pagina de Home

    @GetMapping(value = "/")
    public String getIndex() {
        return "index";
    }
    
}