
package com.projetoescola.projetoescola;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cartoon")
    public String cartoon() {
        return "cartoon";
    }

    @GetMapping("/manga")
    public String manga() {
        return "manga"; 
    }

    @GetMapping("/realismo")
    public String realismo() {
        return "realismo";
    }
}
