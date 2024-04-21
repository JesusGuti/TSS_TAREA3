package Models;

public class HookeJeeves {
    private int iteraciones;
    private final int inventario = 150;
    private int qInicio;
    private int qActual;
    private int qMejorado;
    private int rInicio;
    private int rActual;
    private int rMejorado;
    private Calculo calculoActual;
    private Calculo calculoMejorado;
    private double costoActual;
    private double costoMejorado;
    
    public static void main(String[] args) {
        HookeJeeves h = new HookeJeeves(10);
        h.optimizarHookeJeeves(0);
        System.out.println(h.costoActual + "Q optimo: " + h.qMejorado + " Roptimo: " + h.rMejorado);
    }

    public HookeJeeves(int iteraciones) {
        this.iteraciones = iteraciones;
        qInicio = qActual = 200;
        rInicio = rActual = 100;
        qMejorado = -1;
        rMejorado = -1;
        calculoActual = new Calculo(iteraciones,inventario,qActual,rActual);
        costoActual = calculoActual.costoTotal();
        System.out.println("El costo actual es: " + costoActual);
        costoMejorado = Double.POSITIVE_INFINITY;
    }

    public void optimizarHookeJeeves(int i) {
        if(i>0 &&(qInicio  == qActual && rInicio == rActual)) {
            return;
        }else {
            System.out.println(i);
            probarX1();
            probarX2();
            optimizarHookeJeeves(i+1);
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
                System.out.println("x1a: " + promedioResta);
            }              
        }else if(promedioResta > promedioSuma){
            if(promedioSuma < costoMejorado) {
                costoMejorado = promedioSuma;
                calculoMejorado = calculoSuma;
                qMejorado = qActual + 1;
                System.out.println("x1b: " + promedioSuma);
            }
        }

        if(costoMejorado < costoActual) {
            costoActual = costoMejorado;
            calculoActual = calculoMejorado;
            qActual = qMejorado;
        }else {
            qActual = qInicio;
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
                System.out.println("x2a" + promedioResta);
            }              
        }else if(promedioResta > promedioSuma) {
            if(promedioSuma < costoMejorado) {
                costoMejorado = promedioSuma;
                calculoMejorado = calculoSuma;
                rMejorado = rActual + 1;
                System.out.println("x2b" + promedioSuma);
            }
        }

        if(costoMejorado < costoActual) {
            costoActual = costoMejorado;
            calculoActual = calculoMejorado;
            rActual = rMejorado;
        }else {
            rActual = rInicio;
        }

        System.out.println("Costo actual: " + costoActual+ ", Costo Mejorado " + costoMejorado );
    }
}
