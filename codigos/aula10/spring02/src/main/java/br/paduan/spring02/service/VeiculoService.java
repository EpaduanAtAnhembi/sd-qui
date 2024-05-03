package br.paduan.spring02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.paduan.spring02.model.Veiculo;
import br.paduan.spring02.repository.VeiculoRepo;

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
}
