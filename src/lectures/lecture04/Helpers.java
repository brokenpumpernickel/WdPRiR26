package lectures.lecture04;

public class Helpers {
    public static boolean isPrime(int n) { // Nie mówcie nikomu, że ja to zrobiłem
        for(int i = 2; i < n; ++i) // Nie róbcie tego w domu, błagam!
            if(n % i == 0)
                return false;

        return true;
    }

    public static double fibon(double n) {
        if(n < 2)
            return n;

        return fibon(n - 1) + fibon(n - 2);
    }

    static void main() {
        System.out.println("Number of cores: " + Runtime.getRuntime().availableProcessors());

        for(int i = 1; i < 20; ++i)
            if(isPrime(i))
                System.out.println("Prime: " + i);
    }
}
