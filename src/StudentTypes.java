import java.io.Serializable;

public enum StudentTypes implements Serializable {
    DRAGON("\u001B[31m"), GNOME("\u001B[33;1m"), FAIRY("\u001B[35m"), UNICORN("\u001B[34;1m"), FROG("\u001B[32m");
    private final String name;

    StudentTypes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
