package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEverydayDemo {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();
		
		names.add("Bryan");
		names.add("Aaron");
		names.add("Jason");
		
		Iterator<String> namesItr = names.iterator();
		
		/*for (String name : names) {
			System.out.println(name);
		}*/
		
		while(namesItr.hasNext()) {
			String name = namesItr.next();
			System.out.println(name);
			namesItr.remove();
		}
		
		System.out.println("Names size: " + names.size());
		
	}

}
