package com.amazinglystupidsoftware.arewegonnaburn.model.service;

import com.amazinglystupidsoftware.arewegonnaburn.model.VenueCSVParser.Safe;

public class VenueServiceModel {
	
	private String number;
	private String nombre;
	private String domicilio;
	private String nro_domicilio;
	private String nro_expediente;
	private String capacidad;
	private String clase;
	private String estado;
	private String dispocision_inscripcion_nro;
	private String fecha_disposicion_inscripcion;
	private String dispocision_reinscripcion_nro;
	private String fecha_disposicion_reinscripcion;
	private String dispocision_rechazo_nro;
	private String fecha_disposicion_rechazo;
	private String disposicion_recalculo_capacidad_nro;
	private String fecha_disposicion_recalculo_capacidad;

	public VenueServiceModel(String[] fields)
	{
		super();
		Safe<String> safeIndex = new Safe<String>();
		number = 								safeIndex.get(fields, 0);
		nombre = 								safeIndex.get(fields, 1);
		domicilio = 							safeIndex.get(fields, 2);
		nro_domicilio = 						safeIndex.get(fields, 3);
		nro_expediente = 						safeIndex.get(fields, 4);
		capacidad = 							safeIndex.get(fields, 5);
		clase = 								safeIndex.get(fields, 6);
		estado = 								safeIndex.get(fields, 7);
		dispocision_inscripcion_nro = 			safeIndex.get(fields, 8);
		fecha_disposicion_inscripcion = 		safeIndex.get(fields, 9);
		dispocision_reinscripcion_nro = 		safeIndex.get(fields, 10);
		fecha_disposicion_reinscripcion = 		safeIndex.get(fields, 11);
		dispocision_rechazo_nro = 				safeIndex.get(fields, 12);
		fecha_disposicion_rechazo = 			safeIndex.get(fields, 13);
		disposicion_recalculo_capacidad_nro = 	safeIndex.get(fields, 14);
		fecha_disposicion_recalculo_capacidad = safeIndex.get(fields, 15);
	}

	public String getNumber() {
		return number;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getNro_domicilio() {
		return nro_domicilio;
	}

	public String getNro_expediente() {
		return nro_expediente;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public String getClase() {
		return clase;
	}

	public String getEstado() {
		return estado;
	}

	public String getDispocision_inscripcion_nro() {
		return dispocision_inscripcion_nro;
	}

	public String getFecha_disposicion_inscripcion() {
		return fecha_disposicion_inscripcion;
	}

	public String getDispocision_reinscripcion_nro() {
		return dispocision_reinscripcion_nro;
	}

	public String getFecha_disposicion_reinscripcion() {
		return fecha_disposicion_reinscripcion;
	}

	public String getDispocision_rechazo_nro() {
		return dispocision_rechazo_nro;
	}

	public String getFecha_disposicion_rechazo() {
		return fecha_disposicion_rechazo;
	}

	public String getDisposicion_recalculo_capacidad_nro() {
		return disposicion_recalculo_capacidad_nro;
	}

	public String getFecha_disposicion_recalculo_capacidad() {
		return fecha_disposicion_recalculo_capacidad;
	}
	
	
}
