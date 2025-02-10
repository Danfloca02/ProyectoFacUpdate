/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USER
 */
public class StringValidator {
        public static boolean validateUsername(String username) {
            String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9._%+-]{6,20}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(username);

            if (username.contains(" ") || username.contains("\\")) {
                return false;
            }

            return matcher.matches();
        }

        public static boolean validateIDcard(String idCard) {
            String regex = "^[0-9]{1,9}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(idCard);

            if (idCard.contains(" ") || idCard.contains("\\")) {
                return false;
            }

            return matcher.matches();
        }

        public static boolean validateEmail(String correo) {
            String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(correo);

            if (correo.contains(" ") || correo.contains("\\")) {
                return false;
            }

            return matcher.matches();
        }

        public static boolean validatePassword(String password) {
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{3,20}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (password.contains(" ") || password.contains("\\")) {
                return false;
            }

            return matcher.matches();
        }
}
