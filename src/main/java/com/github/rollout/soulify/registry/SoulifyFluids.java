package com.github.rollout.soulify.registry;

import com.github.rollout.soulify.Soulify;
import com.github.rollout.soulify.fluid.SoulLavaFluid;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tag.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class SoulifyFluids {

    private static final String MOD_ID = Soulify.MOD_ID;

    public static FlowableFluid STILL_SOUL_LAVA = new SoulLavaFluid.Still();
    public static FlowableFluid FLOWING_SOUL_LAVA = new SoulLavaFluid.Flowing();
    public static BucketItem SOUL_LAVA_BUCKET = new BucketItem(STILL_SOUL_LAVA, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1));
    public static FluidBlock SOUL_LAVA = new FluidBlock(STILL_SOUL_LAVA, FabricBlockSettings.of(Material.LAVA).noCollision().ticksRandomly().strength(100.0F).luminance((state) -> {
        return 10;
    }).dropsNothing()){};

    public static void RegisterSoulifyFluids() {

        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "soul_lava"), STILL_SOUL_LAVA);
        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_soul_lava"), FLOWING_SOUL_LAVA);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "soul_lava_bucket"), SOUL_LAVA_BUCKET);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "soul_lava"), SOUL_LAVA);

    }

}
