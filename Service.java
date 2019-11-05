import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Service {
  public Service() {

  }

  public double getRandomDecimal(int min, int max) {
    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }
    return (Math.random() * ((max - min) + 1 + (min - max) - (max - min)));
  }

  public int[][] readFile(String name, int[] size) {
    int[][] intArray = new int[size[0]][size[1]];
    String[] stringArray = new String[size[1]];
    String strLine = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(name));
      int count = 0;
      while (strLine != null) {
        strLine = br.readLine();
        if (strLine == null)
          break;
        stringArray = strLine.split(",");
        for (int i = 0; i < stringArray.length; i++)
          intArray[count][i] = Integer.valueOf(stringArray[i]);
        count++;
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return intArray;
  }

  public int[] get2DArraySize(String name) {
    int[] result = new int[2];
    String strLine = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(name));
      int count = 0;
      while (strLine != null) {
        strLine = br.readLine();
        if (strLine == null)
          break;
        result[1] = strLine.split(",").length;
        count++;
      }
      result[0] = count;
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  public int[][] split2Columns(int[][] data) {
    int row = data.length;
    int column = data[0].length - 1;
    int[][] result = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        result[i][j] = data[i][j];
      }
    }
    return result;
  }

  public int[] split1Column(int index, int[][] data) {
    int row = data.length;
    int column = data[0].length;
    int[] result = new int[row];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (j == index) {
          result[count] = data[i][j];
          count++;
        }
      }
    }
    return result;
  }

  // public int[] splitColumnInt(int index, int[][] data) {
  // int row = data.length;
  // int column = data[0].length;
  // int[] result = new int[row];
  // int count = 0;
  // for (int i = 0; i < row; i++) {
  // for (int j = 0; j < column; j++) {
  // if (j == index) {
  // result[count] = data[i][j];
  // count++;
  // }
  // }
  // }
  // return result;
  // }

  // public boolean[][] mergeColumnBoolean(boolean[] data1, boolean[] data2) {
  // int total = data1.length;
  // boolean[][] result = new boolean[total][2];
  // for (int i = 0; i < total; i++) {
  // result[i][0] = data1[i];
  // result[i][1] = data2[i];
  // }
  // return result;
  // }

  public boolean intToBoolean(int data) {
    boolean result;
    if (data == 0) {
      result = false;
    } else {
      result = true;
    }
    return result;
  }

  public int booleanToInt(boolean data) {
    int result;
    if (data == false) {
      result = 0;
    } else {
      result = 1;
    }
    return result;
  }

  public boolean[][] intArrayToBooleanArray(int[][] data) {
    int row = data.length;
    int column = data[0].length;
    boolean[][] result = new boolean[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        result[i][j] = intToBoolean(data[i][j]);
      }
    }
    return result;
  }

  public int[][] booleanArrayToIntArray(boolean[][] data) {
    int row = data.length;
    int column = data[0].length;
    int[][] result = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        result[i][j] = booleanToInt(data[i][j]);
      }
    }
    return result;
  }

  public int[] targetAnd(boolean[][] data) {
    if (data[0].length > 2) {
      throw new IllegalArgumentException("maximum of column total is 2");
    }
    int size = data.length;
    boolean[] temp = new boolean[size];
    for (int i = 0; i < size; i++) {
      temp[i] = data[i][0] && data[i][1];
    }
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = booleanToInt(temp[i]);
    }
    return result;
  }

  public int[] targetOr(boolean[][] data) {
    if (data[0].length > 2) {
      throw new IllegalArgumentException("maximum of column total is 2");
    }
    int size = data.length;
    boolean[] temp = new boolean[size];
    for (int i = 0; i < size; i++) {
      temp[i] = data[i][0] || data[i][1];
    }
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = booleanToInt(temp[i]);
    }
    return result;
  }

  public int[][] updateLabelRuspini(int[][] data) {
    int row = data.length;
    int column = data[0].length;
    int[][] result = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        int position = column - 1;
        if (j == position) {
          if (data[i][position] == 1 || data[i][position] == 3) {
            result[i][j] = 0;
          } else {
            result[i][j] = 1;
          }
        } else {
          result[i][j] = data[i][j];
        }
      }
    }
    return result;
  }
}
