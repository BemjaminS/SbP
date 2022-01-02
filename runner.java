import java.io.FileNotFoundException;
import java.io.IOException;

public class runner {
    
    public static void main(String[] args) throws IOException {

        studentDS studentArray = new studentDS();
        studentArray.initDs();
        studentArray.searchByYear(2);
        studentArray.SearchByAvgRange(72.2, 98.6);
        studentArray.delStudentById("5590");
        studentArray.searchById("5590");
        studentArray.searchById("111");
        studentArray.printLastAdded();
        studentArray.addStudent("Haim Levi", "7780", 3, 90.8);
        studentArray.addStudent("Ben swisa", "2201", 2, 88.5);
        studentArray.printLastAdded();
        studentArray.printDS();
        
        


        
    }
}
