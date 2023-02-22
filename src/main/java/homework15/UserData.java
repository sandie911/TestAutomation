package homework15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class UserData {
    public String name;
    public String email;
    public int age;

    public UserData() {

    }
    // Default constructor
    public UserData(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public void serialize(String filePath) throws IOException {
        //Saving of object in a file
        File file = new File(filePath);
        //if (!file.exists()) {
        file.createNewFile();
        //}
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fileWriter);
        if(name != null) {
            out.write(String.format("name: %s", name));
            out.newLine();
        }
        if(email != null) {
            out.write(String.format("email: %s", email));
            out.newLine();
        }
        if(age != 0) {
            out.write(String.format("age: %s", age));
            out.newLine();
        }
        out.close();
        fileWriter.close();
    }
    public void deserialize(String filePath) throws IOException, ClassNotFoundException {
        // Reading the object from a file
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        Scanner scanner = new Scanner(file);
        if(!scanner.hasNext("name:"))
            this.name = null;
        else {
            scanner.next();
            this.name = scanner.nextLine();
        }
        if(!scanner.hasNext("email:"))
            this.email = null;
        else {
            scanner.next();
            this.email = scanner.nextLine();
        }
        if(!scanner.hasNext("age:"))
            this.age = 0;
        else {
            scanner.next();
            this.age = scanner.nextInt();
        }
    }
}
