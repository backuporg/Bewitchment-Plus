package dev.mrsterner.bewitchmentplus;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import dev.mrsterner.bewitchmentplus.client.model.entity.BlackDogEntityModel;
import dev.mrsterner.bewitchmentplus.client.model.entity.CambionEntityModel;
import dev.mrsterner.bewitchmentplus.client.model.entity.LilimEntityModel;
import dev.mrsterner.bewitchmentplus.client.model.entity.UnicornEntityModel;
import dev.mrsterner.bewitchmentplus.client.renderer.*;
import dev.mrsterner.bewitchmentplus.client.renderer.entity.*;
import dev.mrsterner.bewitchmentplus.common.block.blockentity.BWPChestBlockEntity;
import dev.mrsterner.bewitchmentplus.common.block.blockentity.LeechChestBlockEntity;
import dev.mrsterner.bewitchmentplus.common.block.yew.YewChestBlockEntity;
import dev.mrsterner.bewitchmentplus.common.item.GobletBlockItem;
import dev.mrsterner.bewitchmentplus.common.item.StatueBlockItem;
import dev.mrsterner.bewitchmentplus.common.network.packet.S2CBloodParticlesPacket;
import dev.mrsterner.bewitchmentplus.common.registry.*;
import moriyashiine.bewitchment.client.renderer.WitchArmorRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;


