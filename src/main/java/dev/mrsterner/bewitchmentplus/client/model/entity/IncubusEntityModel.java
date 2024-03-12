package dev.mrsterner.bewitchmentplus.client.model.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class IncubusEntityModel extends EntityModel<Entity> {
    private final ModelPart body;
    private final ModelPart bipedLeftArm;
    private final ModelPart bipedRightArm;
    private final ModelPart bipedLeftLeg;
    private final ModelPart bipedRightLeg;
    private final ModelPart head;

    public IncubusEntityModel(ModelPart root) {
        this.body = root.getChild("body");
        this.bipedLeftArm = root.getChild("bipedLeftArm");
        this.bipedRightArm = root.getChild("bipedRightArm");
        this.bipedLeftLeg = root.getChild("bipedLeftLeg");
        this.bipedRightLeg = root.getChild("bipedRightLeg");
        this.head = root.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(19, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.7F, 0.0F));

        ModelPartData backLoincloth_r1 = body.addChild("backLoincloth_r1", ModelPartBuilder.create().uv(115, 48).cuboid(-2.5F, 0.5F, -0.25F, 5.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData frontLoincloth_r1 = body.addChild("frontLoincloth_r1", ModelPartBuilder.create().uv(45, 0).cuboid(-2.5F, -1.0F, -0.25F, 5.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.0F, -2.0F, -0.2618F, 0.0F, 0.0F));

        ModelPartData frontSash_r1 = body.addChild("frontSash_r1", ModelPartBuilder.create().uv(86, 14).cuboid(-5.5F, -1.75F, 0.4F, 11.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -4.0F, -0.0436F, 0.0F, 0.0F));

        ModelPartData rPec_r1 = body.addChild("rPec_r1", ModelPartBuilder.create().uv(17, 33).mirrored().cuboid(-4.75F, 0.2F, -3.4F, 5.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.1047F, -0.0873F));

        ModelPartData lPec_r1 = body.addChild("lPec_r1", ModelPartBuilder.create().uv(17, 33).cuboid(-0.25F, 0.2F, -3.4F, 5.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.1047F, 0.0873F));

        ModelPartData lWing01 = body.addChild("lWing01", ModelPartBuilder.create().uv(26, 39).mirrored().cuboid(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.5F, 3.2F, 1.4F, 0.2618F, 0.5236F, 0.0F));

        ModelPartData lWing02 = lWing01.addChild("lWing02", ModelPartBuilder.create().uv(38, 52).mirrored().cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 0.2F, 6.4F, 1.1781F, 0.0F, 0.0F));

        ModelPartData lWing03 = lWing02.addChild("lWing03", ModelPartBuilder.create().uv(29, 54).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, -0.5F, 8.1F, -0.3403F, 0.0F, 0.0F));

        ModelPartData lWing04 = lWing03.addChild("lWing04", ModelPartBuilder.create().uv(22, 47).mirrored().cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 15.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 7.7F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData lWingMembrane03 = lWing03.addChild("lWingMembrane03", ModelPartBuilder.create().uv(61, 13).mirrored().cuboid(0.01F, -3.0F, -25.5F, 0.0F, 24.0F, 27.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 2.4F, -0.4F));

        ModelPartData lWingMembrane02 = lWing02.addChild("lWingMembrane02", ModelPartBuilder.create().uv(61, 12).mirrored().cuboid(0.0F, -2.5F, -2.5F, 0.0F, 16.0F, 12.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.5F, 0.0F, -1.3177F, 0.0F, 0.0F));

        ModelPartData lWingMembrane01 = lWing01.addChild("lWingMembrane01", ModelPartBuilder.create().uv(61, 2).mirrored().cuboid(-0.01F, -0.2F, -1.7F, 0.0F, 11.0F, 11.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -1.1F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData rWing01 = body.addChild("rWing01", ModelPartBuilder.create().uv(26, 39).cuboid(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, 3.2F, 1.4F, 0.2618F, -0.5236F, 0.0F));

        ModelPartData rWing02 = rWing01.addChild("rWing02", ModelPartBuilder.create().uv(38, 52).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 0.2F, 6.4F, 1.1781F, 0.0F, 0.0F));

        ModelPartData rWing03 = rWing02.addChild("rWing03", ModelPartBuilder.create().uv(29, 54).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, -0.5F, 8.1F, -0.3403F, 0.0F, 0.0F));

        ModelPartData rWing04 = rWing03.addChild("rWing04", ModelPartBuilder.create().uv(22, 47).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 15.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.7F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData rWingMembrane03 = rWing03.addChild("rWingMembrane03", ModelPartBuilder.create().uv(61, 13).cuboid(-0.01F, -3.0F, -25.5F, 0.0F, 24.0F, 27.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 2.4F, -0.4F));

        ModelPartData rWingMembrane02 = rWing02.addChild("rWingMembrane02", ModelPartBuilder.create().uv(61, 12).cuboid(0.0F, -2.5F, -2.5F, 0.0F, 16.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.0F, -1.3177F, 0.0F, 0.0F));

        ModelPartData rWingMembrane01 = rWing01.addChild("rWingMembrane01", ModelPartBuilder.create().uv(61, 2).cuboid(0.01F, -0.2F, -1.7F, 0.0F, 11.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.1F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData capeUpper = body.addChild("capeUpper", ModelPartBuilder.create().uv(78, 1).cuboid(-5.0F, -0.3F, -0.1F, 10.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.2F, 2.0F, 0.1222F, 0.0F, 0.0F));

        ModelPartData capeLower = capeUpper.addChild("capeLower", ModelPartBuilder.create().uv(39, 33).cuboid(-4.5F, -0.3F, -0.1F, 9.0F, 11.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.7F, 0.0F, -0.0698F, 0.0F, 0.0F));

        ModelPartData bipedLeftArm = modelPartData.addChild("bipedLeftArm", ModelPartBuilder.create().uv(44, 15).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -5.7F, 0.0F, 0.0F, 0.0F, -0.1F));

        ModelPartData lCape = bipedLeftArm.addChild("lCape", ModelPartBuilder.create().uv(0, 50).cuboid(-2.5F, -2.7F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.75F, 0.45F, 0.3F, 0.0F, 0.0F, -0.1F));

        ModelPartData bipedRightArm = modelPartData.addChild("bipedRightArm", ModelPartBuilder.create().uv(44, 15).mirrored().cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, -5.7F, 0.0F, 0.0F, 0.0F, 0.1F));

        ModelPartData bipedLeftLeg = modelPartData.addChild("bipedLeftLeg", ModelPartBuilder.create().uv(0, 17).mirrored().cuboid(-2.0F, -1.3F, -2.7F, 4.0F, 10.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.1F, 6.3F, 0.1F, -0.1745F, 0.0F, -0.1047F));

        ModelPartData lLeg02 = bipedLeftLeg.addChild("lLeg02", ModelPartBuilder.create().uv(0, 32).mirrored().cuboid(-1.5F, -0.1F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 7.9F, -0.4F, 0.4014F, 0.0F, 0.1047F));

        ModelPartData lLeg03 = lLeg02.addChild("lLeg03", ModelPartBuilder.create().uv(0, 42).mirrored().cuboid(-1.0F, -0.3F, -1.5F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.9F, 0.2F, -0.2094F, 0.0F, 0.0F));

        ModelPartData lTalon01 = lLeg03.addChild("lTalon01", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.5F, 3.5F, 0.0F, 0.0349F, -0.3142F, 0.0F));

        ModelPartData lTalon0 = lLeg03.addChild("lTalon0", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 3.3F, 0.0F, 0.0349F, 0.0F, 0.0F));

        ModelPartData lTalon03 = lLeg03.addChild("lTalon03", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 3.5F, 0.0F, 0.0349F, 0.3142F, 0.0F));

        ModelPartData bipedRightLeg = modelPartData.addChild("bipedRightLeg", ModelPartBuilder.create().uv(0, 17).mirrored().cuboid(-2.0F, -1.3F, -2.7F, 4.0F, 10.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.1F, 6.3F, 0.1F, -0.1745F, 0.0F, 0.1047F));

        ModelPartData rLeg02 = bipedRightLeg.addChild("rLeg02", ModelPartBuilder.create().uv(0, 32).mirrored().cuboid(-1.5F, -0.1F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 7.9F, -0.4F, 0.4014F, 0.0F, -0.1047F));

        ModelPartData rLeg03 = rLeg02.addChild("rLeg03", ModelPartBuilder.create().uv(0, 42).mirrored().cuboid(-1.0F, -0.3F, -1.5F, 2.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.9F, 0.2F, -0.2094F, 0.0F, 0.0F));

        ModelPartData rTalon01 = rLeg03.addChild("rTalon01", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 3.5F, 0.0F, 0.0349F, 0.3142F, 0.0F));

        ModelPartData rTalon0 = rLeg03.addChild("rTalon0", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 3.3F, 0.0F, 0.0349F, 0.0F, 0.0F));

        ModelPartData rTalon03 = rLeg03.addChild("rTalon03", ModelPartBuilder.create().uv(12, 42).mirrored().cuboid(-0.5F, -0.5F, -4.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.5F, 3.5F, 0.0F, 0.0349F, -0.3142F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(93, 22).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.25F))
                .uv(59, 0).cuboid(-4.0F, -3.0F, 2.75F, 8.0F, 9.0F, 1.0F, new Dilation(-0.05F)), ModelTransform.pivot(0.0F, -7.7F, 0.0F));

        ModelPartData lHorn01 = head.addChild("lHorn01", ModelPartBuilder.create().uv(108, 0).mirrored().cuboid(-1.5F, -3.4F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.9F, -6.9F, -0.3F, 0.3054F, -0.2618F, 0.7854F));

        ModelPartData lHorn02 = lHorn01.addChild("lHorn02", ModelPartBuilder.create().uv(109, 7).mirrored().cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.1F, 0.0F, 0.2618F, -0.6981F, -0.2618F));

        ModelPartData lHorn03 = lHorn02.addChild("lHorn03", ModelPartBuilder.create().uv(118, 5).mirrored().cuboid(-1.1F, -2.8F, -0.99F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F)).mirrored(false), ModelTransform.of(0.25F, -3.5F, 0.25F, 0.48F, 0.0F, -0.5934F));

        ModelPartData lHorn04a = lHorn03.addChild("lHorn04a", ModelPartBuilder.create().uv(0, 4).mirrored().cuboid(-0.4F, -3.0F, -0.7F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)).mirrored(false), ModelTransform.of(-0.05F, -2.0F, 0.0F, -0.4538F, 0.0F, -0.4014F));

        ModelPartData lHorn05 = lHorn04a.addChild("lHorn05", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-0.5F, -2.0F, -0.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.8F, 0.0F, -0.384F, 0.0F, 0.2269F));

        ModelPartData rHorn01 = head.addChild("rHorn01", ModelPartBuilder.create().uv(108, 0).cuboid(-1.5F, -3.4F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-2.9F, -6.9F, -0.3F, 0.3054F, 0.2618F, -0.7854F));

        ModelPartData rHorn02 = rHorn01.addChild("rHorn02", ModelPartBuilder.create().uv(109, 7).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.1F, 0.0F, 0.2618F, 0.6981F, 0.2618F));

        ModelPartData rHorn03 = rHorn02.addChild("rHorn03", ModelPartBuilder.create().uv(118, 5).cuboid(-0.9F, -2.8F, -0.99F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.of(-0.25F, -3.5F, 0.25F, 0.48F, 0.0F, 0.5934F));

        ModelPartData rHorn04 = rHorn03.addChild("rHorn04", ModelPartBuilder.create().uv(0, 4).cuboid(-0.6F, -3.0F, -0.7F, 1.0F, 3.0F, 1.0F, new Dilation(0.15F)), ModelTransform.of(0.05F, -2.0F, 0.0F, -0.4538F, 0.0F, 0.4014F));

        ModelPartData rHorn05 = rHorn04.addChild("rHorn05", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -2.0F, -0.75F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.8F, 0.0F, -0.384F, 0.0F, -0.2269F));
        return TexturedModelData.of(modelData, 128, 64);
    }

    @Override
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bipedLeftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bipedRightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bipedLeftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        bipedRightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}