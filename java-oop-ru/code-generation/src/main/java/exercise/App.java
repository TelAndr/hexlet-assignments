package exercise;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.util.stream.Stream;

// BEGIN
public class App {
	//private Car instance;
    /*public static void save(Path objPath, Car objCar) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.valueOf(objPath))))
        {
            String jsonRepresentation = objCar.serialize();
			oos.writeUTF(jsonRepresentation);
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        } 
	}*/
	/*public static Car extract(Path objPath) throws IOException {
        //Files.lines(Paths.get(objPath.getFileName().toString()), Charset.forName("windows-1251"));
        Car instance = new Car();
        if (Files.exists(objPath)) {
            Stream<String> lines =  Files.lines(objPath, Charset.forName("windows-1251"));
            //try(ObjectInputStream ois = new ObjectInputStream(new FileInputStreagradlem(String.valueOf(objPath))))
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objPath.getFileName().toString())))
            {
                String jsonRepresentation = ois.readUTF(); //(Car)ois.readUTF();
                instance = Car.unserialize(jsonRepresentation);
            }
            catch(Exception ex){

                System.out.println(ex.getMessage());
            }
            lines.close();
        }
	    return instance;
    }*/
    public static void save(Path filePath, Car instance) throws Exception {
        String jsonRepresentation = instance.serialize();
        Files.writeString(filePath, jsonRepresentation, StandardOpenOption.WRITE);
    }

    public static Car extract(Path filePath) throws Exception {
        String jsonRepresentation = Files.readString(filePath);
        Car instance = Car.unserialize(jsonRepresentation);
        return instance;
    }
}
// END
