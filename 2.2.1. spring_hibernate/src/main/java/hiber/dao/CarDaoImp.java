package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImp implements CarDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getCarsList() {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public User findByCar(String name, String series) {
        TypedQuery<Car> findCarQuery = sessionFactory.getCurrentSession().createQuery("from Car where name = :name and series = :series")
                .setParameter("name", name)
                .setParameter("series", series);
        List<Car> findCarList = findCarQuery.getResultList();
        Long ownerId = findCarList.get(0).getId();

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car = :car")
                .setParameter("car", findCarList.get(0));
        List<User> findUserList = query.getResultList();
        User owner = findUserList.get(0);

        return owner;
    }
}
