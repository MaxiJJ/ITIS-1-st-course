class OrdinaryUser implements Cloneable {
    private String name;
    private boolean hasPC;
    private boolean frightenedWhenError;
    private int msOfficeSkillLvl;

    OrdinaryUser(String name, boolean hasPC, boolean frightenedWhenError, int msOfficeSkillLvl) {
        if (!hasPC) {
            System.out.println("You can't be PC user, if you don't have the PC!");
            System.exit(0);
        }
        this.name = name;
        this.hasPC = hasPC;
        this.frightenedWhenError = frightenedWhenError;
        this.msOfficeSkillLvl = msOfficeSkillLvl;
    }

    void tryReinstallWindows() {
        System.out.println("I just ordinary PC user. I can't reinstall Windows! " +
                "But I have a good friend and he always help me with home appliances and computer");
    }

    void getError() {
        System.out.println("Oh my God! What it is? So, I just click \"Close\"!");
    }

    public String getName() {
        return name;
    }

    public boolean isHasPC() {
        return hasPC;
    }

    public boolean isFrightenedWhenError() {
        return frightenedWhenError;
    }

    public int getMsOfficeSkillLvl() {
        return msOfficeSkillLvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        OrdinaryUser ou = (OrdinaryUser) o;

        if (hasPC != ou.hasPC || frightenedWhenError != ou.frightenedWhenError
                || msOfficeSkillLvl != ou.msOfficeSkillLvl) return false;
        return name.equals(ou.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (hasPC ? 1 : 0);
        result = 31 * result + (frightenedWhenError ? 1 : 0);
        result = 31 * result + msOfficeSkillLvl;
        return result;
    }

    @Override
    public String toString() {
        return "Ordinary User's name is " + name +
                ", MS Office skill level: " + msOfficeSkillLvl;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
