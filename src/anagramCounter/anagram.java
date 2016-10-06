package anagramCounter;


import java.util.*;

public class anagram {
	static HashMap<Character, Integer> l2a = new HashMap<Character, Integer>();
	static int[] nums = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107};
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	
	public static void createHashMap(){
		for (int i = 0; i < alpha.length(); i++){
			l2a.put(alpha.charAt(i), nums[i]);
		}
	}
	
	public static int returnHash(char[] input){
		int hash = 1;
		for (char a: input){
			hash*= l2a.get(a);
		}
		return hash;
	}
	
	
	public static void main(String args[]){
		createHashMap();
		Scanner a = new Scanner(System.in);
		System.out.println("Enter number of entries: ");
		int count = Integer.parseInt(a.nextLine());
		String[] in = new String[count];
		for (int i = 0; i < count; i++){
			System.out.println("Enter next string: ");
			in[i] = a.nextLine();
			System.out.println();
		}
		
		System.out.println("There are "+ pairOfAnagrams(in) + "pair(s) of anagrams in that string.");
	}


	public static int pairOfAnagrams(String[] in) {
		int number = 0; // number of unique anagrams
		HashSet<Integer> data = new HashSet<Integer>(); //set of unique anagrams
		for (String current: in) {
			if (!data.contains(returnHash(current.toCharArray()))) { //check if new string isn't contained in the set
				data.add(returnHash(current.toCharArray())); //add it to the set
			}
		}
		for (int a: data) {
			number++; // for each string in the set, increment the number of unique anagrams
		}
		return number;
	}
}
