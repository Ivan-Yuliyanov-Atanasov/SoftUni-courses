package Telephony;


import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String url : urls) {
            if(url.matches(".*\\d.*")){
                output.append("Invalid URL!").append(System.lineSeparator());
            } else {
                output.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            }
        }
        return output.toString();
    }


    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : numbers) {
            if(number.matches("[0-9]+")){
                output.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                output.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return output.toString();
    }
}
