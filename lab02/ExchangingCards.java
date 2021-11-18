import java.io.*;
import java.util.TreeSet;

public class ExchangingCards {
    public static void main(String[] args) throws IOException{
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        OutputStreamWriter ow = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(ow);

        boolean isFirstLine = true;
        while (true){
            String in = br.readLine();
            if (in.equals("0 0"))
                break;
            if (isFirstLine){
                isFirstLine = false;
            }else{
                bw.newLine();
            }

            in = br.readLine();
            int[] alicesDeck = parseStringToIntArr(in);
            TreeSet<Integer> alicesUniqueCards = getUniquesInDeck(alicesDeck);

            in = br.readLine();
            int[] bettysDeck = parseStringToIntArr(in);
            TreeSet<Integer> bettysUniqueCards = getUniquesInDeck(bettysDeck);

            int numCardsBothHave = 0;
            for (Integer card : alicesUniqueCards){
                if (bettysUniqueCards.contains(card)){
                    numCardsBothHave++;
                }
            }

            int numAliceCanTrade = alicesUniqueCards.size() - numCardsBothHave;
            int numBettyCanTrade = bettysUniqueCards.size() - numCardsBothHave;
            int maxTrades = Math.min(numAliceCanTrade, numBettyCanTrade);

            bw.write(Integer.toString(maxTrades));
            bw.flush();
        }
    }

    private static int[] parseStringToIntArr(String stringOfInts){
        String[] separatedInts = stringOfInts.split(" ");
        int[] parsedInts = new int[separatedInts.length];

        for(int i = 0; i < separatedInts.length; i++){
            parsedInts[i] = Integer.parseInt(separatedInts[i]);
        }
        return parsedInts;
    }

    private static TreeSet<Integer> getUniquesInDeck(int[] deck){
        TreeSet<Integer> uniqueCards = new TreeSet<>();

        for (int card : deck){
            uniqueCards.add(card);
        }
        return uniqueCards;
    }
}
