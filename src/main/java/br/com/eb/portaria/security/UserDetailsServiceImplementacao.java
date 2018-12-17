package br.com.eb.portaria.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import br.com.eb.portaria.model.Soldado;
import br.com.eb.portaria.repository.SoldadoRepository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDetailsServiceImplementacao implements UserDetailsService {
	@Autowired
	private SoldadoRepository sdRepository;

	@Override
	public UserDetails loadUserByUsername(String login) {
		Soldado sd = sdRepository.findByLogin(login);
		if (sd == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		return new User(sd.getUsername(), 
				sd.getPassword(), true, true, true, true, 
				sd.getAuthorities());
	}
}
