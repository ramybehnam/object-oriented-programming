package arrays;

import java.util.Arrays;

public class Integer2DArrays {
	public static String toString(int[][] array) {		
		String str ="{";
		int i;
		for (i = 0; i < array.length-1; i++) {
			str+="{";
			for (int j = 0; j < array[i].length-1; j++) {
				str+=array[i][j];
				str+= ",";
			}	
			str+=array[i][array[i].length-1]+"},";
		}
		str+="{";
		for(int k=0;k<array[i].length-1;k++) {
			str+=array[i][k]+",";
		}
		str+=array[i][array[i].length-1]+"}}";

		return str;		
	}

	public static String elements(int[][] array) {
		int counter=0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				counter++;
			}
		}
		return ""+counter;
	}

	public static String max(int[][] array) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				if(array[i][j]>max) {
					max=array[i][j];
				}
			}
		}
		return ""+max;
	}

	public static String min(int[][] array) {
		int min=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[array.length-1].length;j++) {
				if(array[i][j]<min) {
					min=array[i][j];
				}
			}
		}
		return ""+min;
	}

	public static String sum(int[][] array) {
		int sum=0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum+=array[i][j];
			}
		}
		return ""+sum;
	}

	public static Object average(int[][] array) {
		int sum=0,counter=0;
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum+=array[i][j];
				counter++;
			}
		}
		return (float)sum/counter;
	}
}
