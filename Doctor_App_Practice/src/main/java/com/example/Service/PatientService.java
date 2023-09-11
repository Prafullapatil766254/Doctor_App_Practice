package com.example.Service;

import com.example.ExceptionHandler.NotFoundException;
import com.example.Model.Doctor;
import com.example.Model.Patient;
import com.example.Repository.IDoctorRepo;
import com.example.Repository.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private IPatientRepo patientRepository;

    public Patient addPatient(Patient patient) {

        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient not found"));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Long id, Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);


        if (updatedPatient.getName() != null) {
            existingPatient.setName(updatedPatient.getName());
        }
        if (updatedPatient.getCity() != null) {
            existingPatient.setCity(updatedPatient.getCity());
        }
        if (updatedPatient.getEmail() != null) {
            existingPatient.setEmail(updatedPatient.getEmail());
        }
        if (updatedPatient.getPhoneNumber() != null) {
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
        }
        if (updatedPatient.getSymptom() != null) {
            existingPatient.setSymptom(updatedPatient.getSymptom());
        }



        return patientRepository.save(existingPatient);
    }

    public void deletePatient(Long id) {
        Patient existingPatient = getPatientById(id);

        patientRepository.delete(existingPatient);
    }
}
