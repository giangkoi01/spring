package main.java.com.controller;

import main.java.com.DTO.AssignmentDTO;
import main.java.com.service.AssignmentService;
import main.java.com.service.DriverService;
import main.java.com.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @Autowired
    RouterService routerService;

    @Autowired
    DriverService driverService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("assignmentList", assignmentService.getAll());
        return "assignment/index";
    }

    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("listDriver", driverService.getAll());
        model.addAttribute("listRouter", routerService.getAll());
        model.addAttribute("assignment", new AssignmentDTO());
        return "assignment/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("assignment") AssignmentDTO assignmentDTO){
        System.out.println(assignmentDTO);
        assignmentService.insert(assignmentDTO);
        return "redirect:/assignment";
    }

    @GetMapping("/update/{id}")
    public String viewUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("listDriver", driverService.getAll());
        model.addAttribute("listRouter", routerService.getAll());
        model.addAttribute("assignment", assignmentService.findById(id));
        return "assignment/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("assignment") AssignmentDTO assignmentDTO){
        assignmentService.update(assignmentDTO);
        return "redirect:/assignment";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        assignmentService.deleteById(id);
        return "redirect:/assignment";
    }


}
