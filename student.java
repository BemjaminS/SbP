/**
 * student
 */
public class student {

    private String name;
    private String id;
    private int year;
    private double avargae;

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public int getYear() {
        return this.year;
    }

    public double getAvargae() {
        return this.avargae;
    }


    public student(String name , String id , int year, double avg){

        this.name = name;
        this.id=id;
        this.year=year;
        this.avargae=avg;

    }



    public String toString() {
        return "Name: " + name + " ID: " + id + " Year: " + year + " Avarage: " + avargae ;
    }

    
}