package dev.mrsterner.bewitchmentplus.client.shader;

import net.minecraft.client.render.*;
import net.minecraft.resource.ResourceManager;
import com.mojang.datafixers.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class BWPShader  {
    private static Shader rune;
    private static Shader shadow;

    public static void init(ResourceManager resourceManager, List<Pair<Shader, Consumer<Shader>>> registrations) throws IOException {
        registrations.add(Pair.of(
        new Shader(resourceManager, "bwp_rune_test", VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL),
        inst -> rune = inst)
        );
        registrations.add(Pair.of(
                new Shader(resourceManager, "bwp_shadow", VertexFormats.POSITION_COLOR_TEXTURE_OVERLAY_LIGHT_NORMAL),
                inst -> shadow = inst)
        );
    }

    /**
     * Used to create a Shader instance
     * @return
     */
    public static Shader rune() {
        return rune;
    }
    public static Shader shadow() {
        return shadow;
    }

}