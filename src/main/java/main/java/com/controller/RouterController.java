package main.java.com.controller;

import main.java.com.entity.Router;
import main.java.com.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import main.java.com.service.AssignmentService;

@Controller
@RequestMapping("/router")
public class RouterController {
    @Autowired
    RouterService routerService;

    @Autowired
    AssignmentService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("listRouter", routerService.getAll());
        return "router/index";
    }

    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("router", new Router());
        return "router/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("router") Router router){
        routerService.insert(router);
        return "redirect:/router";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("router", routerService.findRouterId(id));
        return "router/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("router") Router router){
        routerService.update(router);
        return "redirect:/router";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        assignmentService.deleteByRouterId(id);
        routerService.deleteById(id);
        return "redirect:/router";
    }
}
