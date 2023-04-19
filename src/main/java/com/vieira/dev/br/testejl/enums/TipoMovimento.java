/*
 */
package com.vieira.dev.br.testejl.enums;

import com.vieira.dev.br.testejl.exception.ServiceException;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author francisco
 */
public enum TipoMovimento {

    ENTRADA(1, "Entrada"),
    SAIDA(2, "Saída"),
    DEVOLUCAO(3, "Devolução");

    private final Integer codigo;
    private final String value;

    private TipoMovimento(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.value = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public static TipoMovimento valueOfDefault(Object obj) {

        Stream<TipoMovimento> list = Arrays.stream(TipoMovimento.values());
        if (obj instanceof TipoMovimento || obj instanceof String) {
            return list.filter(f -> f.value.equalsIgnoreCase(String.valueOf(obj)))
                    .findFirst()
                    .orElseThrow(() -> new ServiceException("Tipo de entrada inválida"));
        }

        if (obj instanceof Integer ) {
            return list.filter(f -> f.codigo.equals(Integer.valueOf(String.valueOf(obj)))) 
                    .findFirst().
                    orElseThrow(() -> new ServiceException("Tipo de entrada inválida"));
        }
        
        return null;
    }

    public String getValue() {
        return value;
    }

}
