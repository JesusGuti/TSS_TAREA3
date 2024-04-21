package Models;

public class Costo {
    private final double costoXOrden = 100.0;
    private final double costoXInventario = 20.0/12.0;
    private final double costoXFaltante = 50.0;    
    private Calculo calculo;
    public double costoOrdenar;
    public double costoInventario;
    public double costoFaltante;

    public Costo(Calculo calculo) {
        this.calculo = calculo;
    }

    public double calcularCostoOrden() {
        double res = 0.0;
        int nroOrdenes = 0;
        String[] ordenes = calculo.obtenerOrden();
        for(int i=0; i < ordenes.length ; i++) {
            if(ordenes[i] != "-") {
                nroOrdenes++;
            }
        }
        res = nroOrdenes * costoXOrden;
        costoOrdenar = res;
        return res;
    }

    public double calcularCostoInventario() {
        double res = 0.0;
        double[] inventarioPromedio = calculo.obtenerInventarioPromedio();
        for(int i=0; i < inventarioPromedio.length; i++) {
            res = res + inventarioPromedio[i];
        }
        res = res * costoXInventario;
        costoInventario = res;
        return res;
    }

    public double calcularCostoFaltante() {
        double res = 0.0;
        int faltante = 0;
        int[] faltantes = calculo.obtenerFaltante();
        for(int i=0; i < faltantes.length; i++) {
            faltante = faltante + faltantes[i];
        }
        res = faltante * costoXFaltante;
        costoFaltante = res;
        return res;
    }

    public double calcularCostoTotal() {
        double res = costoOrdenar + costoInventario + costoFaltante;
        return res;
    }
    
    public double calcularCostoTotalHookeJeeves() {
        double res = calcularCostoOrden() + calcularCostoFaltante() + calcularCostoInventario();
        return res;
    }
}