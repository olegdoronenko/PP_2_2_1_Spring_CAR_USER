package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Transactional
    @Override
    public List<Car> getCarsList() {
        return carDao.getCarsList();
    }

    @Transactional
    @Override
    public User findByCar(String carName, String carSeries) {{
            return carDao.findByCar(carName, carSeries);
        }
    }
}
