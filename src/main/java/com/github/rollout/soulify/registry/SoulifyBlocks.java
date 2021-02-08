package com.github.rollout.soulify.registry;

import com.github.rollout.soulify.Soulify;
import com.github.rollout.soulify.blocks.SoulMagmaBlock;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class SoulifyBlocks {

    private static final String MOD_ID = Soulify.MOD_ID;

    public static final SoulMagmaBlock SOUL_MAGMA_BLOCK = new SoulMagmaBlock(AbstractBlock.Settings.of(Material.STONE, MaterialColor.NETHER).requiresTool().luminance((state) -> {
        return 2;
    }).ticksRandomly().strength(0.5F).allowsSpawning((state, world, pos, entityType) -> {
        return entityType.isFireImmune();
    }).postProcess(SoulifyBlocks::always).emissiveLighting(SoulifyBlocks::always));
    public static final BlockItem SOUL_MAGMA_ITEM = new BlockItem(SOUL_MAGMA_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
    private static boolean always(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return true;
    }

    public static final FurnaceBlock FURNACE = new FurnaceBlock(AbstractBlock.Settings.of(Material.STONE).requiresTool().strength(3.5F).luminance(createLightLevelFromBlockState(13)));
    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> {
            return (Boolean)blockState.get(Properties.LIT) ? litLevel : 0;
        };
    }
    public static void RegisterSoulifyBlocks() {

        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "soul_magma_block"), SOUL_MAGMA_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_magma_block"), SOUL_MAGMA_ITEM);

    }

}
