package p6;

public class Controller {
	private Viewer viewer;
	private Array7x7 array;
	
	/**
	 * Reads the row of the array given 
	 * by the parameter and displays it.
	 * 
	 * @param row  which row will be read 
	 */
	public void readRow(int row) {
		Array7 a7 = array.getRow(row);
		viewer.setRow(a7);
	}
	/**
	 * Reads the column of the array given 
	 * by the parameter and displays it.
	 * 
	 * @param col  which column will be read 
	 */
	public void readCol(int col) {
		Array7 a7 = array.getCol(col);
		viewer.setColum(a7);
	}
	
	/**
	 * Writes the array given by the parameter
	 * on the row given by the parameter
	 * 
	 * @param row  in which row the array will be written
	 * @param arr7  the array to be written
	 */
		public void writeRow(int row, Array7 arr7) {
		viewer.setRowInArray(row,arr7);
	}

	/**
	 * Writes the array given by the parameter
	 * on the column given by the parameter
	 * 
	 * @param col  in which column the array will be written
	 * @param arr7  the array to be written
	 */
	public void writeCol(int col, Array7 arr7) {
		viewer.setColumInArray(col,arr7);
	}
	
}
