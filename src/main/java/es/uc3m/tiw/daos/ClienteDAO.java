package es.uc3m.tiw.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uc3m.tiw.dominios.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
