package com.phenrique.minhasfinancas.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phenrique.minhasfinancas.exception.ErroAutenticacao;
import com.phenrique.minhasfinancas.exception.RegraNegocioException;
import com.phenrique.minhasfinancas.model.entity.Usuario;
import com.phenrique.minhasfinancas.model.repository.UsuarioRepository;
import com.phenrique.minhasfinancas.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository repository;
	
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuario = repository.findByEmail(email);
		if(!usuario.isPresent()) {
			throw new ErroAutenticacao("Usuário não encontrado;");
		}
		
		if(usuario.get().getSenha().equals(senha)) {
			throw new ErroAutenticacao("Senha inválida;");
		}
		
		return usuario.get();
	}

	@Override
	@Transactional
	public Usuario salvarUsuario(Usuario usuario) {
		validarEmail(usuario.getEmail());
		return repository.save(usuario);
	}

	@Override
	public void validarEmail(String email) {
		boolean existe = repository.existsByEmail(email);
		if(existe) {
			throw new RegraNegocioException("Já existe um usuário cadastrado com este email.");
		}
	}

}
