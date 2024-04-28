package Models;
public class HookeJeeves {
    private final int MAX_ITERACIONES = 100;
    private int MESES;
    private final int INVENTARIO_INICIAL = 150;
    private int qActual;
    private int rActual;
    private double costoActual;
    private Calculo calculoActual;
    private int cambioDePaso = 1;

    public static void main(String[] args) {
        HookeJeeves h = new HookeJeeves(24);
        h.optimizarHookeJeeves(0);
        System.out.println("Costo actual: " + h.costoActual + ", Q óptimo: " + h.qActual + ", R óptimo: " + h.rActual);
    }

    public HookeJeeves(int meses) {
        this.qActual = 150;
        this.rActual = 200;
        this.MESES = meses;
        this.calculoActual = evaluarCosto(qActual, rActual); 
        this.costoActual = this.calculoActual.costoTotal();
    }

    public void optimizarHookeJeeves(int iteracion) {
        if (iteracion >= MAX_ITERACIONES) {
            return; // Condición de parada: se alcanzó el número máximo de iteraciones
        }

        // Realizar exploración en la dirección de q
        Calculo calculoQMenos =  evaluarCosto(qActual - cambioDePaso, rActual);
        Calculo calculoQMas = evaluarCosto(qActual + cambioDePaso, rActual);
        double costoEnQMenos = calculoQMenos.costoTotal();
        double costoEnQMas = calculoQMas.costoTotal();

        if (costoEnQMenos < costoActual) {
            qActual -= cambioDePaso;
            costoActual = costoEnQMenos;
            calculoActual = calculoQMas;
        } else if (costoEnQMas < costoActual) {
            qActual += cambioDePaso;
            costoActual = costoEnQMas;
            calculoActual = calculoQMas;
        } else {
            cambioDePaso++;
        }

        // Realizar exploración en la dirección de r
        Calculo calculoRMenos =  evaluarCosto(qActual - cambioDePaso, rActual);
        Calculo calculoRMas = evaluarCosto(qActual + cambioDePaso, rActual);
        double costoEnRMenos = calculoRMenos.costoTotal();
        double costoEnRMas = calculoRMas.costoTotal();

        if (costoEnRMenos < costoActual) {
            rActual -= cambioDePaso;
            costoActual = costoEnRMenos;
            calculoActual = calculoRMenos;
        } else if (costoEnRMas < costoActual) {
            rActual += cambioDePaso;
            costoActual = costoEnRMas;
            calculoActual = calculoRMas;
        } else {
            cambioDePaso++;
        }

        System.out.println(iteracion + " qActual: " + qActual + " ; rActual: " + rActual + " costoAct: " + costoActual);
        // Llamar recursivamente para la siguiente iteración
        optimizarHookeJeeves(iteracion + 1);
    }

    private Calculo evaluarCosto(int q, int r) {
        Calculo calculo = new Calculo(MESES, INVENTARIO_INICIAL, q, r);
        return calculo;
    }

    public Calculo obtenerMejorCalculo() {
        optimizarHookeJeeves(0);
        return calculoActual;        
    }

    public int obtenerQ() {
        return qActual;
    }

    public int obtenerR() {
        return rActual;
    }
}
