package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   Car getCar(String model, String series);
   List<User> listUsers();
}
