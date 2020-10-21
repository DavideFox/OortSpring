package it.beije.oort.kirolosmater.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.oort.kirolosmater.biblioteca.model.Editore;

@Repository
public interface EditoreRepository extends JpaRepository<Editore, Integer>{

}
