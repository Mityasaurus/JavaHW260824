package task2;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Consumer<Object> methodPrint = Tools::print;
        
        methodPrint.accept("Test string");
        methodPrint.accept(123);
        methodPrint.accept(123.456);
    }
}
