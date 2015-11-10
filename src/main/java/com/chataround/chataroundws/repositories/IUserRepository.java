package com.chataround.chataroundws.repositories;

import com.chataround.chataroundws.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Gewrgia on 10/11/2015.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
