package ru.kata.spring.boot_security.demo.pp_3_1_5_rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.pp_3_1_5_rest.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u join fetch u.roles where u.username = :email")
    User findByUsername(String email);

    @Query("select u from User u join fetch u.roles where u.id =:id")
    Optional<User> findById(Long id);

    @Query("select distinct u from User u join fetch u.roles ")
    List<User> findAll();

    void deleteById(Long id);


}
