package com.newstartup.litepaymentservice.application.entrypoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Home controller
 *
 * @author <a href="mailto:jorge.riveros@payu.com"> Jorge Riveros </a>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Redirects all the GET requests from "/" to the swagger documentation
     */
    @GetMapping
    public String home() {

        return "redirect:/swagger-ui.html";
    }
}
