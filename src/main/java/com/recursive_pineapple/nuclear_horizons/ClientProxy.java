package com.recursive_pineapple.nuclear_horizons;

import com.recursive_pineapple.nuclear_horizons.reactors.blocks.ReactorCore;
import com.recursive_pineapple.nuclear_horizons.reactors.render.ReactorCoreRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

    @Override
    public Side getSide() {
        return Side.CLIENT;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        ReactorCore.renderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new ReactorCoreRenderer());
    }
}
