package br.com.poc.generics.model;

public enum AlertEnum {
    ANIMAL_GDP_BELLOW("animal_gdp_bellow"),
    ANIMAL_WITHOUT_WEIGHT_UNTIL("animal_without_weight_until"),
    LOT_WITH_PICKET_NOT_REGISTERED("lot_with_picket_not_registered"),
    DIET_STRATEGIE_OUT_OF_PERIOD("diet_strategie_out_of_period");

    private String code;

    AlertEnum(String code){
        this.code = code;
    }

    public static AlertEnum getByCode(String code){
        for (AlertEnum e : AlertEnum.values()){
            if (e.code.equals(code))
                return e;
        }
        return ANIMAL_GDP_BELLOW;
    }

    public String getCode(){
        return code;
    }

    public String getRouteName() {
        return code + ".*";
    }

    public String getQueueName() {
        return code + "Queue";
    }

    public String getEntityRouteName() {
        return code + ".entity.*";
    }

    public String getEntityQueueName() {
        return code + "EntityQueue";
    }
}
