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
public class IDLoginStrategy implements LoginStrategy{
    private DatabaseUsers DB;
    @Override
    public boolean authenticate(String data, String Password){
        DB = DatabaseUsers.GetInstance();
        try {
                long dat = Long.parseLong(data);
                User session = DB.userSearchByID(dat);
            
                // Verifica si la búsqueda del usuario por ID retornó nulo
                if (session == null) return false;
            
                // Valida la contraseña usando StringValidator
                if (StringValidator.validatePassword(Password)) {
                    // Compara las contraseñas, teniendo en cuenta valores nulos
                    return session.Password.equals(Password);
                }
            } catch (NumberFormatException e) {
                // Manejo de excepciones para números inválidos
                e.printStackTrace();
                return false;
            }
        return false;
    }
}
