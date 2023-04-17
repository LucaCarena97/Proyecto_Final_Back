/*
package com.example.clinicaOdontologica.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
@ToString
public class AppUser implements UserDetails {

    @Id
    @SequenceGenerator(name = "user_Sequence", sequenceName = "user_Sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
    private Long id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private AppUserRol appRoles;

    public AppUser() {
    }

    public AppUser(String nombre, String nombreUsuario, String email, String contrasena, AppUserRol appRoles) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.appRoles = appRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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
*/