package com.cmc.evaluacion;

import com.cmc.evaluacion.*;
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
            System.out.println("Cliente ya está existe: "+cliente.getCedula());
        }
    }
}
