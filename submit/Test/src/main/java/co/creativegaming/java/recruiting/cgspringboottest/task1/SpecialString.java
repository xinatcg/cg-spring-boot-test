package co.creativegaming.java.recruiting.cgspringboottest.task1;

import java.util.ArrayList;
import java.util.List;

public class SpecialString {
	
	
	
	
    public static Boolean isSpecial(String strToCheck) {
        // TODO()
    	
    	boolean check1=false;
    	// achieve requirement 1 doesn't contain substrings bu ba be
    	if(!strToCheck.contains("bu")&&!strToCheck.contains("ba")&&!strToCheck.contains("be")) {
    		check1=true;
    	}
    	
    	// achieve requirement 2 contain at least three voweles;
    	//user an list to store vowels and then iterates the list
    	List<String> vowels = new ArrayList<>();
    	vowels.add("a");
    	vowels.add("e");
    	vowels.add("i");
    	vowels.add("o");
    	vowels.add("u");
    	boolean check2=false;
    	// use a count variable to count how many vowels that contain in the argument
    	int count=0;
    	for (int i=0;i<strToCheck.length();i++) {
    		//check each character(string) of the argument to see if there is a identical element in the list;
    		if (vowels.contains(String.valueOf(strToCheck.charAt(i)))){
    			//if so count ++
    			count++;
    		}
    	}
    	//if count is greater or equal than three then the argument doesn't satisfy requirement2;
    	if (count>=3) {
    		check2=true;
    	}
    	
    	//achieve requirement 3 contains a double letter
    	//iterate each charact of the argument
    	boolean check3=false;
    	for(int i=0;i<strToCheck.length();i++) {
    		//append each character by itself
    		String temp = strToCheck.charAt(i)+""+strToCheck.charAt(i);
    		//check if there is double letter
    		if(strToCheck.contains(temp)) {
    			//if so return true
    			check3=true;
    			break;
    		}
    	}
    	//System.out.println(check1 + "   " + check2 +"  " +check3);
    	if((check1==true&&check2==true)||(check1==true&&check3==true)||(check3==true&&check2==true)) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
