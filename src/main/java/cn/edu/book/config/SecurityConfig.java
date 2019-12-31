package cn.edu.book.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，对应功能页只有对应有权限的人可以访问
        //请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll();
//        .antMatchers("/login").hasRole("manager")

        //没有权限默认会到登陆页面
        // /login
        http.formLogin().loginPage("/login");
        //防网站攻击关闭
        //logout失败可能导致原因
        http.csrf().disable();
        // 开启注销功能
        http.logout().logoutSuccessUrl("/");


    }


        //认证
        //密码编码：passwordEncoder
        // 如不编码 密码明文不安全

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        可从缓存中添加认证
//        也可从JDBC添加认证
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("manager").password(new BCryptPasswordEncoder().encode("123456")).roles("manager")
                .and()
                .withUser("teacher").password(new BCryptPasswordEncoder().encode("123456")).roles("teacher")
                .and()
                .withUser("student").password(new BCryptPasswordEncoder().encode("123456")).roles("student");
    }
}
