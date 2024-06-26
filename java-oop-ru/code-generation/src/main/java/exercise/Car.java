package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.File;
@Getter
@NoArgsConstructor
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
	public String serialize() {
		final ObjectMapper mapper = new ObjectMapper(); // can use static singleton, inject: just make sure to reuse!
		//MyValue value = new MyValue();
		// ... and configure
		Car myCar = new Car();
		File newState = new File("my-stuff.json");
		//return mapper.writeValue(newState, this); // writes JSON serialization of MyValue instance
		return mapper.writeValueAsString(myCar);
	}
	public static Car unserialize(String nameJSON) {
		final ObjectMapper mapper = new ObjectMapper(); // can use static singleton, inject: just make sure to reuse!
		//MyValue value = new MyValue();
		// ... and configure
		// or, read
		//return mapper.readValue(new File(nameJSON), Car.class);
		return mapper.readValue(nameJSON, Car.class);
	}
    // END
}
