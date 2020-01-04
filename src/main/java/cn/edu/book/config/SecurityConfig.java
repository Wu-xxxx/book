package cn.edu.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //首页所有人可以访问，对应功能页只有对应有权限的人可以访问
        //请求授权规则

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                //角色是老师和学生可以访问index
                //.antMatchers("/index").hasAnyRole("student","teacher")
                .antMatchers("/index").hasAnyRole("admin", "teacher", "student")
                .antMatchers("/college", "/class", "/course", "/bookadmin", "/usermgmt").hasRole("admin");
        http.formLogin().loginPage("/login").defaultSuccessUrl("/index");
        http.csrf().disable();
        // 开启注销功能
        http.logout().logoutSuccessUrl("/login");
        //防网站攻击关闭
        //logout失败可能导致原因


    }


    //认证

    //密码编码：passwordEncoder

    // 如不编码 密码明文不安全

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //可从缓存中添加认证//也可从JDBC添加认证
        //auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("root").roles("admin");
        auth.userDetailsService(myUserDetailService).passwordEncoder(new MyPasswordEncoder());

    }
}
