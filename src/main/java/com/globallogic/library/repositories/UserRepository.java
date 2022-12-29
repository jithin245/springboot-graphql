package com.globallogic.library.repositories;

import com.globallogic.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmailIdAndPassword(String userName, String password);
}
