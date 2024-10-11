package com.cmc.evaluacion;

import com.cmc.evaluacion.CalcularAmortizacion;
import com.cmc.evaluacion.Prestamo;
import com.cmc.evaluacion.Cliente;
import java.util.ArrayList;

public class Banco {
	private ArrayList<Prestamo> prestamos;
    private ArrayList<Cliente> clientes;

    public Banco() {
        prestamos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarCliente(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
        	Cliente cliente = clientes.get(i);
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getCedula()) == null) {
            clientes.add(cliente);
        } else {
            System.out.println("Cliente ya existe: "+cliente.getCedula());
        }
    }
    
    public void asignarPrestamo(String cedula, Prestamo prestamo) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            System.out.printf("No es cliente del banco");
        }else {
        	cliente.setPrestamos(prestamo);
			CalcularAmortizacion.generarTabla(prestamo);
        }
    }
    
    public ArrayList<Prestamo> buscarPrestamos(String cedula) {
		
		Cliente clienteBuscado=buscarCliente(cedula);
		if(clienteBuscado==null) {
			System.out.println("No es cliente del banco");
			return new ArrayList<>();
		}else {
			ArrayList<Prestamo> prestamosClientes=clienteBuscado.getPrestamos();
			if(prestamosClientes.isEmpty()) {
				 System.out.println("El cliente no tiene prestamos");
			}
			return prestamosClientes;
		}
	}        
}