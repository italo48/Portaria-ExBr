package br.com.EB.Portaria.security;

import br.com.EB.Portaria.model.Soldado;
import br.com.EB.Portaria.repository.SoldadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService {
	@Autowired
	private SoldadoRepository sdRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Soldado sd = sdRepository.findByLogin(login);
		
		if(sd == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		
		return new User(sd.getUsername(),sd.getPassword(),true,true,true,true, sd.getAuthorities());
	}

}
