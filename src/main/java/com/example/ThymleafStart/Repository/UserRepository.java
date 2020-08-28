package com.example.ThymleafStart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT u from User u WHERE u.FirsName = :FirstName")
    public User getUserByUsername(@Param("FirstName") String FirstName);

}
