import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyString str = new MyString("AbabB");
        System.out.println(str.charAt(1));
        System.out.println(new MyString("Abc"));
        str = str.concat(new MyString("CD"));
        System.out.println(str);
        System.out.println(str.equals(new MyString("AbabBCD")));
        System.out.println(str.indexOf(new MyString("bbA")));
        System.out.println(str.length());
        System.out.println(Arrays.toString(str.split('b')));
        System.out.println(str.substring(0,4));
    }
}