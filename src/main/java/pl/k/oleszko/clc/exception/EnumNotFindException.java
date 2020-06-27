package pl.k.oleszko.clc.exception;

public class EnumNotFindException extends Exception {

    private static final String MSG = ": Enum Not Find Exception";

    private String message;

    public EnumNotFindException(String message) {
        this.message = message + MSG;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
