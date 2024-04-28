package Models;

import java.util.Random;

public class Calculo {
    private int iteraciones;
    private int inventario;
    private int cantidadOrdenar;
    private int nivelReorden;
    private int numOrden;
    private int diasEspera;
    /** Modelos de la Transformada Inversa **/
    private Demanda demandaInversa;
    private TiempoDeEntrega tiempoDeEntregaInversa;
    /** Estos son los arreglos donde se guardan los datos de la tabla **/
    private int[] meses;
    private double[] factorEstacional;
    private int[] inventarioInicial;
    private double[] numeroR1;
    private int[] demanda;
    private int[] demandaAjustada;
    private int[] inventarioFinal;
    private int[] faltante;
    private String[] orden;
    private double[] numeroR2;
    private String[] dias;
    private double[] inventarioPromedio;
    private Random random;

    public static void main(String[] args) {
        Calculo c = new Calculo(24,150,200,100);    
        c.calcularTabla();
    }
    
    public Calculo(int iteraciones, int inventario,int cantidadOrdenar, int nivelReorden) {
        this.iteraciones = iteraciones;
        this.inventario = inventario;
        this.cantidadOrdenar = cantidadOrdenar;
        this.nivelReorden = nivelReorden;
        this.iniciarValores();
        this.inicializarArreglos();
        this.calcularFactorEstacional();
        this.calcularTabla();
    }

    private void iniciarValores() {
        this.numOrden = 0;
        this.diasEspera = -1;
        this.random = new Random();
        this.demandaInversa = new Demanda();
        this.tiempoDeEntregaInversa = new TiempoDeEntrega();
    }

    private void inicializarArreglos() {
        this.meses = new int[iteraciones];
        this.factorEstacional = new double[iteraciones];
        this.inventarioInicial = new int[iteraciones];
        this.numeroR1 = new double[iteraciones];
        this.demanda = new int[iteraciones];
        this.demandaAjustada = new int[iteraciones];
        this.inventarioFinal = new int[iteraciones];
        this.faltante = new int[iteraciones];
        this.orden = new String[iteraciones];
        this.numeroR2 = new double[iteraciones];
        this.dias = new String[iteraciones];
        this.inventarioPromedio = new double[iteraciones];
    }

    private void calcularFactorEstacional() {
        for(int i=0; i < factorEstacional.length; i++) {
            int modulo = (i+1) % 12;
            if(modulo == 1 || modulo == 10) {
                factorEstacional[i] = 1.2;
            }else if(modulo == 2 || modulo == 9) {
                factorEstacional[i] = 1.0;
            }else if(modulo == 3 || modulo == 8) {
                factorEstacional[i] = 0.9;
            }else if(modulo == 4 || modulo == 5 || modulo == 7) {
                factorEstacional[i] = 0.8;
            }else if(modulo == 6) {
                factorEstacional[i] = 0.7;
            }else if(modulo == 11) {
                factorEstacional[i] = 1.3;
            }else if(modulo == 0) {
                factorEstacional[i] = 1.4;
            }
        }
    }

    public void calcularTabla() {
        for(int i=0; i < iteraciones; i++) {
            meses[i] = i+1;
            inventarioInicial[i] = i > 0 ? obtenerInventarioInicial(i) : inventario;  
            numeroR1[i] = random.nextDouble();
            demanda[i] = demandaInversa.transformadaInversa(numeroR1[i]);
            demandaAjustada[i] = (int) Math.round(demanda[i] * factorEstacional[i]);
            inventarioFinal[i] = inventarioInicial[i] - demandaAjustada[i];
            faltante[i] = inventarioFinal[i] < 0 ? Math.abs(inventarioInicial[i]) : 0;
            orden[i] = seRealizaOrden(i);
            numeroR2[i] = random.nextDouble();
            dias[i] = obtenerDiasDeEspera(i); 
            inventarioPromedio[i] = calcularInventarioPromedio(i);
            diasEspera--;
        }
    }

    private int obtenerInventarioInicial(int indice) {
        int res;
        if(diasEspera == 0) {
            res = cantidadOrdenar + inventarioFinal[indice - 1];
        }else {
            res =  inventarioFinal[indice - 1];
        }
        return res;
    }

    private String seRealizaOrden(int indice) {
        String res;
        if(inventarioFinal[indice] < nivelReorden && diasEspera <= 0) {
            numOrden++;
            res = "" + numOrden;
        }else {
            res = "-";
        }
        return res;
    }

    private String obtenerDiasDeEspera(int indice) {
        String res;
        if(orden[indice] != "-") {
            diasEspera = tiempoDeEntregaInversa.transformadaInversaTiempo(numeroR2[indice]);
            res = "" + diasEspera;
            diasEspera++;
        }else {
            res = "-";
        }
        return res;
    }

    private double calcularInventarioPromedio(int indice)  {
        double res = 0.0;
        if(faltante[indice] == 0) {
            res = (inventarioInicial[indice]+inventarioFinal[indice]) / 2.0;
        }else {
            res = (inventarioInicial[indice]/2) * (inventarioInicial[indice]/demandaAjustada[indice]);
        }
        return res;
    }

    public double costoTotal() {
        Costo c = new Costo(this);
        return c.calcularCostoTotalHookeJeeves();
    }

    private void imprimir(int i) {
        System.out.println(meses[i] + " " + inventarioInicial[i] + 
            " " + numeroR1[i] + " " + demanda[i] + " " + demandaAjustada[i] + " "
            + inventarioFinal[i] + " " + faltante[i] + " " + orden[i] + " " + numeroR2[i] + " "
            + dias[i] + " " + inventarioPromedio[i]);
    }

    public int[] obtenerMeses() {
        return meses;
    }

    public double[] obtenerFactoresEstacionales() {
        return factorEstacional;
    }

    public int[] obtenerInventarioInicial() {
        return inventarioInicial;
    }

    public double[] obtenerR1() {
        return numeroR1;
    }

    public int[] obtenerDemanda() {
        return demanda;
    }

    public int[] obtenerDemandaAjustada() {
        return demandaAjustada;
    }
    
    public int[] obtenerInventarioFinal() {
        return inventarioFinal;
    }

    public int[] obtenerFaltante() {
        return faltante;
    }

    public String[] obtenerOrden() {
        return orden;
    }

    public double[] obtenerR2() {
        return numeroR2;
    }

    public String[] obtenerDias() {
        return dias;
    }

    public double[] obtenerInventarioPromedio() {
        return inventarioPromedio;
    }
}
