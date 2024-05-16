package br.paduan.spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paduan.spring02.model.Veiculo;
import br.paduan.spring02.repository.VeiculoRepo;

import java.util.Optional;
import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepo repo;

    public int imposto(int ano) {
        return ano % 100;
    }

    public Veiculo novoVeiculo(Veiculo veiculo) {
        return repo.save(veiculo);
    }

    public Optional<Veiculo> buscarPorId(long id) {
        return repo.findById(id); 
    }

    // public Veiculo buscarPorId2(long id) {
    //     Optional<Veiculo> opt = repo.findById(id); 
    //     return opt.get();
    // }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = (List<Veiculo>) repo.findAll();
        return veiculos;
    }
}
