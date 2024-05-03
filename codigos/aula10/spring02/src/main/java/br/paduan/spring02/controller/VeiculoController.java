package br.paduan.spring02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.paduan.spring02.model.Veiculo;
import br.paduan.spring02.service.VeiculoService;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    
    @Autowired
    VeiculoService service;

    @GetMapping("/oi/{nome}")
    public ResponseEntity<String> hello(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body("Boa noite " + nome);
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<Integer> imposto(@PathVariable int ano) {
        int imposto = service.imposto(ano);
        if(imposto >= 0) {
            return ResponseEntity.ok(imposto);
        }
        return ResponseEntity.badRequest().build();

    }

    @PostMapping
    public ResponseEntity<Veiculo> novoVeiculo(@RequestBody Veiculo novoVeiculo) {
        Veiculo veiculo = service.novoVeiculo(novoVeiculo);

        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

}
