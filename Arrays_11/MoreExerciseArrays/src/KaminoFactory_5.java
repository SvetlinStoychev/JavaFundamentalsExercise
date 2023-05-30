import java.util.Scanner;

public class KaminoFactory_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int lengthSequences = Integer.parseInt(reader.nextLine());
        String userInput = reader.nextLine();

        int resultSequenceCnt = 0;
        int resultStartIndex = -1;
        int[] resultSequence = new int[lengthSequences];
        int resultSum = 0;
        int bestSample = 1;
        int bestSampleCnt = 1;
        int maxSum = 0;
        int maxSumSemple = 0;
        int[] maxSumSempleArr = new int[lengthSequences];

        while (!userInput.equals("Clone them!")) {

            int[] currentSequence = new int[lengthSequences];
            int indexCnt = 0;
            int currentSum = 0;


            for (int i = 0; i < userInput.length(); i++) {

                if (userInput.charAt(i) == '1') {
                    currentSequence[indexCnt] = 1;
                    currentSum++;
                    indexCnt++;
                }  else if (userInput.charAt(i) == '0') {
                    currentSequence[indexCnt] = 0;
                    indexCnt++;
                }
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumSemple = bestSampleCnt;
                maxSumSempleArr = currentSequence;
            }

            int bestCntSequence = 1;
            int bestStartIndex = -1;
            for (int i = 0; i < currentSequence.length; i++) {

                int sequenceCnt = 1;
                int sequenceStartIndex = i;
                for (int j = i + 1; j < currentSequence.length; j++) {
                    if (currentSequence[i] == 1 && currentSequence[j] == 1) {
                        sequenceCnt++;
                    } else {
                        break;
                    }
                }

                if (sequenceCnt > bestCntSequence) {
                    bestCntSequence = sequenceCnt;
                    bestStartIndex = sequenceStartIndex;
                }
            }

            if (bestCntSequence > resultSequenceCnt) {
                resultSequenceCnt = bestCntSequence;
                resultStartIndex = bestStartIndex;
                resultSequence = currentSequence;
                resultSum = bestCntSequence;
                bestSample = bestSampleCnt;
            } else if (bestCntSequence == resultSequenceCnt) {
                if (bestStartIndex < resultStartIndex) {
                    resultStartIndex = bestStartIndex;
                    resultSequence = currentSequence;
                    resultSum = bestCntSequence;
                    bestSample = bestSampleCnt;
                } else if (bestStartIndex == resultStartIndex) {
                    if(maxSum > currentSum) {
                        resultSum = maxSum;
                        resultSequence = maxSumSempleArr;
                        bestSample = maxSumSemple;
                    } else {
                        resultSum = currentSum;
                        resultSequence = currentSequence;
                        bestSample = bestSampleCnt;
                    }
                }
            }

            bestSampleCnt++;
            userInput = reader.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSample, resultSum);

        for (int i = 0; i < resultSequence.length; i++) {
            System.out.printf("%d ", resultSequence[i]);
        }
    }
}
