package com.hp.hiddenmounts.client;

import com.hp.hiddenmounts.HiddenMounts;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

@EventBusSubscriber(modid = HiddenMounts.MOD_ID, value = Dist.CLIENT)
public final class MountRenderHandler {
    private MountRenderHandler() {
    }

    @SubscribeEvent
    public static void onRenderLivingPre(RenderLivingEvent.Pre<?, ?> event) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null && event.getEntity() == minecraft.player.getVehicle()) {
            event.setCanceled(true);
        }
    }
}
