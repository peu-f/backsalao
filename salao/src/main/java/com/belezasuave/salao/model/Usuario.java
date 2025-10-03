package com.belezasuave.salao.model;
import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "usuario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String telefone;
    
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_conta")
    private TipoConta tipoConta;

    @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            if (this.tipoConta == TipoConta.ADMIN) {
                return List.of(new SimpleGrantedAuthority("salao"), new SimpleGrantedAuthority("cliente"));
            }
            return List.of(new SimpleGrantedAuthority("cliente"));
        }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
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
