package com.GARCIA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Cuenta es la clase pero tambien se pone tipos de datos
        ArrayList<Cuenta> cuentas = new ArrayList<>();

        Scanner lector = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("\tBienvenido");
        System.out.println("~~~~~~~~~~~~~~~~~");

        while (true) {
            //manejar la exepcion de leer datos y otras donde halla xx|x
            // crear una funcion solicitar un entero y dentro de la funcion
            //llamrlo de nuevo ,
            System.out.println("1. Crear una cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar saldo de una cuenta");
            System.out.println("5. Mostrar cuentas");
            System.out.println("6. Salir");
            int opcion =LectorDeDatos.solicitarEntero("Ingrese una opcion");

            // int opcion = lector.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("~~ Creando una Cuenta ~~");
                    Random rand = new Random();
                    /**^ Creamos el objeto para que tire los numero aleatorios**/
                    int numeroCuenta = rand.nextInt(1000);
                    /**  ^es una variable temporal que la vamos a asignar ala clase padre**/
                    System.out.println("su numeor de cuenta es :" + numeroCuenta);
                    System.out.println("Especifique que tipo de cuenta desea crear");
                    System.out.println("\t1.Cuenta de ahorro");
                    System.out.println("\t2.Cuenta de Largo plazo");
                    int tipoCuenta = lector.nextInt();
                    double saldo = LectorDeDatos.solicitarDouble("ingrese el saldo inicial:  ");
                    System.out.print("ingrese el saldo inicial:    ");
                    //double saldo = lector.nextDouble();

                    if (tipoCuenta == 1) {
                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        //^nuevo objeto
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.Saldo = saldo;
                        cuentas.add(nuevaCuenta);
                    } else if (tipoCuenta == 2) {
                        CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.Saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        /**nueva cuenta se puede de clarar la variable, porque solo existe adentro del if**/
                    } else {
                        System.out.println("Tipo de cuenta no existe");
                    }
                    System.out.println("la cuenta ha sido creada ");
                    break;

                case 2:
                    System.out.println("~~ Deposito de cuentas ~~2");
                    if (cuentas.isEmpty()) {
                        System.out.println("---- No hay cuentas --");
                        break;
                    } else {
                        System.out.println("** Depositos A Cuentas **");
                    }

                    //System.out.println("Ingrese El Numero De Cuenta Que Desea Depositar");
                    int tipoDeposito = LectorDeDatos.solicitarEntero("Ingrese El Numero De Cuenta Que Desea Depositar");
                    //int tipoDeposito = lector.nextInt();
                    for (Cuenta c : cuentas) {
                        if (tipoDeposito == c.numCuenta) {
                            System.out.println("La Cuenta Si Existe\n" +
                                    "-------------------");
                            //System.out.println("Ingrese El Monto A Depositar");
                            double deposito = LectorDeDatos.solicitarDouble("Ingrese El Monto A Depositar");
                            //double deposito = lector.nextDouble();
                            if (c.Depositar(deposito) == true) {
                                System.out.println("nuevo saldo de la targeta--> " + c.Saldo);
                                System.out.println("Ha Resivido Un Porcentaje De Interes por El Deposito");
                            } else if (deposito > c.SALDO_MAX) {
                                System.out.println("No se permite hacer deposito mayor ");
                            } else if (c.Depositar(deposito) == false) {
                                c.Saldo += deposito;
                                System.out.println("nuevo saldo de la targeta-->" + c.Saldo);
                            }
                        } else if (tipoDeposito != c.numCuenta) {
                            System.out.println("~~ La cuenta no existe ~~");
                        }
                    }
                    break;
                case 3:
                    System.out.println("~~ Retiro DE Cuentas ~~3");
                    if (cuentas.isEmpty()) {
                        System.out.println("---- No hay cuentas --");
                        break;
                    }

                    System.out.println("~~ Retiro De Cuentas ~~\n");
                            //"Ingrese El Numero De Cuenta Que Desea Retirar ");
                    int tipoRetiro = LectorDeDatos.solicitarEntero("Ingrese El Numero De Cuenta Que Desea Retirar");
                    //int tipoRetiro = lector.nextInt();
                    for (Cuenta c : cuentas) {
                        if (tipoRetiro == c.numCuenta) {
                            System.out.println("La cuenta Existe\n ");
                                    //"Ingrese el monto que Desea Retirar");
                            double Retiro =LectorDeDatos.solicitarDouble("Ingrese el monto que Desea Retirar");
                            //double Retiro = lector.nextDouble();
                            if (c.Retirar(Retiro) == true) {
                                System.out.println("Su Retiro Fue De: " + Retiro);
                                System.out.println("Nuevo Saldo De La Tarjeta: " + c.Saldo);
                            } else if (c.Retirar(Retiro) == false) {
                                System.out.println("Saldo De La Cuenta Es Menor Al Retiro ==>" + c.Saldo);
                            }
                        } else if (tipoRetiro != c.numCuenta) {
                            System.out.println("~~ La Cuenta No Existe ~~");
                        }
                    }

                    break;
                case 4:
                    if (cuentas.isEmpty()) {
                        System.out.println("-- No hay cuentas --");
                        break;
                    }

                    System.out.println("~~ Saldo De Cuentas ~~\n");

                    int tipo_Cuenta=LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta");
                    //int tipo_Cuenta = lector.nextInt();
                    for (Cuenta c : cuentas) {
                        if (tipo_Cuenta == c.numCuenta) {
                            System.out.println("Saldo De La Cuenta #" + c.numCuenta + "," + "Es" + " " + c.Saldo);
                        } else {
                            System.out.println("~~ Numero De Cuenta NO  Existe ~~");
                        }
                    }

                    break;
                case 5:
                    // numero de cuenta - tipo de cuenta
                    System.out.println("~~ Mostrando Cuentas ~~5");
                    if (cuentas.isEmpty()) {
                        System.out.println("---- No hay cuentas --");
                    } else {
                        System.out.println("** Mostrando Cuentas **");
                    }
                    for (Cuenta c : cuentas) {
                        String tipo = " ";
                        if (c instanceof CuentaAhorro)
                            tipo = "Cuenta de Ahorro";
                        else if (c instanceof CuentaLargoPlazo)
                            tipo = "cuenta a largo plazo";
                        System.out.println("Numero de cuenta:" + c.numCuenta + " - " + tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6) {
                break;
            }
        }
    }
}