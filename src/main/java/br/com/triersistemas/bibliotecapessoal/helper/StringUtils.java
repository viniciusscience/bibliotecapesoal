package br.com.triersistemas.bibliotecapessoal.helper;

import javax.swing.*;

public class StringUtils {

    public static StringBuilder porcentagemLeitura(Integer perLeitura, String titulo) {
        StringBuilder percent = new StringBuilder("");
        for (int i = 0; i < perLeitura; i += 5) {
            percent.append("*");
        }
        percent.append(" ").append(perLeitura).append("%");
        return percent;
    }
}
