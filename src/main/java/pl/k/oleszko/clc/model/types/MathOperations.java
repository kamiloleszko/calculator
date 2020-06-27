package pl.k.oleszko.clc.model.types;

import pl.k.oleszko.clc.exception.EnumNotFindException;

public enum MathOperations {
    ADD,
    MULTIPLY;

    public static MathOperations getValue(String value) throws EnumNotFindException {

        for (MathOperations mathOperation : MathOperations.values()) {
            if (mathOperation.name().equalsIgnoreCase(value)) {
                return mathOperation;
            }
        }
        throw new EnumNotFindException(value);
    }
}
