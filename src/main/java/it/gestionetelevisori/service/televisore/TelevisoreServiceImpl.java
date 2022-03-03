package it.gestionetelevisori.service.televisore;

import java.util.List;

import it.gestionetelevisori.dao.televisore.TelevisoreDAO;
import it.gestionetelevisori.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDAO;

	@Override
	public void setTelevisoreDAO(TelevisoreDAO televisoreDAO) {
		this.televisoreDAO = televisoreDAO;
	}

	@Override
	public Televisore cercaPerId(Long idInput) throws Exception {
		return televisoreDAO.get(idInput);

	}

	@Override
	public List<Televisore> elencoTelevisori() throws Exception {
		return televisoreDAO.list();
	}

	@Override
	public void aggiungiNuovo(Televisore nuovoTelevisore) throws Exception {
		televisoreDAO.insert(nuovoTelevisore);

	}

	@Override
	public void elimina(Long idInput) throws Exception {
		televisoreDAO.delete(televisoreDAO.get(idInput));

	}

	@Override
	public int aggiorna(Televisore televisoreInput) throws Exception {
		return televisoreDAO.update(televisoreInput);

	}

}
