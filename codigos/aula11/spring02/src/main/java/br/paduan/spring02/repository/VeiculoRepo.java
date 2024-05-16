package br.paduan.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.paduan.spring02.model.Veiculo;

// CRUD = Create, Read, Update, Delete
public interface VeiculoRepo extends CrudRepository<Veiculo, Long>{

}
