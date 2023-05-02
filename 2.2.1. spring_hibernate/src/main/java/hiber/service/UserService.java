package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsersList();
    void deleteAllUsers();
    //User findByCar(String carName, String carSeries);
}
