package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDao {

    public List<Car> shouCountCar(List<Car> car, int number) {
        if (number == 0 || number > 5) return car;
        return car.stream().limit(number).collect(Collectors.toList());
    }

}
