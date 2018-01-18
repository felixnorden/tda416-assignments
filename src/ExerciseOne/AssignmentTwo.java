package ExerciseOne;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.IntFunction;

public class AssignmentTwo {

    private FrequenceObject[] frequencies;
    private String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "å", "ä", "ö"};

    public AssignmentTwo(String filePath) {
        System.out.println("Exercise 2");
        try {
            frequencies = Arrays
                    .stream(alphabet)
                    .map(FrequenceObject::new)
                    .toArray(FrequenceObject[]::new);
            frequenseAnalysis(filePath);
        } catch (IOException e) {
            System.out.println("Shit gone wrong, m8, such gr8");
        }
    }

    private void frequenseAnalysis(String filepath) throws IOException {
        FileReader fr = new FileReader(filepath);
        int charCounter = 0;
        BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            String formattedLine = br.readLine()
                    .toLowerCase()
                    .replaceAll("/[^a-zåäö]/", "");
            charCounter += formattedLine.length();

            for (char c : formattedLine.toCharArray()) {
                Character ch = new Character(c);
                Arrays.stream(frequencies)
                        .forEach(fo -> {
                            if (ch.toString().equals(fo.character)) {
                                fo.frequency++;
                            }
                        });
            }
        }
        System.out.printf("%s\t  %s\t   %s\n", "Letter", "Freq", "Percent");
        final int finalCount = charCounter;
        Arrays.stream(frequencies).forEach(fo -> {
            System.out.printf("   %s   |   %d   |   %.4f\n", fo.character, fo.frequency, (double) fo.frequency/ (double) finalCount);
        });

    }

    private class FrequenceObject {

        String character;
        int frequency;

        private FrequenceObject(String character) {
            this.character = character;
        }

    }

    public static void main(String[] args) {
        if(args.length < 1 ) {
            System.out.println("No filepath input");
        } else {
            System.out.printf("Analyzing %s", args[0]);
            new AssignmentTwo(args[0]);
        }
    }
}
