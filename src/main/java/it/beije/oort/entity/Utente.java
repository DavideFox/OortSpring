package it.beije.oort.entity;

public class Utente {
	
	private int id;
	
	private String name;
	
	private String cognome;
	
	private String telefono;
	
	private String email;
	
	private String password;
	
	
	public Utente() {}
	
	public Utente(String nome, String cognome, String telefono) {
		this(nome, cognome, telefono, "");
	}
	
	public Utente(String nome, String cognome, String telefono, String email) {
		this.name = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		builder.append("Nome : ").append(this.name)
			.append(" - Cognome : ").append(this.cognome)
			.append(" - Telefono : ").append(this.telefono)
			.append(" - Email : ").append(this.email).append("]");
		
		return builder.toString();
	}
	
}
