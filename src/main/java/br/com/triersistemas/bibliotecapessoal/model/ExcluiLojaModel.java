package br.com.triersistemas.bibliotecapessoal.model;

import lombok.Getter;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;
import java.util.UUID;

@Getter
public class ExcluiLojaModel {

    private List<UUID> idsLojas;
}
