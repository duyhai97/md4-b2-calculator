package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator {




    @GetMapping("/view")
    public ModelAndView showForm(){
        return  new ModelAndView("/view");
    }

    @PostMapping("/view")
    public ModelAndView calculator(@RequestParam("operator") String valueOne, double first, double second){
       ModelAndView modelAndView = new ModelAndView("/view");
        double result;
        switch (valueOne){

            case "ADD":
                result = first + second;
                break;
            case "MIN":
                result = first - second;
                break;
            case "MUL":
                result = first*second;
                break;
            case "DIV":
                if (second != 0) result = first/second;
                else throw new RuntimeException("Can't divide by zero");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + valueOne) ;
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
