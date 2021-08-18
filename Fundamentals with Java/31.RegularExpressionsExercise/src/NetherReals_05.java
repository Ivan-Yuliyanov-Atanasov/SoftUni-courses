import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherReals_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] names = scan.nextLine().split(",\\s*");
        Map<String, ArrayList<Double>> monsters = new TreeMap<>();
        String regex = "(?<sign>\\+|\\-)?(?<number>\\d+([\\.][\\d]+)?)";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < names.length; i++) {
            String demon = names[i].replaceAll("[,\\s]","");
            double health = 0;
            double damage = 0;
            for (int j = 0; j < demon.length(); j++) {
                char character = demon.charAt(j);
                if(character != '+' && character != '/' && character != '*' && character != '-' && character != '.' && !Character.isDigit(character)){
                    health += (int)character;
                }

            }
            Matcher matcher = pattern.matcher(demon);
            while (matcher.find()){
                String sign = matcher.group("sign");
                double number = Double.parseDouble(matcher.group("number"));
                if(sign == null || sign.equals("+")){
                    damage += number;
                } else {
                    damage -= number;
                }
            }
            for (int j = 0; j < demon.length(); j++) {
                char sign = demon.charAt(j);
                if (sign == '*'){
                    damage *= 2;
                } else if (sign == '/'){
                    damage /= 2;
                }

            }
            monsters.put(demon,new ArrayList<>());
            monsters.get(demon).add(health);
            monsters.get(demon).add(damage);
        }
        monsters.entrySet().stream()
                .forEach(m -> System.out.printf("%s - %.0f health, %.2f damage%n",m.getKey(),m.getValue().get(0),m.getValue().get(1)));
    }
}
