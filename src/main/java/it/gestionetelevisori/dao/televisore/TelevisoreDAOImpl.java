package it.gestionetelevisori.dao.televisore;

import java.sql.Connection;
import java.util.List;

import it.gestionetelevisori.dao.DB_Mock;
import it.gestionetelevisori.model.Televisore;

public class TelevisoreDAOImpl implements TelevisoreDAO {
	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Televisore> list() throws Exception {
		return DB_Mock.LISTA_TELEVISORI;

	}

	@Override
	public Televisore get(Long id) throws Exception {
		if (id == null) {
			throw new IllegalArgumentException("Id televisore non trovato");
		}
		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId().equals(id)) {
				return televisoreItem;
			}
		}
		throw new IllegalArgumentException("Id televisore non trovato");
	}

	@Override
	public int update(Televisore input) throws Exception {
		if (input == null) {
			return 0;
		}

		for (Televisore televisoreItem : DB_Mock.LISTA_TELEVISORI) {
			if (televisoreItem.getId().equals(input.getId())) {
				televisoreItem.setMarca(input.getMarca());
				televisoreItem.setModello(input.getModello());
				televisoreItem.setPrezzo(input.getPrezzo());
				televisoreItem.setCodice(input.getCodice());
				televisoreItem.setNumeroPollici(input.getNumeroPollici());
				return 1;
			}

		}
		return 0;
	}

	@Override
	public int insert(Televisore input) throws Exception {
		input.setId(DB_Mock.getNexIdAvailable());
		return DB_Mock.LISTA_TELEVISORI.add(input) ? 1 : 0;
	}

	@Override
	public int delete(Televisore input) throws Exception {
		if (input == null) {
			return 0;
		}
		if (DB_Mock.LISTA_TELEVISORI.remove(input)) {
			return 1;
		}
		return 0;
	}

}
