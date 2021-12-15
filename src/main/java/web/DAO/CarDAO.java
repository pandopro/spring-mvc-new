package web.DAO;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDAO implements ICarDAO {
    private static CarDAO instance;
    private static List<Car> cars;

    private CarDAO() {
    }

    public static CarDAO getInstance() {
        if (instance == null) {
            instance = new CarDAO();
            cars = new ArrayList<>();
            cars.add(new Car("Lada", "XRAY", "BLACK"));
            cars.add(new Car("Lada", "VESTA", "WHITE"));
            cars.add(new Car("Lada", "LARGUS", "GRAY"));
            cars.add(new Car("Lada", "KALINA", "RED"));
            cars.add(new Car("BMW", "X5", "BLACK"));
        }
        return instance;
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }

    @Override
    public List<Car> getCars(int count) {
        if (count > 4) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
