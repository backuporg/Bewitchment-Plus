package dev.mrsterner.bewitchmentplus.client.model.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CleaverEntityModel extends EntityModel<Entity> {
    private final ModelPart body;
    private final ModelPart bipedLeftArm;
    private final ModelPart bipedRightArm;
    private final ModelPart bipedLeftLeg;
    private final ModelPart bipedRightLeg;
    private final ModelPart head;

    public CleaverEntityModel(ModelPart root) {
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
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 13.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.7F, 0.0F));

        ModelPartData loincloth = body.addChild("loincloth", ModelPartBuilder.create().uv(48, 34).cuboid(-3.0F, 0.0F, -0.5F, 6.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.6F, -1.5F, -0.3491F, 0.0F, 0.0F));

        ModelPartData loincloth02 = loincloth.addChild("loincloth02", ModelPartBuilder.create().uv(48, 43).cuboid(-3.0F, 0.05F, -0.55F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.7F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData loinclothBack = body.addChild("loinclothBack", ModelPartBuilder.create().uv(48, 51).cuboid(-3.5F, 0.05F, -0.25F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 10.6F, 1.6F));

        ModelPartData bipedLeftArm = modelPartData.addChild("bipedLeftArm", ModelPartBuilder.create().uv(40, 16).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -3.7F, 0.0F, 0.0F, 0.0F, -0.1F));

        ModelPartData bipedRightArm = modelPartData.addChild("bipedRightArm", ModelPartBuilder.create().uv(40, 16).mirrored().cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, -3.7F, 0.0F, 0.0F, 0.0F, 0.1F));

        ModelPartData bipedLeftLeg = modelPartData.addChild("bipedLeftLeg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-1.8F, -0.9F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.1F, 6.7F, 0.1F, -0.3491F, 0.0F, -0.1047F));

        ModelPartData lLeg02 = bipedLeftLeg.addChild("lLeg02", ModelPartBuilder.create().uv(24, 33).mirrored().cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.3F, 6.7F, -0.7F, 0.7679F, 0.0F, 0.1047F));

        ModelPartData lLeg03 = lLeg02.addChild("lLeg03", ModelPartBuilder.create().uv(24, 43).mirrored().cuboid(-1.49F, -0.4F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.4F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData lHoof = lLeg03.addChild("lHoof", ModelPartBuilder.create().uv(25, 52).mirrored().cuboid(-1.5F, -0.7F, -1.9F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 5.2F, -0.7F));

        ModelPartData bipedRightLeg = modelPartData.addChild("bipedRightLeg", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.2F, -0.9F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.0F, 6.7F, 0.1F, -0.3491F, 0.0F, 0.1047F));

        ModelPartData rLeg02 = bipedRightLeg.addChild("rLeg02", ModelPartBuilder.create().uv(24, 33).mirrored().cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.3F, 6.7F, -0.7F, 0.7679F, 0.0F, -0.1047F));

        ModelPartData rLeg03 = rLeg02.addChild("rLeg03", ModelPartBuilder.create().uv(24, 43).mirrored().cuboid(-1.51F, -0.4F, -1.5F, 3.0F, 6.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.4F, 0.0F, -0.4363F, 0.0F, 0.0F));

        ModelPartData rHoof = rLeg03.addChild("rHoof", ModelPartBuilder.create().uv(25, 52).mirrored().cuboid(-1.5F, -0.7F, -1.9F, 3.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 5.2F, -0.7F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -5.7F, 0.0F));

        ModelPartData upperJaw = head.addChild("upperJaw", ModelPartBuilder.create().uv(0, 46).cuboid(-3.0F, -0.65F, -4.7F, 6.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.8F, -4.1F));

        ModelPartData upperTeethL = upperJaw.addChild("upperTeethL", ModelPartBuilder.create().uv(52, 58).cuboid(-1.2F, 0.0F, -1.7F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 2.2F, -2.8F));

        ModelPartData upperTeethR = upperJaw.addChild("upperTeethR", ModelPartBuilder.create().uv(52, 58).mirrored().cuboid(-0.8F, 0.0F, -1.7F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-2.0F, 2.2F, -2.8F));

        ModelPartData snout = head.addChild("snout", ModelPartBuilder.create().uv(0, 35).cuboid(-2.5F, -2.05F, -6.4F, 5.0F, 3.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, -2.3F, 0.3491F, 0.0F, 0.0F));

        ModelPartData lowerJaw = head.addChild("lowerJaw", ModelPartBuilder.create().uv(0, 55).cuboid(-2.5F, -0.5F, -5.0F, 5.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.9F, -3.5F, -0.0349F, 0.0F, 0.0F));

        ModelPartData lowerTeethL = lowerJaw.addChild("lowerTeethL", ModelPartBuilder.create().uv(24, 58).cuboid(-0.2F, -2.0F, -1.4F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.2F, -0.4F, -3.5F));

        ModelPartData lowerTeethR = lowerJaw.addChild("lowerTeethR", ModelPartBuilder.create().uv(24, 58).cuboid(-0.8F, -2.0F, -1.4F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.2F, -0.4F, -3.5F));

        ModelPartData lowerTeethM = lowerJaw.addChild("lowerTeethM", ModelPartBuilder.create().uv(35, 61).cuboid(-1.5F, -1.1F, -1.4F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -0.4F, -3.5F));

        ModelPartData lEar01 = head.addChild("lEar01", ModelPartBuilder.create().uv(47, 0).cuboid(0.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(3.4F, -5.5F, 0.0F, -0.6981F, 0.0873F, 0.3491F));

        ModelPartData lEar02 = lEar01.addChild("lEar02", ModelPartBuilder.create().uv(48, 5).cuboid(0.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.2276F));

        ModelPartData rEar01 = head.addChild("rEar01", ModelPartBuilder.create().uv(47, 0).mirrored().cuboid(-5.0F, -0.5F, -1.5F, 5.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-3.4F, -5.5F, 0.0F, -0.6981F, 0.0873F, -0.3491F));

        ModelPartData rEar02 = rEar01.addChild("rEar02", ModelPartBuilder.create().uv(48, 5).mirrored().cuboid(-4.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -0.9F, 0.0F, 0.0F, 0.0F, -0.2276F));

        ModelPartData lHorn01 = head.addChild("lHorn01", ModelPartBuilder.create().uv(37, 37).mirrored().cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.8F, -6.8F, 2.0F, 0.0873F, 0.0F, 0.7854F));

        ModelPartData lHorn02 = lHorn01.addChild("lHorn02", ModelPartBuilder.create().uv(39, 38).mirrored().cuboid(-0.4F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.1F, -1.9F, 0.2F, 0.2793F, 0.0F, -0.2618F));

        ModelPartData lHorn03 = lHorn02.addChild("lHorn03", ModelPartBuilder.create().uv(38, 43).mirrored().cuboid(-0.3F, -2.9F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.1396F, 0.0F, -0.3491F));

        ModelPartData lHorn04 = lHorn03.addChild("lHorn04", ModelPartBuilder.create().uv(43, 43).mirrored().cuboid(-0.2F, -2.4F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.3F, 0.0F, 0.1396F, 0.0F, -0.3491F));

        ModelPartData rHorn01 = head.addChild("rHorn01", ModelPartBuilder.create().uv(37, 37).mirrored().cuboid(-1.0F, -2.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.8F, -6.8F, 2.0F, 0.0873F, 0.0F, -0.7854F));

        ModelPartData rHorn02 = rHorn01.addChild("rHorn02", ModelPartBuilder.create().uv(39, 38).mirrored().cuboid(-0.6F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(-0.1F, -1.9F, 0.2F, 0.2793F, 0.0F, 0.2618F));

        ModelPartData rHorn03 = rHorn02.addChild("rHorn03", ModelPartBuilder.create().uv(38, 43).mirrored().cuboid(-0.7F, -2.9F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.1396F, 0.0F, 0.3491F));

        ModelPartData rHorn04 = rHorn03.addChild("rHorn04", ModelPartBuilder.create().uv(43, 43).mirrored().cuboid(-0.9F, -2.4F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.3F, 0.0F, 0.1396F, 0.0F, 0.3491F));
        return TexturedModelData.of(modelData, 64, 64);
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

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        copyRotation(head, super.head);
        copyRotation(bipedLeftArm, super.leftArm);
        bipedLeftArm.roll -= 0.1309f;
        copyRotation(bipedRightArm, super.rightArm);
        bipedRightArm.roll += 0.1309f;
        copyRotation(bipedLeftLeg, super.leftLeg);
        bipedLeftLeg.pitch /= 2;
        bipedLeftLeg.pitch -= 0.2793f;
        bipedLeftLeg.roll -= 0.1047f;
        copyRotation(bipedRightLeg, super.rightLeg);
        bipedRightLeg.pitch /= 2;
        bipedRightLeg.pitch -= 0.2793f;
        bipedRightLeg.roll += 0.1047f;
    }

    private void copyRotation(ModelPart to, ModelPart from) {
        to.pitch = from.pitch;
        to.yaw = from.yaw;
        to.roll = from.roll;
    }

    protected ModelPart getArm(Arm arm) {
        return arm == Arm.LEFT ? this.bipedLeftArm : this.bipedRightArm;
    }

    @Override
    public void setArmAngle(Arm arm, MatrixStack matrices) {
        super.setArmAngle(arm, matrices);
        matrices.translate(0, 0.05, 0);
    }

    @Override
    public ModelPart getHead() {
        return head;
    }
}