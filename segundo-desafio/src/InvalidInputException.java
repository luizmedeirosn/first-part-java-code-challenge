public final class InvalidInputException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public InvalidInputException(String message) {
        super(message);
    }

    public static void verify(Double num) throws InvalidInputException {
        try {
            String numSting = num.toString();
            if (numSting.charAt(0) == '-') {
                throw new InvalidInputException("Entre um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).");
            }
            
            int numPointIndex = numSting.indexOf(".");
            int intetegerPart = Integer.parseInt( numSting.substring(0, numPointIndex) );
            int decimalPart = Integer.parseInt( numSting.substring(numPointIndex + 1, numSting.length()) );

            if ( intetegerPart > 1000000 || (intetegerPart == 1000000 && decimalPart > 0 )) {
                throw new InvalidInputException("Entre um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).");
            }

        } catch (Exception e) {
            throw new InvalidInputException("Entre um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).");
        }
    }
}
