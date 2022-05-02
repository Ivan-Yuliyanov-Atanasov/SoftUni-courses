package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Field[] fields = RichSoilLand.class.getDeclaredFields();
		
		String inputLine = "";
		while(!(inputLine = scanner.nextLine()).equals("HARVEST")){
			switch (inputLine){
				case "private":
					Arrays.stream(fields).filter(f-> Modifier.isPrivate(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				case "public":
					Arrays.stream(fields).filter(f-> Modifier.isPublic(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				case "protected":
					Arrays.stream(fields).filter(f-> Modifier.isProtected(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n",Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
				case "all":
					Arrays.stream(fields)
							.forEach(f -> System.out.printf("%s %s %s%n",Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
					break;
			}
		}

	}
}
