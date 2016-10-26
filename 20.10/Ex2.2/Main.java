public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        OrdinaryUser ou = new OrdinaryUser("Alesha", true, true, 2);
        ou.tryReinstallWindows();
        ou.getError();

        String[] problemsSolutions = {"Reboot PC", "Close and re-open the app", "Put somewhere bracket, suddenly help",
                "Hit the computer"};
        ItisStudent p = new ItisStudent("Maxim", true, false, 10, 1, "Java", problemsSolutions);

        System.out.println(p.getName());
        p.getError();
        p.tryReinstallWindows();
        p.code();

        String[] developerProblemSolution = {"I can't get error. I fix it 5 minutes ago. Exactly 5 minutes ago"};
        String[] techonologyStack = {"Java SE, Java EE, XML, JavaScript, Spring, Struts, CXF, WebSphere, DB2, MySQL, " +
                "AST, RADAD, Maven, SVN"};
        Developer d = new Developer("Vasya", true, false, 10, 1000, "Java", developerProblemSolution,
                "Google", 8, techonologyStack);

        System.out.println(d.code());
        Developer d2 = (Developer) d.clone();
        System.out.println("Name equals: " + d2.getName().equals(d.getName()));
        System.out.println("Developers equals: " + d.equals(d2));
        System.out.println("Developers hashcode equals: " + (d.hashCode() == d2.hashCode()));
    }
}
