import java.util.Scanner;

public class KaminoFactory_5 {
    private static int currentSum = 0;
    private static int bestSum = 0;
    private static int longestSubsequenceOfOnes = 0;
    private static int[] bestDnaSequence = new int[0];
    private static int bestStartIndex = 0;
    private static int bestDnaSample = 1;
    private static boolean isCurrentSequenceLegal = true;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int dnaLength = Integer.parseInt(reader.nextLine());
        String inputCommand = reader.nextLine();

        int sampleCnt = 0;
        while (!inputCommand.equals("Clone them!")) {

            int[] currentDnaSequence = new int[dnaLength];
            currentDnaSequence = createCurrentSequence(inputCommand, dnaLength);

            if (!isCurrentSequenceLegal) {
                inputCommand = reader.nextLine();
                break;
            }
            sampleCnt++;

            int[] currentSubsequenceOfOnes = calculateSubsequenceOfOnes(currentDnaSequence);
            int currentSubsequenceLength = currentSubsequenceOfOnes[0];
            int currentSubsequenceStartIndex = currentSubsequenceOfOnes[1];

            if (currentSubsequenceLength > longestSubsequenceOfOnes) {
                longestSubsequenceOfOnes = currentSubsequenceLength;
                bestDnaSequence = currentDnaSequence;
                bestStartIndex = currentSubsequenceStartIndex;
                bestSum = currentSum;
                bestDnaSample = sampleCnt;
            } else if (currentSubsequenceLength == longestSubsequenceOfOnes) {
                if (currentSubsequenceStartIndex < bestStartIndex) {
                    bestDnaSequence = currentDnaSequence;
                    bestStartIndex = currentSubsequenceStartIndex;
                    bestSum = currentSum;
                    bestDnaSample = sampleCnt;
                } else if (currentSubsequenceStartIndex == bestStartIndex) {
                    if (currentSum > bestSum) {
                        bestDnaSequence = currentDnaSequence;
                        bestSum = currentSum;
                        bestDnaSample = sampleCnt;
                    } else {
                        bestDnaSequence = currentDnaSequence;
                    }
                }
            }

            inputCommand = reader.nextLine();
        }

        printBestDna();
    }

    private static void printBestDna() {
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaSample, bestSum);
        for (int i = 0; i < bestDnaSequence.length; i++) {
            System.out.printf("%d ", bestDnaSequence[i]);
        }
        //System.out.println();
    }

    private static int[] calculateSubsequenceOfOnes(int[] sequence) {
        int[] bestLengthOfOnes = new int[2];
        bestLengthOfOnes[0] = 0;
        bestLengthOfOnes[1] = 0;
        for (int i = 0; i < sequence.length - 1; i++) {

            int currentCnt = 0;
            if (sequence[i] == 1) {
                currentCnt++;
            }

            for (int j = i + 1; j < sequence.length ; j++) {
                if (sequence[i] == 1 && sequence[j] == 1) {
                    currentCnt++;
                } else {
                    break;
                }
            }

            if (currentCnt > bestLengthOfOnes[0]) {
                bestLengthOfOnes[0] = currentCnt;
                bestLengthOfOnes[1] = i;
            }
        }

        return bestLengthOfOnes;
    }

    private static int[] createCurrentSequence(String input, int length) {
        currentSum = 0;
        int[] result = new int[length];
        int arrCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                result[arrCnt] = 1;
                arrCnt++;
                currentSum++;
            } else if(input.charAt(i) == '0') {
                result[arrCnt] = 0;
                arrCnt++;
            }
        }

        if (arrCnt != result.length) {
            isCurrentSequenceLegal = false;
        }
        return result;
    }
}
