package org.example.Spring_Boot_3_1_1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.Spring_Boot_3_1_1.model.User;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    public EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.merge(user);
    }
    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("select u from User u ");
        return query.getResultList();
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void update(User user) {
        User existingUser = entityManager.find(User.class, user.getId());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        entityManager.merge(existingUser);
    }

}
