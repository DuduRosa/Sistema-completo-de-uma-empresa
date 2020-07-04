package br.com.usjfarma.usjfarma.Cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    String nome;
    String telefone;
    String endereco;
    int idade;
    String cpf;
    
}