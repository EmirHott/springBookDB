package com.springBookDB.springBookDB.MySecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService myUserDetailsService;


    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/userhome","/toview","/editnote","/removenote","/notesearch","/books","/notes","/search")
                .hasAnyAuthority("User", "Admin")
                .and()

                .authorizeRequests()
                .antMatchers("/users","/removeuser","/usersearch","/edituser","/addpublisher","/addbookimg","/addauthor","/addgenre","/addbook",
                        "/edituser","/editpublisher","/editbookimg","editauthor","/editgenre","/editbook","/removeuser","/removepublisher","/removebookimg",
                        "/removeauthor","/removegenre","/removebook","/usersearch","/genresearch","/publishersearch","/bookimgsearch","/authorsearch","/booksearch")
                .hasAuthority("Admin")
                .and()

                .authorizeRequests()
                .antMatchers("/addnote")
                .hasAuthority("User")
                .and()

                .authorizeRequests()
                .antMatchers("/signedup", "/tosignup","/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()



                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/toview")
                .permitAll()
                .and()

                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()

                .httpBasic();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**");
    }

    }

