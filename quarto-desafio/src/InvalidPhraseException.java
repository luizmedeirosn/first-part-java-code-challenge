public final class InvalidPhraseException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidPhraseException(String message) {
        super(message);
    }

    public static void verifyPhrase(char[] phrase, int begin, int end) throws InvalidPhraseException {
        if (begin > phrase.length-1) {
                return;

        } else if (end-begin < 1) {
            if ( !Character.isLetter(phrase[begin]) && !Character.isWhitespace(phrase[begin]) ) {
                throw new InvalidPhraseException("Uma frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços");
            }

            if ( phrase[begin] != Character.toUpperCase(phrase[begin]) ) {
                throw new InvalidPhraseException("Uma frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços");
            }

            return;

        } else {
            int mid = (begin + end)/2;
            verifyPhrase(phrase, begin, mid);
            verifyPhrase(phrase, mid+1, end);
        }
    }

    public static void verifyPhraseLimits(String phrase) throws InvalidPhraseException {
        if (phrase.length() < 2 || phrase.length() > 100) {
            throw new InvalidPhraseException("Uma frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços");
        }
    }
}
