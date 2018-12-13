package cnpm.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cnpm.domain.Account;
import cnpm.domain.AppRole;
import cnpm.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Account user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Collection<AppRole> roles = user.getRoles();

        if (roles != null) {
            for (AppRole role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
    public Account findByUsername(final String username) throws UsernameNotFoundException  {
    	 Account user = userRepository.findByUsername(username);

         if (user == null) {
             throw new UsernameNotFoundException("User " //
                     + username + " was not found in the database");
         }
		return user;
	}
}
