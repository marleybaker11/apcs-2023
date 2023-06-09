import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class SpellingBee {

    private char[] letters;
    private char mustUse;

    public SpellingBee(char[] letters, char mustUse) {
        this.letters = letters;
        this.mustUse = mustUse;
    }

 public boolean checkWord(String word) {
    // Check if the word contains only the required letters and the must-use letter
    // Must be at least 4 letters long
    if (word.length() < 4) {
        return false;
    }
    
    for (char c : word.toCharArray()) {
        if (!containsLetter(c)) {
            return false;
        }
    }
    
    return word.indexOf(mustUse) != -1;
}

private boolean containsLetter(char letter) {
    for (char c : letters) {
        if (c == letter) {
            return true;
        }
    }
    return false;
}

    /**
     * Loads the contents of file "filename" as a String.
     * 
     * @param filename the file to load
     * @return the contents of file "filename"
     */
    public static String loadFile(String filename) {
        String contents = "";
        Path path = Paths.get(filename);
        try {
            path = Path.of(ClassLoader.getSystemResource(filename).toURI());
            contents = Files.readString(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return contents;
    }

    public static void main(String[] args) {
        String[] words = loadFile("words_dropped.txt").split("\n");
        System.out.println("Loaded " + words.length + " words");

        SpellingBee bee = new SpellingBee("rmnuiaj".toCharArray(), 'n');
        for(String word:words){
            if(bee.checkWord(word)){
                System.out.println(word);
            }
        }

        // Sort the words array
        Arrays.sort(words);

        // Find the position of the word "search" in the sorted list
        int index = Arrays.binarySearch(words, "search");
        if (index >= 0) {
            System.out.println("Found 'search' at position " + (index + 1));
        } else {
            System.out.println("Word 'search' not found.");
        }
    }
}
