public enum StudentTypes {
    DRAGON("dragon"),GNOME("gnome"),FAIRIE("fairie"),UNICORN("unicorn"),FROG("frog");
    private final String name;

    StudentTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
