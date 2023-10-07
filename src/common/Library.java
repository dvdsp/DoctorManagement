/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author DELL
 */
public class Library {
    
    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty() ) {
                System.out.println("Can not be empty");
                System.out.print("Let's try enter again:        ");
            } else {
                return result;
            }
        }
    }
    
    
    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y") ) {
                return true;
            } else if (result.equalsIgnoreCase("N") ) {
                return false;
            }
            System.out.println("Please input y/Y or n/N. Try again:     ");
            
        }
    }
    
    public static boolean checkIdExist(ArrayList<Doctor> doctorList, String code) {
        for ( Doctor d : doctorList) {
            if (d.getCode().equalsIgnoreCase(code)) {
                return false;
            }
        }
        return true;
    }
    
    public static int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                return choice;
            } catch( NumberFormatException e) {
                System.out.print("*Must be a number. Let's enter again:    ");
            }
        }
    }
    
    public static boolean checkDuplicate(ArrayList<Doctor> doctorList, String code,
            String name, String specialization, int availability) { 
        
        for (Doctor d : doctorList) {
            if (code.equalsIgnoreCase(d.getCode()) &&
                    name.equalsIgnoreCase(d.getName()) &&
                    specialization.equalsIgnoreCase(d.getSpecialization()) &&
                    availability == d.getAvailability()) {
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean checkChange(Doctor doctor, String code, String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code) &&
                doctor.getName().equalsIgnoreCase(name) &&
                doctor.getSpecialization().equalsIgnoreCase(specialization) &&
                doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
