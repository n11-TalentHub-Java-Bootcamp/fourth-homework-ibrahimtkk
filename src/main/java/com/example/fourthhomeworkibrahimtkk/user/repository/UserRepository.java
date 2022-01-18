package com.example.fourthhomeworkibrahimtkk.user.repository;

import com.example.fourthhomeworkibrahimtkk.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
