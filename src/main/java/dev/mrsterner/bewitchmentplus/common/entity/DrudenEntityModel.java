package dev.mrsterner.bewitchmentplus.common.entity;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartData;

public class DrudenEntityModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "druden"), "main");
	private final ModelPart body;
	private final ModelPart bipedLeftArm;
	private final ModelPart bipedRightArm;
	private final ModelPart bipedLeftLeg;
	private final ModelPart bipedRightLeg;
	private final ModelPart head;

	public DrudenEntityModel(ModelPart root) {
		this.body = root.getChild("body");
		this.bipedLeftArm = root.getChild("bipedLeftArm");
		this.bipedRightArm = root.getChild("bipedRightArm");
		this.bipedLeftLeg = root.getChild("bipedLeftLeg");
		this.bipedRightLeg = root.getChild("bipedRightLeg");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		ModelPartData ModelPartData = meshdefinition.getRoot();

		ModelPartData body = ModelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(19, 17).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.7F, 0.0F));

		ModelPartData boobs = body.addOrReplaceChild("boobs", CubeListBuilder.create().texOffs(0, 57).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9F, -0.3F, -0.5585F, 0.0F, 0.0F));

		ModelPartData stomach = body.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(19, 27).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		ModelPartData bSkirt01 = stomach.addOrReplaceChild("bSkirt01", CubeListBuilder.create().texOffs(62, 22).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.1F, 0.0F, 0.4189F, 0.0F, 0.0F));

		ModelPartData bSkirt02 = bSkirt01.addOrReplaceChild("bSkirt02", CubeListBuilder.create().texOffs(62, 22).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.1F, 0.2F, -0.4189F, 0.0F, 0.0F));

		ModelPartData lSkirt = stomach.addOrReplaceChild("lSkirt", CubeListBuilder.create().texOffs(88, 22).addBox(0.0F, 0.0F, -2.5F, 2.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 5.8F, 0.0F, -0.0698F, 0.0F, -0.0873F));

		ModelPartData rSkirt = stomach.addOrReplaceChild("rSkirt", CubeListBuilder.create().texOffs(88, 22).mirror().addBox(-1.9F, 0.0F, -2.5F, 2.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.2F, 5.8F, 0.0F, -0.0698F, 0.0F, 0.0873F));

		ModelPartData bipedLeftArm = ModelPartData.addOrReplaceChild("bipedLeftArm", CubeListBuilder.create().texOffs(44, 14).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -7.7F, 0.0F, 0.0F, 0.0F, -0.1F));

		ModelPartData lArmLeaves01 = bipedLeftArm.addOrReplaceChild("lArmLeaves01", CubeListBuilder.create().texOffs(33, 39).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 5.3F, 0.0F));

		ModelPartData lArmLeaves02 = lArmLeaves01.addOrReplaceChild("lArmLeaves02", CubeListBuilder.create().texOffs(13, 39).addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		ModelPartData lClaw01 = bipedLeftArm.addOrReplaceChild("lClaw01", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 11.2F, -1.5F, -0.1047F, 0.0F, 0.2269F));

		ModelPartData lClaw02 = bipedLeftArm.addOrReplaceChild("lClaw02", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2F, -1.2F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 11.2F, 0.0F, 0.0F, 0.0F, 0.2269F));

		ModelPartData lClaw03 = bipedLeftArm.addOrReplaceChild("lClaw03", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 11.2F, 1.5F, 0.1047F, 0.0F, 0.2269F));

		ModelPartData bipedRightArm = ModelPartData.addOrReplaceChild("bipedRightArm", CubeListBuilder.create().texOffs(44, 14).mirror().addBox(-2.0F, -2.0F, -2.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -7.7F, 0.0F, 0.0F, 0.0F, 0.1F));

		ModelPartData rArmLeaves01 = bipedRightArm.addOrReplaceChild("rArmLeaves01", CubeListBuilder.create().texOffs(33, 39).mirror().addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, 5.3F, 0.0F));

		ModelPartData rArmLeaves02 = rArmLeaves01.addOrReplaceChild("rArmLeaves02", CubeListBuilder.create().texOffs(13, 39).mirror().addBox(-2.0F, -6.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		ModelPartData rClaw01 = bipedRightArm.addOrReplaceChild("rClaw01", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.8F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 11.2F, -1.5F, -0.1047F, 0.0F, -0.2269F));

		ModelPartData rClaw02 = bipedRightArm.addOrReplaceChild("rClaw02", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.8F, -1.2F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 11.2F, 0.0F, 0.0F, 0.0F, -0.2269F));

		ModelPartData rClaw03 = bipedRightArm.addOrReplaceChild("rClaw03", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.8F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.6F, 11.2F, 1.5F, 0.1047F, 0.0F, -0.2269F));

		ModelPartData bipedLeftLeg = ModelPartData.addOrReplaceChild("bipedLeftLeg", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 4.3F, 0.1F, -0.3491F, 0.0F, -0.1047F));

		ModelPartData lLeg02 = bipedLeftLeg.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(0, 31).addBox(-1.5F, 0.0F, -2.7F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.7F, -0.4F, 0.7418F, 0.0F, 0.1047F));

		ModelPartData lLeg03 = lLeg02.addOrReplaceChild("lLeg03", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, 1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.2F, 0.2F, -0.4189F, 0.0F, 0.0F));

		ModelPartData lHoofClaw01a = lLeg03.addOrReplaceChild("lHoofClaw01a", CubeListBuilder.create().texOffs(20, 57).addBox(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.4F, -1.3F, 0.1745F, -0.1396F, -0.0349F));

		ModelPartData lHoofClaw01b = lHoofClaw01a.addOrReplaceChild("lHoofClaw01b", CubeListBuilder.create().texOffs(27, 56).addBox(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData lHoofClaw02a = lLeg03.addOrReplaceChild("lHoofClaw02a", CubeListBuilder.create().texOffs(20, 57).addBox(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.4F, -1.3F, 0.1745F, 0.0873F, 0.0349F));

		ModelPartData lHoofClaw02b = lHoofClaw02a.addOrReplaceChild("lHoofClaw02b", CubeListBuilder.create().texOffs(27, 56).addBox(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData bipedRightLeg = ModelPartData.addOrReplaceChild("bipedRightLeg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1F, 4.3F, 0.1F, -0.3491F, 0.0F, 0.1047F));

		ModelPartData rLeg02 = bipedRightLeg.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-1.5F, 0.0F, -2.7F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.7F, -0.4F, 0.7418F, 0.0F, -0.1047F));

		ModelPartData rLeg03 = rLeg02.addOrReplaceChild("rLeg03", CubeListBuilder.create().texOffs(0, 42).mirror().addBox(-1.0F, 1.0F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.2F, 0.2F, -0.4189F, 0.0F, 0.0F));

		ModelPartData rHoofClaw01a = rLeg03.addOrReplaceChild("rHoofClaw01a", CubeListBuilder.create().texOffs(20, 57).mirror().addBox(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 7.4F, -1.3F, 0.1745F, 0.1396F, 0.0349F));

		ModelPartData rHoofClaw01b = rHoofClaw01a.addOrReplaceChild("rHoofClaw01b", CubeListBuilder.create().texOffs(27, 56).mirror().addBox(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData rHoofClaw02a = rLeg03.addOrReplaceChild("rHoofClaw02a", CubeListBuilder.create().texOffs(20, 57).mirror().addBox(-0.5F, 1.5F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 7.4F, -1.3F, 0.1745F, -0.0873F, -0.0349F));

		ModelPartData rHoofClaw02b = rHoofClaw02a.addOrReplaceChild("rHoofClaw02b", CubeListBuilder.create().texOffs(27, 56).mirror().addBox(-0.49F, 0.9F, -1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		ModelPartData head = ModelPartData.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.7F, 0.0F));

		ModelPartData lAntler01 = head.addOrReplaceChild("lAntler01", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9F, -7.1F, -0.5F, -0.2094F, 0.0F, 0.3491F));

		ModelPartData lAntler02 = lAntler01.addOrReplaceChild("lAntler02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.6F, 0.0F, -0.2094F, 0.0F, 0.6109F));

		ModelPartData Box_r1 = lAntler02.addOrReplaceChild("Box_r1", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.6F, -2.9F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.1F, -0.6F, 0.5F, -0.0873F, 0.0F, -0.0436F));

		ModelPartData rightAntler02 = lAntler02.addOrReplaceChild("rightAntler02", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.1F, 0.0F, -0.6981F, 0.0F, -0.3142F));

		ModelPartData lAntler03a = rightAntler02.addOrReplaceChild("lAntler03a", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, -0.4538F, 0.0F, -0.0524F));

		ModelPartData lAntler03b = lAntler03a.addOrReplaceChild("lAntler03b", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -3.9F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, -0.1047F, 0.0F, -0.2793F));

		ModelPartData lAntler03c = lAntler03b.addOrReplaceChild("lAntler03c", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -3.0F, -0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, 0.0F, 0.0F, -0.4363F));

		ModelPartData lAntler04a = rightAntler02.addOrReplaceChild("lAntler04a", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2F, -5.9F, 1.0F, 0.4538F, 0.0F, -0.8029F));

		ModelPartData lAntler04b = lAntler04a.addOrReplaceChild("lAntler04b", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, -0.3142F));

		ModelPartData lAntler05a = rightAntler02.addOrReplaceChild("lAntler05a", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3F, -6.7F, 1.4F, -0.0349F, 0.0F, -0.5236F));

		ModelPartData lAntler05b = lAntler05a.addOrReplaceChild("lAntler05b", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData lAntler06a = lAntler02.addOrReplaceChild("lAntler06a", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.5F, -0.4F, -1.3963F, 0.6981F, -0.4363F));

		ModelPartData lAntler06b = lAntler06a.addOrReplaceChild("lAntler06b", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 0.0F, -3.4F, 0.0F, 0.576F, 0.0F));

		ModelPartData lAntler07a = lAntler01.addOrReplaceChild("lAntler07a", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, -0.4F, -0.9076F, 0.5236F, 0.0F));

		ModelPartData lAntler07b = lAntler07a.addOrReplaceChild("lAntler07b", CubeListBuilder.create().texOffs(49, 34).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1F, 0.0F, -3.4F, 0.0F, 0.576F, 0.0F));

		ModelPartData rAntler01 = head.addOrReplaceChild("rAntler01", CubeListBuilder.create().texOffs(49, 34).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -7.1F, -0.5F, -0.2094F, 0.0F, -0.3491F));

		ModelPartData rAntler02 = rAntler01.addOrReplaceChild("rAntler02", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.6F, 0.0F, -0.2094F, 0.0F, -0.6109F));

		ModelPartData Box_r2 = rAntler02.addOrReplaceChild("Box_r2", CubeListBuilder.create().texOffs(49, 34).addBox(-0.4F, -2.9F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.1F, -0.6F, 0.5F, -0.0873F, 0.0F, 0.0436F));

		ModelPartData rAntler03a = rAntler02.addOrReplaceChild("rAntler03a", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.1F, 0.0F, -0.6981F, 0.0F, 0.3142F));

		ModelPartData rAntler03b = rAntler03a.addOrReplaceChild("rAntler03b", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, -0.4538F, 0.0F, 0.0524F));

		ModelPartData rAntler03c = rAntler03b.addOrReplaceChild("rAntler03c", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -3.9F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.8F, 0.0F, -0.1047F, 0.0F, 0.2793F));

		ModelPartData rAntler03d = rAntler03c.addOrReplaceChild("rAntler03d", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -3.0F, -0.4F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData rAntler04a = rAntler03a.addOrReplaceChild("rAntler04a", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -5.9F, 1.0F, 0.4538F, 0.0F, 0.8029F));

		ModelPartData rAntler04b = rAntler04a.addOrReplaceChild("rAntler04b", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, 0.3142F));

		ModelPartData rAntler05a = rAntler03a.addOrReplaceChild("rAntler05a", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -6.7F, 1.4F, -0.0349F, 0.0F, 0.5236F));

		ModelPartData rAntler05b = rAntler05a.addOrReplaceChild("rAntler05b", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -2.0F, -0.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, 0.5236F));

		ModelPartData rAntler06a = rAntler02.addOrReplaceChild("rAntler06a", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -0.4F, -1.3963F, -0.6981F, 0.4363F));

		ModelPartData rAntler06b = rAntler06a.addOrReplaceChild("rAntler06b", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.0F, -3.4F, 0.0F, -0.576F, 0.0F));

		ModelPartData rAntler07a = rAntler01.addOrReplaceChild("rAntler07a", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -0.5F, -3.8F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -0.4F, -0.9076F, -0.5236F, 0.0F));

		ModelPartData rAntler07b = rAntler07a.addOrReplaceChild("rAntler07b", CubeListBuilder.create().texOffs(49, 34).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.0F, -3.4F, 0.0F, -0.576F, 0.0F));

		ModelPartData hood = head.addOrReplaceChild("hood", CubeListBuilder.create().texOffs(69, 0).addBox(-4.5F, -8.5F, -4.4F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		ModelPartData HAIR = head.addOrReplaceChild("HAIR", CubeListBuilder.create().texOffs(46, 1).addBox(-4.0F, 5.0F, 1.2F, 8.0F, 11.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -7.3F, 2.0F));

		ModelPartData Base_r1 = HAIR.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(53, 46).addBox(-5.0F, -3.0F, -1.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 0.4363F, 0.7854F, 0.3054F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedLeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedRightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bipedRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}