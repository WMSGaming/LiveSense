package livesense.livesense.module.modules;

import livesense.livesense.LiveSense;
import livesense.livesense.module.Module;
import livesense.livesense.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Comparator;


public class Hud {
    public static MinecraftClient mc = MinecraftClient.getInstance();
    public static int color = new Color(129, 17, 255, 255).getRGB();

    public static void draw(MatrixStack matrixStack, float tickDelta) {
        mc.textRenderer.drawWithShadow(matrixStack, LiveSense.NAME + " [" + mc.getSession().getUsername() + "] ",2,2,color);
        mc.textRenderer.drawWithShadow(matrixStack, "[XYZ] " + (int)mc.player.getX() +", " + (int)mc.player.getZ(),2,10,color);

        /**
         *      int y = 15;
         *         ModuleManager.getModules().sort(Comparator.comparingInt((Module module) -> module.getName().length()).reversed());
         *         for(Module m : ModuleManager.getModules()) {
         *
         *             if(m.isToggled()){
         *                 mc.textRenderer.drawWithShadow(matrixStack, m.getName(),2,y,color);
         *                 y+=mc.textRenderer.fontHeight+1;
         *             }
         *         }
         */


        int y = 20;
        ModuleManager.getModules().sort(Comparator.comparingInt((Module module) -> module.getName().length()).reversed());
        for(Module m : ModuleManager.getModules()) {

            mc.textRenderer.drawWithShadow(matrixStack, m.getName() + " [" + KeyEvent.getKeyText(m.getBind())+"]",2,y,m.isToggled() ? color : -1);
            y+=mc.textRenderer.fontHeight+1;

        }
    }
}
