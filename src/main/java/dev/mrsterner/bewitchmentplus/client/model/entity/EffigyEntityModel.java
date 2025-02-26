package dev.mrsterner.bewitchmentplus.client.model.entity;

import dev.mrsterner.bewitchmentplus.BewitchmentPlus;
import dev.mrsterner.bewitchmentplus.common.entity.EffigyEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EffigyEntityModel extends AnimatedGeoModel<EffigyEntity> {

    @Override
    public Identifier getAnimationResource(EffigyEntity entity) {
        return new Identifier(BewitchmentPlus.MODID, "animations/effigy.animation.json");
    }

    @Override
    public Identifier getModelResource(EffigyEntity entity) {
        return new Identifier(BewitchmentPlus.MODID, "geo/effigy.geo.json");
    }

    @Override
    public Identifier getTextureResource(EffigyEntity entity) {
        return new Identifier(BewitchmentPlus.MODID, "textures/entity/effigy.png");
    }
}