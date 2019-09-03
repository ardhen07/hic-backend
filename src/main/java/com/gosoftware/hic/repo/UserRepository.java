package com.gosoftware.hic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gosoftware.hic.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findOneByemailid(String emailid);

}
