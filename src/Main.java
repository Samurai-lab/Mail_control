import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static final Pattern addPattern = Pattern.compile("(?i)add");
    public static void main(String[] rgs) {
        SortedSet<String> treeSet = new TreeSet<>();
        System.out.println("Добро пожаловать в базу почт mail");
        while (true) {
            System.out.println("Список команд: \nLIST - вывести лист добавленных ранее почт \nADD - добавить почту в базу");
            System.out.print("Введите одну из вышепредставленных комманд: ");
            Scanner scanner = new Scanner(System.in);
            String mail = scanner.nextLine();
            Matcher addMatcher = addPattern.matcher(mail);
            boolean addControl = addMatcher.find() &&  mail.matches("^[a-zA-Z]{3}\\s(.+@.+\\..+)$");
            if (mail.equalsIgnoreCase("list")) {
                for (String s : treeSet){
                    System.out.println(s);
                }
                Random random = new Random(30);
                SortedSet<Integer> is = new TreeSet<>();
                for(int i = 0; i < 25; i++) {
                    is.add(random.nextInt(10));
                }
                //Добавление строки в древо
            } else if (!addControl) {
                System.out.println("Вы ввели неверный формат почты. Пожалуйста повторите попытку");
            } else {
                    //Отграничиваем пробелами
                    String[] split = mail.split(" ");
                    //Отствупаем, чтобы add не попало в древо
                    String add = mail.substring(split[0].length() + 1);
                    //Заносим почту
                    treeSet.add(add);
            }
        }
    }
}