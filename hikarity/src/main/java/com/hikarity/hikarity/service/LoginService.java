package com.hikarity.hikarity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hikarity.hikarity.mapper.HikarityMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {

    // 한번만 만들어짐.로그인 할 때마다 만들어지지 않음
    // public LoginService() {
    //     log.info("LoginService constructed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    // }

    // @Autowired
    // private HikarityMapper mapper;

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     Map<String,Object> userInfo = mapper.secMatch(username);

    //     if(userInfo.isEmpty()) {
    //         throw new UsernameNotFoundException("Invalid user");
    //     }
        
    //     log.info("아이디 : {}, 비밀번호 : {}",userInfo.get("UserId").toString(),userInfo.get("UserPwd"));

    //     LoginDetails loginDetails = new LoginDetails();
    //     loginDetails.setUsername(userInfo.get("UserId").toString());
    //     try {
    //         loginDetails.setPassword(EncryptionUtil.sha256(userInfo.get("UserPwd").toString()));
    //         // loginDetails.setPassword(userInfo.get("UserPwd").toString());
    //     } catch (Exception e) {
    //         throw new UsernameNotFoundException("Something's wrong if you are seeing this.");
    //     }

    //     ArrayList<LoginAuthority> auths = new ArrayList<>();
    //     auths.add(new LoginAuthority(userInfo.get("UserId").toString()));
    //     loginDetails.setAuthorities(auths);

    //     for (LoginAuthority auth : auths) {
    //         log.info("{}", auth.getAuthority());
    //     }
    //     return loginDetails;

    // }
}
