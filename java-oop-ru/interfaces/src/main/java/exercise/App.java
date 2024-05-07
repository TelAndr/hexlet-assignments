package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class App {
	public static List<String> buildApartmentsList(List<Home> apartments, int n) {
		Comparator<Home> compareByArea = Comparator
                        .comparing(Home::getArea);
		List result = apartments.stream().sorted(compareByArea).    //sorted((o1, o2)->o1.getArea().
                                   //compareTo(o2.getArea())).
								   limit(n).
								   map(Home::toString). 
                                   toList(); //collect(Collectors.toList());
		//int sizeApart = apartments.size();
		//List<Home> firstPart = new ArrayList<>(apartments.subList(0, n));
		//List<Home> secondPart = new ArrayList<>(apartments.subList(n, sizeApart));
		//Collections.sort(firstPart); 
		//var strRepresList = firstPart.stream()
        //                    .map(firstPartElem -> firstPartElem.toString())
        //                    .toList();
		return result;
	}
}
// END
