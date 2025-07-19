package com.mb.spring.security.FirstApp.appSpringSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppSecurityConfig {

    /*
    In memory database used for user creation and authorizing roles
     */
/*    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.withUsername("Mohit")
                .password(passwordEncoder().encode("Banyal"))
                .authorities("read")
                .build();
        userDetailsManager.createUser(userDetails);
        return userDetailsManager;
    }*/
    /*
    Password encoder to encode all password
    Must need, Spring security need this for all password
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /*
    this is a filter which will have all its
     request passed through this with security
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.httpBasic(Customizer.withDefaults());
    //    http.formLogin(Customizer.withDefaults());
        http.authorizeHttpRequests(authorize ->
                                     authorize
                                  .anyRequest() // pass every request
                                // .requestMatchers("/hello")
                                          .authenticated());
                                      /*  .anyRequest()//these 2 methods are obvious that spring uses
                                        .denyAll());// but writting to understand*/
        http.addFilterBefore(new AppSecurityFilter(), BasicAuthenticationFilter.class);
        return http.build();
    }
}
