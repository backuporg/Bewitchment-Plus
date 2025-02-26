package dev.mrsterner.bewitchmentplus.client.model.entity;

import dev.mrsterner.bewitchmentplus.BewitchmentPlus;
import dev.mrsterner.bewitchmentplus.common.entity.NifflerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static dev.mrsterner.bewitchmentplus.common.entity.NifflerEntity.SLEEPING;

public class NifflerEntityModel extends AnimatedGeoModel<NifflerEntity> {

    @Override
    public Identifier getModelResource(NifflerEntity object) {
        return new Identifier(BewitchmentPlus.MODID, "geo/niffler.geo.json");
    }

    @Override
    public Identifier getTextureResource(NifflerEntity object) {
        return new Identifier(BewitchmentPlus.MODID, "textures/entity/niffler/0.png");
    }

    @Override
    public Identifier getAnimationResource(NifflerEntity animatable) {
        return new Identifier(BewitchmentPlus.MODID, "animations/niffler.animation.json");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setLivingAnimations(NifflerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("headJoint");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        boolean isMovingHorizontal = Math.sqrt(Math.pow(entity.getDeltaMotion().x, 2) + Math.pow(entity.getDeltaMotion().z, 2)) > 0.005;
        if (head != null && !entity.getDataTracker().get(SLEEPING)) {
            if (!isMovingHorizontal) {
                head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
                head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
            } else {
                head.setRotationZ(extraData.netHeadYaw * ((float) Math.PI / 180F));
            }
        }
    }
}
