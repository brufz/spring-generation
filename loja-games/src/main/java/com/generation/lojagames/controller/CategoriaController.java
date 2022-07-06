package com.generation.lojagames.controller;
	
	import java.util.List;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.generation.lojagames.model.CategoriaModel;
	import com.generation.lojagames.repository.CategoriaRepository;

	@RestController
	@RequestMapping("/categoria")
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public class CategoriaController {
		
		@Autowired
		public CategoriaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<CategoriaModel>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/id")
		public ResponseEntity<CategoriaModel> getById(@PathVariable Long id){
			return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/nomeCategoria/{nomeCategoria}")
		public ResponseEntity<List<CategoriaModel>> getByNomeCategoria(@PathVariable String nomeCategoria){
			return ResponseEntity.ok(repository.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
		}
		
		@PostMapping
		public ResponseEntity<CategoriaModel> post(@Valid @RequestBody CategoriaModel categoriaModel) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoriaModel));
		}
		
		@PutMapping
		public ResponseEntity<CategoriaModel> put(@Valid @RequestBody CategoriaModel categoriaModel){
			return repository.findById(categoriaModel.getId()).map(resposta -> {
				return ResponseEntity.ok().body(repository.save(categoriaModel));
			}).orElse(ResponseEntity.notFound().build());
		}
		
		@DeleteMapping("/id")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			return repository.findById(id).map(resposta -> {
				repository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
}
