package com.udeesha.userhandlesystembackend.repository;

import com.udeesha.userhandlesystembackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositary extends JpaRepository <User,Long>{

}
