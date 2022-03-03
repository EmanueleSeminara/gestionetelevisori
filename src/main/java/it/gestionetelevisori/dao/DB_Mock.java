package it.gestionetelevisori.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.gestionetelevisori.model.Televisore;

public class DB_Mock {
	public static final List<Televisore> LISTA_TELEVISORI = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		LISTA_TELEVISORI.add(new Televisore(1l, "marca1", "modello1", 160, 25, "asd1234"));
		LISTA_TELEVISORI.add(new Televisore(2l, "marca2", "modello2", 160, 25, "asd1235"));
		LISTA_TELEVISORI.add(new Televisore(3l, "marca3", "modello3", 160, 25, "asd1236"));
		LISTA_TELEVISORI.add(new Televisore(4l, "marca4", "modello4", 160, 25, "asd1237"));
		LISTA_TELEVISORI.add(new Televisore(5l, "marca5", "modello5", 160, 25, "asd1238"));
		LISTA_TELEVISORI.add(new Televisore(6l, "marca6", "Topolino", 300, 25, "asd1239"));
		LISTA_TELEVISORI.add(new Televisore(7l, "Pippo7", "modello7", 300, 25, "asd1230"));

	}

	public static Long getNexIdAvailable() {
		Long resultId = null;
		if (LISTA_TELEVISORI == null || LISTA_TELEVISORI.isEmpty()) {
			resultId = 1L;
		}
		resultId = LISTA_TELEVISORI.stream().max(Comparator.comparing(Televisore::getId)).get().getId();
		return ++resultId;
	}
}
