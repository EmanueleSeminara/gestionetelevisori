package it.gestionetelevisori.service.televisore;

import java.util.List;

import it.gestionetelevisori.dao.televisore.TelevisoreDAO;
import it.gestionetelevisori.model.Televisore;

public interface TelevisoreService {
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO);

	public Televisore cercaPerId(Long idInput) throws Exception;

	public List<Televisore> elencoTelevisori() throws Exception;

	public void aggiungiNuovo(Televisore nuovoTelevisore) throws Exception;

	public void elimina(Long idInput) throws Exception;

	public int aggiorna(Televisore televisoreInput) throws Exception;
}
