import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        DoublyLinkedList<Student> dll = new DoublyLinkedList<Student>();

        File inputFile;
        String inputFileName;

        //ask user for the file they want to read
        System.out.println("Working directory = " + System.getProperty("user.dir"));

        //scans in the user file
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Please enter file name from the working directory: ");
            inputFileName = s.next();
            inputFile = new File(inputFileName);

            Scanner fileScanner = new Scanner(inputFile);

            String line = fileScanner.nextLine();

            while (!line.equals("")){


                String[] strArr = line.split(" ");
                Student s1 = new Student(strArr[0],strArr[1],strArr[2]);

                //if(dll.isEmpty()){
                    //dll.addNode(s1);

                //}

                //else{
                    //Node<E> current = dll.getHead();
                    //while
                dll.addNode(s1);

                line = fileScanner.nextLine();
            }


            dll.printNodes();

            s.close();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ///Users/kevintrinh/Desktop/ProgramC2/src/F1c.txt

}
