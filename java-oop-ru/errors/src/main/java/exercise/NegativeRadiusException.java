package exercise;


// BEGIN
class NegativeRadiusException extends Exception {
    private String messageError;

    NegativeRadiusException(String messageError) {
        this.messageError = messageError;
    }

    public String getMessageError() {
        return messageError;
    }
}
// END
