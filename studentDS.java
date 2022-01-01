import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class studentDS{
    static int index =0;
    private student[] ds;

    public studentDS(){
        this.ds= new student[50];
    }
    
    //----------------------------------------------------------------------------------------------->
    public void initDs() throws IOException{
        FileReader f = new FileReader("File.txt");
        BufferedReader br = new BufferedReader(f);
        
        while (br.ready()) {
            String name = br.readLine();
            String id = br.readLine();
            int year = Integer.parseInt(br.readLine());
            double avg = Double.parseDouble(br.readLine());
            br.readLine();//skip after 4 line

            student s = new student(name, id, year, avg);//create new student from the file
            this.ds[index]=s;//stored the student object in array
            index++;

        }
        f.close();
        br.close();
        
    } 
    //----------------------------------------------------------------------------------------------->
    public void searchById(String id){
        for (int i = 0; i < index; i++) {
            if (id.equals(this.ds[i].getId())) {
                System.out.println("Found By ID -------------> " + ds[i].toString());
            }
            else{
                System.out.println("Student not Found By ID");
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }
    //----------------------------------------------------------------------------------------------->
    public void addStudent(String name , String id , int year , double avg){    
        student s = new student(name, id, year, avg);
        ds[index] = s;
        index++;
    }
    //----------------------------------------------------------------------------------------------->
    public void printDS() throws IOException {
        FileWriter dsFile = new FileWriter("StudentDs.txt");
        PrintWriter pw = new PrintWriter(dsFile);
        
        for (int i = 0; i < index; i++) {
            pw.println(this.ds[i].getName());
            pw.println(this.ds[i].getId());
            pw.println(this.ds[i].getYear());
            pw.println(this.ds[i].getAvargae());
            pw.println();
        }

        pw.close();
        dsFile.close();

    }
    //----------------------------------------------------------------------------------------------->
    public void SearchByAvgRange(double x , double y){
        for (int i = 0; i < index; i++) {
            if (this.ds[i].getAvargae()>=x && this.ds[i].getAvargae()<=y) {
                System.out.println("Found Between This Avg's ->" + this.ds[i].toString());
            }
            else{
                System.out.println("Student Not Found Between This Avg's ");
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }
    //----------------------------------------------------------------------------------------------->
    public void searchByYear(int y){
        for (int i = 0; i < index; i++) {
            if (this.ds[i].getYear()==y) {
                System.out.println("Found Studing in "+ y +" year ->" + this.ds[i].toString() );
            }
            else{
                System.out.println("Student Not studing in This year ");
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }
    //----------------------------------------------------------------------------------------------->


    


    
}
