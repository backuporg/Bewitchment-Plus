package dev.mrsterner.bewitchmentplus.client.model.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class BeelzedroneEntityModel extends EntityModel<Entity> {
    private final ModelPart thorax;

    public BeelzedroneEntityModel(ModelPart root) {
        this.thorax = root.getChild("thorax");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData thorax = modelPartData.addChild("thorax", ModelPartBuilder.create().uv(0, 15).cuboid(-3.0F, -3.0F, -3.5F, 6.0F, 7.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 12.0F, -3.6F));

        ModelPartData rFur_r1 = thorax.addChild("rFur_r1", ModelPartBuilder.create().uv(32, 52).mirrored().cuboid(-0.5F, -1.75F, -2.0F, 1.0F, 4.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.0F, -3.0F, -1.0F, 0.2182F, -0.0873F, -0.2618F));

        ModelPartData lFur_r1 = thorax.addChild("lFur_r1", ModelPartBuilder.create().uv(32, 52).cuboid(-0.5F, -1.75F, -2.0F, 1.0F, 4.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -3.0F, -1.0F, 0.2182F, 0.0873F, 0.2618F));

        ModelPartData thoraxBack = thorax.addChild("thoraxBack", ModelPartBuilder.create().uv(29, 0).cuboid(-2.5F, -1.5F, 0.0F, 5.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.4F, 4.1F, -0.1745F, 0.0F, 0.0F));

        ModelPartData abdomen01 = thoraxBack.addChild("abdomen01", ModelPartBuilder.create().uv(0, 30).cuboid(-4.0F, -3.5F, 0.0F, 8.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.7F, -0.1745F, 0.0F, 0.0F));

        ModelPartData abdomen02 = abdomen01.addChild("abdomen02", ModelPartBuilder.create().uv(31, 29).cuboid(-3.0F, -3.5F, 0.0F, 6.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.2F, 5.8F, -0.2793F, 0.0F, 0.0F));

        ModelPartData abdomen03 = abdomen02.addChild("abdomen03", ModelPartBuilder.create().uv(30, 41).cuboid(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.8F, 3.0F, -0.2793F, 0.0F, 0.0F));

        ModelPartData abdomen04 = abdomen03.addChild("abdomen04", ModelPartBuilder.create().uv(45, 41).cuboid(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2F, 2.4F, -0.2793F, 0.0F, 0.0F));

        ModelPartData sting = abdomen04.addChild("sting", ModelPartBuilder.create().uv(17, 44).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2F, 2.4F, -0.2793F, 0.0F, 0.0F));

        ModelPartData head = thorax.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -3.5F, -6.0F, 7.0F, 7.0F, 6.0F, new Dilation(0.0F))
                .uv(4, 13).cuboid(-1.0F, 2.0F, -6.01F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.1F, -3.4F));

        ModelPartData lAntenna01 = head.addChild("lAntenna01", ModelPartBuilder.create().uv(44, 0).mirrored().cuboid(-0.5F, -6.0F, 0.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.3F, -3.4F, -5.1F, 0.2793F, 0.0F, 0.3665F));

        ModelPartData lAntenna02 = lAntenna01.addChild("lAntenna02", ModelPartBuilder.create().uv(53, 0).mirrored().cuboid(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.05F, -5.7F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData rAntenna01 = head.addChild("rAntenna01", ModelPartBuilder.create().uv(44, 0).cuboid(-0.5F, -6.0F, 0.0F, 1.0F, 6.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.3F, -3.4F, -5.1F, 0.2793F, 0.0F, -0.3665F));

        ModelPartData rAntenna02 = rAntenna01.addChild("rAntenna02", ModelPartBuilder.create().uv(53, 0).cuboid(-0.5F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.05F, -5.7F, 0.0F, 0.0F, 0.0F, 0.4363F));

        ModelPartData lEye = head.addChild("lEye", ModelPartBuilder.create().uv(15, 51).cuboid(0.0F, -2.0F, -2.5F, 3.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(1.85F, -1.35F, -3.9F, 0.2618F, 0.2618F, -0.576F));

        ModelPartData rEye = head.addChild("rEye", ModelPartBuilder.create().uv(15, 51).mirrored().cuboid(-3.0F, -2.0F, -2.5F, 3.0F, 4.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.85F, -1.35F, -3.9F, 0.2618F, -0.2618F, 0.576F));

        ModelPartData lMandible = head.addChild("lMandible", ModelPartBuilder.create().uv(48, 33).mirrored().cuboid(-1.0F, -1.0F, -5.2F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.0F, 1.6F, -6.3F, 0.4363F, 0.0436F, 0.1309F));

        ModelPartData rMandible = head.addChild("rMandible", ModelPartBuilder.create().uv(48, 33).cuboid(-1.0F, -1.0F, -5.2F, 2.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 1.6F, -6.3F, 0.4363F, -0.0436F, -0.1309F));

        ModelPartData probosis01 = head.addChild("probosis01", ModelPartBuilder.create().uv(51, 49).cuboid(-1.0F, -0.7F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.6F, -5.5F, -0.384F, 0.0F, 0.0F));

        ModelPartData probosis02 = probosis01.addChild("probosis02", ModelPartBuilder.create().uv(52, 55).cuboid(-0.5F, -0.7F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.4F, 0.1F, 0.2443F, 0.0F, 0.0F));

        ModelPartData lLeg01a = thorax.addChild("lLeg01a", ModelPartBuilder.create().uv(0, 44).cuboid(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.8F, 1.0F, -1.0F, 0.0F, 0.3491F, 0.7854F));

        ModelPartData lLeg01b = lLeg01a.addChild("lLeg01b", ModelPartBuilder.create().uv(0, 48).cuboid(-0.5F, -2.0F, -0.49F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.7F, 0.2F, 0.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData lLeg01c = lLeg01b.addChild("lLeg01c", ModelPartBuilder.create().uv(6, 48).cuboid(-0.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, -1.6F, -0.1F, 0.0F, 0.0F, -1.2217F));

        ModelPartData lLeg01d = lLeg01c.addChild("lLeg01d", ModelPartBuilder.create().uv(1, 53).cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 4.8F, 0.0F, 0.1309F, 0.0F, 0.0175F));

        ModelPartData lClaw01_r1 = lLeg01d.addChild("lClaw01_r1", ModelPartBuilder.create().uv(6, 61).cuboid(-1.5F, 0.0F, -2.75F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 1.8326F, 0.0F, 0.0F));

        ModelPartData rLeg01a = thorax.addChild("rLeg01a", ModelPartBuilder.create().uv(0, 44).mirrored().cuboid(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.8F, 1.0F, -1.0F, 0.0F, -0.3491F, -0.7854F));

        ModelPartData rLeg01b = rLeg01a.addChild("rLeg01b", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(-0.5F, -2.0F, -0.49F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.7F, 0.2F, 0.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData rLeg01c = rLeg01b.addChild("rLeg01c", ModelPartBuilder.create().uv(6, 48).mirrored().cuboid(-1.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, -1.6F, -0.1F, 0.0F, 0.0F, 1.2217F));

        ModelPartData rLeg01d = rLeg01c.addChild("rLeg01d", ModelPartBuilder.create().uv(1, 53).mirrored().cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 4.8F, 0.0F, 0.1309F, 0.0F, -0.0175F));

        ModelPartData rClaw01_r1 = rLeg01d.addChild("rClaw01_r1", ModelPartBuilder.create().uv(6, 61).mirrored().cuboid(-1.5F, 0.0F, -2.75F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.0F, 0.0F, 1.8326F, 0.0F, 0.0F));

        ModelPartData lLeg02a = thorax.addChild("lLeg02a", ModelPartBuilder.create().uv(0, 44).cuboid(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.8F, 1.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

        ModelPartData lLeg02b = lLeg02a.addChild("lLeg02b", ModelPartBuilder.create().uv(0, 48).cuboid(-0.5F, -2.0F, -0.49F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6F, 0.2F, 0.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData lLeg02c = lLeg02b.addChild("lLeg02c", ModelPartBuilder.create().uv(6, 48).cuboid(-0.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, -1.6F, -0.1F, 0.0F, 0.0F, -1.2217F));

        ModelPartData lLeg02d = lLeg02c.addChild("lLeg02d", ModelPartBuilder.create().uv(1, 53).cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 4.8F, 0.0F, 0.3054F, 0.0F, 0.0611F));

        ModelPartData lClaw02_r1 = lLeg02d.addChild("lClaw02_r1", ModelPartBuilder.create().uv(6, 61).cuboid(-1.85F, 0.0F, -2.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.2F, 5.0F, 0.0F, 1.6144F, 0.0F, 0.0F));

        ModelPartData rLeg02a = thorax.addChild("rLeg02a", ModelPartBuilder.create().uv(0, 44).mirrored().cuboid(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.8F, 1.0F, 0.5F, 0.0F, 0.0F, -0.7854F));

        ModelPartData rLeg02b = rLeg02a.addChild("rLeg02b", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(-0.5F, -2.0F, -0.49F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.6F, 0.2F, 0.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData rLeg02c = rLeg02b.addChild("rLeg02c", ModelPartBuilder.create().uv(6, 48).mirrored().cuboid(-1.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, -1.6F, -0.1F, 0.0F, 0.0F, 1.2217F));

        ModelPartData rLeg02d = rLeg02c.addChild("rLeg02d", ModelPartBuilder.create().uv(1, 53).mirrored().cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 4.8F, 0.0F, 0.3054F, 0.0F, -0.0611F));

        ModelPartData rClaw02_r1 = rLeg02d.addChild("rClaw02_r1", ModelPartBuilder.create().uv(6, 61).mirrored().cuboid(-1.15F, 0.0F, -2.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.2F, 5.0F, 0.0F, 1.6144F, 0.0F, 0.0F));

        ModelPartData lLeg03a = thorax.addChild("lLeg03a", ModelPartBuilder.create().uv(0, 44).cuboid(0.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.8F, 1.0F, 2.0F, 0.0F, -0.3491F, 0.7854F));

        ModelPartData lLeg03b = lLeg03a.addChild("lLeg03b", ModelPartBuilder.create().uv(0, 48).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6F, 0.2F, 0.0F, 0.0F, 0.0F, 0.6981F));

        ModelPartData lLeg03c = lLeg03b.addChild("lLeg03c", ModelPartBuilder.create().uv(6, 48).cuboid(-0.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, -2.0F, -0.1F, 0.0F, 0.0F, -1.3526F));

        ModelPartData lLeg03d = lLeg03c.addChild("lLeg03d", ModelPartBuilder.create().uv(1, 53).cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 4.8F, 0.0F, 0.4363F, 0.0F, -0.0698F));

        ModelPartData lClaw03_r1 = lLeg03d.addChild("lClaw03_r1", ModelPartBuilder.create().uv(6, 61).cuboid(-1.6F, -0.1F, -2.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 1.4835F, 0.0F, 0.0F));

        ModelPartData rLeg03a = thorax.addChild("rLeg03a", ModelPartBuilder.create().uv(0, 44).mirrored().cuboid(-2.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.8F, 1.0F, 2.0F, 0.0F, 0.3491F, -0.7854F));

        ModelPartData rLeg03b = rLeg03a.addChild("rLeg03b", ModelPartBuilder.create().uv(0, 48).mirrored().cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.6F, 0.2F, 0.0F, 0.0F, 0.0F, -0.6981F));

        ModelPartData rLeg03c = rLeg03b.addChild("rLeg03c", ModelPartBuilder.create().uv(6, 48).mirrored().cuboid(-1.5F, -0.9F, -0.5F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.6F, -2.0F, -0.1F, 0.0F, 0.0F, 1.3526F));

        ModelPartData rLeg03d = rLeg03c.addChild("rLeg03d", ModelPartBuilder.create().uv(1, 53).mirrored().cuboid(-0.5F, 0.0F, -0.49F, 1.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 4.8F, 0.0F, 0.4363F, 0.0F, 0.0698F));

        ModelPartData rClaw03_r1 = rLeg03d.addChild("rClaw03_r1", ModelPartBuilder.create().uv(6, 61).mirrored().cuboid(-1.4F, -0.1F, -2.5F, 3.0F, 0.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.0F, 0.0F, 1.4835F, 0.0F, 0.0F));

        ModelPartData lBackWing = thorax.addChild("lBackWing", ModelPartBuilder.create().uv(11, 7).mirrored().cuboid(0.3F, 0.0F, 0.0F, 7.0F, 0.0F, 16.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-1.9F, -2.8F, 0.0F, 0.2182F, 0.3142F, 0.0524F));

        ModelPartData rBackWing = thorax.addChild("rBackWing", ModelPartBuilder.create().uv(11, 7).cuboid(-7.3F, 0.0F, 0.0F, 7.0F, 0.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(1.9F, -2.8F, 0.0F, 0.2182F, -0.3142F, -0.0524F));

        ModelPartData lFrontWing = thorax.addChild("lFrontWing", ModelPartBuilder.create().uv(22, 7).mirrored().cuboid(-3.2F, 0.0F, 0.0F, 10.0F, 0.0F, 20.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9F, -2.8F, -2.5F, 0.3403F, 0.6545F, 0.1222F));

        ModelPartData rFrontWing = thorax.addChild("rFrontWing", ModelPartBuilder.create().uv(22, 7).cuboid(-6.8F, 0.0F, 0.0F, 10.0F, 0.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, -2.8F, -2.5F, 0.3403F, -0.6545F, -0.1222F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        thorax.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}