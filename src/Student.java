public class Student implements Comparable<Student> {

    String firstName;
    String lastName;
    String starID;


    public Student() {
        firstName = null;
        lastName = null;
        starID = null;
    }

    public Student(  String first, String last, String starID ) {
        firstName = first;
        lastName = last;
        this.starID = starID;

    }

    public int compareTo( Student s ) {
        int d = this.lastName.compareTo(s.lastName);
        if(d == 0){
            d = this.firstName.compareTo(s.firstName);
            if(d == 0){
                d = this.starID.compareTo(s.starID);
            }
        }
        return d;
    }

    public String toString() {
        return( firstName + ", " + lastName + ": " + starID );
    }
}

