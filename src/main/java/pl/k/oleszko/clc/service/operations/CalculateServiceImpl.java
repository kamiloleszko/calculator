package pl.k.oleszko.clc.service.operations;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculateServiceImpl implements CalculateService {

    private static final Logger LOGGER = Logger.getLogger( CalculateServiceImpl.class.getName() );


    public Integer add(Integer finalValue, Integer number) {
        LOGGER.log(Level.INFO, "adding: " + finalValue + " + " + number);
        Integer result =  finalValue + number;
        logResult(result);
        return result;
    }

    public Integer multiply(Integer finalValue, Integer number) {
        LOGGER.log(Level.INFO, "multipling: " + finalValue + " * " + number);
        Integer result =  finalValue * number;
        logResult(result);
        return result;
    }

    private void logResult(Integer result) {
        LOGGER.log(Level.INFO, "result: " + result);
    }
}
