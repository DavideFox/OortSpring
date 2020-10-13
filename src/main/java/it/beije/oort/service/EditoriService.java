package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.EditoriRepository;
import it.beije.oort.sb.biblioteca.Editori;

@Service
public class EditoriService {

	@Autowired
	private EditoriRepository editoriRepository;
	
	public List<Editori> loadEditori(){
		return editoriRepository.findAll();
	}
	
	public Editori loadById(Integer id) {
		Optional<Editori> editore = editoriRepository.findById(id);
		return editore.isPresent() ? editore.get() : null;
	}
}
