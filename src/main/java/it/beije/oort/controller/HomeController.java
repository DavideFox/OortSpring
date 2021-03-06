package it.beije.oort.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.entity.Utente;
import it.beije.oort.service.UtenteService;


@Controller
public class HomeController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.trace("home...");
		log.debug("home...");
		log.info("home...");
		log.warn("home...");
		log.error("home...");
		
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("login..." + request.getContextPath());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("localDateTime", localDateTime);
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("lingua", locale.getLanguage());
		
		return "login";
	}

	@RequestMapping(value = "/utente", method = RequestMethod.GET)
	public String utente() {
		System.out.println("utente...");
		
		return "form_utente";
	}

//	@RequestMapping(value = "/utente", method = RequestMethod.POST)
//	public String utente(Utente utente, HttpServletRequest request, Model model) {//@RequestParam String cognome
//		System.out.println("ricevo dati utente...");
//		
////		Utente utente = new Utente();
////		utente.setCognome(cognome);
////		utente.setNome(request.getParameter("nome"));
////		utente.setEmail(request.getParameter("email"));
////		utente.setTelefono(request.getParameter("telefono"));
//		
//		utenteService.insert(utente);
//		
//		model.addAttribute("utente", utente);
//		
//		return "utente";
//	}
//
//	@RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
//	public String utente(@PathVariable Integer id, Model model) {
//		System.out.println("utente : " + id);
//		
//		//carico utente...
////		Utente utente = new Utente();
////		utente.setCognome("Zegna");
////		utente.setNome("Ermenegildo");
//		
//		Utente utente = utenteService.load(id);
//		
//		//String nominativo = utenteService.getNominativo(utente);
//		
//		model.addAttribute("utente", utente);
//		//model.addAttribute("nominativo", nominativo);
//		
//		return "utente";
//	}

	@RequestMapping(value = "/utente/nome/{nome}", method = RequestMethod.GET)
	public String utente(@PathVariable String nome, Model model) {
		System.out.println("utente : " + nome);
		
		List<Utente> utenti = utenteService.findByNome(nome);
		
		System.out.println(utenti);
		
		model.addAttribute("utente", utenti.size() > 0 ? utenti.get(0) : new Utente() );
		
		return "utente";
	}
	
	@RequestMapping(value = "/utente/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		System.out.println("update utente : " + id);
		
		Utente utente = new Utente();
		utente.setCognome("Zegna");
		utente.setNome("Ermenegildo");
		
		utenteService.update(id, utente);
		
		model.addAttribute("utente", utente);
		
		return "utente";
	}


}
