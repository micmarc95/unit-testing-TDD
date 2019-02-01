package exercises;

import java.util.List;
import java.util.function.Function;

public class AdvancedCalculator {

    public int silnia(int x){ // TODO: wyrazić używając klasy IntStream oraz metod range i reduce
        if(x < 0){
            throw new IllegalArgumentException("Silnia jest policzalna tylko dla liczb dodatnich");
        }

        int wynik = 1;
        for (int i=1; i<=x; i++){
            wynik *= i;
        }

        if(wynik < 0){
            throw new IllegalArgumentException("Wynik nie może być mniejszy od zera");
        }
        
        return wynik;
    }

    public double potega(int podstawa, int potega) {
        // TODO implement
        //throw new UnsupportedOperationException("Not implemented yet");

        double wynik;
        if (podstawa == 0){
            wynik = 1;
        } else {
            wynik = Math.pow(podstawa,potega);
        }
       return wynik;
    }

    public Function<Double, Double> funkcjaLiniowa(List<Double> ciagLiczb) {

        double b = ciagLiczb.get(0);
        double a = ciagLiczb.get(1) - ciagLiczb.get(0);
        return x -> a * x + b;
    }

}
