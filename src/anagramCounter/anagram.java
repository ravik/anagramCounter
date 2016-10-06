package anagramCounter;


import java.util.*;

public class anagram {
	static HashMap<Character, Integer> l2a = new HashMap<Character, Integer>();
	static int[] nums = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27};
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
		String[] in = {"abc","def","cba","efd","ghi"};
		System.out.println(pairOfAnagrams(in));
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
