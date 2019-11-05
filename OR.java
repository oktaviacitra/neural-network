public class OR {
    public static void main(String[] args) {
        double miu = 0.1;
        Controller controller = new Controller();
        Service service = new Service();
        int epoch = controller.getEpoch();
        String fileName = "/Users/oktaviacitra/Documents/MachineLearning/NN/Dummy.csv";
        int[] size = service.get2DArraySize(fileName);
        int[][] dataInt = service.readFile(fileName, size);
        // controller.print2DArray(dataInt);
        boolean[][] dataBoolean = service.intArrayToBooleanArray(dataInt);
        int[] target = service.targetOr(dataBoolean);
        NeuralNetwork neuralNetwork = new NeuralNetwork();
        int[][] input = neuralNetwork.initialization(dataInt);
        double[] weight = neuralNetwork.initialWeight();
        // double[] weight = { -0.3, 0.5, -0.4 };
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
    }
}