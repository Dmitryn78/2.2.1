package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;


   @Transactional
   @Override
   public void add(User user, Car car) {
      user.setCar(car);
      car.setUser(user);
      userDao.add(user);
   }

   @Override
   @Transactional
   public User getUserFromModelAndSeries(String model, String series) {
        return userDao.getCar(model, series).getUser();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

}
