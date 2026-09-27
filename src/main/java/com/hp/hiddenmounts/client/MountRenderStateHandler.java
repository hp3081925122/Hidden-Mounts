package com.hp.hiddenmounts.client;

import com.google.common.reflect.TypeToken;
import com.hp.hiddenmounts.HiddenMounts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.renderstate.RegisterRenderStateModifiersEvent;

@EventBusSubscriber(modid = HiddenMounts.MOD_ID, value = Dist.CLIENT)
public final class MountRenderStateHandler {
    private MountRenderStateHandler() {
    }

    @SubscribeEvent
    public static void registerRenderStateModifiers(RegisterRenderStateModifiersEvent event) {
        event.registerEntityModifier(new TypeToken<LivingEntityRenderer<LivingEntity, LivingEntityRenderState, ?>>() {}, (entity, renderState) -> {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player != null && entity == minecraft.player.getVehicle()) {
                renderState.setRenderData(MountRenderHandler.HIDDEN_MOUNT, true);
            }
        });
    }
}
