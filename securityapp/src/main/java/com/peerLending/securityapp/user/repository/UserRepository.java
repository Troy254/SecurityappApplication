package com.peerLending.securityapp.user.repository;

import com.peerLending.securityapp.user.model.SecurityUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SecurityUsers,String> {

}
