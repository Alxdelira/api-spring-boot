package com.api.userdept.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity //Entidade do banco de dados
@Table(name = "tb_user") //Nome da tabela
public class User {
  @Id //Chave primária
  @GeneratedValue(strategy =  GenerationType.IDENTITY) //Auto incremento

  private Long id;
  private String name;
  private String email;

  @ManyToOne //Muitos usuários para um departamento
  @JoinColumn(name = "departmentId") //Chave estrangeira
  private Department department; //Relacionamento


  public User() {

  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public Department getDepartment() {
    return department;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;

  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }



}