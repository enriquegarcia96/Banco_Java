package com.GARCIA;

public class CuentaAhorro extends Cuenta {


    public final double SALDO_MIN_BONO = 50_000;
    public final double INTERES_BONO = 0.01;

    public boolean Depositar(double monto){
        if (monto > SALDO_MIN_BONO){
            monto += (monto*INTERES_BONO);

            /**aqui llamo el metodo DEPOSITAR que esta en el padre**/
            return super.Depositar(monto);
        }else{
            return false;
        }





    }



}