public class BewitchmentPlusClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BWPParticleTypes.init();

        for (Item item : BWPObjects.getItems().keySet().stream().filter(item -> item instanceof GobletBlockItem).toList()) {
            BuiltinItemRendererRegistry.INSTANCE.register(item, new GobletBlockItemRenderer());
        }
        for (Item item : BWPObjects.getItems().keySet().stream().filter(item -> item instanceof StatueBlockItem).toList()) {
            BuiltinItemRendererRegistry.INSTANCE.register(item, new StatueRenderer());
        }

        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.YEW_CHEST);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.TRAPPED_YEW_CHEST);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.YEW_CHEST_LEFT);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.TRAPPED_YEW_CHEST_LEFT);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.YEW_CHEST_RIGHT);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.TRAPPED_YEW_CHEST_RIGHT);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.BLOOD);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.UNICORN);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.HONEY);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.MIMIC_SPRITE);
        BWPSpriteIdentifiers.INSTANCE.addIdentifier(BWPSpriteIdentifiers.LEECH_CHEST);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getDefaultColor(), BWPObjects.BLOODROOT, BWPObjects.EMBERGRASS);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> tintIndex == 1 ? ((BedBlock) state.getBlock()).getColor().getFireworkColor() : 0xffffff, BWPObjects.WHITE_COFFIN, BWPObjects.ORANGE_COFFIN, BWPObjects.MAGENTA_COFFIN, BWPObjects.LIGHT_BLUE_COFFIN, BWPObjects.YELLOW_COFFIN, BWPObjects.LIME_COFFIN, BWPObjects.PINK_COFFIN, BWPObjects.GRAY_COFFIN, BWPObjects.LIGHT_GRAY_COFFIN, BWPObjects.CYAN_COFFIN, BWPObjects.PURPLE_COFFIN, BWPObjects.BLUE_COFFIN, BWPObjects.BROWN_COFFIN, BWPObjects.GREEN_COFFIN, BWPObjects.RED_COFFIN, BWPObjects.BLACK_COFFIN);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex == 1 ? ((BedBlock) Block.getBlockFromItem(stack.getItem())).getColor().getFireworkColor() : 0xffffff, BWPObjects.WHITE_COFFIN, BWPObjects.ORANGE_COFFIN, BWPObjects.MAGENTA_COFFIN, BWPObjects.LIGHT_BLUE_COFFIN, BWPObjects.YELLOW_COFFIN, BWPObjects.LIME_COFFIN, BWPObjects.PINK_COFFIN, BWPObjects.GRAY_COFFIN, BWPObjects.LIGHT_GRAY_COFFIN, BWPObjects.CYAN_COFFIN, BWPObjects.PURPLE_COFFIN, BWPObjects.BLUE_COFFIN, BWPObjects.BROWN_COFFIN, BWPObjects.GREEN_COFFIN, BWPObjects.RED_COFFIN, BWPObjects.BLACK_COFFIN);


        GeoItemRenderer.registerItemRenderer(BWPObjects.DRAGONBLOOD_STAFF, new DragonbloodStaffRenderer());
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BWPObjects.LOCACACA_LEAVES, BWPObjects.LOCACACA_BRANCH, BWPObjects.DRAGONFRUIT_BLOCK, BWPObjects.GOLD_STANDING_CANDELABRA, BWPObjects.NETHERITE_STANDING_CANDELABRA, BWPObjects.SILVER_STANDING_CANDELABRA, BWPObjects.BLOODROOT, BWPObjects.EMBERGRASS, BWPObjects.YEW_SAPLING, BWPObjects.YEW_DOOR, BWPObjects.YEW_TRAPDOOR, BWPObjects.YEW_CUT_LOG);
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, BWPObjects.YEW_SIGN.getTexture()));
        ClientTickEvents.END_CLIENT_TICK.register(ClientTickHandler::clientTickEnd);
        ClientPlayNetworking.registerGlobalReceiver(S2CBloodParticlesPacket.ID, S2CBloodParticlesPacket::handle);
        GeoArmorRenderer.registerArmorRenderer(new LeshonSkullArmorRenderer(), BWPObjects.LESHON_SKULL);
        GeoItemRenderer.registerItemRenderer(BWPObjects.LESHON_SKULL, new LeshonSkullItemRenderer());
        TerraformBoatClientHelper.registerModelLayers(new Identifier(BewitchmentPlus.MODID, "yew"));
        ArmorRenderer.register(new WitchArmorRenderer(new Identifier(BewitchmentPlus.MODID, "textures/entity/armor/death_robes.png"), null), BWPObjects.DEATHS_HOOD, BWPObjects.DEATHS_ROBES, BWPObjects.DEATHS_FOOTWEAR);


        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.GOBLET, ctx -> new GobletBlockItemRenderer());
        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.STATUE_BLOCK_ENTITY, ctx -> new StatueRenderer());
        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.MOONFLOWER_BLOCK_ENTITY, ctx -> new MoonflowerBlockEntityRenderer());
        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.MIMIC_CHEST_BLOCK_ENTITY, MimicBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.YEW_CHEST_BLOCK_ENTITY, ChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register(BWPBlockEntityTypes.LEECH_CHEST_BLOCK_ENTITY, LeechChestBlockEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CambionEntityModel.MALE_CAMBION_MODEL_LAYER, CambionEntityModel::getTexturedModelDataMale);
        EntityModelLayerRegistry.registerModelLayer(CambionEntityModel.FEMALE_CAMBION_MODEL_LAYER, CambionEntityModel::getTexturedModelDataFemale);
        EntityModelLayerRegistry.registerModelLayer(MimicBlockEntityRenderer.MIMIC_LAYER, MimicBlockEntityRenderer::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(BlackDogEntityModel.BLACKDOG_MODEL_LAYER, BlackDogEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(UnicornEntityModel.UNICORN_MODEL_LAYER, UnicornEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(LilimEntityModel.LILIM_MODEL_LAYER, LilimEntityModel::getTexturedModelData);


        EntityRendererRegistry.register(BWPEntityTypes.MUTANDIS_ENTITY_ENTITY_TYPE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.NIFFLER, NifflerEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.LESHON, LeshonEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.BLACK_DOG, BlackDogEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.UNICORN, UnicornEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.EFFIGY, EffigyEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.YEW_BROOM, YewBroomEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.CAMBION, CambionEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.RUNE, RuneEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.PHOENIX, PhoenixEntityRenderer::new);
        //EntityRendererRegistry.register(BWPEntityTypes.DRAGON, DragonEntityRenderer::new);
        EntityRendererRegistry.register(BWPEntityTypes.LILIM, LilimEntityRenderer::new);
        //EntityRendererRegistry.register(BWPEntityTypes.DEATH, DeathEntityRenderer::new);


        BuiltinItemRendererRegistry.INSTANCE.register(BWPObjects.YEW_CHEST, (stack, mode, matrices, vertexConsumers, light, overlay) -> MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(new YewChestBlockEntity(BWPBlockEntityTypes.YEW_CHEST_BLOCK_ENTITY, BlockPos.ORIGIN, BWPObjects.YEW_CHEST.getDefaultState(), YewChestBlockEntity.Type.YEW, false), matrices, vertexConsumers, light, overlay));
        BuiltinItemRendererRegistry.INSTANCE.register(BWPObjects.TRAPPED_YEW_CHEST, (stack, mode, matrices, vertexConsumers, light, overlay) -> MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(new YewChestBlockEntity(BWPBlockEntityTypes.YEW_CHEST_BLOCK_ENTITY, BlockPos.ORIGIN, BWPObjects.YEW_CHEST.getDefaultState(), YewChestBlockEntity.Type.YEW, true), matrices, vertexConsumers, light, overlay));
        BuiltinItemRendererRegistry.INSTANCE.register(BWPObjects.MIMIC_CHEST, (stack, mode, matrices, vertexConsumers, light, overlay) -> MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(new BWPChestBlockEntity(BlockEntityType.CHEST, BlockPos.ORIGIN, Blocks.CHEST.getDefaultState()), matrices, vertexConsumers, light, overlay));
        BuiltinItemRendererRegistry.INSTANCE.register(BWPObjects.LEECH_CHEST, (stack, mode, matrices, vertexConsumers, light, overlay) -> MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(new LeechChestBlockEntity(BlockEntityType.CHEST, BlockPos.ORIGIN, Blocks.CHEST.getDefaultState()), matrices, vertexConsumers, light, overlay));

/*TODO
		TrinketRendererRegistry.registerRenderer(BWPObjects.CROWN_OF_THE_FOREST, (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
			TrinketRenderer.translateToChest(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, (AbstractClientPlayerEntity) entity);
			matrices.translate(0, -1 / 4.25f, 1 / 48f);
			matrices.scale(1 / 3f, 1 / 3f, 1 / 3f);
			matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180));
			MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
		});

 */
    }

    public static final class ClientTickHandler {
        private ClientTickHandler() {
        }

        public static int ticksInGame = 0;
        public static float partialTicks = 0;
        public static float delta = 0;
        public static float total = 0;

        public static void calcDelta() {
            float oldTotal = total;
            total = ticksInGame + partialTicks;
            delta = total - oldTotal;
        }

        public static void renderTick(float renderTickTime) {
            partialTicks = renderTickTime;
        }

        public static void clientTickEnd(MinecraftClient mc) {
            if (!mc.isPaused()) {
                ticksInGame++;
                partialTicks = 0;
            }
            calcDelta();
        }
    }
}