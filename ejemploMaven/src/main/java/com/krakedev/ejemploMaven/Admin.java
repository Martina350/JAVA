package com.krakedev.ejemploMaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Admin {
	private static Logger logger=LogManager.getLogger(Admin.class);
	
	public void agregar() {
		logger.warn("MENSAJE DE WARN");
		logger.info("MENSAJE DE INFO");
		logger.debug("MENSAJE DE DEBUG ");
		logger.trace("MENSAJE DE TRACE");
		logger.error("MENSAJE DE ERROR");
	}
	
}
