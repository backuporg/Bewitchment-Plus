package dev.mrsterner.bewitchmentplus.client.renderer.entity;

import dev.mrsterner.bewitchmentplus.BewitchmentPlus;
import dev.mrsterner.bewitchmentplus.client.model.entity.CleaverEntityModel;
import dev.mrsterner.bewitchmentplus.common.entity.CleaverEntity;
import moriyashiine.bewitchment.common.entity.living.util.BWHostileEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CleaverEntityRenderer extends MobEntityRenderer<CleaverEntity, CleaverEntityModel<CleaverEntity>> {
    private static Identifier[] TEXTURES;

    public CleaverEntityRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new CleaverEntityModel<>(), 0.5f);
        addFeature(new HeldItemFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(CleaverEntity entity) {
        if (TEXTURES == null) {
            int variants = entity.getVariants();
            TEXTURES = new Identifier[variants];
            for (int i = 0; i < variants; i++) {
                TEXTURES[i] = new Identifier(BewitchmentPlus.MODID, "textures/entity/living/cleaver/" + i + ".png");
            }
        }
        return TEXTURES[entity.getDataTracker().get(BWHostileEntity.VARIANT)];
    }
}
