package com.nhoclahola.bt2511_springsecurityjwt_demo2.services;

import com.nhoclahola.bt2511_springsecurityjwt_demo2.entities.UserInfo;
import com.nhoclahola.bt2511_springsecurityjwt_demo2.repositories.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record UserService(UserInfoRepository repository, PasswordEncoder passwordEncoder)
{
    public String addUser(UserInfo userInfo)
    {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Thêm user thành công";
    }
}
