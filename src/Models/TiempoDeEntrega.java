package Models;

import java.util.Random;

public class TiempoDeEntrega {
    private Random random;
    
    public TiempoDeEntrega() {
        this.random = new Random();
    }

    public int transformadaInversaTiempo(double r) {
        int res = 0;
        if(r >= 0.0 && r < 0.3) {
            res = 1;
        }else if(r >= 0.3 && r < 0.7) {    
            res = 2;
        }else {
            res = 3;
        }
        return res;
    }
}
