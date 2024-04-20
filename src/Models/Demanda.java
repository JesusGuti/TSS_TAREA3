package Models;

import java.util.Random;

public class Demanda {
    private Random random;

    public Demanda() {
        this.random = new Random();
    }

    public double transformadaInversa() {
        double res = 0.0;
        double r = this.random.nextDouble();
        if(r >= 0.0 && r < 0.010) {
            res = 35.0;
        }else if(r >= 0.010 && r < 0.025) {
            res = 36.0;
        }else if(r >= 0.025 && r < 0.045) {
            res = 37.0;
        }else if(r >= 0.045 && r < 0.065) {
            res = 38.0;
        }else if(r >= 0.065 && r < 0.087) {
            res = 39.0;
        }else if(r >= 0.087 && r < 0.110) {
            res = 40.0;
        }else if(r >= 0.110 && r < 0.135) {
            res = 41.0;
        }else if(r >= 0.135 && r < 0.162) {
            res = 42.0;
        }else if(r >= 0.162 && r < 0.190) {
            res = 43.0;
        }else if(r >= 0.190 && r < 0.219) {
            res = 44.0;
        }else if(r >= 0.219 && r < 0.254) {
            res = 45.0;
        }else if(r >= 0.254 && r < 0.299) {
            res = 46.0;
        }else if(r >= 0.299 && r < 0.359) {
            res = 47.0;
        }else if(r >= 0.359 && r < 0.424) {
            res = 48.0;
        }else if(r >= 0.424 && r < 0.494) {
            res = 49.0;
        }else if(r >= 0.494 && r < 0.574) {
            res = 50.0;
        }else if(r >= 0.574 && r < 0.649) {
            res = 51.0;
        }else if(r >= 0.649 && r < 0.719) {
            res = 52.0;
        }else if(r >= 0.719 && r < 0.784) {
            res = 53.0;
        }else if(r >= 0.784 && r < 0.844) {
            res = 54.0;
        }else if(r >= 0.844 && r < 0.894) {
            res = 55.0;
        }else if(r >= 0.894 && r < 0.934) {
            res = 56.0;
        }else if(r >= 0.934 && r < 0.964) {
            res = 57.0;
        }else if(r >= 0.964 && r < 0.980) {
            res = 58.0;
        }else if(r >= 0.980 && r < 0.995) {
            res = 59.0;
        }else {
            res = 60.0;
        }
        return res;
    }
}
