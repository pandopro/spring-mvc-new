package web.DAO;

import web.model.Car;

import java.util.List;

public interface ICarDAO {
    List<Car> getAll();

    List<Car> getCars(int count);
}
