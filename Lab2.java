
class M_prostokatow extends Thread{
    public double calka;
    private static double func(double x) {
        return x*x+3;
    }
    public void run() {
        double ai = 3;

        double bi = 5;

        double dx;

        int n = 3;
        dx = (bi - ai) / (double)n;
        calka = 0;
        for (int i=1; i<=n; i++) {
            calka += func(ai + i * dx);
        }

        calka *= dx;

        System.out.println("Wartość całki metoda prostokatow: " + calka);
    }
}
class M_trapezow extends Thread{
    public double calka;
    private static double func(double x) {
        return x*x+3;
    }



    public void run() {
        double ai = 4;

        double bi = 8;

        double dx;
        int n = 3;
        dx = (bi - ai) / (double)n;
        calka = 0;
        for (int i=1; i<n; i++) {
            calka += func(ai + i * dx);
        }

        calka += (func(ai) + func(bi)) / 2;

        calka *= dx;

        System.out.println("Wartość całki metoda trapezow: " + calka);
    }
}
class M_Simpsona extends Thread{
    public double calka;
    private static double func(double x) {
        return x*x+3;
    }

    public void run() {
        double ai = 5;

        double bi = 8;

        double dx, s, x;
        
        int n = 3;
        dx = (bi - ai) / (double)n;
        calka = 0;
        s = 0;

        for (int i=1; i<n; i++) {
            x = ai + i*dx;
            s += func(x - dx / 2);
            calka += func(x);
        }

        s += func(bi - dx / 2);

        calka = (dx/6) * (func(ai) + func(bi) + 2*calka + 4*s);

        System.out.println("Wartosc calki metoda Simpsona: " + calka);
    }
}
public class Lab2 {
    public static void main(String[] args) {
        M_prostokatow method1 = new M_prostokatow();
        method1.start();
        M_trapezow method2 = new M_trapezow();
        method2.start();
        M_Simpsona method3 = new M_Simpsona();
        method3.start();
        try{
            method1.join();
            method2.join();
            method3.join();
        } catch (InterruptedException e){

        }
        double sum = 0;
        sum += method1.calka;
        sum += method2.calka;
        sum += method3.calka;
        System.out.println("Suma to: " + sum);
    }
}                                                    