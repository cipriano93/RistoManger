package model;

import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;

public class PrenotazioneBean {
	
	public PrenotazioneBean() {
		idPrenotazione = ThreadLocalRandom.current().nextInt(10000, 99999 + 1);
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	
	
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	
	
	public GregorianCalendar getData() {
		return data;
	}
	
	
	public void setData(GregorianCalendar data) {
		this.data = data;
	}


	public int getNumPersone() {
		return num_persone;
	}


	public void setNumPersone(int num_persone) {
		this.num_persone = num_persone;
	}
	
	public void setTelefono(String tel) {
		telefono = tel;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	//
	public String getUsername() {
		return username;
	}

//
	public void setUsername(String username) {
		this.username = username;
	}

	private int idPrenotazione, num_persone;
	private String descrizione, telefono;
	private GregorianCalendar data;
	private String username;
}
