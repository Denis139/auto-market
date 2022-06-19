package com.gavrish.automarket.util;

import lombok.experimental.UtilityClass;

@UtilityClass                    //   изучить
public class Constant {

    public static final String ADD_ENGINE = "/api/v1/engine/add";
    public static final String GET_ALL_ENGINE = "/api/v1/engine/getAll";
    public static final String GET_ENGINE = "/api/v1/engine/get/{id}";
    public static final String UPDATE_ENGINE = "/api/v1/engine/update/{id}";
    public static final String DELETE_ENGINE = "/api/v1/engine/delete/{id}";


    public static final String ADD_TRANSMISSION = "/api/v1/transmission/add";
    public static final String GET_TRANSMISSION = "/api/v1/transmission/get/{id}";
    public static final String GET_ALL_TRANSMISSION = "/api/v1/transmission/getAll";
    public static final String UPDATE_TRANSMISSION = "/api/v1/transmission/update/{id}";
    public static final String DELETE_TRANSMISSION = "/api/v1/transmission/delete/{id}";


    public static final String ADD_WHEEL = "/api/v1/wheel/add";
    public static final String GET_WHEEL = "/api/v1/wheel/get/{id}";
    public static final String GET_ALL_WHEEL = "/api/v1/wheel/getAll";
    public static final String UPDATE_WHEEL = "/api/v1/wheel/update/{id}";
    public static final String DELETE_WHEEL = "/api/v1/wheel/delete/{id}";


    public static final String ADD_FACTORY = "/api/v1/factory/add";
    public static final String GET_FACTORY = "/api/v1/factory/get/{id}";
    public static final String GET_ALL_FACTORY = "/api/v1/factory/getAll";
    public static final String UPDATE_FACTORY = "/api/v1/factory/update/{id}";
    public static final String DELETE_FACTORY = "/api/v1/factory/delete/{id}";


    public static final String ADD_CAR= "/api/v1/car/add";
    public static final String GET_CAR = "/api/v1/car/get/{id}";
    public static final String GET_ALL_CAR = "/api/v1/car/getAll";
    public static final String UPDATE_CAR = "/api/v1/car/update/{id}";
    public static final String DELETE_CAR = "/api/v1/car/delete/{id}";


    public static final String ADD_MODEL = "/api/v1/models/add";
    public static final String GET_MODEL = "/api/v1/models/get";
}
