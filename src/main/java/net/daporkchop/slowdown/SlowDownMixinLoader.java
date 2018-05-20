package net.daporkchop.slowdown;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

/**
 * @author DaPorkchop_
 */
public class SlowDownMixinLoader implements IFMLLoadingPlugin {

    public SlowDownMixinLoader() {
        FMLLog.log.info("\n\n\nPepsiMod Mixin init\n\n");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.slowdown.json");

        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");

        FMLLog.log.info(MixinEnvironment.getDefaultEnvironment().getObfuscationContext());

    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
