package com.GARCIA;

public class CuentaLargoPlazo extends Cuenta {

    public final double PENALTI = 0.05;

    public boolean Retirar(double monto){
        monto += (monto * PENALTI);
        return super.Retirar(monto);

    }



}
