package clearmind.cuentas.test;

import clearmind.cuentas.Cuentas;

public class TestCuentas {

	public static void main(String[] args) {
		Cuentas cuenta1=new Cuentas("03476","");
		cuenta1.setSaldo(675);
		Cuentas cuenta2=new Cuentas("03476","C",98);
		Cuentas cuenta3=new Cuentas("03476","");
		cuenta3.setTipo("C");
		Cuentas cuenta4=new Cuentas("0987","");
		cuenta4.setSaldo(10);
		Cuentas cuenta5=new Cuentas("0557","C",10);
		Cuentas cuenta6=new Cuentas("0666","");
		cuenta6.setSaldo(0);
		
		
		System.out.println("-----Valores Iniciales-----");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		System.out.println("-----Valores Modificados-----");
		cuenta1.setSaldo(444);
		cuenta3.setSaldo(567);
		cuenta2.setTipo("D");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		System.out.println("******CUENTA 4******");
		cuenta4.imprimirConMiEstilo();
		System.out.println("******CUENTA 5******");
		cuenta5.imprimirConMiEstilo();
		System.out.println("******CUENTA 6******");
		cuenta6.imprimirConMiEstilo();
	}
}
