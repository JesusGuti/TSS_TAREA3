package Models;

import java.util.Random;

public class Demanda {
    private Random random;

    public Demanda() {
        this.random = new Random();
    }

    public int transformadaInversa(double r) {
        int res = 0;
        if(r >= 0.0 && r < 0.010) {
            res = 35;
        }else if(r >= 0.010 && r < 0.025) {
            res = 36;
        }else if(r >= 0.025 && r < 0.045) {
            res = 37;
        }else if(r >= 0.045 && r < 0.065) {
            res = 38;
        }else if(r >= 0.065 && r < 0.087) {
            res = 39;
        }else if(r >= 0.087 && r < 0.110) {
            res = 40;
        }else if(r >= 0.110 && r < 0.135) {
            res = 41;
        }else if(r >= 0.135 && r < 0.162) {
            res = 42;
        }else if(r >= 0.162 && r < 0.190) {
            res = 43;
        }else if(r >= 0.190 && r < 0.219) {
            res = 44;
        }else if(r >= 0.219 && r < 0.254) {
            res = 45;
        }else if(r >= 0.254 && r < 0.299) {
            res = 46;
        }else if(r >= 0.299 && r < 0.359) {
            res = 47;
        }else if(r >= 0.359 && r < 0.424) {
            res = 48;
        }else if(r >= 0.424 && r < 0.494) {
            res = 49;
        }else if(r >= 0.494 && r < 0.574) {
            res = 50;
        }else if(r >= 0.574 && r < 0.649) {
            res = 51;
        }else if(r >= 0.649 && r < 0.719) {
            res = 52;
        }else if(r >= 0.719 && r < 0.784) {
            res = 53;
        }else if(r >= 0.784 && r < 0.844) {
            res = 54;
        }else if(r >= 0.844 && r < 0.894) {
            res = 55;
        }else if(r >= 0.894 && r < 0.934) {
            res = 56;
        }else if(r >= 0.934 && r < 0.964) {
            res = 57;
        }else if(r >= 0.964 && r < 0.980) {
            res = 58;
        }else if(r >= 0.980 && r < 0.995) {
            res = 59;
        }else {
            res = 60;
        }
        return res;
    }
}
