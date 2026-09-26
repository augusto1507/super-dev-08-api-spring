package com.superdev.helpdesk.services;

import com.superdev.helpdesk.dtos.Usuario.UsuarioAtualizarDto;
import com.superdev.helpdesk.dtos.Usuario.UsuarioCriarDto;
import com.superdev.helpdesk.exceptions.ConflitoException;
import com.superdev.helpdesk.models.Usuario;
import com.superdev.helpdesk.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService (UsuarioRepository repository){this.repository = repository;}

    public List<Usuario> listar(){return this.repository.findAll();}

    public Usuario criar(UsuarioCriarDto dado){
        String email = dado.email().trim().toLowerCase();
        repository.findByEmail(email).ifPresent(usuario ->{
            throw  new ConflitoException("E-mail já cadastrado");
        });
        var usuario = Usuario.builder()
                .nome(dado.nome())
                .email(dado.email())
                .papel(dado.papel())
                .ativo(true)
                .build();

        return this.repository.save(usuario);
    }

    public Usuario obterPorId(int id){
        var usuario = repository.findById(id).orElseThrow();
        return usuario;
    }

    public Usuario atualizar(int id, UsuarioAtualizarDto dado){
        var usuario = repository.findById(id).orElseThrow();

        usuario.setNome(dado.nome());
        usuario.setEmail(dado.email());
        usuario.setPapel(dado.papel());

        return repository.save(usuario);
    }

    public Usuario apagar(int id){
        var usuario = repository.findById(id).orElseThrow();

        usuario.setAtivo(false);
        return repository.save(usuario);
    }


}
