package com.chataround.chataroundws.repository;

import com.chataround.chataroundws.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {

    @Query(value = "SELECT DISTINCT * FROM message WHERE earth_box(ll_to_earth((SELECT coordinates_latitude FROM user_table WHERE user_table.id=senderId), (SELECT coordinates_longitude FROM user_table WHERE user_table.id=senderid)),radius) @> ll_to_earth((SELECT coordinates_latitude FROM user_table WHERE user_table.id=?1),(SELECT coordinates_longitude FROM user_table WHERE user_table.id=?1) )", nativeQuery = true)
    List<Message> findById(Long id);

}
