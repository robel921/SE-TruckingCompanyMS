package edu.miu.cs.cs425.webapp.homib_tcms.config;
//import edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl.HomibUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig  {

//    private UserDetailsService userDetailsService;
//
//    public WebSecurityConfig(HomibUserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(this.userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//
//                .csrf().disable()
//                .headers()
//                .frameOptions().sameOrigin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/resources/static/**", "/images/**", "/css/**", "/secured/home/login","test/**").permitAll()
////                .antMatchers("/", "/ecarrental/public/search/results").permitAll()
//                .antMatchers("/admin/booking/***","/admin/driver/***","/admin/load/***","/fragments/admin/**", "/layouts/main-layout/","/secured/home/**").hasRole("ADMIN")
//                .antMatchers("/driver/driver/list","/fragments/driver/**","/layouts/driver-layout/").hasRole("DRIVER")
////                .antMatchers("/ecarrental/public/search/result/**").hasRole("CUSTOMER")
////                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/secured/home/login")
//                .defaultSuccessUrl("/secured/home/")
//                .failureUrl("/secured/home/login?error")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/secured/public/home/logout"))
//                .logoutSuccessUrl("/secured/public/home/login?logout")
//                .permitAll()
//                .and()
//                .exceptionHandling();
//    }
}
