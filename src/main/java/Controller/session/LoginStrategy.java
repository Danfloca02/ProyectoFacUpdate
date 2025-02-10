/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller.session;

/**
 *
 * @author USER
 */
public interface LoginStrategy {
    boolean authenticate(String data, String password);
}

