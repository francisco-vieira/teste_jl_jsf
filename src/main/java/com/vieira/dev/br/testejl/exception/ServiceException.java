/*
 */
package com.vieira.dev.br.testejl.exception;

/**
 *
 * @author francisco
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
    }

    public ServiceException(String string) {
        super(string);
    }

    public ServiceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ServiceException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ServiceException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
