package com.nhoclahola.bt2511_springsecurityjwt_demo2.repositories;

import com.nhoclahola.bt2511_springsecurityjwt_demo2.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>
{
    Optional<UserInfo> findByName(String username);
}
