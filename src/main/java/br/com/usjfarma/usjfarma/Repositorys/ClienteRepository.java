package br.com.usjfarma.usjfarma.Repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.usjfarma.usjfarma.Cliente.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{
    List<Cliente> findAll();
}