package Models;

import java.util.Random;

public class TiempoDeEntrega {
    private Random random;
    
    public TiempoDeEntrega() {
        this.random = new Random();
    }

    public double transformadaInversaTiempo() {
        double res = 0.0;
        double r = this.random.nextDouble();
        if(r >= 0.0 && r < 0.3) {
            res = 1.0;
        }else if(r >= 0.3 && r < 0.7) {    
            res = 2.0;
        }else {
            res = 3.0;
        }
        return res;
    }
}
