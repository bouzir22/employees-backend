package com.example.employees.scurity;

import com.example.employees.repositories.UserRepo;
import com.example.employees.scurity.jwt.JwtAuthorizationFilter;
import com.example.employees.services.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
private UserService userService;
private UserRepo userRepo;
   @Autowired
    public securityConfig(UserService userService, UserRepo userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

       try {
           http.csrf()

                   .disable()
                   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                   .and()
                   .addFilter(new JwtAuthorizationFilter(authenticationManager(),userRepo))
                   .authorizeRequests()

                   .antMatchers("/employee/delete/**").hasRole("superadmin")
                   .antMatchers("/employee/edit/**").hasRole("superadmin")
                   .antMatchers("/signin").permitAll()
                   .anyRequest().authenticated();

       }catch (Exception e){e.printStackTrace();}

    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());

    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




    @Bean
    PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
}
