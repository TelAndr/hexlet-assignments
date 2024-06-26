package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

// BEGIN
public class App {
	//private Car instance;
    public static void save(Path objPath, Car objCar) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(String.valueOf(objPath))))
        {
            String jsonRepresentation = objCar.serialize();
			oos.writeUTF(jsonRepresentation);
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        } 
	}
	public static Car extract(Path objPath) {
        Car instance = new Car();
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(String.valueOf(objPath))))
        {
            String jsonRepresentation = ois.readUTF(); //(Car)ois.readUTF();
			instance = Car.unserialize(jsonRepresentation);
            //System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());
			//return instance;
        }
        catch(Exception ex){
             
            System.out.println(ex.getMessage());
        }
	    return instance;
    }
}
// END
