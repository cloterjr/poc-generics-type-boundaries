package br.com.poc.generics.model;

public enum AlertExecutionStatusEnum {
    SUCCESS("success"),
    PARTIAL("partial"),
    FAILED("failed");

    private String code;

    AlertExecutionStatusEnum(String code){
        this.code = code;
    }

    public static AlertExecutionStatusEnum getByCode(String code){
        for (AlertExecutionStatusEnum e : AlertExecutionStatusEnum.values()){
            if (e.code.equals(code))
                return e;
        }
        return SUCCESS;
    }

    public String getCode(){
        return code;
    }
}
