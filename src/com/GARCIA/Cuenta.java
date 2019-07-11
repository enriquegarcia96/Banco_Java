package com.GARCIA;

 // se pone abstract para hacerlo,  que no se puede instanciar
public abstract class Cuenta {
    public int  numCuenta;
    public double Saldo;
    public final double SALDO_MAX = 10_000_000;  //es una constante.  final es valor constate


    public boolean Retirar(double monto){
        if((Saldo - monto) < 0){
            return false;
        }else {
            Saldo -= monto;  // tambien se puede poner this.  saldo = saldo - monto
            return true;
        }
    }



    public  boolean Depositar(double monto){
        if ((monto + Saldo) > SALDO_MAX){
            return false;
        }
            Saldo += monto;
            return true;

    }





}
