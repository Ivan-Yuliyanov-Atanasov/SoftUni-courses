import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;


public class NestedFolders_08 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\user\\Desktop\\SoftUni\\Java Advanced" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
        int counter = 0;
        ArrayDeque <File> files = new ArrayDeque<>();
        files.offer(file);
        while(!files.isEmpty()){
            File innerFile = files.poll();
            if(innerFile.isDirectory()){
                File [] innerFiles = innerFile.listFiles();
                for (File f :innerFiles) {
                    if(f.isDirectory()){
                        files.offer(f);
                        System.out.println(f.getName());
                        counter++;
                    }
                }


            }
        }
        System.out.println(counter + " folders");

    }
}

