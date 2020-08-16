package edu.miu.cs.cs425.webapp.homib_tcms.service.serviceImpl;

//import edu.miu.cs.cs425.webapp.homib_tcms.module.Credential;
//import edu.miu.cs.cs425.webapp.homib_tcms.repository.ICredentialRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HomibUserDetailsService  {

//    @Autowired
//    private ICredentialRepository credentialRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Credential user = credentialRepository.findByUserName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
//        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                getAuthorities(user));
//    }
//
//    private static Collection<? extends GrantedAuthority> getAuthorities(Credential user) {
//        String[] userRoles = user.getUser().getRoles().stream().map((role) -> role.getRoleName()).toArray(String[]::new);
//        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//        return authorities;
//    }
}
