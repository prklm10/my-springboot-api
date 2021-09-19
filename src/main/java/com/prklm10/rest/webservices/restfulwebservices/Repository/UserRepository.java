package com.prklm10.rest.webservices.restfulwebservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prklm10.rest.webservices.restfulwebservices.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
