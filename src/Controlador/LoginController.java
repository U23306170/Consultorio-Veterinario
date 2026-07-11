/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import MODELO.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class LoginController {

    public Usuario loginRetornaUsuario(String user, String pass) {
        if (user.equals("admin") && pass.equals("1234")) {

            Usuario u = new Usuario();
            u.usuario = user;

            return u;
        }
        JOptionPane.showMessageDialog(null,
                "Usuario o contraseña incorrectos");
        return null;
    }

    public boolean cambiarContrasena(Usuario u, String actual, String nueva) {

        // verifica la contraseña actual del parametro u de 
        if (!u.password.equals(actual)) {

            JOptionPane.showMessageDialog(null,
                    "La contraseña actual es incorrecta");

            return false;
        }

        u.password = nueva;

        JOptionPane.showMessageDialog(null,
                "Contraseña cambiada correctamente");

        return true;
    }
}
