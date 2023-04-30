package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
   @Autowired
   private SessionFactory sessionFactory;

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }
   @Transactional
   @Override
   public void deleteAllUsers() {
      List<User> users = listUsers();
      for (User user : users) {
         sessionFactory.getCurrentSession().delete(user);
      }
   }
   @Transactional
   //@Override
   public User findByCar(String carName, String carSeries) {
      return userDao.findByCar(carName, carSeries);
   }
   }




