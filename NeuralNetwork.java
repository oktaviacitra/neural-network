import java.util.Random;

public class NeuralNetwork {

  public NeuralNetwork() {

  }

  public int[][] initialization(int[][] data) {
    int row = data.length;
    int column = data[0].length + 1;
    int[][] result = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (j == 0) {
          result[i][j] = 1;
        } else {
          result[i][j] = data[i][j - 1];
        }
      }
    }
    return result;
  }

  public double getSummation(double[] weight, int[] input) {
    int size = weight.length;
    double result = 0.0;
    for (int i = 0; i < size; i++) {
      result += (weight[i] * input[i]);
    }
    return result;
  }

  public int getOutput(double summation, double threshold) {
    int result;
    if (summation > threshold) {
      result = 1;
    } else {
      result = 0;
    }
    return result;
  }

  // public boolean getInfo(double output, double target) {
  // boolean result;
  // if (output == target) {
  // result = true;
  // } else {
  // result = false;
  // }
  // return result;
  // }

  public double[] getWeight(double[] weight, int[] input, int error, double miu) {
    int size = weight.length;
    double[] result = new double[size];
    for (int i = 0; i < size; i++) {
      result[i] = weight[i] + miu * input[i] * error;
    }
    return result;
  }

  public double[] initialWeight() {
    double[] result = new double[3];
    Service service = new Service();
    for (int i = 0; i < 3; i++) {
      result[i] = service.getRandomDecimal(-1, 1);
    }
    Random r = new Random();
    int position = r.nextInt(3);
    result[position] = (-1) * result[position];
    return result;
  }

  public String getError(int output, int target) {
    String result = "";
    if (output == target) {
      result = "FIX";
    } else {
      result = "ERROR";
    }
    return result;
  }
}