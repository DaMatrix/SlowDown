package net.daporkchop.slowdown.mixin.network;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.daporkchop.pepsimod.misc.TickRate;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author DaPorkchop_
 */
@Mixin(NetworkManager.class)
public abstract class MixinNetworkManager extends SimpleChannelInboundHandler<Packet<?>> {
    @Inject(method = "channelRead0", at = @At("HEAD"))
    public void preProcess(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
        TickRate.update(packet);
    }

    @Inject(method = "closeChannel", at = @At("HEAD"))
    public void preCloseChannel(ITextComponent message, CallbackInfo callbackInfo) {
        TickRate.reset();
    }
}
