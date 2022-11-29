package com.example.fashionblogapi.config;//package com.week9task.fashionblogapi.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure (HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .antMatcher("v3/api/-docs/**").permitAll()
//                .antMatcher("v2/api-docs/**").permitAll()
//                .antMatcher("swagger-ui/**").permitAll()
//                .antMatcher("swagger-resources/**").permitAll()
//                .antMatcher("swagger-ui.html").permitAll()
//                .antMatcher("webjars/**").permitAll()
//                .anyRequest()
//                .authenticated();
//        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//
//16-21
////
//    }
//
//    con
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//              .csrf().disable()
//              .authorizeRequests()
//              .antMatchers("v3/api/-docs/**").permitAll()
//                .antMatchers("v2/api-docs/**").permitAll()
//                .antMatchers("swagger-ui/**").permitAll()
//                .antMatchers("swagger-resources/**").permitAll()
//                .antMatchers("swagger-ui.html").permitAll()
//                .antMatchers("webjars/**").permitAll()
//                .anyRequest()
//                .authenticated()
//              .and()
//              .httpBasic();
//    }
//}
