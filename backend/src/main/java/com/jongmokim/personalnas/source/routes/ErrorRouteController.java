package com.jongmokim.personalnas.source.routes;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorRouteController implements ErrorController {
    
    @RequestMapping("/error")
    public String errorRoute() {
        return "forward:/index.html";
    }
}
