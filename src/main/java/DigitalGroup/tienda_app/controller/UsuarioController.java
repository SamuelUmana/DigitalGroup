package DigitalGroup.tienda_app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DigitalGroup.tienda_app.model.Usuario;
import DigitalGroup.tienda_app.repository.UsuarioRepository;


@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")

public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    

    @PostMapping
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario usuario){
        if(usuarioRepository.existsById(usuario.getIdUsuario())){
            return ResponseEntity.badRequest().body("El usuario ya esta registrado en la base de datos");
        }

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioGuardado);
    }

    @PutMapping("https://digitalgroup.onrender.com/configurar")
    public ResponseEntity<?> configurarTienda(@RequestHeader("X-User-Id") String userId,
            @RequestBody Usuario datosTienda) {
        return usuarioRepository.findById(userId)
                .map(usuario -> {
                    // Actualizamos los datos de la logística de la tienda
                    usuario.setNombreTienda(datosTienda.getNombreTienda());
                    usuario.setUbicacion(datosTienda.getUbicacion());

                    Usuario usuarioActualizado = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(usuarioActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    
}
