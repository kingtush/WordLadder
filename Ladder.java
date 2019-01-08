import java.io.*;
import java.util.*;
import java.lang.*;
public class Ladder {

    /*
    Method that contains logic to find adjacent nodes/words.
     */

    public static boolean isNeighbor(String a, String b) {
        //assert a.length() == b.length();
        if(a.equals(b)){
            return false;
        }

        if(a.length() == b.length()) {

            int differ = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) differ++;
                if (differ > 1) return false;
            }
        }

       else if((a.length()-b.length())==1 || (b.length()-a.length())==1){
            int success = 0;
            int j= 0;
            String longer = longerString(a,b);
            String shorter = shorterString(a,b);

            for(int i=0; i< longer.length(); i++){

                if(j<shorter.length()){
                    if(longer.charAt(i)==shorter.charAt(j)){
                        success++;
                        j++;
                    }
                }

            }

            if(success != shorter.length()){
                return false;
            }
        }
        return true;
    }

    /*
    longerString and shorterString are methods that help in the isNeighbor method.
     */
    public static String longerString(String s1,String s2){
        if(s1.length() > s2.length())
            return s1;
        else
            return s2;
    }

    public static String shorterString(String s1,String s2){
        if(s1.length() < s2.length())
            return s1;
        else
            return s2;
    }

    public static void main(String [] args) throws IOException{

        //int searches,k=0;
        List<String> words = new ArrayList<String>();
        Scanner l_scan = new Scanner(System.in);

        String placer;

        System.out.println("Enter the full path to the dictionary file: ");
        String filePath = l_scan.nextLine();

        //BufferedReader scanner = new BufferedReader(new FileReader("/Users/tushmark/IdeaProjects/Ladder/Files/dictionary.txt"));
        BufferedReader scanner = new BufferedReader(new FileReader(filePath));

        while((placer = scanner.readLine())!= null){

            words.add(placer);
            //wordcount++;

        }
        Graph G = new Graph(words.size());
        for (String word1 : words) {
            for (String word2 : words) {
                //if (word1.length() != word2.length()) {
                    //throw new RuntimeException("Words have different lengths");
                //}
                if(((Math.max(word1.length(),word2.length())) -(Math.min(word1.length(),word2.length())) )>1){
                    continue;
                }

                if(isNeighbor(word1,word2)){
                    G.addEdge(words.indexOf(word1), words.indexOf(word2));
                }

                //if (word1.compareTo(word2) < 0 && isNeighbor(word1, word2)) {
                    //G.addEdge(words.indexOf(word1), words.indexOf(word2));
                //}
            }
        }
        System.err.println("Finished building graph");

        //System.out.println(words.size());
        //System.out.println(wordcount);

        String from;
        String to;
        boolean check=true;


            while(check) {


                System.out.print("Enter the first word: ");
                from = l_scan.nextLine();
                System.out.print("Enter the second word: ");
                to = l_scan.nextLine();

                if (!words.contains(from)) throw new RuntimeException(from + " is not in word list");
                if (!words.contains(to)) throw new RuntimeException(to + " is not in word list");

                BreadthFirstPaths bfs = new BreadthFirstPaths(G, words.indexOf(to));
                if (bfs.hasPathTo(words.indexOf(from))) {
                    //System.out.println("length = " + bfs.distTo(words.indexOf(from)));
                    for (int v : bfs.pathTo(words.indexOf(from))) {
                        System.out.print(words.get(v) + " ");
                    }
                } else System.out.println("NOT CONNECTED");
                System.out.println();

                System.out.println("Would you like to search for more words? (yes/no)");
                String moreWords = l_scan.nextLine();

                if(moreWords.equals("no")){
                    check = false;
                }

            }


            //System.out.println("Would you like to see a string Representation of the Graph?: (yes/no)");
            //show = l_scan.nextLine();



        //System.out.println(G.toString(words));

       //
    }
}

