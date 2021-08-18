import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles20_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String [] tokens = scan.nextLine().split(",");
            Article article = new Article(tokens[0],tokens[1],tokens[2]);
            articles.add(article);

        }
        String command = scan.nextLine();

        articles.stream()
        .sorted((a1, a2) -> {
            int res = 0 ;
            if (command.equals("title")){
                res = a1.getTitle().compareTo(a2.getTitle());
            } else if (command.equals("content")){
                res = a1.getContent().compareTo(a2.getContent());
            } else if (command.equals("author")) {
                res = a1.getAuthor().compareTo(a2.getAuthor());
            }
            return res;
        })
                .forEach(article -> System.out.printf("%s -%s:%s%n",article.getTitle(),article.getContent(),article.getAuthor()));

    }


    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public String getTitle(){
            return title;
        }
        public String getContent(){
            return content;
        }
        public String getAuthor(){
            return author;
        }
    }
}
