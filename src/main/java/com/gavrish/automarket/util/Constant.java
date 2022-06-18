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
    public static final String GET_TRANSMISSION = "/api/v1/transmission/get";


    public static final String ADD_WHEEL = "/api/v1/wheel/add";
    public static final String GET_WHEEL = "/api/v1/wheel/get";


    public static final String ADD_CAR = "/api/v1/cars/add";
    public static final String GET_CAR = "/api/v1/cars/get";
    public static final String UPDATE_CAR = "/api/v1/cars/update";
    public static final String DELETE_CAR = "/api/v1/users/delete";


    public static final String ADD_MODEL = "/api/v1/models/add";
    public static final String GET_MODEL = "/api/v1/models/get";


    public static final String ADD_FACTORY = "/api/v1/factorys/add";
    public static final String GET_FACTORY = "/api/v1/factorys/get";







}
