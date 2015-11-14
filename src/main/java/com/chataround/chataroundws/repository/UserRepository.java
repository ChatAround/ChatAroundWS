package com.chataround.chataroundws.repository;

import com.chataround.chataroundws.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Gewrgia on 10/11/2015.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
