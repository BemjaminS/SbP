import java.io.FileNotFoundException;
import java.io.IOException;

public class runner {
    
    public static void main(String[] args) throws IOException {

        studentDS studentArray = new studentDS();
        studentArray.initDs();
        studentArray.addStudent("Ben swisa", "2055", 2, 82.5);
        studentArray.printDS();
        studentArray.searchById("3313");
        studentArray.SearchByAvgRange(75, 90);
        studentArray.searchByYear(3);
        
        


        
    }
}
