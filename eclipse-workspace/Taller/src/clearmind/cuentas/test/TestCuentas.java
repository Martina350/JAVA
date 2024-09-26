package clearmind.cuentas.test;

import clearmind.cuentas.Cuentas;

public class TestCuentas {

	public static void main(String[] args) {
		Cuentas cuenta1=new Cuentas("03476","");
		cuenta1.setSaldo(675);
		Cuentas cuenta2=new Cuentas("03476","D",98);
		Cuentas cuenta3=new Cuentas("03476","");
		cuenta3.setTipo("C");
		
		System.out.println("-----Valores Iniciales-----");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		System.out.println("-----Valores Modificados-----");
	}
}
