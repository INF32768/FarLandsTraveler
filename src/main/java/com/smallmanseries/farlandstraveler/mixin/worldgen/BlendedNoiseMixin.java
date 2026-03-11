package com.smallmanseries.farlandstraveler.mixin.worldgen;

import com.smallmanseries.farlandstraveler.common.worldgen.densityfunctions.BlendedNoiseOverflowable;
import net.minecraft.world.level.levelgen.synth.BlendedNoise;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 将原版的混合噪声改造成基于派生类类型控制溢出的混合噪声，若为 {@link BlendedNoiseOverflowable} 派生类则溢出。
 *
 *
 *
 * @author INF32768
 *
 * @author OslorasKi
 */
@Mixin(BlendedNoise.class)
public abstract class BlendedNoiseMixin {

    @Redirect(method = "compute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/synth/PerlinNoise;wrap(D)D"))
    private double redirectWrap(double value) {
        if(((BlendedNoise)(Object)this) instanceof BlendedNoiseOverflowable) {
            return value;
        }
        return PerlinNoise.wrap(value);
    }
}
