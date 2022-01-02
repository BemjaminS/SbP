import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class studentDS{
    int index =0;
    student sTemp;
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
            sTemp=s;
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
        sTemp=s;
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
        sortedList();
        

        pw.close();
        dsFile.close();

    }
    //----------------------------------------------------------------------------------------------->
    public void SearchByAvgRange(double x , double y){
        sortedList();
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

    public void sortedList(){
        student temp =null;
        for (int i = 0; i < index; i++) {
            for (int j = i+1; j < index; j++) {
                if (ds[j]==null) {
                    break;
                }
                if (ds[i].getAvargae()>ds[j].getAvargae()) {
                    temp = ds[i];
                    ds[i]=ds[j];
                    ds[j]=temp;
                }
            }
        }
    }
    //----------------------------------------------------------------------------------------------->

    public void printLastAdded(){
        System.out.println("Last added Student: " +  sTemp.toString());
    }
    //----------------------------------------------------------------------------------------------->

    public void delStudentById(String id){
        student [] tempArr = new student[50];
        for (int i = 0 , j=0 ; i < index; i++) {
            if (!(this.ds[i].getId().equals(id))) {
                tempArr[j++] = this.ds[i]; 
            }
            
        }
        this.ds=tempArr;//re-assaign the array after change
        index--;
    }

    //----------------------------------------------------------------------------------------------->

    
}
