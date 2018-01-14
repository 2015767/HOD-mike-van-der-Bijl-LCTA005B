package nl.hva.web;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/")
    public ModelAndView hello() throws IOException {
        ModelAndView helloworld = new ModelAndView("hello");

        return helloworld;
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView helloWorld() throws IOException {
        ModelAndView helloworld = new ModelAndView("moreHello");

        return helloworld;
    }

}
