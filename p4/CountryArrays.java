package arrays;

public class CountryArrays {

	public static String toString(Country[] array) {
		String str = "{";
		for(int i=0;i<array.length-1;i++) {
			str+="["+array[i].getName()+","+array[i].getPopulation()+"], ";
		}
		str+="["+array[array.length-1].getName()+","+array[array.length-1].getPopulation()+"]}";
		
		return str;
	}

	public static int indexOf(Country[] array, Country country) {
		int indexOf=-1;
		for(int i=0;i<array.length;i++) {
			if(country.equals(array[i])) {
				indexOf=i;
			}
		}
		return indexOf;
	}

	public static boolean member(Country[] array, Country country) {
		boolean isMember=false;
		for(int i=0;i<array.length;i++) {
			if(country.equals(array[i])) {
				isMember=true;
			}
		}
		return isMember;
	}

	public static Country min(Country[] array) {
		long min = Integer.MAX_VALUE;
		Country c = null;
		for(int i=0;i<array.length;i++) {
			if(array[i].getPopulation()<min) {
				min = array[i].getPopulation();
				c=array[i];
			}
		}
		return c;
	}

	public static Country max(Country[] array) {
		long max = 0;
		Country c = null;
		for(int i=0;i<array.length;i++) {
			if(array[i].getPopulation()>max) {
				max = array[i].getPopulation();
				c=array[i];
			}
		}
		return c;
	}
	
}
