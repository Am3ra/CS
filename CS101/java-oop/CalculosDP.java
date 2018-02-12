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
    public String raizes(Float a, Float b, Float c) {
        if(a == 0){
            if(b==0){
                return "ERROR, NO EXISTE";
            } else{
                if(c == 0){
                    return "X =  "+b;
                }
                return "Ecuacion lineal, x = "+(-c/b);
            }
        }
        float i = b*b - (4 * a *c);
        if (i <0) {
            return "Raizes imaginarias";
        } else {
            System.out.println(a);
            System.out.println(b);
            System.out.println();
            float x1 = (float)(-b + Math.sqrt(i))/(2*a);
            float x2 = (float)(-b - Math.sqrt(i))/(2 * a);
            return "Raiz x1 = "+x1+", Raiz x2 = "+x2;
        }
    }
}