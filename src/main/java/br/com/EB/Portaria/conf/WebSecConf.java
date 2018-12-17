package br.com.EB.Portaria.conf;

import br.com.EB.Portaria.security.UserDetailsServiceImplementacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImplementacao userDetailsImplementacao;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll();

        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/logar")
                .permitAll()
                .defaultSuccessUrl("/",true)
                .and()
                .logout()
                .logoutSuccessUrl("/logar?logout")
                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsImplementacao).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
