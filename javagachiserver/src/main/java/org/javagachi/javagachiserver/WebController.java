package org.javagachi.javagachiserver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class WebController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="JavaGachi Name Failed To Load") String name, @RequestParam(name="age", required=false, defaultValue="0") String age, Model model) {
     //   Random rng = new Random(System.currentTimeMillis());
      //  int randomNum = rng.nextInt();
        model.addAttribute("name", name);
        model.addAttribute("age", age);
    //    model.addAttribute("randomnum", randomNum);
        return "greeting";
    }

}