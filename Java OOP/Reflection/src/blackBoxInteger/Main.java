package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String inputLine = scanner.nextLine();
        while(!inputLine.equals("END")){
            int n = Integer.parseInt(inputLine.split("_")[1]);
            switch (inputLine.split("_")[0]){
                case "add":
                    Method addMethod = clazz.getDeclaredMethod("add", int.class);
                    addMethod.setAccessible(true);
                    addMethod.invoke(blackBoxInt,n);
                    break;
                case "subtract":
                    Method subMethod = clazz.getDeclaredMethod("subtract", int.class);
                    subMethod.setAccessible(true);
                    subMethod.invoke(blackBoxInt,n);
                    break;
                case "multiply":
                    Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class);
                    multiplyMethod.setAccessible(true);
                    multiplyMethod.invoke(blackBoxInt,n);
                    break;
                case "divide":
                    Method divideMethod = clazz.getDeclaredMethod("divide", int.class);
                    divideMethod.setAccessible(true);
                    divideMethod.invoke(blackBoxInt,n);
                    break;
                case "leftShift":
                    Method leftShiftMethod = clazz.getDeclaredMethod("leftShift", int.class);
                    leftShiftMethod.setAccessible(true);
                    leftShiftMethod.invoke(blackBoxInt,n);
                    break;
                case "rightShift":
                    Method rightShiftMethod = clazz.getDeclaredMethod("rightShift", int.class);
                    rightShiftMethod.setAccessible(true);
                    rightShiftMethod.invoke(blackBoxInt,n);
                    break;

            }
            System.out.println(innerValue.get(blackBoxInt));
            inputLine = scanner.nextLine();
        }

    }
}

