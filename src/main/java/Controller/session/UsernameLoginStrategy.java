/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.session;

import Controller.StringValidator;

import Data.DatabaseUsers;
import Model.User;

/**
 *
 * @author USER
 */
public class UsernameLoginStrategy implements LoginStrategy{
    private DatabaseUsers DB;
    @Override
    public boolean authenticate(String data, String Password){
        DB = DatabaseUsers.GetInstance();
        User session = DB.userSearchByUSERNAME(data);
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