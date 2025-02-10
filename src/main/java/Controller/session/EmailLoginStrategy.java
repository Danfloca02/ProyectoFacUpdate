/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.session;

import Controller.StringValidator;
import static Controller.session.SesionController.DB;
import Model.User;

/**
 *
 * @author USER
 */
public class EmailLoginStrategy implements LoginStrategy{
    @Override
    public boolean authenticate(String data, String Password){
        User session = DB.userSearchByEMAIL(data);
        // Verifica si la búsqueda del usuario por ID retornó nulo
        if (session == null) return false;
            
        // Valida la contraseña usando StringValidator
        if (StringValidator.validatePassword(Password)) {
            // Compara las contraseñas, teniendo en cuenta valores nulos
            return session.Password.equals(Password);
        }
        return false;
    }
}
