package com.chataround.chataroundws.repository;

import com.chataround.chataroundws.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gewrgia
 */
@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long>{

   @Query(value="SELECT * FROM userprofile WHERE userprofile.username=?1", nativeQuery = true)
    UserProfile findOne(String username);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM userprofile WHERE userprofile.username=?1",nativeQuery = true)
    void delete(String username);


   @Query(value = "SELECT count(*)>0 FROM userprofile WHERE username=?1", nativeQuery =true)
    boolean exists(String username);
}
