import java.util.*;

public class HeroesOfCodeAndLogic_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> heroes = new TreeMap<>();
        for (int i = 1; i <= n ; i++) {
            String [] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mana = Integer.parseInt(input[2]);
            List<Integer> stats = new ArrayList<>();
            stats.add(hp);
            stats.add(mana);
            heroes.put(name,stats);

        }
        String inputLine = scan.nextLine();
        while(!inputLine.equals("End")){
            String [] tokens = inputLine.split(" - ");
            String command = tokens[0];
            String hero = tokens[1];
            switch (command){
                case "Recharge":
                    int mana = Integer.parseInt(tokens[2]);
                    if(mana + heroes.get(hero).get(1) <= 200){
                        heroes.get(hero).set(1,mana + heroes.get(hero).get(1));
                        System.out.printf("%s recharged for %d MP!%n",hero,mana);
                    } else {
                        int diff = 200 - heroes.get(hero).get(1);
                        heroes.get(hero).set(1,200);
                        System.out.printf("%s recharged for %d MP!%n",hero,diff);
                    }
                    break;
                case "Heal":
                    int health = Integer.parseInt(tokens[2]);
                    if(health + heroes.get(hero).get(0) <= 100) {
                        heroes.get(hero).set(0, health + heroes.get(hero).get(0));
                        System.out.printf("%s healed for %d HP!%n", hero, health);
                    } else {
                        int diff = 100 - heroes.get(hero).get(0);
                        heroes.get(hero).set(0,100);
                        System.out.printf("%s healed for %d HP!%n",hero,diff);
                    }
                    break;

                case "CastSpell":
                    int manaNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if(manaNeeded > heroes.get(hero).get(1)){
                        System.out.printf("%s does not have enough MP to cast %s!%n",hero,spellName);
                    } else {
                        heroes.get(hero).set(1,heroes.get(hero).get(1) - manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",hero, spellName, heroes.get(hero).get(1));
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    if(damage >= heroes.get(hero).get(0)){
                        System.out.printf("%s has been killed by %s!%n",hero,attacker);
                        heroes.remove(hero);
                    } else {
                        heroes.get(hero).set(0,heroes.get(hero).get(0) - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",hero, damage, attacker, heroes.get(hero).get(0));
                    }
                    break;

            }

            inputLine = scan.nextLine();
        }
        heroes.entrySet().stream()
                .sorted((c1,c2) -> Integer.compare(c2.getValue().get(0),c1.getValue().get(0)))
                .forEach(c-> {
                    System.out.printf("%s%n",c.getKey());
                    System.out.printf("  HP: %d%n",c.getValue().get(0));
                    System.out.printf("  MP: %d%n",c.getValue().get(1));
                });
    }
}
