import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RandomNoGeneration {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//To generate random no*******
//Random random=new Random();
//int randomNo=random.nextInt(51);
//
//System.out.println("no is:"+randomNo);

		//reverse a string
//		String temp="";
//String str="aashu";
//String[] strArray=str.split("");
//for(int i=(str.length()-1);i>=0;i--){
//	temp=temp+strArray[i];
//	System.out.println("split value:"+strArray[i]);
//}
//System.out.println("Value:"+temp);

//Remove duplicates in a string
String str1="little";
String temp="";
String[] strArray=str1.split("");

Set<String> s=new TreeSet<String>();
for(int i=0;i<=(str1.length()-1);i++){
	s.add(strArray[i]);
	
}
for(String str:s){
	temp=temp+str;
System.out.println("String:"+temp);
	}

//Given 2 integer arrays, find common elements
	Integer[] intArray1=new Integer[]{12,34,13,43,434,1,2,3};
	Integer[] intArray2=new Integer[]{1,2,3,45,67,23,9,10,12,56,13,1,2,13};
	Set<Integer> intArray2Set=new HashSet<>();
	for(int i=0;i<intArray2.length;i++){
		intArray2Set.add(intArray2[i]);
		System.out.println("Set:"+intArray2Set.toString());
	}
	List<Integer> list=new ArrayList();

	for(int i=0;i<intArray1.length;i++){
		for(int j=0;j<intArray2.length;j++){
			int result=intArray1[i].compareTo(intArray2[j]);
			if(result==0){
				list.add(intArray1[i]);
			}
		}
	}
	int i=1;
	int j=0;
	while( i<=list.size()){
System.out.println("Common elements are:"+list.get(j));
i++;
j++;
	}
	
	List<String> list1=new ArrayList();
	list1.add("Aashu");
	list1.add("Jony");
	list1.add("Yashu");
	list1.add("Anshul");
	list1.add("Anu");
	//list1.forEach(list.iterator().next());

	}
	}





