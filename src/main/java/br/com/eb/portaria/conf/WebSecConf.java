package br.com.eb.portaria.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.com.eb.portaria.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class WebSecConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImplementacao userDetailsImplementacao;

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/logar")
                .permitAll()
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutSuccessUrl("/logar?logout")
                .permitAll();
    }
    
    @Override
    protected final void configure(final AuthenticationManagerBuilder auth) 
    		throws Exception {
    		auth.userDetailsService(
    				userDetailsImplementacao).passwordEncoder(
    						new BCryptPasswordEncoder());
    }
    
    @Override
    public final void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**");
    }
}
