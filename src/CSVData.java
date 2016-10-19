import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * A class to read/write numerical CSV Files and allow easy access
 * 
 * @author mkapila779
 *
 */
public class CSVData {
	private double[][] data;
	private String[] columnNames;
	private int row, numLinesToIgnore, rowIndex, colIndex;
	private double newValue;
	private String colName;
	private double[] arr, row0;
	private int numRows;
	private String filePathToCSV;

	public double[] getArr() {
		return arr;
	}

	public void setArr(double[] arr) {
		this.arr = arr;
	}

	public static CSVData readCSVFile(String filename, int numLinesToIgnore, String[] columnNames) {
		return null;
	}

	public CSVData(String filepath, String[] columnNames, int startRow) {
		this.filePathToCSV = filepath;

		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split("\n");

		// number of data points
		int n = lines.length - startRow;
		this.numRows = n;
		int numColumns = columnNames.length;

		// create storage for column names
		this.columnNames = columnNames;

		// create storage for data
		this.data = new double[n][numColumns];
		for (int i = 0; i < lines.length - startRow; i++) {
			String line = lines[startRow + i];
			String[] coords = line.split(",");
			for (int j = 0; j < numColumns; j++) {
				if (coords[j].endsWith("#"))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
	}

	private String readFileAsString(String filepath) {
		StringBuilder output = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filepath))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				output.append(line + System.getProperty("line.separator"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	/***
	 * Returns a new CSVData object for a file ignore lines at the top It uses
	 * the first row as the col names. All other data is stoered as doubles.
	 * 
	 * @param filenames
	 * @param NumLinesToIgnore
	 * @return a CSVData object for that file
	 */
	public static CSVData readCSVFile(String filenames, int numLinesToIgnore) {
		// numLinesToIgnore;

		return null;
	}

	/***
	 * get individual rows
	 * 
	 * @param rowNumber
	 *            index of the row to return
	 * @return the row we're returning
	 */
	public double[] GetRow(int rowNumber) {

		return null;
	}

	/***
	 * get individual cols
	 * 
	 * @param colName,
	 *            its name
	 * @return individual col we're returning
	 */
	public double[] GetCol(String colName) {
		return null;
	}

	/***
	 * Get a whole Row
	 * 
	 * @param rowNumberIndex
	 * @return New set value in the whole row
	 */
	public double[][] GetRow(int[] rowNumberIndex) {
		
		int[][] arr = new int[row0.length][0];
		for (int j = 0; j < colName.length(); j++) {
			if (colName == columnNames[j]) {
				int a = j;
			}
		}
		for (int i = 0; i < row0.length; i++) {
			arr[i][0] = data[rowNumberIndex][a];
		}
		return arr;

		return null;
	}

	/***
	 * Get a whole Col
	 * 
	 * @param colName
	 * @return New set value in the whole col
	 */
	public double[][] GetCol(String[][] colName) {
		int a = -1;
		double[][] arr = new double[0][row0.length];
		for (int j = 0; j < row0.length; j++) {
			if (columnNames[j] == colName) {
				a = j;
			}
		}
		for (int i = 0; i < row0.length; i++) {
			arr[a][i] = data[i][a];
		}
		return arr;

		return null;
	}

	/***
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @param newValue
	 *            Save newValues to CSVData
	 */
	public void SetIndividualEnteries(int rowIndex, int colIndex, double newValue) {
		data[rowIndex][colIndex] = newValue;
	}

	/***
	 * @param rowIndex
	 *            Save row values
	 */
	public void SetIndividualRow(int rowIndex, int value) {
		for (int i = 0; i < colName.length(); i++) {
			data[rowIndex][i] = value;
		}
	}

	/***
	 * @param colName,
	 *            value, String array columnName Save col values
	 */
	public void SetIndividualCol(String colName, int value, String[] columnName) {
		int a=-1;
		for (int j = 0; j < columnName.length; j++) {
			if (colName == columnName[j]) {
				a = j;
			}
		}
		for (int i = 0; i < row0.length; i++) {

			data[i][a] = value;
		}
	}

	/***
	 * 
	 * @param columnName
	 * @return changed titles of col
	 */
	public String[] Titles(String[] columnName) {
		columnName[0] = "time (ms)";
		columnName[1] = "accel (x)";
		columnName[2] = "accel (y)";
		columnName[3] = "accel (z)";
		return null;
	}

	public void saveToFiles(String FileName) {

	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getNumLinesToIgnore() {
		return numLinesToIgnore;
	}

	public void setNumLinesToIgnore(int numLinesToIgnore) {
		this.numLinesToIgnore = numLinesToIgnore;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}

	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

	public double getNewValue() {
		return newValue;
	}

	public void setNewValue(double newValue) {
		this.newValue = newValue;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

}
