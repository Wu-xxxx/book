package cn.edu.book.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，对应功能页只有对应有权限的人可以访问
        //请求授权规则
        //没有权限默认会到登陆页面
        // /login
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login")
                .permitAll()                   //跳转登录页面的控制器，该地址要保证和表单提交的地址一致！
                .and()
                .logout().permitAll()         // 开启注销功能
                 .and()
                .csrf().disable();            //防网站攻击关闭,logout失败可能导致原

    }


        //认证
        //密码编码：passwordEncoder
        // 如不编码 密码明文不安全

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        可从缓存中添加认证
//        也可从JDBC添加认证
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("admin")
                .and()
                .withUser("teacher").password(new BCryptPasswordEncoder().encode("123456")).roles("teacher")
                .and()
                .withUser("student").password(new BCryptPasswordEncoder().encode("123456")).roles("student");
    }
}
