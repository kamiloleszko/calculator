package pl.k.oleszko.clc.service.calculator;

import pl.k.oleszko.clc.exception.EnumNotFindException;
import pl.k.oleszko.clc.model.types.MathOperations;
import pl.k.oleszko.clc.service.operations.CalculateService;
import pl.k.oleszko.clc.service.operations.CalculateServiceImpl;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {

    private static final Logger LOGGER = Logger.getLogger( Calculator.class.getName() );

    public void calculate(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        CalculateService service = new CalculateServiceImpl();

        String line;
        Integer finalValue = 0;
        Integer value = 0;
        boolean doOperation = false;
        boolean isFirstLine = true;
        MathOperations operation = null;

      try {
          while ((line = br.readLine()) != null) {

              if (isNumber(line)) {
                  if (isFirstLine) {
                      finalValue = Integer.valueOf(line);
                      isFirstLine = false;
                  } else {
                      value = Integer.valueOf(line);
                      doOperation = true;
                  }
              } else {
                  operation = MathOperations.getValue(line);
                  doOperation = false;
              }

             if(doOperation){
                 finalValue = doOperations(service, operation, finalValue, value);
             }

          }
      } catch (IOException | EnumNotFindException ex ) {
          LOGGER.log(Level.WARNING, ex.getMessage());
      }
      LOGGER.log(Level.INFO, finalValue.toString());
    }


    private Integer doOperations(CalculateService service, MathOperations operation, Integer result, Integer value) {
        switch (operation) {
            case ADD: result =  service.add(result, value);
                    break;
            case MULTIPLY: result =  service.multiply(result, value);
                    break;
            default: break;
        }
        return result;
    }

    private boolean isNumber(String value) {
        try {
            Integer.valueOf(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
