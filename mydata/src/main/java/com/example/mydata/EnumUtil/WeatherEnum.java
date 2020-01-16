package com.example.mydata.EnumUtil;

public enum WeatherEnum {

    SUNNY("sunny","晴天"),
    RAINY("rainy","雨天"),
    CLOUDY("cloudy","多云");


    String code;
    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    WeatherEnum(String code,String name){
        this.name= name;
        this.code = code;
    }

    //TODO 定义方法，可以通过code得到name

}
