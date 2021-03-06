package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import model.UtenteBean;
import model.UtenteBeanDAO;

public class PrenotazioneManager {
	public boolean prenotaTavolo(String username, GregorianCalendar data, int num_persone, String telefono, String descrizione) {
		boolean result = false;
		
		PrenotazioneBean pb = new PrenotazioneBean();
		pb.setNumPersone(num_persone);
		pb.setData(data);
		pb.setTelefono(telefono);
		pb.setDescrizione(descrizione);
			
		PrenotazioneBeanDAO pbd = new PrenotazioneBeanDAO();
		result = pbd.doSave(pb, username);
		
		return result;
	}
	
	public boolean rimozionePrenotazione(int idPrenotazione) {
		boolean result = false;
		PrenotazioneBeanDAO pbd = new PrenotazioneBeanDAO();
		
		result = pbd.doDelete(idPrenotazione);
		
		return result;
	}
	
	public ArrayList<PrenotazioneBean> visualizzaPrenotazioni(String username){
		ArrayList<PrenotazioneBean> prenotazioni = new ArrayList<PrenotazioneBean>();
		PrenotazioneBeanDAO pbd = new PrenotazioneBeanDAO();
		
		UtenteBean ub = new UtenteBean();
		UtenteBeanDAO ubd = new UtenteBeanDAO();
		
		ub = ubd.doRetrieveByOneKey(username);
		
		if(ub.getTipo().equals("gestore"))
			prenotazioni = pbd.doRetrieveAll();
		else
			prenotazioni = pbd.doRetrieveAllByKey(username);
		
		return prenotazioni;
		
	}
}
