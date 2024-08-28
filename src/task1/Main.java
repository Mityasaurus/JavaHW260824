package task1;

public class Main {
    public static void main(String[] args) {
        Fraction f = new Fraction(1,4);
        System.out.println(f.toDecimal.get());
        //
        Fraction f2 = new Fraction(3, 5);
        System.out.println(f.equals.test(f2));
        //
        f.multiply.apply(f2);
        System.out.println(f.toString.get());
        //
        f.divide.apply(f2);
        System.out.println(f.toString.get());
        //
        System.out.println(Fraction.fractionToDecimal.apply(new Fraction(12, 5)));
        //
        try {
            System.out.println(Fraction.fromString.apply("5/6/7").toString.get());
        } catch (Exception e){
            System.err.println(e);
        }
        //
        System.out.println(Fraction.fromString.apply("10/-15").toString.get());
        //
        System.out.println(Fraction.fractionsEquals.test(f, new Fraction(1, 4)));
        //
        System.out.println(Fraction.multiplyFractions.apply(f, f2).toString.get());
        //
        System.out.println(Fraction.divideFractions.apply(f, f2).toString.get());
    }
}