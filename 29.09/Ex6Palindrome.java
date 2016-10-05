class Ex6Palindrome {
    public static void main(String[] args) {

        String text = args[0];
        if (text.length() == 0) {
        	System.out.print("String length must be greater than zero");
            System.exit(0);
        }
        if (isPalindrome(text)) System.out.print("It is palindrome");
        else System.out.print("It isn't palindrome");

    }

    public static boolean isPalindrome(String text) {

        String cleanText = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] line = cleanText.toCharArray();

        boolean isSame = true;

        for (int i = 0; i < line.length/2; i++) {
            if (line[i] != line[line.length - 1 - i]) isSame = false;
        }

        return isSame;
    }
}