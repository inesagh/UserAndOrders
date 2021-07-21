package com.example.springjparelations.security;

import com.example.springjparelations.persistence.model.Person;
import com.example.springjparelations.service.PersonService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final PersonService personService;

    public CustomAuthenticationProvider(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<Person> personList = personService.getByYourChoice("username", username);

        List<GrantedAuthority> authorities = new ArrayList<>();
        personList.stream().map(each ->
                authorities.add(new SimpleGrantedAuthority(each.getRole())));

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
