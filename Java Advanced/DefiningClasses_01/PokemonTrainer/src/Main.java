import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputLine = "";
        Map<String, List<Pokemon>> trainers = new LinkedHashMap<>();
        Map<String,Integer> badges = new LinkedHashMap<>();
        while(!(inputLine = scan.nextLine()).equals("Tournament")){
            String [] tokens = inputLine.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            if(!trainers.containsKey(trainerName)){
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                trainers.put(trainerName,pokemons);
                badges.put(trainerName,0);
            } else {
                trainers.get(trainerName).add(pokemon);
            }

        }
        String  elementToSearch = "";
        while (!(elementToSearch = scan.nextLine()).equals("End")){
            for (Map.Entry<String,List<Pokemon>> entry : trainers.entrySet()) {
                List<Pokemon> currentList = entry.getValue();
                boolean noSuchElement = true;
                for (Pokemon pokemon : currentList) {
                    if(elementToSearch.equals(pokemon.getElement())){
                        int currentCountBadges = badges.get(entry.getKey());
                        badges.put(entry.getKey(),currentCountBadges + 1);
                        noSuchElement = false;
                        break;
                    }
                }
                if(noSuchElement){
                    for (int i=0; i < currentList.size(); i++ ) {
                        if(currentList.get(i).getHealth() - 10 <= 0){
                            currentList.remove(i);
                            i--;
                        } else {
                            currentList.get(i).setHealth(currentList.get(i).getHealth() - 10);
                        }
                    }
                }

            }

        }
        badges.entrySet().stream()
                .sorted((t1,t2) -> Integer.compare(t2.getValue(),t1.getValue()))
                .forEach(t-> System.out.printf("%s %d %d%n",t.getKey(),t.getValue(),trainers.get(t.getKey()).size()));
    }
}
