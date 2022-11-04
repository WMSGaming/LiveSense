package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.*;
import org.lwjgl.glfw.GLFW;

public class NoWorldBorder extends Module {
    public NoWorldBorder() {
        super("NoBorder", GLFW.GLFW_KEY_U, Category.EXPLOIT);
    }
}
