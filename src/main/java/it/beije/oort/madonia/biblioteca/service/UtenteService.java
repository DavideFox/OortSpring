package it.beije.oort.madonia.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.repository.UtenteRepository;
import it.beije.oort.madonia.biblioteca.utilities.EbeanUtils;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Service
public class UtenteService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	public Utente login(String email, String password) {
		if (GeneralUtils.stringIsNullOrEmpty(email) || GeneralUtils.stringIsNullOrEmpty(password)) {
			throw new IllegalArgumentException("Email o password sono vuoti");
		}
		
		Optional<Utente> utente = utenteRepository.findByEmailAndPassword(email, password);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public Utente trova(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id � un valore null");
		}
		
		Optional<Utente> utente = utenteRepository.findById(id);
		return utente.isPresent() ? utente.get() : null;
	}
	
	public Utente trova(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id � null o vuota");
		}
		
		return this.trova(Integer.valueOf(id));
	}
	
	public List<Utente> trovaTutti() {
		log.debug("Chiamata db per recuperare la lista utenti");
		return utenteRepository.findAll();
	}
	
	@Transactional
	public Utente inserisci(Utente utente) {
		log.debug("Inserimento utente in corso");
		if (utente == null) {
			log.error("Utente non inserito nel database: null");
			throw new IllegalArgumentException("L'utente � un valore null");
		}
		
		if (EbeanUtils.utenteIsEmpty(utente)) {
			log.debug("Utente non inserito nel database: vuoto");
			throw new IllegalArgumentException("L'utente deve avere almeno un campo con un valore non vuoto");
		}
		
		return utenteRepository.saveAndFlush(utente);
	}
	
	@Transactional
	public Utente modifica(Integer id, Utente datiUtente) {
		log.debug("Modifica utente in corso");
		if (datiUtente == null) {
			log.error("Utente non inserito nel database: null");
			throw new IllegalArgumentException("L'utente � un valore null");
		}
		
		if (EbeanUtils.utenteIsEmpty(datiUtente)) {
			throw new IllegalArgumentException("L'utente deve avere almeno un campo con un valore non vuoto");
		}
		
		Utente utente = this.trova(id);
		
		if (utente == null) {
			log.debug("Non � presente alcun utente con la id " + id);
			throw new IllegalArgumentException("Non � presente alcun utente con la id " + id);
		}
		
		BeanUtils.copyProperties(datiUtente, utente, "id","password","admin");
		return utenteRepository.saveAndFlush(utente);
	}
	
	public Utente modifica(String id, Utente datiUtente) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id � null o vuota");
		}
		
		return this.modifica(Integer.valueOf(id), datiUtente);
	}
	
	@Transactional
	public void cancella(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id � un valore null");
		}
		
		utenteRepository.deleteById(id);
	}
	
	public void cancella(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id � null o vuota");
		}
		
		this.cancella(Integer.parseInt(id));
	}
}
