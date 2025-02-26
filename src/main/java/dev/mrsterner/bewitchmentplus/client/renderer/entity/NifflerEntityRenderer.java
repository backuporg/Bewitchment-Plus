package dev.mrsterner.bewitchmentplus.client.renderer.entity;

import dev.mrsterner.bewitchmentplus.client.model.entity.NifflerEntityModel;
import dev.mrsterner.bewitchmentplus.common.entity.NifflerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NifflerEntityRenderer extends GeoEntityRenderer<NifflerEntity> {
    public NifflerEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new NifflerEntityModel());
    }


    @Override
    public RenderLayer getRenderType(NifflerEntity animatable, float partialTicks, MatrixStack stack, @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTexture(animatable));
    }
/*TODO add Magical
    @Override
    public Color getRenderColor(NifflerEntity animatable, float partialTicks, MatrixStack stack, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn) {
        return Color.ofRGBA(1.0F,1.0F,1.0F, MinecraftClient.getInstance().getCameraEntity() instanceof AbstractClientPlayerEntity playerEntity && Magical.of(playerEntity).get().hasMagical() ? 1 : 0.1F);
    }

 */


    @Override
    public void renderRecursively(GeoBone bone, MatrixStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (bone.getName().equals("rightItem") && !mainHand.isEmpty()) {
            stack.push();
            stack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-75));
            stack.translate(0.2D, 0.4D, -0.2D);
            stack.scale(1.0f, 1.0f, 1.0f);
            MinecraftClient.getInstance().getItemRenderer().renderItem(mainHand, ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND, packedLightIn, packedOverlayIn, stack, rtb, 0);
            stack.pop();
            bufferIn = rtb.getBuffer(RenderLayer.getEntityTranslucent(whTexture));
        }
        if (bone.getName().equals("leftItem") && !offHand.isEmpty()) {
            stack.push();
            stack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-75));
            stack.translate(-0.2D, 0.4D, -0.2D);
            stack.scale(1.0f, 1.0f, 1.0f);
            MinecraftClient.getInstance().getItemRenderer().renderItem(offHand, ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND, packedLightIn, packedOverlayIn, stack, rtb, 0);
            stack.pop();
            bufferIn = rtb.getBuffer(RenderLayer.getEntityTranslucent(whTexture));
        }
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
