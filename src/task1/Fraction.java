package task1;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.*;

public class Fraction {
    private int flag;
    private int dig;

    public Fraction() {
        dig = 1;
    }

    public Fraction(int flag, int dig) {
        this.flag = flag;
        this.dig = dig;
        reduce();
    }

    private static boolean test(Fraction f1, Fraction f2) {
        return f1.equals.test(f2);
    }

    private static Fraction apply(Fraction f1, Fraction f2) {
        return f1.multiply.apply(f2);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void reduce() {
        int gcd = gcd(Math.abs(flag), Math.abs(dig));
        flag /= gcd;
        dig /= gcd;

        if (dig < 0) {
            flag = -flag;
            dig = -dig;
        }
    }

    public final Supplier<Integer> getFlag = () -> flag;
    public final Supplier<Integer> getDig = () -> dig;

    public final Consumer<Integer> setFlag = flag -> {
        this.flag = flag;
        reduce();
    };
    public final Consumer<Integer> setDig = dig -> {
        this.dig = dig;
        reduce();
    };

    public final Supplier<String> toString = () -> flag + "/" + dig;

    public final Supplier<Double> toDecimal = () -> (double) flag / dig;

    public final Predicate<Fraction> equals = other -> Objects.equals(this.toDecimal.get(),
            other.toDecimal.get());

    public final UnaryOperator<Fraction> multiply = other -> {
        if (other.dig == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        flag *= other.flag;
        dig *= other.dig;

        reduce();

        return this;
    };

    public final UnaryOperator<Fraction> divide = other -> {
        if (other.flag == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        flag *= other.dig;
        dig *= other.flag;

        reduce();

        return this;
    };

    public static final Function<Fraction, Double> fractionToDecimal = f -> (double) f.flag / f.dig;

    public static final Function<String, Fraction> fromString = s -> {
        var nums = Arrays.stream(s.split("/")).map(Integer::parseInt).toList();
        if(nums.size() != 2){
            throw new IllegalArgumentException("Invalid string format");
        }
        return new Fraction(nums.get(0), nums.get(1));
    };

    public static final BiPredicate<Fraction, Fraction> fractionsEquals = (f1, f2) ->
                                                                            f1.equals.test(f2);
    
    public static final BinaryOperator<Fraction> multiplyFractions = (f1, f2) ->
                                                                            f1.multiply.apply(f2);

    public static final BinaryOperator<Fraction> divideFractions = (f1, f2) ->
            f1.divide.apply(f2);
}
