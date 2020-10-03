package br.com.totvs.cadastro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totvs.cadastro.exception.PessoaNotFoundException;
import br.com.totvs.cadastro.model.Pessoa;
import br.com.totvs.cadastro.repository.DependenteRepository;
import br.com.totvs.cadastro.repository.EnderecoRepository;
import br.com.totvs.cadastro.repository.PessoaRepository;
import br.com.totvs.cadastro.repository.TelefoneRepository;

@RestController
@RequestMapping("/api")
public class PessoaController {

	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	DependenteRepository dependenteRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@GetMapping("/pessoas")
    public Iterable<Pessoa> listPessoas() {
        return pessoaRepository.findAll();
    }
	
	@GetMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable(value="id") Long pessoaId) 
    	throws PessoaNotFoundException {
        
		Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new PessoaNotFoundException("Pessoa nao encontrada"));
        	
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/pessoa")
    public Pessoa criarPessoa(@Valid @RequestBody Pessoa pessoa) {
        return gravarPessoa(pessoa);
    }

    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable(value="id") Long pessoaId, @Valid @RequestBody Pessoa pessoaAlterar) 
    	throws PessoaNotFoundException {
        	
    	pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new PessoaNotFoundException("Pessoa nao encontrada"));

    	return ResponseEntity.ok(gravarPessoa(pessoaAlterar));
    }

    @DeleteMapping("/pessoa/{id}")
    public Map<String, Boolean> deletePessoa(@PathVariable(value = "id") Long pessoaId)
    	throws PessoaNotFoundException {
        
    	Pessoa pessoa = pessoaRepository.findById(pessoaId)
        .orElseThrow(() -> new PessoaNotFoundException("Pessoa nao encontrada"));
    	
    	pessoaRepository.delete(pessoa);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
    
    private Pessoa gravarPessoa(Pessoa pessoaDetalhe) {
    	try {
    		
    		enderecoRepository.saveAll(pessoaDetalhe.getEnderecos());
    		
    		dependenteRepository.saveAll(pessoaDetalhe.getDependentes());
    		
    		telefoneRepository.saveAll(pessoaDetalhe.getTelefones());
    		
    		pessoaRepository.save(pessoaDetalhe);
            
            return pessoaDetalhe;
            
		} catch (Exception e) {
			System.out.println("Excecao: " + e.getMessage());
			return new Pessoa();
		}
    	
    }
	
}
