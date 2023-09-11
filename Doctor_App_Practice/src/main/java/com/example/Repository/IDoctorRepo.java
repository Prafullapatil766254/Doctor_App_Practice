package com.example.Repository;

import com.example.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDoctorRepo extends JpaRepository<Doctor , Long> {


    List<Doctor> findBySpecialityAndCity(String s, String patientCity);
}
