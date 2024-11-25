package com.nhoclahola.bt2511_springsecurityjwt_demo2.services;

import com.nhoclahola.bt2511_springsecurityjwt_demo2.entities.UserInfo;
import com.nhoclahola.bt2511_springsecurityjwt_demo2.models.UserInfoUserDetails;
import com.nhoclahola.bt2511_springsecurityjwt_demo2.repositories.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService
{
    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
    }
}
