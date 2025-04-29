/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api;

/**
 * Static access point for the API
 * Use {@link #getInstance()} to access the API implementation.
 */
public class MoFlowersAPI {
    public static final String MOD_ID = "moflowers";
    public static final String MOD_NAME = "Mo Flowers";

    private static IMoFlowersAPI instance = null;

    /**
     * Gets the current API instance.
     *
     * @return The API instance.
     * @throws IllegalStateException if the API is not initialized yet.
     */
    public static IMoFlowersAPI getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MoFlowers API not initialized yet!");
        }
        return instance;
    }

    /**
     * Sets the API implementation. Should only be called once during mod initialization.
     *
     * @param impl The API implementation.
     * @throws IllegalStateException if the API is already initialized.
     */
    public static void setInstance(IMoFlowersAPI impl) {
        if (instance != null) {
            throw new IllegalStateException("MoFlowers API already initialized!");
        }
        instance = impl;
    }
}
