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
        if(veiculo.getCodigo() == null)
            return repo.save(veiculo);
        return null;
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

    public boolean apagarPorId(long id) {
        Optional<Veiculo> veiculo = repo.findById(id);
        if(veiculo.isEmpty()) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    public Veiculo atualizarCompleto(Veiculo veiculo, long id) {
        Optional<Veiculo> veiculoAtual = repo.findById(id);
        if(veiculoAtual.isEmpty()) {
            return null;
        }
        veiculo.setCodigo(id);
        return repo.save(veiculo);
    }

    public Veiculo atualizarParcial(Veiculo veiculo, long id) {
        Optional<Veiculo> veiculoOptional = repo.findById(id);
        if(veiculoOptional.isEmpty()) {
            return null;
        }
        Veiculo veiculoAtualizado = veiculoOptional.get();
        if(veiculo.getModelo() != null) {
            veiculoAtualizado.setModelo(veiculo.getModelo());
        }
        if(veiculo.getPlaca() != null) {
            veiculoAtualizado.setPlaca(veiculo.getPlaca());
        }
        if(veiculo.getAno() > 0) {
            veiculoAtualizado.setAno(veiculo.getAno());
        }
        return repo.save(veiculoAtualizado);
    }
}
