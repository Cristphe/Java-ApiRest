package dio.web.api.doc;

import java.util.ArrayList;
import java.util.List;

import dio.web.api.model.Usuario;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SwaggerConfig {

    private final List<Usuario> usuarios = createList();

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<Usuario> firstPage() {
        return usuarios;
    }

    @DeleteMapping(path = {"/{id}"})
    public Usuario delete(@PathVariable("id") int id) {
        Usuario deleteUsuario = null;
        for (Usuario login : usuarios) {
            if (login.getId().equals(id)) {
                usuarios.remove(login);
                deleteUsuario = login;
                break;
            }
        }
        return deleteUsuario;
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario user) {
        usuarios.add(user);
        System.out.println(usuarios);
        return user;
    }

    private static List<Usuario> createList() {
        List<Usuario> usuarios = new ArrayList<>();
        Usuario login1 = new Usuario();
        login1.setLogin("login1");
        login1.setId(Integer.valueOf("5"));


        Usuario login2 = new Usuario();
        login2.setLogin("login1");
        login2.setId(Integer.valueOf("2"));
        usuarios.add(login1);
        usuarios.add(login2);
        return usuarios;
    }
}