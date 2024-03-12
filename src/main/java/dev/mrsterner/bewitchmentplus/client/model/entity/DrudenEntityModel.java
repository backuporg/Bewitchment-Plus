package dev.mrsterner.bewitchmentplus.client.model.entity;

import dev.mrsterner.bewitchmentplus.common.entity.DrudenEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
@Environment(EnvType.CLIENT)
public class DrudenEntityModel extends BipedEntityModel<DrudenEntity> {
    private final ModelPart body;
    private final ModelPart bipedLeftArm;
    private final ModelPart bipedRightArm;
    private final ModelPart bipedLeftLeg;
    private final ModelPart bipedRightLeg;
    private final ModelPart head;

    public DrudenEntityModel(ModelPart root) {
        super(root);
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
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(19, 17).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.7F, 0.0F));

        ModelPartData boobs = body.addChild("boobs", ModelPartBuilder.create().uv(0, 57).cuboid(-3.5F, 0.0F, -2.0F, 7.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.9F, -0.3F, -0.5585F, 0.0F, 0.0F));

        ModelPartData stomach = body.addChild("stomach", ModelPartBuilder.create().uv(19, 27).cuboid(-3.5F, 0.0F, -2.0F, 7.0F, 8.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData bSkirt01 = stomach.addChild("bSkirt01", ModelPartBuilder.create().uv(62, 22).cuboid(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.1F, 0.0F, 0.4189F, 0.0F, 0.0F));

        ModelPartData bSkirt02 = bSkirt01.addChild("bSkirt02", ModelPartBuilder.create().uv(62, 22).cuboid(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 3.1F, 0.2F, -0.4189F, 0.0F, 0.0F));

        ModelPartData lSkirt = stomach.addChild("lSkirt", ModelPartBuilder.create().uv(88, 22).cuboid(0.0F, 0.0F, -2.5F, 2.0F, 14.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.2F, 5.8F, 0.0F, -0.0698F, 0.0F, -0.0873F));

        ModelPartData rSkirt = stomach.addChild("rSkirt", ModelPartBuilder.create().uv(88, 22).mirrored().cuboid(-1.9F, 0.0F, -2.5F, 2.0F, 14.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.2F, 5.8F, 0.0F, -0.0698F, 0.0F, 0.0873F));

        ModelPartData bipedLeftArm = modelPartData.addChild("bipedLeftArm", ModelPartBuilder.create().uv(44, 14).cuboid(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -7.7F, 0.0F, 0.0F, 0.0F, -0.1F));

        ModelPartData lArmLeaves01 = bipedLeftArm.addChild("lArmLeaves01", ModelPartBuilder.create().uv(33, 39).cuboid(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 5.3F, 0.0F));

        ModelPartData lArmLeaves02 = lArmLeaves01.addChild("lArmLeaves02", ModelPartBuilder.create().uv(13, 39).cuboid(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData lClaw01 = bipedLeftArm.addChild("lClaw01", ModelPartBuilder.create().uv(0, 0).cuboid(-0.2F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 11.2F, -1.5F, -0.1047F, 0.0F, 0.2269F));

        ModelPartData lClaw02 = bipedLeftArm.addChild("lClaw02", ModelPartBuilder.create().uv(0, 0).cuboid(-0.2F, -1.2F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 11.2F, 0.0F, 0.0F, 0.0F, 0.2269F));

        ModelPartData lClaw03 = bipedLeftArm.addChild("lClaw03", ModelPartBuilder.create().uv(0, 0).cuboid(-0.2F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6F, 11.2F, 1.5F, 0.1047F, 0.0F, 0.2269F));

        ModelPartData bipedRightArm = modelPartData.addChild("bipedRightArm", ModelPartBuilder.create().uv(44, 14).mirrored().cuboid(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-5.0F, -7.7F, 0.0F, 0.0F, 0.0F, 0.1F));

        ModelPartData rArmLeaves01 = bipedRightArm.addChild("rArmLeaves01", ModelPartBuilder.create().uv(33, 39).mirrored().cuboid(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-0.5F, 5.3F, 0.0F));

        ModelPartData rArmLeaves02 = rArmLeaves01.addChild("rArmLeaves02", ModelPartBuilder.create().uv(13, 39).mirrored().cuboid(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rClaw01 = bipedRightArm.addChild("rClaw01", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.8F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.6F, 11.2F, -1.5F, -0.1047F, 0.0F, -0.2269F));

        ModelPartData rClaw02 = bipedRightArm.addChild("rClaw02", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.8F, -1.2F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.6F, 11.2F, 0.0F, 0.0F, 0.0F, -0.2269F));

        ModelPartData rClaw03 = bipedRightArm.addChild("rClaw03", ModelPartBuilder.create().uv(0, 0).mirrored().cuboid(-1.8F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.6F, 11.2F, 1.5F, 0.1047F, 0.0F, -0.2269F));

        ModelPartData bipedLeftLeg = modelPartData.addChild("bipedLeftLeg", ModelPartBuilder.create().uv(0, 18).cuboid(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(2.1F, 4.3F, 0.1F, -0.3491F, 0.0F, -0.1047F));

        ModelPartData lLeg02 = bipedLeftLeg.addChild("lLeg02", ModelPartBuilder.create().uv(0, 31).cuboid(-1.5F, 0.0F, -2.7F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.7F, -0.4F, 0.7418F, 0.0F, 0.1047F));

        ModelPartData lLeg03 = lLeg02.addChild("lLeg03", ModelPartBuilder.create().uv(0, 42).cuboid(-1.0F, 1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.2F, 0.2F, -0.4189F, 0.0F, 0.0F));

        ModelPartData lHoofClaw01a = lLeg03.addChild("lHoofClaw01a", ModelPartBuilder.create().uv(20, 57).cuboid(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 7.4F, -1.3F, 0.1745F, -0.1396F, -0.0349F));

        ModelPartData lHoofClaw01b = lHoofClaw01a.addChild("lHoofClaw01b", ModelPartBuilder.create().uv(27, 56).cuboid(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData lHoofClaw02a = lLeg03.addChild("lHoofClaw02a", ModelPartBuilder.create().uv(20, 57).cuboid(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 7.4F, -1.3F, 0.1745F, 0.0873F, 0.0349F));

        ModelPartData lHoofClaw02b = lHoofClaw02a.addChild("lHoofClaw02b", ModelPartBuilder.create().uv(27, 56).cuboid(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData bipedRightLeg = modelPartData.addChild("bipedRightLeg", ModelPartBuilder.create().uv(0, 18).mirrored().cuboid(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-2.1F, 4.3F, 0.1F, -0.3491F, 0.0F, 0.1047F));

        ModelPartData rLeg02 = bipedRightLeg.addChild("rLeg02", ModelPartBuilder.create().uv(0, 31).mirrored().cuboid(-1.5F, 0.0F, -2.7F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.7F, -0.4F, 0.7418F, 0.0F, -0.1047F));

        ModelPartData rLeg03 = rLeg02.addChild("rLeg03", ModelPartBuilder.create().uv(0, 42).mirrored().cuboid(-1.0F, 1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 5.2F, 0.2F, -0.4189F, 0.0F, 0.0F));

        ModelPartData rHoofClaw01a = rLeg03.addChild("rHoofClaw01a", ModelPartBuilder.create().uv(20, 57).mirrored().cuboid(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.5F, 7.4F, -1.3F, 0.1745F, 0.1396F, 0.0349F));

        ModelPartData rHoofClaw01b = rHoofClaw01a.addChild("rHoofClaw01b", ModelPartBuilder.create().uv(27, 56).mirrored().cuboid(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData rHoofClaw02a = rLeg03.addChild("rHoofClaw02a", ModelPartBuilder.create().uv(20, 57).mirrored().cuboid(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.5F, 7.4F, -1.3F, 0.1745F, -0.0873F, -0.0349F));

        ModelPartData rHoofClaw02b = rHoofClaw02a.addChild("rHoofClaw02b", ModelPartBuilder.create().uv(27, 56).mirrored().cuboid(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 1).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.7F, 0.0F));

        ModelPartData lAntler01 = head.addChild("lAntler01", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.9F, -7.1F, -0.5F, -0.2094F, 0.0F, 0.3491F));

        ModelPartData lAntler02 = lAntler01.addChild("lAntler02", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.6F, 0.0F, -0.2094F, 0.0F, 0.6109F));

        ModelPartData Box_r1 = lAntler02.addChild("Box_r1", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.6F, -2.9F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(0.1F, -0.6F, 0.5F, -0.0873F, 0.0F, -0.0436F));

        ModelPartData rightAntler02 = lAntler02.addChild("rightAntler02", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -3.1F, 0.0F, -0.6981F, 0.0F, -0.3142F));

        ModelPartData lAntler03a = rightAntler02.addChild("lAntler03a", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -3.7F, 0.0F, -0.4538F, 0.0F, -0.0524F));

        ModelPartData lAntler03b = lAntler03a.addChild("lAntler03b", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -3.9F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.8F, 0.0F, -0.1047F, 0.0F, -0.2793F));

        ModelPartData lAntler03c = lAntler03b.addChild("lAntler03c", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -3.0F, -0.4F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -3.7F, 0.0F, 0.0F, 0.0F, -0.4363F));

        ModelPartData lAntler04a = rightAntler02.addChild("lAntler04a", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.2F, -5.9F, 1.0F, 0.4538F, 0.0F, -0.8029F));

        ModelPartData lAntler04b = lAntler04a.addChild("lAntler04b", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, -0.3142F));

        ModelPartData lAntler05a = rightAntler02.addChild("lAntler05a", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.3F, -6.7F, 1.4F, -0.0349F, 0.0F, -0.5236F));

        ModelPartData lAntler05b = lAntler05a.addChild("lAntler05b", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, -0.5236F));

        ModelPartData lAntler06a = lAntler02.addChild("lAntler06a", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.5F, -0.4F, -1.3963F, 0.6981F, -0.4363F));

        ModelPartData lAntler06b = lAntler06a.addChild("lAntler06b", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 0.0F, -3.4F, 0.0F, 0.576F, 0.0F));

        ModelPartData lAntler07a = lAntler01.addChild("lAntler07a", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, -2.0F, -0.4F, -0.9076F, 0.5236F, 0.0F));

        ModelPartData lAntler07b = lAntler07a.addChild("lAntler07b", ModelPartBuilder.create().uv(49, 34).mirrored().cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.1F, 0.0F, -3.4F, 0.0F, 0.576F, 0.0F));

        ModelPartData rAntler01 = head.addChild("rAntler01", ModelPartBuilder.create().uv(49, 34).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.9F, -7.1F, -0.5F, -0.2094F, 0.0F, -0.3491F));

        ModelPartData rAntler02 = rAntler01.addChild("rAntler02", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.6F, 0.0F, -0.2094F, 0.0F, -0.6109F));

        ModelPartData Box_r2 = rAntler02.addChild("Box_r2", ModelPartBuilder.create().uv(49, 34).cuboid(-0.4F, -2.9F, -1.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.2F)), ModelTransform.of(-0.1F, -0.6F, 0.5F, -0.0873F, 0.0F, 0.0436F));

        ModelPartData rAntler03a = rAntler02.addChild("rAntler03a", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.1F, 0.0F, -0.6981F, 0.0F, 0.3142F));

        ModelPartData rAntler03b = rAntler03a.addChild("rAntler03b", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.7F, 0.0F, -0.4538F, 0.0F, 0.0524F));

        ModelPartData rAntler03c = rAntler03b.addChild("rAntler03c", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -3.9F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.8F, 0.0F, -0.1047F, 0.0F, 0.2793F));

        ModelPartData rAntler03d = rAntler03c.addChild("rAntler03d", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -3.0F, -0.4F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.7F, 0.0F, 0.0F, 0.0F, 0.4363F));

        ModelPartData rAntler04a = rAntler03a.addChild("rAntler04a", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.2F, -5.9F, 1.0F, 0.4538F, 0.0F, 0.8029F));

        ModelPartData rAntler04b = rAntler04a.addChild("rAntler04b", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, 0.3142F));

        ModelPartData rAntler05a = rAntler03a.addChild("rAntler05a", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.3F, -6.7F, 1.4F, -0.0349F, 0.0F, 0.5236F));

        ModelPartData rAntler05b = rAntler05a.addChild("rAntler05b", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, 0.5236F));

        ModelPartData rAntler06a = rAntler02.addChild("rAntler06a", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, -0.4F, -1.3963F, -0.6981F, 0.4363F));

        ModelPartData rAntler06b = rAntler06a.addChild("rAntler06b", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 0.0F, -3.4F, 0.0F, -0.576F, 0.0F));

        ModelPartData rAntler07a = rAntler01.addChild("rAntler07a", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, -0.4F, -0.9076F, -0.5236F, 0.0F));

        ModelPartData rAntler07b = rAntler07a.addChild("rAntler07b", ModelPartBuilder.create().uv(49, 34).cuboid(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 0.0F, -3.4F, 0.0F, -0.576F, 0.0F));

        ModelPartData hood = head.addChild("hood", ModelPartBuilder.create().uv(69, 0).cuboid(-4.5F, -8.5F, -4.4F, 9.0F, 11.0F, 9.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData HAIR = head.addChild("HAIR", ModelPartBuilder.create().uv(46, 1).cuboid(-4.0F, 5.0F, 1.2F, 8.0F, 11.0F, 1.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, -7.3F, 2.0F));

        ModelPartData Base_r1 = HAIR.addChild("Base_r1", ModelPartBuilder.create().uv(53, 46).cuboid(-5.0F, -3.0F, -1.0F, 6.0F, 12.0F, 6.0F, new Dilation(0.1F)), ModelTransform.of(0.0F, 3.0F, -2.0F, 0.4363F, 0.7854F, 0.3054F));
        return TexturedModelData.of(modelData, 128, 64);
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

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        realArm = false;
        super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);
        realArm = true;
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

        this.bipedRightArm.pitch = -MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 2.0F * limbDistance * 0.55F;
        this.bipedLeftArm.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 2.0F * limbDistance * 0.55F;
        float j = MathHelper.sin(entity.handSwingProgress * 3.1415927F);
        if (j > 0) {
            this.bipedRightArm.pitch = -j;
            if (entity.getDataTracker().get(DrudenEntity.SPEAR_LUNGE)) {
                this.bipedLeftArm.pitch = -j;
            }
        }
    }

    private void setRotation(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

    @Override
    public void setArmAngle(Arm arm, MatrixStack matrices) {
        super.setArmAngle(arm, matrices);
        matrices.translate(0, 0.20, 0);
    }

    protected ModelPart getArm(Arm arm) {
        return arm == Arm.LEFT ? this.bipedLeftArm : this.bipedRightArm;
    }

    private void copyRotation(ModelPart to, ModelPart from) {
        to.pitch = from.pitch;
        to.yaw = from.yaw;
        to.roll = from.roll;
    }
}