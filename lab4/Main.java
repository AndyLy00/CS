package lab4;

public class Main {
    public static void main(String[] args) {
        String binaryString1 = "01011101010001101110111101010101";
        String binaryString2 = "11000100110010001101110010001100";

        // Concatenate the two binary strings
        String concatenatedBinary = concatenateBinaryStrings(binaryString1, binaryString2);

        //Make final permutation
        String performedFinalPermutation = performFinalPermutation(concatenatedBinary);

        // Convert the concatenated binary string to hexadecimal
        String hexadecimalResult = binaryToHexadecimal(performedFinalPermutation);

        System.out.println("Concatenated Binary: " + concatenatedBinary);
        System.out.println("Concatenated Binary after Final Permutation: " + performedFinalPermutation);
        System.out.println("Hexadecimal Result: " + hexadecimalResult);
    }

    // Function to concatenate two binary strings
    public static String concatenateBinaryStrings(String binaryString1, String binaryString2) {
        return binaryString1 + binaryString2;
    }

    // Function to convert a binary string to a hexadecimal string
    public static String binaryToHexadecimal(String binary) {
        // Ensure that the binary string has a length multiple of 4 by adding leading zeros if needed
        int remainder = binary.length() % 4;
        if (remainder != 0) {
            int zerosToAdd = 4 - remainder;
            StringBuilder leadingZeros = new StringBuilder();
            for (int i = 0; i < zerosToAdd; i++) {
                leadingZeros.append('0');
            }
            binary = leadingZeros.toString() + binary;
        }

        StringBuilder hexadecimal = new StringBuilder();
        for (int i = 0; i < binary.length(); i += 4) {
            String chunk = binary.substring(i, i + 4);
            int decimalValue = Integer.parseInt(chunk, 2);
            String hexDigit = Integer.toHexString(decimalValue).toUpperCase();
            hexadecimal.append(hexDigit);
        }

        return hexadecimal.toString();
    }

    public static String performFinalPermutation(String inputBinary) {
        final int[] FINAL_PERMUTATION_TABLE = {
                40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
                38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29,
                36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27,
                34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25
        };


        if (inputBinary.length() != 64) {
            throw new IllegalArgumentException("Input binary string must be 64 bits long.");
        }

        char[] outputArray = new char[64];
        char[] inputArray = inputBinary.toCharArray();

        for (int i = 0; i < 64; i++) {
            outputArray[i] = inputArray[FINAL_PERMUTATION_TABLE[i] - 1];
        }

        return new String(outputArray);
    }
}
