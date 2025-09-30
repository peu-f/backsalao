package com.belezasuave.salao.repository;


import com.belezasuave.salao.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
