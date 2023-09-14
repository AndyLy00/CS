import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cesarEncryption("Maw Maw", 2);
        System.out.println();
        cesarDecryption("OCYOCY", 2);
        System.out.println();
        cesarBrutEncryption("Maw Maw", 2, "Nya");
        System.out.println();
        cesarBrutDecryption("PCZPCZ", 2, "Nya");
        System.out.println();
    }

    private static List<Character> getAlphabetList() {
        List<Character> alphabet = new ArrayList<>();
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            alphabet.add(letter);
        }
        return alphabet;
    }

    public static void cesarEncryption(String word, int key) {
        keyVerification(key);
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toUpperCase().replaceAll(" ", "").toCharArray()) {
            chars.add(ch);
        }
        List<Character> alphabetList = getAlphabetList();
        alphabetList.forEach(System.out::print);
        System.out.println();
        chars.stream().map(character -> {
            int i = indexOfElement(alphabetList, character);
            if ((i + key) >= alphabetList.size()) {
                return alphabetList.get(indexOfElement(alphabetList, character) - 26 + key);
            }
            return alphabetList.get(indexOfElement(alphabetList, character) + key);
        }).forEach(System.out::print);
    }

    public static void cesarDecryption(String word, int key) {
        keyVerification(key);
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toUpperCase().replaceAll(" ", "").toCharArray()) {
            chars.add(ch);
        }
        List<Character> alphabetList = getAlphabetList();
        alphabetList.forEach(System.out::print);
        System.out.println();
        chars.stream().map(character -> {
            int i = indexOfElement(alphabetList, character);
            if ((i - key) < 0) {
                return alphabetList.get(i + 26 - key);
            }
            return alphabetList.get(i - key);
        }).forEach(System.out::print);
    }

    public static void cesarBrutEncryption(String word, int key, String keyWord) {
        keyVerification(key);
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toUpperCase().replaceAll(" ", "").toCharArray()) {
            chars.add(ch);
        }
        List<Character> alphabetList = getAlphabetList();
        List<Character> keyWordList = new ArrayList<>();
        for (char ch : keyWord.toUpperCase().replaceAll(" ", "").toCharArray()) {
            keyWordList.add(ch);
        }
        List<Character> keyWordRemove = new ArrayList<>();
        for (char ch : keyWord.toUpperCase().replaceAll(" ", "").toCharArray()) {
            keyWordRemove.add(ch);
        }
        keyWordRemove.forEach(alphabetList::remove);
        alphabetList.addAll(0, keyWordRemove.stream().distinct().toList());
        alphabetList.forEach(System.out::print);
        System.out.println();
        chars.stream().map(character -> {
            int i = indexOfElement(alphabetList, character);
            if ((i + key) >= alphabetList.size()) {
                return alphabetList.get(indexOfElement(alphabetList, character) - 26 + key);
            }
            return alphabetList.get(indexOfElement(alphabetList, character) + key);
        }).forEach(System.out::print);
    }

    public static void cesarBrutDecryption(String word, int key, String keyWord) {
        keyVerification(key);
        List<Character> chars = new ArrayList<>();
        for (char ch : word.toUpperCase().replaceAll(" ", "").toCharArray()) {
            chars.add(ch);
        }
        List<Character> alphabetList = getAlphabetList();
        List<Character> keyWordList = new ArrayList<>();
        for (char ch : keyWord.toUpperCase().replaceAll(" ", "").toCharArray()) {
            keyWordList.add(ch);
        }
        List<Character> keyWordRemove = new ArrayList<>();
        for (char ch : keyWord.toUpperCase().replaceAll(" ", "").toCharArray()) {
            keyWordRemove.add(ch);
        }
        keyWordRemove.forEach(alphabetList::remove);
        alphabetList.addAll(0, keyWordRemove.stream().distinct().toList());
        alphabetList.forEach(System.out::print);
        System.out.println();
        chars.stream().map(character -> {
            int i = indexOfElement(alphabetList, character);
            if ((i - key) < 0) {
                return alphabetList.get(i + 26 - key);
            }
            return alphabetList.get(i - key);
        }).forEach(System.out::print);
    }

    private static void keyVerification(int key) {
        if ((key > 25) || (key <= 0)) {
            throw new NoSuchElementException("Introduce 0 < K < 26");
        }
    }

    public static int indexOfElement(List<Character> characterList, Character elementToFind) {
        int index = 0;
        for (Character element : characterList) {
            if (element.equals(elementToFind)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}