package main.java.com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import main.java.com.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import main.java.com.service.AssignmentService;
import main.java.com.service.DriverService;

@Controller
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @Autowired
    AssignmentService assignmentService;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("listDriver", driverService.getAll());
        return "driver/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String driver(Model model) {
        model.addAttribute("driver", new Driver());
        return "driver/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String addNewDriver(@ModelAttribute("driver") Driver driver, Model model) {
        driverService.insert(driver);
        return "redirect:/driver";

    }


    @GetMapping(value = "/delete/{id}")
    public String removeDriver(@PathVariable("id") int id) {
        assignmentService.deleteByDriverId(id);
        driverService.deleteById(id);
        return "redirect:/driver";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String viewUpdate(@PathVariable("id") int id, Model model) {
         Driver driver = driverService.findById(id);
         model.addAttribute("driver", driver);
        return "driver/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateDriver(@ModelAttribute("driver") Driver driver) {
        driverService.update(driver);
        return "redirect:/driver";
    }

}
