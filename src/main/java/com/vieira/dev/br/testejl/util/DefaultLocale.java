package com.vieira.dev.br.testejl.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Locale;

@Named
@ApplicationScoped
public class DefaultLocale {
    public Locale getLocale() {
        return new Locale("pt", "BR");
    }

}
