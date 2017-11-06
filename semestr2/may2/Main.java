package course1.may2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Максим on 03.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        String text = "Sleep, sleep, beauty bright,\n" +
                "Dreaming in the joys of night;\n" +
                "Sleep, sleep; in thy sleep\n" +
                "Little sorrows sit and weep.\n" +
                "\n" +
                "Sweet babe, in thy face\n" +
                "Soft desires I can trace,\n" +
                "Secret joys and secret smiles,\n" +
                "Little pretty infant wiles. homeenglish.ru\n" +
                "\n" +
                "As thy softest limbs I feel\n" +
                "Smiles as of the morning steal\n" +
                "O'er thy cheek, docs.google.com and o'er thy breast\n" +
                "Where thy little heart doth rest.\n" +
                "\n" +
                "O the cunning wiles that creep\n" +
                "In thy little heart asleep!\n" +
                "When thy little heart doth wake,\n" +
                "Then the dreadful night shall break";
        String domainName = "habrahabr.ru";
        String email = "yalubludjavky@net.ru";

        findDomenNames(text);
        System.out.println();

        checkDomainName(text);
        checkDomainName(domainName);

        checkEmail(domainName);
        checkEmail(email);
    }
    public static void findDomenNames(String text) {
        Pattern p = Pattern.compile("([a-z0-9-]+\\.)+([a-z0-9-]+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        while(m.find()) {
            System.out.print(text.substring(m.start(), m.end()) + " , ");
        }
    }

    public static void checkDomainName(String domainName) {
        Pattern p = Pattern.compile("([a-z0-9-]+\\.)+([a-z0-9-]+)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(domainName);

        System.out.println(m.matches());
    }

    public static void checkEmail(String email) {
        Pattern p = Pattern.compile("[a-z\\d-]+@[a-z\\d-]+\\.[a-z\\d-]+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);

        System.out.println(m.matches());
    }
}
