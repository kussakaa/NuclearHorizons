package com.recursive_pineapple.nuclear_horizons.reactors.render;

import com.recursive_pineapple.nuclear_horizons.reactors.blocks.ReactorCore;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class ReactorCoreRenderer implements ISimpleBlockRenderingHandler {

    public static int renderId = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {

        int meta = world.getBlockMetadata(x, y, z);

        renderer.renderStandardBlock(block, x, y, z);

        Tessellator t = Tessellator.instance;
        t.setBrightness(240);
        t.setColorOpaque_F(1f, 1f, 1f);

        ReactorCore b = (ReactorCore) block;
        renderer.setRenderBounds(-0.001, -0.001, -0.001, 1.001, 1.001, 1.001);

        IIcon icon = b.getIconGlow(2, meta);
        if (icon != null) {
            renderer.renderFaceZNeg(block, x, y, z, icon);
            renderer.renderFaceZPos(block, x, y, z, icon);
            renderer.renderFaceXNeg(block, x, y, z, icon);
            renderer.renderFaceXPos(block, x, y, z, icon);
        }

        renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
        return true;
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return ReactorCore.renderId;
    }
}
