package com.krakedev;

public class Calculadora {
	public int sumar(int valor1,int valor2) {
		int  resultado;
		resultado=valor1+valor2;
		return resultado;
	}
	public int restar(int valor1,int valor2) {
		int resultado;
		resultado=valor1-valor2;
		return resultado;
	}
	public double multiplicar(double valor1, double valor2) {
		double resultado;
		resultado=valor1*valor2;
		return resultado;
	}
	public double dividir(double dividiendo, double divisor) {
		double resultado;
		resultado=dividiendo/divisor;
		return resultado;
	}
	public double promediar(double valor1,double valor2, double valor3) {
		double  resultadoTotal;
		double promedioTotal;
		resultadoTotal=valor1+valor2+valor3;
		promedioTotal=resultadoTotal/3;
		return promedioTotal;
	}
	public void mostrarResultado() {
			System.out.println("Ahorita no joven, sali al almuerzo. Regreso en 15 minutos");
	}
}

