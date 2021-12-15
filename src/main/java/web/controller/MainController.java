package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.DAO.CarDAO;
import web.DAO.ICarDAO;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private ICarDAO carDAO = CarDAO.getInstance();

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model) {
        List<Car> cars = carDAO.getAll();
        model.addAttribute("cars", cars);
        return "main";
    }

    @RequestMapping(value = "/cars/{count}")
    private String printCarsLimited(ModelMap model, @PathVariable int count) {
        List<Car> cars = carDAO.getCars(count);
        model.addAttribute("cars", cars);

        return "main";
    }
}
