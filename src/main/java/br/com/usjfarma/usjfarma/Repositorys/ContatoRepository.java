package br.com.usjfarma.usjfarma.Repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.usjfarma.usjfarma.Contato.Contato;

public interface ContatoRepository extends CrudRepository<Contato,Long>{
    List<Contato> findAll();
}