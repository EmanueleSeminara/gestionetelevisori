package it.gestionetelevisori.service;

import it.gestionetelevisori.dao.MyDaoFactory;
import it.gestionetelevisori.service.televisore.TelevisoreService;
import it.gestionetelevisori.service.televisore.TelevisoreServiceImpl;

public class MyServiceFactory {
	private static TelevisoreService ABITANTE_SERVICE_INSTANCE;

	public static TelevisoreService getTelevisoreServiceInstance() {
		if (ABITANTE_SERVICE_INSTANCE == null)
			ABITANTE_SERVICE_INSTANCE = new TelevisoreServiceImpl();

		ABITANTE_SERVICE_INSTANCE.setTelevisoreDAO(MyDaoFactory.getTelevisoreDAOInstance());

		return ABITANTE_SERVICE_INSTANCE;
	}
}
