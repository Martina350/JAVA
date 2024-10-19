package com.krakedev.persistencia.utils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Convertidor {
	private static final String FORMATO_FECHA="yyyy/MM/dd";
	private static final String FORMATO_HORA="hh:mm:ss";
	private static final Logger LOGGER=LogManager.getLogger(Convertidor.class);
	public static Date convertirFecha(String fechaStr) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_FECHA);
		Date fechaDate=null;
		try {
			LOGGER.trace("CONVIRTIENDO FECHA "+fechaStr);
			fechaDate = sdf.parse(fechaStr);
			LOGGER.trace("FECHA CONVERTIDA "+fechaStr);
		} catch (ParseException e) {
			LOGGER.error("LA FECHA NO TIENE EL FORMATO CORRECTO"+fechaStr,e);
			throw new Exception("LA FECHA NO TIENE EL FORMATO CORRECTO"+fechaStr);
		}
		return fechaDate;
	}
	
	public static Date convertirHora(String horaStr) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat(FORMATO_HORA);
		Date horaDate=null;
		try {
			horaDate = sdf.parse(horaStr);
		} catch (ParseException e) {
			LOGGER.error("LA HORA NO TIENE EL FORMATO CORRECTO"+horaStr,e);
			throw new Exception("LA HORA NO TIENE EL FORMATO CORRECTO"+horaStr);
		}
		return horaDate;
	}
}
