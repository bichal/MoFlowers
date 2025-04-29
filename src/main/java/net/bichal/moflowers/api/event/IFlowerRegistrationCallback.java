/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api.event;

import net.bichal.moflowers.api.flowers.FlowerData;

@FunctionalInterface
public interface IFlowerRegistrationCallback {
    /**
     * Called when a new flower is registered.
     *
     * @param flowerData The data of the registered flower.
     */
    void onFlowerRegistered(FlowerData flowerData);
}
