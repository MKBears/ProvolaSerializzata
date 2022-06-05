import java.io.Serializable;
import java.util.ArrayList;

public class Cloud implements Serializable {

    private final ArrayList<Student> students;
    private boolean hasBeenChosen;
    private final int nop;

    /**
     *
     * @param number_of_players necessary in order to know the number of Students to get
     * @throws Exception if the number of players is none between 2 and 3
     */
    public Cloud (int number_of_players) throws Exception{
        if(number_of_players==2 || number_of_players==4){
            students = new ArrayList<>(3);
            nop=3;
        }
        else if(number_of_players==3){
            students = new ArrayList<>(4);
            nop=4;
        }
        else
            throw new Exception("Wrong number of players");
        hasBeenChosen=false;
    }

    /**
     * refills the cloud automatically
     */
    public void importStudents(ArrayList<Student> students) throws Exception{
        this.students.addAll(students);
    }

    /**
     *
     * @return ArrayList that contains the students of the cloud
     */
    public ArrayList<Student> getStudents() {
        ArrayList<Student> s = (ArrayList<Student>) students.clone();
        students.clear();
        return s;
    }

    /**
     * changes to true the state "hasBeenChosen"
     */
    public void choose(){
        hasBeenChosen = true;
    }

    /**
     *
     * @return boolean valor: true if it has been chosen
     */
    public boolean hasBeenChosen(){
        return hasBeenChosen;
    }

    /**
     * turns the state "hasBeenChosen" to false
     */
    public void reset(){
        hasBeenChosen = false;
    }


    @Override
    public String toString() {
        String cloud;

        if (!students.isEmpty()) {
            cloud = "  # ## # ## #\n" +
                    " #    " + students.get(0).toString() + "    #\n" +
                    "  # " + students.get(1).toString() + " " + students.get(2).toString() + " #\n";

            if (nop == 4) {
                cloud = cloud + " #    " + students.get(3).toString() + "    #\n";
            }
            cloud += "   ## # ## #";
        }
        else {
            cloud = "Nuvola vuota";
        }

        return cloud;
    }
}
