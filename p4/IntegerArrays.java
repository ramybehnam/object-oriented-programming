package arrays;

import java.util.Arrays;

public class IntegerArrays {
	public static String toString(int[] array) {		
		int l = array.length;
		String str = "{";
		for(int i=0;i<l-1;i++) str += array[i]+", ";
		str += array[l-1]+"}";
		return str;		
	}
	public static String max(int[] array) {
		int max = 0;
		for(int i=0;i<array.length;i++) if(array[i]>max) max=array[i];
		return ""+max;
	}
	public static String min(int[] array) {
		int min = Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++)	if(array[i]<min) min=array[i];
		return ""+min;
	}
	public static String sum(int[] array) {
		int sum = 0;
		for(int i=0;i<array.length;i++)sum += array[i];
		return ""+sum;
	}
	public static Object average(int[] array) {
		int sum = 0;
		for(int i=0;i<array.length;i++)sum += array[i];
		return (float)sum/array.length;
	}
	public static String range(int[] array) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0;i<array.length;i++) if(array[i]<min)min=array[i];		
		for(int i=0;i<array.length;i++) if(array[i]>max)max=array[i];
		return min+"-"+max;
	}
	public static int[] copy(int[] array) {
		int[] newArr = new int[array.length];
		for(int i=0;i<array.length;i++) {
			newArr[i]=array[i];
		}
		return newArr;
	}
	public static void sortAsc(int[] array) {	
		Arrays.sort(array); 
	}
	public static void sortDesc(int[] array) {
		int temp;
		Arrays.sort(array);
		for(int i=0;i<array.length/2;i++) {
			temp = array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=temp;		
		}
	}
	public static double median(int[] array) {
		int[] arr = array; 
		Arrays.sort(arr);
		double median;
		if (array.length % 2 == 0) median = ((double)arr[arr.length/2] + (double)arr[arr.length/2 - 1])/2;
		else median = (double) arr[arr.length/2];
		return median;
		
	}
	public static String mode(int[] array) {
		int mode = 0, counter = 0;
		int[] arr = array, counterArr;		
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(mode==arr[i]) {
				counter++;	
				mode = arr[i];
			}
		}
		
		
		return "";		
	}
}