package com.chataround.chataroundws.repository;

import com.chataround.chataroundws.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Georgia Grigoriadou
 */
@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
