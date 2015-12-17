package com.chataround.chataroundws.repository;

import com.chataround.chataroundws.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author Georgia Grigoriadou
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        @Query(value = "SELECT DISTINCT * FROM user_table WHERE earth_box(ll_to_earth(?1, ?2), ?3) @> ll_to_earth(coordinates_latitude, coordinates_longitude)", nativeQuery = true)
        List<User> findInRadius(Double latitude, Double longitude, Double radius);

        @Query(value="SELECT * FROM  user_table WHERE user_table.username=?1",nativeQuery = true)
        User findOne(String username);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM user_table WHERE user_table.username=?1",nativeQuery = true)
        void delete(String username);
}
