package br.edu.unipe.customer_management_spring.enums;

import br.edu.unipe.customer_management_spring.errors.BusinessException;

import java.util.Arrays;

public enum State {

    ACRE("AC"),
    ALAGOAS("AL"),
    AMAPA("AP"),
    AMAZONAS("AM"),
    BAHIA("BA"),
    CEARA("CE"),
    DISTRITO_FEDERAL("DF"),
    ESPIRITO_SANTO("ES"),
    GOIAS("GO"),
    MARANHAO("MA"),
    MATO_GROSSO("MT"),
    MATO_GROSSO_DO_SUL("MS"),
    MINAS_GERAIS("MG"),
    PARA("PA"),
    PARAIBA("PB"),
    PARANA("PR"),
    PERNAMBUCO("PE"),
    PIAUI("PI"),
    RIO_DE_JANEIRO("RJ"),
    RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"),
    RONDONIA("RO"),
    RORAIMA("RR"),
    SANTA_CATARINA("SC"),
    SAO_PAULO("SP"),
    SERGIPE("SE"),
    TOCANTINS("TO");

    private final String abbreviation;

    State(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static State fromAbbreviation(String abbreviation) {
        for (State state : State.values()) {
            if (state.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return state;
            }
        }

        String validStates = Arrays.toString(State.values()).replaceAll("^.|.$", "");
        throw new BusinessException("Invalid state abbreviation: '" + abbreviation + "'. Valid values are: " + validStates);
    }

}
