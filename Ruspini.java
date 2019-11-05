import java.util.Scanner;

public class Ruspini {
    public static void main(String[] args) {
        double miu = 0.1;
        Controller controller = new Controller();
        Service service = new Service();
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        int epoch = controller.getEpoch();
        String fileName = "/Users/oktaviacitra/Documents/MachineLearning/NN/ruspini.csv";
        int[] size = service.get2DArraySize(fileName);
        int[][] dataSet = service.readFile(fileName, size);
        // controller.print2DArray(dataSet);
        dataSet = service.updateLabelRuspini(dataSet);
        // controller.print2DArray(dataSet);
        int[][] trainingData = service.split2Columns(dataSet);
        int[] target = service.split1Column(2, dataSet);
        int[][] input = neuralNetwork.initialization(trainingData);
        double[] weight = neuralNetwork.initialWeight();
        controller.printInitial(input, weight, target);
        for (int i = 0; i < epoch; i++) {
            System.out.println("\nEPOCH-" + (i + 1));
            double[] summation = new double[size[0]];
            int[] output = new int[size[0]];
            String[] info = new String[size[0]];
            String[] temp = new String[size[0]];
            for (int j = 0; j < size[0]; j++) {
                summation[j] = neuralNetwork.getSummation(weight, input[j]);
                output[j] = neuralNetwork.getOutput(summation[j], 0.0);
                info[j] = neuralNetwork.getError(output[j], target[j]);
                if (info[j].equals("ERROR")) {
                    int error = target[j] - output[j];
                    weight = neuralNetwork.getWeight(weight, input[j], error, miu);
                }
                temp[j] = controller.printRow(weight);
            }
            controller.printTable(input, summation, output, target, info, temp);
        }
        String answer = "y";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            int[] testingData = controller.getInput();
            double testingSummation = neuralNetwork.getSummation(weight, testingData);
            int outputTesting = neuralNetwork.getOutput(testingSummation, 0.0);
            String testingWeight = controller.printRow(weight);
            System.out.printf("Input-1\tInput-2\tInput-3\tSummation\tOutput\tWeight\n%d\t%d\t%d\t%.2f\t\t%d\t%s\n",
                    testingData[0], testingData[1], testingData[2], testingSummation, outputTesting, testingWeight);
            System.out.print("Apakah anda ingin melanjutkan (y/t)?");
            answer = scanner.nextLine();
        } while (answer.equals("y"));
    }
}