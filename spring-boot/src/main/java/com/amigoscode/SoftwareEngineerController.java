package com.amigoscode;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/software-engineering")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }
    //server to client
    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineersById(@PathVariable Integer id) {
        return softwareEngineerService.getAllSoftwareEngineerByID(id);
    }
    //client to server
    @PostMapping
    public void addNewSoftwareEngineer( @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer( @PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineerById(id);
    }
    @PutMapping("{id}")
    public void updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineer.setId(id); // Ensure the path ID is applied
        softwareEngineerService.updateSoftwareEngineer(softwareEngineer);
    }


}
