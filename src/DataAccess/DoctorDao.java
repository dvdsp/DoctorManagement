/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import common.Library;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author DELL
 */
public class DoctorDao {
    private static volatile DoctorDao instance = null;
    public static DoctorDao Instance() {
        DoctorDao instance = DoctorDao.instance;
        if (instance == null) {
            synchronized (DoctorDao.class) {
                instance = DoctorDao.instance;
                if (instance == null) {
                    DoctorDao.instance = instance = new DoctorDao();
                }
            }
        }
        return instance;
    }
    
    
    
    public void addDoctor(ArrayList<Doctor> doctorList) {
        System.out.print("Enter doctor Code:      ");
        String code = Library.checkInputString();
        if (!Library.checkIdExist(doctorList, code)) {
            return;
        }
        System.out.print("Enter doctor name:     ");
        String name = Library.checkInputString();
        System.out.print("Enter specialization:       ");
        String specialization = Library.checkInputString();
        System.out.print("Enter availability:     ");
        int availability = Library.checkInputInt();
        if (!Library.checkDuplicate(doctorList, code, name, specialization, availability)) {
            System.out.println("*Duplicated*");
            return;
        }
        doctorList.add( new Doctor(code, name,specialization, availability));
        System.out.println("*Add new doctor successfully");
    }
    
    public void updateDoctor(ArrayList<Doctor> doctorList) {
        System.out.print("Enter doctor code:  ");
        String code = Library.checkInputString();
        if (Library.checkIdExist(doctorList, code)) {
            System.out.println("*Not found doctor code*");
            return;
        }
        Doctor doctor = getDoctorByCode(doctorList, code);
        System.out.print("Enter name:     ");
        String name = Library.checkInputString();
        System.out.print("Enter specialization:       ");
        String specialization = Library.checkInputString();
        System.out.print("Enter availability:     ");
        int availability = Library.checkInputInt();
        if (!Library.checkChange(doctor, code, name, specialization, availability)) {
            System.out.println("Not change anything because infor is overlap");
            return;
        }
        
        doctor.setCode(code);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.out.println("*Update successfully");
        
    }
    
    public void searchDoctor(ArrayList<Doctor> doctorList) {
        System.out.print("Enter name: ");
        String name = Library.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(doctorList, name);
        if (listFoundByName.isEmpty()) {
            System.out.println("Not found!");
        } else {
            System.out.format("%-10s%-15s%-25s%-15s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.format("%-10s%-15s%-25s%-15d\n", doctor.getCode(),doctor.getName(), 
                                                 doctor.getSpecialization(),doctor.getAvailability());
            }
            
        }
        
    }
    
    public void deleteDoctor(ArrayList<Doctor> doctorList) {
        System.out.print("Enter code:     ");
        String code = Library.checkInputString();
        Doctor doctor = getDoctorByCode(doctorList, code);
        if (doctor == null) {
            System.out.println("Not found");
            return;
        } else {
            doctorList.remove(doctor);
        }
        System.out.println("*Removed successfully");
    }
    
    public void displayList(ArrayList<Doctor> doctorList) {
        System.out.format("%-10s%-15s%-25s%-15s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : doctorList) {
                System.out.format("%-10s%-15s%-25s%-15d\n", doctor.getCode(),doctor.getName(), 
                                                 doctor.getSpecialization(),doctor.getAvailability());
            }
    }
    
    
    //
    public Doctor getDoctorByCode(ArrayList<Doctor> doctorList, String code) {
        for (Doctor d : doctorList) {
            if(d.getCode().equalsIgnoreCase(code)) {
                return d;
            }
        }
        return null;
    }
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> doctorList, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        
        for (Doctor d : doctorList) {
            if (d.getName().equalsIgnoreCase(name)) {
                listFoundByName.add(d);
            }
        }
        return listFoundByName;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
