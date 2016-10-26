import java.util.Arrays;

class ItisStudent extends OrdinaryUser implements Cloneable {
    private String programmingLanguage;
    private int starsInGitHub;
    private String[] problemsSolutions;

    ItisStudent(String name, boolean hasPC, boolean frightenedWhenError, int msOfficeSkillLvl,
                int starsInGitHub, String programmingLanguage, String[] problemsSolutions) {

        super(name, hasPC, frightenedWhenError, msOfficeSkillLvl);

        if (programmingLanguage.isEmpty()) {
            System.out.println("You a Programmer! You have to know programming language.");
            System.exit(0);
        }

        if (starsInGitHub < 0) starsInGitHub = 0;

        this.starsInGitHub = starsInGitHub;
        this.programmingLanguage = programmingLanguage;
        this.problemsSolutions = problemsSolutions;
    }

    @Override
    void tryReinstallWindows() {
        System.out.println("I'm a Programmer! I know how click a few button. Trust me and you get reinstalled Windows!");
    }

    @Override
    void getError() {
        int randomNum = (int) (Math.random() * problemsSolutions.length);

        System.out.println("Hmm... I've got a NullPointerException. What I should do?");
        System.out.println(problemsSolutions[randomNum]);
    }

    String code() {
        return "public class Main{\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World!\");\n" +
                "    }\n" +
                "}";
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public int getStarsInGitHub() {
        return starsInGitHub;
    }

    public String[] getProblemsSolutions() {
        return problemsSolutions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ItisStudent p = (ItisStudent) o;

        if (starsInGitHub != p.starsInGitHub ||
                !programmingLanguage.equals(p.programmingLanguage)) return false;

        return Arrays.equals(problemsSolutions, p.problemsSolutions);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + programmingLanguage.hashCode();
        result = 31 * result + starsInGitHub;
        result = 31 * result + Arrays.hashCode(problemsSolutions);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Programmer name is " + getName() +
                ", Programming Language: " + programmingLanguage +
                ", Count of stars in GitHub: " + starsInGitHub;
    }
}
