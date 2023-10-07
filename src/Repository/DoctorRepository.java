/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.DoctorDao;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author DELL
 */
public class DoctorRepository implements InterfaceDoctorRepository{

    @Override
    public void create(ArrayList<Doctor> doctorList) {
        DoctorDao.Instance().addDoctor(doctorList);
    }

    @Override
    public void update(ArrayList<Doctor> doctorList) {
        DoctorDao.Instance().updateDoctor(doctorList);
    }

    @Override
    public void search(ArrayList<Doctor> doctorList) {
        DoctorDao.Instance().searchDoctor(doctorList);
    }

    @Override
    public void delete(ArrayList<Doctor> doctorList) {
        DoctorDao.Instance().deleteDoctor(doctorList);
    }

    @Override
    public void display(ArrayList<Doctor> doctorList) {
        DoctorDao.Instance().displayList(doctorList);
    }
    
}
