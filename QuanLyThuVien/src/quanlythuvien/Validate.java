/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlythuvien;

import javax.swing.JTextField;

/**
 *
 * @author hai,minh
 */
public class Validate {

    public static boolean isEmpty(JTextField txtField, StringBuilder str, String msg) {
        String strField = txtField.getText().trim();
        if (strField.equals("")) {
            str.append(msg).append("\n");
            return false;
        }

        return true;
    }

    public static boolean isNumber(JTextField txtField, StringBuilder str, String msg, int type) {
        if (!isEmpty(txtField, str, msg)) {
            return false;
        } else {
            try {
                switch (type) {
                    case 0:
                        Integer.parseInt(txtField.getText());
                        break;
                    case 1:
                        Double.parseDouble(txtField.getText());
                        break;
                }
            } catch (Exception e) {
                str.append(msg).append("\n");
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberMinMax(JTextField txtField, StringBuilder str, String msg, int type, int min, int max) {
        if (!isNumber(txtField, str, msg, type)) {
            return false;
        } else {
            
            switch (type) {
                case 0:
                    int numberInt = Integer.valueOf(txtField.getText());
                    if (numberInt < min || numberInt > max) {
                        str.append(msg).append("\n");
                        return false;
                    }
                    break;
                case 1:
                    Double number = Double.parseDouble(txtField.getText());
                    if (number < (double)min || number > (double)max) {
                        str.append(msg).append("\n");
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    public static boolean isNumberMin(JTextField txtField, StringBuilder str, String msg, int type, int min) {
        if (!isNumber(txtField, str, msg, type)) {
            return false;
        } else {
            switch (type) {
                case 0:
                    int numberInt = Integer.valueOf(txtField.getText());
                    if (numberInt < min ) {
                        str.append(msg).append("\n");
                        return false;
                    }
                    break;
                case 1:
                    Double number = Double.parseDouble(txtField.getText());
                    if (number < (double)min ) {
                        str.append(msg).append("\n");
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
