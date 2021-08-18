import java.util.Scanner;

public class Articles_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] input = scan.nextLine().split(",");
        int n = Integer.parseInt(scan.nextLine());
        Article article = new Article(input[0],input[1],input[2]);
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(":");
            String command = tokens[0];
            String replace = tokens[1];
            switch (command){
                case "Edit":
                    article.setContent(replace);
                    break;
                case "Rename":
                    article.setTitle(replace);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(replace);
                    break;
            }

        }
        System.out.printf("%s -%s:%s%n",article.getTitle(),article.getContent(),article.getAuthor());

    }
    static class Article{
        String title;
        String content;
        String author;

        public Article(String title, String content, String author){
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public String getTitle(){
            return title;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getContent(){
            return content;
        }
        public void setContent(String content){
            this.content = content;
        }
        public String getAuthor(){
            return author;
        }
        public void setAuthor(String author){
            this.author = author;
        }
    }
}
