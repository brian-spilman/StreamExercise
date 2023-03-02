package StreamExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Double> numberList = new ArrayList<>();

        Supplier<Double> getRandom = () -> {
            Random generator = new Random();
            return generator.nextDouble(100);
        };

        for(int i = 0; i < 10; i++) {numberList.add(getRandom.get());}

        System.out.println("Generated numbers: " + numberList);

        List<Double> nums100 = numberList.stream().map(x -> x + 100).collect(Collectors.toList());
        System.out.println("Numbers + 100: " + nums100);

        List<Double> aboveFifty = numberList.stream().filter(x -> x > 50).toList();
        System.out.println("Numbers above 50: " + aboveFifty);

        List<Double> numsSorted = numberList.stream().sorted().toList();
        System.out.println("Numbers sorted: " + numsSorted);

        aboveFifty.forEach(val -> {
            System.out.println("Nums above 50 forEach: " + val);
        });

        double sumNumbers = numberList.stream().reduce(0.0, (accumulator, current) -> accumulator + current);
        System.out.println("Sum of all numbers: " + sumNumbers);


    }
}
