package com.firman.belajar_crud.repository;

import com.firman.belajar_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}