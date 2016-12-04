package es.uc3m.tiw;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uc3m.tiw.daos.ClienteRepository;
import es.uc3m.tiw.dominios.Cliente;

@SpringBootApplication
public class WallapoptiwClientesApplication {

	@Autowired
	private ClienteRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(WallapoptiwClientesApplication.class, args);
	}

	@PostConstruct
	public void init() {
		Set<Cliente> clientes = new HashSet<>();
		clientes.add(new Cliente(0, "Carol", "Arredondo", "1234", "carolina@hotmail.com", "Madrid", true));
		clientes.add(new Cliente(0, "Manuel", "Estada", "1234", "manuel@hotmail.com", "Valencia", true));
		clientes.add(new Cliente(0, "Otro", "Sin", "1234", "otrosin@hotmail.com", "Madrid", false));
		

		repository.save(clientes);
		repository.flush();
	}
	
}
