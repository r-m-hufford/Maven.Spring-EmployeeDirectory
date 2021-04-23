package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Department;
import io.zipcoder.persistenceapp.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
public class DepartmentController {

    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    //create, read all, read one, update, delete

    @PostMapping("/department")
    ResponseEntity<Department> createDepartment(@RequestBody Department d) {
        Department department = service.createDepartment(d);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/department")
    ResponseEntity<List<Department>> readAll() {
        List<Department> depts = service.readAll();
        return ResponseEntity.ok(depts);
    }

    @GetMapping("/department/{id}")
    ResponseEntity<Department> readOne(@PathVariable Long id) {
        Department department = service.readOne(id);
        return ResponseEntity.ok(department);
    }

    @PutMapping("/department/{id}")
    ResponseEntity<Department> updateDeptartment(@RequestBody Department d, @PathVariable Long id) {
        Department department = service.updateDepartment(d, id);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/department/{id}")
    ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        service.deleteDepartment(id);
        return ResponseEntity.ok("Department #" + id + " has been removed");
    }
}
