import java.util.Arrays;

class Developer extends ItisStudent implements Cloneable {
    private String workPlace;
    private int experience;
    private String[] technologyStack;

    Developer(String name, boolean hasPC, boolean frightenedWhenError, int msOfficeSkillLvl,
              int starsInGitHub, String programmingLanguage, String[] problemsSolutions,
              String workPlace, int experience, String[] technologyStack) {

        super(name, hasPC, frightenedWhenError, msOfficeSkillLvl, starsInGitHub, programmingLanguage, problemsSolutions);
        if (experience < 0) experience = 0;
        this.workPlace = workPlace;
        this.experience = experience;
        this.technologyStack = technologyStack;
    }

    public String[] getTechnologyStack() {
        return technologyStack;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    void tryReinstallWindows() {
        System.out.println("I'm not a System Administrator! It's not my business.");
    }

    @Override
    String code() {
        return "I can work with such technologies as: "
                + Arrays.toString(technologyStack) + ".  What do you exactly need?";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Developer developer = (Developer) o;

        if (experience != developer.experience) return false;
        if (!workPlace.equals(developer.workPlace)) return false;
        return Arrays.equals(technologyStack, developer.technologyStack);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + workPlace.hashCode();
        result = 31 * result + experience;
        result = 31 * result + Arrays.hashCode(technologyStack);
        return result;
    }

    @Override
    public String toString() {
        return "Developer name is " + getName() +
                ", Programming Language: " + getProgrammingLanguage() +
                ", Work place is " + workPlace +
                ", experience: " + experience + " year";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
