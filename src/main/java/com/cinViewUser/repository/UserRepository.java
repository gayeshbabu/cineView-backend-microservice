package com.cinViewUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cinViewUser.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
    User findByName(String username);

    @Query("select a from User a where a.name=:username ")
	List<User> findUserName(@Param("username")String username) ;
    
    @Query("update User a set a.password=:password where a.name=:name")
	int updateUser(@Param("name")String name,@Param("password") String password);

}