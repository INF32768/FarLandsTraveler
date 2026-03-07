package com.smallmanseries.farlandstraveler.common;

public class MathUtil {

    // 类似于原版的 Mth.clamp，但是不会限制无穷值
    public static double clamp(double value, double min, double max) {
        if (Double.isInfinite(value)) return value;
        return value < min ? min : Math.min(value, max);
    }

    public static double lerp3(double delta1, double delta2, double delta3, double start1, double end1, double start2, double end2, double start3, double end3, double start4, double end4) {
        return lerp(delta3, lerp2(delta1, delta2, start1, end1, start2, end2), lerp2(delta1, delta2, start3, end3, start4, end4));
    }

    public static double lerp2(double delta1, double delta2, double start1, double end1, double start2, double end2) {
        return lerp(delta2, lerp(delta1, start1, end1), lerp(delta1, start2, end2));
    }

    // 类似于原版的 Mth.lerp，但是添加了对 delta == 0 的特殊处理，使得天空网格能够生成
    public static double lerp(double delta, double start, double end) {
        return delta == 0 ? start : start + delta * (end - start);
    }
}
