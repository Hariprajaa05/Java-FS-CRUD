package com.amigoscode;

import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }


    public SoftwareEngineer getAllSoftwareEngineerByID(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id+"not found"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
            boolean exists = softwareEngineerRepository.existsById(id);
            if (!exists) {
                throw new IllegalStateException("Software Engineer with ID " + id + " does not exist.");
            }
            softwareEngineerRepository.deleteById(id);
    }

    public void updateSoftwareEngineer(SoftwareEngineer updatedEngineer) {
        SoftwareEngineer existing = softwareEngineerRepository
                .findById(updatedEngineer.getId())
                .orElseThrow(() -> new IllegalStateException("Engineer with ID " + updatedEngineer.getId() + " not found"));

        existing.setName(updatedEngineer.getName());
        existing.setTechStack(updatedEngineer.getTechStack());

        softwareEngineerRepository.save(existing);
    }

}
