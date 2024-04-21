package Models;

public class HookeJeeves {
    private int iteraciones;
    private final int inventario = 150;
    private int qActual;
    private int qMejorado;
    private int rActual;
    private int rMejorado;
    private Calculo calculoActual;
    private Calculo calculoMejorado;
    private double costoActual;
    private double costoMejorado;
    
    public static void main(String[] args) {
        HookeJeeves h = new HookeJeeves(20);
        h.optimizarHookeJeeves();
    }

    public HookeJeeves(int iteraciones) {
        this.iteraciones = iteraciones;
        qActual = 200;
        rActual = 100;
        calculoActual = new Calculo(iteraciones,inventario,qActual,rActual);
        costoActual = calculoActual.costoTotal();
        costoMejorado = Double.POSITIVE_INFINITY;
    }

    public void optimizarHookeJeeves() {
        int i = 1;
        while(costoActual < costoMejorado) {
            System.out.print(i);
            probarX1();
            probarX2();
            i++;
        }

    }

    public void probarX1() {
        Calculo calculoResta = new Calculo(iteraciones, inventario, qActual-1, rActual);
        Calculo calculoSuma = new Calculo(iteraciones, inventario, qActual+1, rActual);
        double promedioResta = calculoResta.costoTotal();
        double promedioSuma = calculoSuma.costoTotal();
        
        if(promedioSuma > promedioResta) {
            if(promedioResta < costoMejorado) {
                costoMejorado = promedioResta;
                calculoMejorado = calculoResta;
                qMejorado = qActual - 1;
            }              
        }else {
            if(promedioSuma < costoMejorado) {
                costoMejorado = promedioSuma;
                calculoMejorado = calculoSuma;
                qMejorado = qActual + 1;
            }
        } 

        if(costoMejorado < costoActual) {
            costoActual = costoMejorado;
            calculoActual = calculoMejorado;
            qActual = qMejorado;
        }
        System.out.println("Costo actual: " + costoActual+ ", Costo Mejorado " + costoMejorado );
    }

    public void probarX2() {
        Calculo calculoResta = new Calculo(iteraciones, inventario, qActual, rActual-1);
        Calculo calculoSuma = new Calculo(iteraciones, inventario, qActual, rActual+1);
        double promedioResta = calculoResta.costoTotal();
        double promedioSuma = calculoSuma.costoTotal();
        
        if(promedioSuma > promedioResta) {
            if(promedioResta < costoMejorado) {
                costoMejorado = promedioResta;
                calculoMejorado = calculoResta;
                rMejorado = rActual - 1;
            }              
        }else {
            if(promedioSuma < costoMejorado) {
                costoMejorado = promedioSuma;
                calculoMejorado = calculoSuma;
                rMejorado = rActual + 1;
            }
        } 

        if(costoMejorado < costoActual) {
            costoActual = costoMejorado;
            calculoActual = calculoMejorado;
            rActual = rMejorado;
        }

        System.out.println("Costo actual: " + costoActual+ ", Costo Mejorado " + costoMejorado );

    }
}
