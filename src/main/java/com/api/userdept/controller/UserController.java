package com.api.userdept.controller; // Pacote do controlador

import java.util.List; // Importa lista

import org.springframework.web.bind.annotation.DeleteMapping; // Importa requisição DELETE
import org.springframework.web.bind.annotation.GetMapping; // Importa requisição GET
import org.springframework.web.bind.annotation.PostMapping; // Importa requisição POST
import org.springframework.web.bind.annotation.PutMapping; // Importa requisição PUT
import org.springframework.beans.factory.annotation.Autowired; // Importa injeção de dependência
import org.springframework.web.bind.annotation.PathVariable; // Importa parâmetro
import org.springframework.web.bind.annotation.RequestBody; // Importa corpo da requisição
import org.springframework.web.bind.annotation.RequestMapping; // Importa requisição
import org.springframework.web.bind.annotation.RestController; // Importa controlador Rest

import com.api.userdept.entities.User; // Importa entidade
import com.api.userdept.repositories.UserRepository; // Importa repositório

@RestController // Controlador Rest
@RequestMapping(value = "/users") // Caminho do recurso
public class UserController {
  @Autowired // Injeção de dependência
  private UserRepository repository;

  @GetMapping // Requisição GET
  public List<User> findAll() {
    List<User> result = repository.findAll();// Busca todos os usuários
    return result;
  }

  @GetMapping(value = "/{id}") // Requisição GET com parâmetro Id
  public User findById(@PathVariable Long id) {
    User result = repository.findById(id).get(); // Busca usuário por Id
    return result;
  }

  @PostMapping // Requisição POST
  public User insert(@RequestBody User user) {
    User result = repository.save(user); // Insere usuário
    return result;
  }

  @DeleteMapping(value = "/{id}") // Requisição DELETE com parâmetro Id
  public void delete(@PathVariable Long id) {
    repository.deleteById(id); // Deleta usuário por Id
  }

  private void updateData(User entity, User user) { // Atualiza dados

    entity.setName(user.getName());// Atualiza nome
    entity.setEmail(user.getEmail());// Atualiza email
    entity.setDepartment(user.getDepartment());// Atualiza departamento

  }

  @PutMapping(value = "/{id}") // Requisição PUT com parâmetro Id
  public User update(@PathVariable Long id, @RequestBody User user) {
    User entity = repository.findById(id).get(); // Busca usuário por Id
    updateData(entity, user); // Atualiza dados
    entity = repository.save(entity); // Salva usuário
    return entity;
  }

}
