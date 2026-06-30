package DigitalGroup.tienda_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DigitalGroup.tienda_app.model.Usuario;
import DigitalGroup.tienda_app.repository.UsuarioRepository;

public class UsuarioService implements IUsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> listUsers() {
        List<Usuario> users = usuarioRepository.findAll();
       return users;
    }

    @Override
    public Usuario findUser(String idUsuario) {
       Usuario user = usuarioRepository.findById(idUsuario).orElse(null);
       return user;
    }

    @Override
    public void saveUser(Usuario user) {
        usuarioRepository.save(user);
    }

    @Override
    public void deleteUser(Usuario user) {
        usuarioRepository.delete(user);
    }

}
