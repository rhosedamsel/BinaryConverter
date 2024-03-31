class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {

    // Method to convert binary string to decimal
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the string is empty
        if (binaryString.isEmpty()) {
            throw new BinaryFormatException("Binary string cannot be empty");
        }

        // Check if the string is a binary string
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryString);
            }
        }

        // Convert binary string to decimal
        int decimal = 0;
        for (int i = binaryString.length() - 1, j = 0; i >= 0; i--, j++) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, j);
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        // Example usage
        String binaryString = "1010101";
        try {
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal value of " + binaryString + " is: " + decimalValue);
        } catch (BinaryFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
