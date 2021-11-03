
package model;

/**
 *
 * @author Lucas
 */
public class Inicio {
    public String usuario;
    public String contraseña;

    @Override
    public String toString() {
        return "Inicio{" + "usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Inicio(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Inicio() {
    }
}
