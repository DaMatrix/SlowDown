package net.daporkchop.slowdown.mixin.util;

import net.daporkchop.pepsimod.misc.TickRate;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author DaPorkchop_
 */
@Mixin(Timer.class)
public abstract class MixinTimer {
    @Shadow
    public int elapsedTicks;

    @Shadow
    public float renderPartialTicks;

    @Shadow
    public float elapsedPartialTicks;

    @Shadow
    private long lastSyncSysClock;

    @Shadow
    private float tickLength;

    /**
     * this hides a stupid warning
     *
     * @author DaPorkchop_
     */
    @Overwrite
    public void updateTimer() {
        float timerSpeed = TickRate.TPS / 20.0f;

        long i = Minecraft.getSystemTime();
        this.elapsedPartialTicks = (float) (i - this.lastSyncSysClock) / this.tickLength * timerSpeed;
        this.lastSyncSysClock = i;
        this.renderPartialTicks += elapsedPartialTicks;
        this.elapsedTicks = (int) this.renderPartialTicks;
        this.renderPartialTicks -= this.elapsedTicks;
    }
}
