package com.smallmanseries.farlandstraveler.mixin.worldgen;

import com.smallmanseries.farlandstraveler.common.worldgen.densityfunctions.BlendedNoiseOverflowable;
import net.minecraft.world.level.levelgen.synth.BlendedNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * 私有字段访问器，用于给类{@link BlendedNoiseOverflowable}提供 Codec 注册所需的字段。
 *
 * @see BlendedNoiseMixin
 *
 * @author INF32768
 */
@Mixin(BlendedNoise.class)
public interface IBlendedNoiseMixin {
    @Accessor
    double getXzScale();

    @Accessor
    double getYScale();

    @Accessor
    double getXzFactor();

    @Accessor
    double getYFactor();

    @Accessor
    double getSmearScaleMultiplier();
}
