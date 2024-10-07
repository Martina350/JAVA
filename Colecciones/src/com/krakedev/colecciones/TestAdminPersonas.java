package com.krakedev.colecciones;

import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		AdminPersonas admin=new AdminPersonas();
		admin.agregar(new Persona("Gwen","Stacy",18));
		admin.agregar(new Persona("Peter","Parker",22));
		admin.agregar(new Persona("Miles","Morales",16));
		admin.imprimir();
		Persona p1=admin.buscarPorNombre("Miles");
		if(p1!=null) {
			System.out.println("ENCONTRADO: "+p1.getApellido()+" "+p1.getEdad());
		}else {
			System.out.println("PERSONA NO ENCONTRADA");
		}
		ArrayList<Persona> personasMayores=admin.buscarMayores(17);
		System.out.println("MAYORES: "+personasMayores.size());;
	}

}
