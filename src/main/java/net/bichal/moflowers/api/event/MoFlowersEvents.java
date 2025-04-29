/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api.event;

import net.bichal.moflowers.api.flowers.FlowerData;

import java.util.ArrayList;
import java.util.List;

public class MoFlowersEvents {
    private static final List<IFlowerRegistrationCallback> registrationCallbacks = new ArrayList<>();

    /**
     * Registers a callback to be invoked when a flower is registered.
     *
     * @param callback The callback to register.
     */
    public static void registerFlowerRegistrationCallback(IFlowerRegistrationCallback callback) {
        registrationCallbacks.add(callback);
    }

    /**
     * Invokes all registered callbacks with the given flower data.
     *
     * @param data The flower data to pass to the callbacks.
     */
    public static void invokeFlowerRegistration(FlowerData data) {
        registrationCallbacks.forEach(callback -> callback.onFlowerRegistered(data));
    }
}
