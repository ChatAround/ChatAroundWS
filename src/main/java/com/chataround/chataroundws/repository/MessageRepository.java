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
    @Query(value="select * from message  where receiverId = ?1",nativeQuery = true)
    List<Message> findByUserId(Long id);
}
