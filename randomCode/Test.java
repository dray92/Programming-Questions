package randomCode;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("no");
		list1.add("yes");
		list1.add("ok");
		list1.add("not");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("no");
		list2.add("but");
		list2.add("vote");
		list2.add("check");
		
		System.out.println("List1: " + Arrays.toString(list1.toArray()));
		System.out.println("List2: " + Arrays.toString(list2.toArray()));
		
		for(String s: list2)
		    set.add(s);

		String[] list3 = new String[list1.size()];
		list1.toArray(list3);
		for(String s: list3)
		    if(!set.add(s))
		        list1.remove(s);
		
		System.out.println("List1 AFTER: " + Arrays.toString(list1.toArray()));
		
		Path currentRelativePath = Paths.get("");
		String myPath = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + myPath);
	}
}
