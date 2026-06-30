package DigitalGroup.tienda_app.service;

import java.util.List;

import DigitalGroup.tienda_app.model.Usuario;

public interface IUsuarioService {
    public List<Usuario> listUsers();
    public Usuario findUser(String idUsuario);
    public void saveUser(Usuario user);
    public void deleteUser(Usuario user);
}
