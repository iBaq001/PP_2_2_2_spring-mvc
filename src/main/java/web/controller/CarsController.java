package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private CarDao carDao;
    @Autowired
    public CarsController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping("/cars")
    public String index(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
            List<Car> car = new ArrayList<>();
            car.add(new Car("sedan", "audi", "GER"));
            car.add(new Car("hatch", "honda", "JAP"));
            car.add(new Car("pickup", "dodge", "USA"));
            car.add(new Car("truck", "chevrolet", "USA"));
            car.add(new Car("cabriolet", "porsche", "GER"));
            car = carDao.shouCountCar(car, allCars);
        model.addAttribute("cars", car);
        return "cars";
    }
}
