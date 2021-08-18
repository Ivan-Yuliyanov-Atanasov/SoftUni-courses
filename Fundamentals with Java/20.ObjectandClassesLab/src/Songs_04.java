import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split("_");
            String type = input[0];
            String name = input[1];
            String time = input[2];
            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);

        }
        String songType = scan.nextLine();
        if (songType.equals("all")){
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if(song.getTypeList().equals(songType)){
                    System.out.println(song.getName());
                }

            }
        }

    }
    static class Song{
        String typeList;
        String name;
        String time;
        public String getTypeList(){
            return typeList;
        }
        public void setTypeList(String typeList){
            this.typeList = typeList;
        }
        public String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getTime(){
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
    }
}
