package com.hp.hiddenmounts.client;

import com.hp.hiddenmounts.HiddenMounts;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.context.ContextKey;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(modid = HiddenMounts.MOD_ID, value = Dist.CLIENT)
public final class MountRenderHandler {
    public static final ContextKey<Boolean> HIDDEN_MOUNT = new ContextKey<>(Identifier.fromNamespaceAndPath(HiddenMounts.MOD_ID, "hidden_mount"));

    private MountRenderHandler() {
    }

    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?, ?> event) {
        if (Boolean.TRUE.equals(event.getRenderState().getRenderData(HIDDEN_MOUNT))) {
            event.setCanceled(true);
        }
    }
}
