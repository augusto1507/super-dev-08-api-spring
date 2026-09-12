package com.superdev.helpdesk.controllers;



import com.superdev.helpdesk.dtos.Usuario.UsuarioAtualizarDto;
import com.superdev.helpdesk.dtos.Usuario.UsuarioCriarDto;
import com.superdev.helpdesk.models.Usuario;
import com.superdev.helpdesk.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public  UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Usuario> Listar(){
        return service.listar();
    }

    @PostMapping
    public Usuario criar(@RequestBody @Valid UsuarioCriarDto dto){
        return service.criar(dto);
    }

    @GetMapping("/{id}")
    public Usuario obterPorId(@PathVariable int id){
        return service.obterPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable int id, @RequestBody @Valid UsuarioAtualizarDto dto){
        return service.atualizar(id,dto);
    }

    @DeleteMapping("/{id}")
    public Usuario apagar(@PathVariable int id){
        return service.apagar(id);
    }


}
