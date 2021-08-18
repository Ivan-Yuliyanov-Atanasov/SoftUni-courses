import java.util.*;

public class DragonArmy_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, TreeMap<String, ArrayList<Integer>>> dragons = new LinkedHashMap<>();
        Map<String,LinkedHashMap<String, Integer>> dragonsDamage = new LinkedHashMap<>();
        Map<String,LinkedHashMap<String, Integer>> dragonsHealth = new LinkedHashMap<>();
        Map<String,LinkedHashMap<String, Integer>> dragonsArmor = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(" ");
            String color = tokens[0];
            String name = tokens[1];
            String damageString = tokens[2];
            String healthString = tokens[3];
            String armorString = tokens[4];
            int damage = 45;
            int health = 250;
            int armor = 10;

            if (!damageString.equals("null")){
                damage = Integer.parseInt(damageString);
            }
            if (!healthString.equals("null")){
                health = Integer.parseInt(healthString);
            }
            if (!armorString.equals("null")){
                armor = Integer.parseInt(armorString);
            }
            ArrayList<Integer> stats = new ArrayList<>();
            stats.add(damage);
            stats.add(health);
            stats.add(armor);
            if(!dragons.containsKey(color)){
                dragons.put(color,new TreeMap<>());
                dragons.get(color).put(name,stats);
                dragonsDamage.put(color,new LinkedHashMap<>());
                dragonsDamage.get(color).put(name,damage);
                dragonsHealth.put(color,new LinkedHashMap<>());
                dragonsHealth.get(color).put(name,health);
                dragonsArmor.put(color,new LinkedHashMap<>());
                dragonsArmor.get(color).put(name,armor);
            } else {
                dragons.get(color).put(name,stats);
                dragonsDamage.get(color).put(name,damage);
                dragonsHealth.get(color).put(name,health);
                dragonsArmor.get(color).put(name,armor);
            }
        }
        dragons.entrySet().stream()
                .forEach(d->{
                    double averageDamage = dragonsDamage.get(d.getKey()).values().stream().mapToDouble(e->e).average().orElse(0);
                    double averageHealth = dragonsHealth.get(d.getKey()).values().stream().mapToDouble(e->e).average().orElse(0);
                    double averageArmor = dragonsArmor.get(d.getKey()).values().stream().mapToDouble(e->e).average().orElse(0);
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n",d.getKey(),averageDamage,averageHealth,averageArmor);
                    d.getValue().entrySet().stream().
                            forEach(e-> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",e.getKey(),e.getValue().get(0),e.getValue().get(1),e.getValue().get(2)));
                });
    }
}
