import java.util.Scanner;

public class Controller {
  public Controller() {

  }

  public int[] getInput() {
    Scanner scanner = new Scanner(System.in);
    int[] result = new int[3];
    result[0] = 1;
    for (int i = 1; i < 3; i++) {
      System.out.print("Masukkan testing data-" + i + "\t:");
      result[i] = scanner.nextInt();
    }
    return result;
  }

  public String printRow(double[] data) {
    String result = "";
    for (int i = 0; i < data.length; i++) {
      String temp = String.format("%.2f", data[i]) + " ";
      result += temp;
    }
    return result;
  }

  public void printInitial(int[][] input, double[] weight, int[] target) {
    System.out.println("Initialization\nInput-1\tInput-2\tInput-3\tTarget\tWeight:" + printRow(weight));
    // int count = 0;
    // for (int i = 0; i < input.length; i++) {
    // if (count < i) {
    // System.out.printf("%d\t%d\t%d\t%d\t%.2f\n", input[i][0], input[i][1],
    // input[i][2], target[i], weight[count]);
    // count++;
    // } else {
    // System.out.printf("%d\t%d\t%d\t%d\n", input[i][0], input[i][1], input[i][2],
    // target[i]);
    // }
    // }
    for (int i = 0; i < input.length; i++) {
      // if (count < i) {
      // System.out.printf("%d\t%d\t%d\t%d\t%.2f\n", input[i][0], input[i][1],
      // input[i][2], target[i], weight[count]);
      // count++;
      // } else {
      System.out.printf("%d\t%d\t%d\t%d\n", input[i][0], input[i][1], input[i][2], target[i]);
      // }
    }
  }

  public void printTable(int[][] input, double[] summation, int[] output, int[] target, String[] info,
      String[] weight) {
    System.out.println("Input-1\tInput-2\tInput-3\tSummation\tOutput\tTarget\tInfo\tWeight");
    for (int i = 0; i < target.length; i++) {
      System.out.printf("%d\t%d\t%d\t%.2f\t\t%d\t%d\t%s\t%s\n", input[i][0], input[i][1], input[i][2], summation[i],
          output[i], target[i], info[i], weight[i]);
    }
  }

  public void print2DArray(int[][] data) {
    System.out.print("\n");
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[0].length; j++) {
        System.out.print(data[i][j] + " ");
      }
      System.out.print("\n");
    }
    System.out.print("\n");
  }

  public void print1DArray(double[] data) {
    System.out.print("\n");
    for (int i = 0; i < data.length; i++) {
      System.out.println(data[i]);
    }
    System.out.print("\n");
  }

  public int getEpoch() {
    int result;
    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan Epoch\t\t: ");
    result = scanner.nextInt();
    System.out.print("\n");
    return result;
  }

  public double getMiu() {
    double result;
    Service service = new Service();
    result = service.getRandomDecimal(0, 1);
    return result;
  }
}