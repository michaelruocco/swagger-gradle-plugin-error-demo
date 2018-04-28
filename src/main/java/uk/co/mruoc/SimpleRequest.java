package uk.co.mruoc;

import io.swagger.annotations.ApiModel;

import javax.money.MonetaryAmount;

@ApiModel
public class SimpleRequest {

    private String name;
    private String value;
    private MonetaryAmount monetaryAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

}
