package cn.edu.book.config;

import cn.edu.book.mapper.UserMapper;
import cn.edu.book.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Wu on 2020/1/2.
 */
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) {
        System.out.println("登录用户名为："+s);
        User user = userMapper.findByName(s);
        return new org.springframework.security.core.userdetails.User(s, user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_"+user.getRole()));
    }
}
