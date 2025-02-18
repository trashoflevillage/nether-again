package io.github.trashoflevillage.netheragain.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class NetherAgainConfig extends MidnightConfig {
    public static final String ITEMS = "items";

    @Entry(category = ITEMS, isSlider = true, min = 1, max = 50) public static int obsidianPickaxeMiningSpeedMult = 10;
}
