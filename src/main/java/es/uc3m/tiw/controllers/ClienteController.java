package es.uc3m.tiw.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.ClienteRepository;
import es.uc3m.tiw.dominios.Cliente;


@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository repository;


	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	public Cliente validateGetPrueba() {
		return new Cliente(12, "Juan", "Perez", "123", "aa@aa.aa", "Madrid", true);
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	public Cliente validate(@RequestBody Cliente clientePeticion) {
		Cliente clienteRespuesta = null;
		List<Cliente> clientesRespuesta = repository.findByCorreo(clientePeticion.getCorreo());
		if(clientesRespuesta != null && clientesRespuesta.size() > 0) {
			clienteRespuesta = clientesRespuesta.get(0);
		}
		if(clienteRespuesta != null && 
				(clientePeticion.getContrasena() == null ||
				 !clientePeticion.getContrasena().equals(clienteRespuesta.getContrasena()))) {
			clienteRespuesta = null;
		}
		return clienteRespuesta;
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/findByCorreo", method = RequestMethod.POST)
	public Cliente findByCorreo(@RequestBody String correo) {
		Cliente clienteRespuesta = null;
		List<Cliente> clientesRespuesta = repository.findByCorreo(correo);
		if(clientesRespuesta != null && clientesRespuesta.size() > 0) {
			clienteRespuesta = clientesRespuesta.get(0);
		}
		return clienteRespuesta;
	}

	@RequestMapping(value = "/findByID", method = RequestMethod.POST)
	public Cliente findByID(@RequestBody long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Cliente cliente) {
		boolean res = false;
		List<Cliente> clientesExistentes = repository.findByCorreo(cliente.getCorreo());
		if(clientesExistentes == null || clientesExistentes.size() == 0) {
			repository.saveAndFlush(cliente);
			res = true;
		}
		return res;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean Modify(@RequestBody Cliente cliente) {
		repository.saveAndFlush(cliente);
		return true;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public boolean delete(@RequestBody long id) {
		repository.delete(id);
		return true;
	}
	
}
