/**
 * CalculosDP
 */
public class CalculosDP {
    public float gradosCF(float celcius){
        return (float) 9/5*celcius+32;
    }
    public float gradosFC(float farenheit){
        return (float) 5/9 * (farenheit -32);
    }
    public int factorial(int n){
        int f=1;
        for(int i=1 ; i<=n; i++){
            f*=i;
        }
        return f;
    }
    public int exponencial(int x, int y){
        int z = 1;
        for(int i = 0; i < y; i++){
            z*=x;
        }
        return z;
    }
}