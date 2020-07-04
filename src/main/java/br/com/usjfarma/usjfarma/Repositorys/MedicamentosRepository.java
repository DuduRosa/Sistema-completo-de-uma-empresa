package br.com.usjfarma.usjfarma.Repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.usjfarma.usjfarma.Medicamentos.Medicamento;

public interface MedicamentosRepository extends CrudRepository<Medicamento,Long>{
    List<Medicamento> findAll();
}