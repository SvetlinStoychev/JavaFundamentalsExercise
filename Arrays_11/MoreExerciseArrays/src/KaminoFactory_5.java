import java.util.Scanner;

public class KaminoFactory_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int lengthSequences = Integer.parseInt(reader.nextLine());
        String userInput = reader.nextLine();

        int resultSequenceCnt = 0;
        int resultStartIndex = -1;
        int[] resultSequence = new int[lengthSequences];

        while (!userInput.equals("Clone them!")) {

            int[] currentSequence = new int[lengthSequences];
            int indexCnt = 0;

            for (int i = 0; i < userInput.length(); i++) {

                if (userInput.charAt(i) == '1') {
                    currentSequence[indexCnt] = 1;
                    indexCnt++;
                }  else if (userInput.charAt(i) == '0') {
                    currentSequence[indexCnt] = 0;
                    indexCnt++;
                }
            }

            int bestCntSequence = 0;
            int bestStartIndex = -1;
            for (int i = 0; i < currentSequence.length; i++) {

                int sequenceCnt = 1;
                int sequenceStartIndex = i;
                for (int j = i + 1; j < currentSequence.length; j++) {
                    if (currentSequence[i] == currentSequence[j]) {
                        sequenceCnt++;
                    }
                }

                if (sequenceCnt > bestCntSequence) {
                    bestCntSequence = sequenceCnt;
                    bestStartIndex = sequenceStartIndex;
                }
            }

            if (bestCntSequence > resultSequenceCnt) {
                resultSequenceCnt = bestStartIndex;
                resultStartIndex = bestStartIndex;
                resultSequence = currentSequence;
            } else if (bestCntSequence == resultSequenceCnt) {
                if (bestStartIndex < resultStartIndex) {
                    resultStartIndex = bestStartIndex;
                    resultSequence = currentSequence;
                }else if () {
                    
                }
            }

            userInput = reader.nextLine();
        }
    }
}
