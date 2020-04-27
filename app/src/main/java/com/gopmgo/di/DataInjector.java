package com.gopmgo.di;


public class DataInjector implements IDataInjector {

    private static DataInjector dataInjector;

    public static DataInjector getInstance() {
        if (dataInjector == null) {
            dataInjector = new DataInjector();
        }
        return dataInjector;
    }
}
