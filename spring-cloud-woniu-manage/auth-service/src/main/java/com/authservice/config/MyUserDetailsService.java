package com.authservice.config;

import com.authservice.bean.User;
import com.authservice.dao.mysql.UserMysqlDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邵鑫雨
 * @version 1.0
 * @description: TODO
 * @date 2022/8/16 9:30
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserMysqlDao userMysqlDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMysqlDao.getUserByUserName(username);
        if (user == null){
            throw new UsernameNotFoundException("当前用户不存在");
        }

        List<GrantedAuthority> perms = new ArrayList<>();
        perms.add(new SimpleGrantedAuthority("ADMIN"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),perms);
    }
}
