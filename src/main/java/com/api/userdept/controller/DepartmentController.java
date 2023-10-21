package com.api.userdept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.userdept.entities.Department;
import com.api.userdept.repositories.DepartmentRepository;

@RestController // Controlador Rest
@RequestMapping(value = "/department") // Caminho do recurso
public class DepartmentController {
  @Autowired // Injeção de dependência
  private DepartmentRepository repository;

  @GetMapping // Requisição GET
  public List<Department> findAll() {
    List<Department> result = repository.findAll();;// Busca todos os departamentos
    return result;
  }

  @GetMapping(value = "/{id}") // Requisição GET com parâmetro Id
  public Department findById(@PathVariable Long id) {
    Department result = repository.findById(id).get(); // Busca departamento por Id
    return result;
  }

  @PostMapping // Requisição POST
  public Department insert(@RequestBody Department department) {
    Department result = repository.save(department); // Insere departamento
    return result;
  }

  private void updateData(Department entity, Department department) { // Atualiza dados

    entity.setName(department.getName());// Atualiza nome
  }


  @PutMapping(value = "/{id}") // Requisição PUT com parâmetro Id
  public Department update(@PathVariable Long id, @RequestBody Department department) {
    Department entity = repository.findById(id).get(); // Busca departamento por Id
    updateData(entity, department); // Atualiza dados
    entity = repository.save(entity); // Salva departamento
    return entity;
  }

  @DeleteMapping(value = "/{id}") // Requisição DELETE com parâmetro Id
  public void delete(@PathVariable Long id) {
    repository.deleteById(id); // Deleta departamento por Id
  }  


}
