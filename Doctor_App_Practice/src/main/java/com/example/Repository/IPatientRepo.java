package com.example.Repository;

import com.example.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepo extends JpaRepository<Patient , Long> {
}
