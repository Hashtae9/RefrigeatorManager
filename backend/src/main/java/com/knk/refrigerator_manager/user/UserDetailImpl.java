package com.knk.refrigerator_manager.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.knk.refrigerator_manager.user.User;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@AllArgsConstructor
public class UserDetailImpl implements UserDetails {
    private static final String ROLE_PREFIX = "ROLE_";
    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("UserDetail = {}", user);
        String role = user.getRole();
        log.info("UserDetailrole = {}", role);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(ROLE_PREFIX + role);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        log.info("authorities = {}", authority);

        return authorities;
    }

    @Override
    public String getPassword() {
        log.info("impl Username ={}", user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("impl Username ={}", user.getUsername());
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
