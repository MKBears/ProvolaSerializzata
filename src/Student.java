import java.io.Serializable;

public class Student implements Serializable {
    private StudentTypes type;

    public Student(StudentTypes type){
        this.type = type;
    }

    public StudentTypes getType() {
        return type;
    }

    public String toString() {
        return type.toString()+"(X)"+"\u001B[0m";
    }
}
