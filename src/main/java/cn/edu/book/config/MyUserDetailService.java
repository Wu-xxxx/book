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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("登录用户名为："+s);
        User user = userMapper.findByName(s);
        String auth = user.getRole();
        auth = "ROLE_"+auth;
        String ps = user.getPassword();
        return new org.springframework.security.core.userdetails.User(s, ps, AuthorityUtils.commaSeparatedStringToAuthorityList(auth));
    }
}
