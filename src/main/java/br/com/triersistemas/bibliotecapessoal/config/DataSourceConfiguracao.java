package br.com.triersistemas.bibliotecapessoal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguracao {

    @Bean
    public DataSource dataSource(){
        String url = "jdbc:postgresql://localhost:5432/biblioteca_pessoal";
        String usuario = "postgres";
        String senha = "postgres";

        return new DriverManagerDataSource(url, usuario, senha);
    }
}
