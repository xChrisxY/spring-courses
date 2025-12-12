package com.chris.springboot.relationships.repositories;

import com.chris.springboot.relationships.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
