package homework15;

import java.io.IOException;

class Test
{
    public static void main(String[] args)
    {
        UserData userData = new UserData("John","john123@mail.com", 19);
        String filename = "src/user.txt";



        try {
            userData.serialize(filename);

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        UserData userData1 = new UserData();

        // Deserialization
        try
        {
            userData1.deserialize(filename);

            System.out.println("Object has been deserialized ");
            System.out.println("name : " + userData1.name);
            System.out.println("email : " + userData1.email);
            System.out.println("age : " + userData1.age);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}