import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SantaPresentFactory_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicValueQueue = new ArrayDeque<>();
        int [] materials = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] levelValue = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int doll = 0;
        int woodenTrain = 0;
        int teddyBear = 0;
        int bicycle = 0;
        Map<String,Integer> presents = new TreeMap<>();

        for (int i = 0; i < materials.length; i++) {
//            if(materials [i] != 0){
                materialsStack.push(materials[i]);
//            }
        }
        for (int i = 0; i < levelValue.length; i++) {
//            if(levelValue[i] !=0 ){
                magicValueQueue.offer(levelValue[i]);
//            }
        }

        while(!materialsStack.isEmpty() && !magicValueQueue.isEmpty()){
            int currentMaterial = materialsStack.peek();
            int currentMagic = magicValueQueue.peek();
            int total = currentMagic * currentMaterial;
            if(total == 150 || total == 250 || total == 300 || total == 400){
                switch (total){
                    case 150:
                        doll++;
                        magicValueQueue.poll();
                        materialsStack.pop();
                        presents.putIfAbsent("Doll",0);
                        presents.put("Doll",presents.get("Doll") + 1);
                        break;
                    case 250:
                        woodenTrain++;
                        magicValueQueue.poll();
                        materialsStack.pop();
                        presents.putIfAbsent("Wooden train",0);
                        presents.put("Wooden train",presents.get("Wooden train") + 1);
                        break;
                    case 300:
                        teddyBear++;
                        magicValueQueue.poll();
                        materialsStack.pop();
                        presents.putIfAbsent("Teddy bear",0);
                        presents.put("Teddy bear",presents.get("Teddy bear") + 1);
                        break;
                    case 400:
                        bicycle++;
                        magicValueQueue.poll();
                        materialsStack.pop();
                        presents.putIfAbsent("Bicycle",0);
                        presents.put("Bicycle",presents.get("Bicycle") + 1);
                        break;

            }

            } else if (currentMaterial == 0 || currentMagic == 0) {
                if (currentMaterial == 0) {
                    materialsStack.pop();
                }
                if (currentMagic== 0) {
                    magicValueQueue.poll();
                }

            }
            else if (total < 0){
                int sum = currentMagic + currentMaterial;
                magicValueQueue.poll();
                materialsStack.pop();
//                if(sum != 0){
                    materialsStack.push(sum);
//                }
            } else if (total > 0){
                currentMaterial += 15;
                materialsStack.pop();
//                if(materialNewValue != 0){
                    materialsStack.push(currentMaterial);
//                }
                magicValueQueue.poll();
            }

        }
        if((presents.containsKey("Doll") && presents.containsKey("Wooden train"))){
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if ((presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"))){
            System.out.println("The presents are crafted! Merry Christmas!");
        }
          else {
            System.out.println("No presents this Christmas!");
        }
        if(!magicValueQueue.isEmpty()){
            System.out.println("Magic left" + magicValueQueue.toString().replace("[","").replace("]",""));
        }
        if (!materialsStack.isEmpty()){
            System.out.println("Materials left: " + materialsStack.toString().replace("[","").replace("]",""));
        }
//        if (bicycle != 0){
//            System.out.println("Bicycle: " + bicycle);
//        }
//        if (doll != 0){
//            System.out.println("Doll: " + doll);
//        }
//        if (teddyBear != 0){
//            System.out.println("Teddy bear: " + teddyBear);
//        }
//        if (woodenTrain != 0){
//            System.out.println("Wooden train: " + woodenTrain);
//        }
        presents.entrySet().stream().forEach(p-> System.out.printf("%s: %d%n",p.getKey(),p.getValue()));

    }
}
