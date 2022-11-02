package livesense.livesense;

import livesense.livesense.module.Module;
import livesense.livesense.module.ModuleManager;
import livesense.livesense.module.modules.Hud;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;
import org.lwjgl.glfw.GLFW;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LiveSense implements ModInitializer {


    public static final LiveSense INSTANCE = new LiveSense();
    public static MinecraftClient mc = MinecraftClient.getInstance();

    public static String NAME = "LiveSense";
    public static String VERSION = "0.0.1";

    public ModuleManager moduleManager;
    Hud hud;

    @Override
    public void onInitialize() {
        moduleManager = new ModuleManager();
        hud = new Hud();
    }

    public void onKeyPress(int key, int action) {
        if(action == GLFW.GLFW_PRESS) {
            for (Module m : ModuleManager.getModules()) {
                if (m.getBind() == key) {
                    m.toggle();
                }
            }
        }
    }

    public void onTick() {
        if(nullCheck()){return;}
        for(Module m : ModuleManager.getModules()){
            if(m.isToggled()) {
                m.onTick();
            }
        }

    }
    public boolean nullCheck() {
        return mc.player == null || mc.world == null; // Borrowed from l4j cos good idea :)
        //https://github.com/Logging4J/AutoLog.CC/blob/master/src/main/java/cc/l4j/autolog/AutoLog.java
    }

    public void onPacketSend(Packet<?> packet) {
        for(Module m : ModuleManager.getModules()){
            if(m.isToggled()) {
                m.onPacketSend(packet);
            }
        }
    }
}
