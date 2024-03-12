package dev.mrsterner.bewitchmentplus.client.model;

import net.minecraft.client.model.ModelPart;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class GirdleOfTheDryadsModel extends EntityModel<Entity> {
	private final ModelPart rootRight1;
	private final ModelPart rootRight2;
	private final ModelPart rootLeft1;
	private final ModelPart rootLeft2;
	private final ModelPart belt2;
	private final ModelPart belt1;
	private final ModelPart belt3;
	private final ModelPart belt4;
	private final ModelPart barkfront3a;
	private final ModelPart barkfront3d;
	private final ModelPart barkfront3c;
	private final ModelPart barkfront3b;
	private final ModelPart barkfront2a;
	private final ModelPart barkfront2c;
	private final ModelPart barkfront2b;
	private final ModelPart barkfront1a;
	private final ModelPart barkfront1b;
	private final ModelPart barkfront1c;
	private final ModelPart barkBack3a;
	private final ModelPart barkBack3b;
	private final ModelPart barkBack3d;
	private final ModelPart barkBack3c;
	private final ModelPart barkBack2a;
	private final ModelPart barkBack2c;
	private final ModelPart barkBack2b;
	private final ModelPart barkBack1a;
	private final ModelPart barkBack1b;
	private final ModelPart barkBack1c;
	private final ModelPart rootLeft3;
	private final ModelPart rootRight3;
	public GirdleOfTheDryadsModel(ModelPart root) {
		this.rootRight1 = root.getChild("rootRight1");
		this.rootLeft1 = root.getChild("rootLeft1");
		this.belt2 = root.getChild("belt2");
		this.belt1 = root.getChild("belt1");
		this.belt3 = root.getChild("belt3");
		this.belt4 = root.getChild("belt4");
		this.barkfront3a = root.getChild("barkfront3a");
		this.barkfront2a = root.getChild("barkfront2a");
		this.barkfront1a = root.getChild("barkfront1a");
		this.barkBack3a = root.getChild("barkBack3a");
		this.barkBack2a = root.getChild("barkBack2a");
		this.barkBack1a = root.getChild("barkBack1a");
		this.rootLeft3 = root.getChild("rootLeft3");
		this.rootRight3 = root.getChild("rootRight3");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData rootRight1 = modelPartData.addChild("rootRight1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rootRight2 = rootRight1.addChild("rootRight2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rootLeft1 = modelPartData.addChild("rootLeft1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rootLeft2 = rootLeft1.addChild("rootLeft2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData belt2 = modelPartData.addChild("belt2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData belt1 = modelPartData.addChild("belt1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData belt3 = modelPartData.addChild("belt3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData belt4 = modelPartData.addChild("belt4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData barkfront3a = modelPartData.addChild("barkfront3a", ModelPartBuilder.create(), ModelTransform.of(1.19F, 5.05F, -2.19F, 0.2642F, -0.2609F, -0.0202F));

		ModelPartData barkfront3d = barkfront3a.addChild("barkfront3d", ModelPartBuilder.create(), ModelTransform.of(-2.2878F, -2.0808F, 0.3301F, -0.4206F, 0.2867F, -0.3341F));

		ModelPartData barkfront3c = barkfront3a.addChild("barkfront3c", ModelPartBuilder.create(), ModelTransform.of(-0.3364F, -3.143F, 0.0775F, 0.0036F, 0.1386F, 0.5847F));

		ModelPartData barkfront3b = barkfront3a.addChild("barkfront3b", ModelPartBuilder.create(), ModelTransform.of(-2.2954F, 0.1997F, 0.8008F, -0.1573F, 0.4287F, -0.0838F));

		ModelPartData barkfront2a = modelPartData.addChild("barkfront2a", ModelPartBuilder.create(), ModelTransform.of(1.48F, 7.05F, -3.16F, 0.0024F, -0.2609F, -0.0202F));

		ModelPartData barkfront2c = barkfront2a.addChild("barkfront2c", ModelPartBuilder.create(), ModelTransform.of(-2.8506F, 0.9394F, 0.8476F, -0.0261F, 0.4348F, 0.0375F));

		ModelPartData barkfront2b = barkfront2a.addChild("barkfront2b", ModelPartBuilder.create(), ModelTransform.of(-0.2364F, -1.0836F, 0.9001F, 0.1775F, 0.261F, 0.0203F));

		ModelPartData barkfront1a = modelPartData.addChild("barkfront1a", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0538F, -0.1738F, -0.0154F));

		ModelPartData barkfront1b = barkfront1a.addChild("barkfront1b", ModelPartBuilder.create(), ModelTransform.of(-0.4056F, -0.0202F, 0.5789F, 0.0354F, 0.1744F, 0.0062F));

		ModelPartData barkfront1c = barkfront1a.addChild("barkfront1c", ModelPartBuilder.create(), ModelTransform.of(-2.9544F, -0.0182F, 0.5206F, -0.0152F, 0.3488F, 0.0127F));

		ModelPartData barkBack3a = modelPartData.addChild("barkBack3a", ModelPartBuilder.create(), ModelTransform.of(-1.19F, 5.05F, 2.19F, -2.8773F, 0.2609F, -3.1213F));

		ModelPartData barkBack3b = barkBack3a.addChild("barkBack3b", ModelPartBuilder.create(), ModelTransform.of(-2.2954F, 0.1997F, 0.8008F, -0.1573F, 0.4287F, -0.0838F));

		ModelPartData barkBack3d = barkBack3a.addChild("barkBack3d", ModelPartBuilder.create(), ModelTransform.of(-2.2878F, -2.0808F, 0.3301F, -0.1669F, 0.3619F, -0.371F));

		ModelPartData barkBack3c = barkBack3a.addChild("barkBack3c", ModelPartBuilder.create(), ModelTransform.of(-0.3364F, -3.143F, 0.0775F, -0.1585F, 0.3349F, 0.3215F));

		ModelPartData barkBack2a = modelPartData.addChild("barkBack2a", ModelPartBuilder.create(), ModelTransform.of(-1.48F, 7.05F, 3.16F, -3.1391F, 0.2609F, -3.1213F));

		ModelPartData barkBack2c = barkBack2a.addChild("barkBack2c", ModelPartBuilder.create(), ModelTransform.of(-2.8596F, 0.9391F, 0.8518F, -0.0261F, 0.4348F, 0.0375F));

		ModelPartData barkBack2b = barkBack2a.addChild("barkBack2b", ModelPartBuilder.create(), ModelTransform.of(-0.2364F, -1.0836F, 0.9001F, 0.1775F, 0.261F, 0.0203F));

		ModelPartData barkBack1a = modelPartData.addChild("barkBack1a", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.0878F, 0.1738F, -3.1262F));

		ModelPartData barkBack1b = barkBack1a.addChild("barkBack1b", ModelPartBuilder.create(), ModelTransform.of(-0.4056F, -0.0202F, 0.5789F, 0.0354F, 0.1744F, 0.0062F));

		ModelPartData barkBack1c = barkBack1a.addChild("barkBack1c", ModelPartBuilder.create(), ModelTransform.of(-2.9544F, -0.0182F, 0.5206F, -0.0152F, 0.3488F, 0.0127F));

		ModelPartData rootLeft3 = modelPartData.addChild("rootLeft3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData rootRight3 = modelPartData.addChild("rootRight3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		rootRight1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rootLeft1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		belt2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		belt1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		belt3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		belt4.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkfront3a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkfront2a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkfront1a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkBack3a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkBack2a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		barkBack1a.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rootLeft3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		rootRight3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}