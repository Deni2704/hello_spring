package org.launchcode.hello_spring.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HelloController {
    //Handles request at path /hello
   /* @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }*/

    //lives at /hello/hello
    //Handles request of the form /hello?name=LaunchCode
   @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String hello(@RequestParam String name, Model model){
       String thegreeting = "Hello, " + name + "!";
       model.addAttribute("greeting", thegreeting);
        return "Hello";
    }

    //handles request of the form/hello/LaunchCode
    @GetMapping("{name}")
    public String helloAgain(@PathVariable String name, Model model){
       model.addAttribute("greeting", "Hello, " + name + "!");
        return "Hello";
    }

    // hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
       return "hello-list";

    }
}
