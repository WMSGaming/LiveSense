package livesense.livesense.module.modules;

import livesense.livesense.module.Module;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class NetherClip extends Module {
    public NetherClip() {
        super("NetherClip", GLFW.GLFW_KEY_X, Category.EXPLOIT);
    }

    @Override
    public void onTick()  {
        assert mc.player != null;
        if(mc.player.input.jumping) {
            for (float tp = 0; tp < 2; tp += 0.15) {
                mc.player.setPos(mc.player.getX(), mc.player.getY() + tp, mc.player.getZ());
            }
        }
        if(mc.player.input.sneaking) {
            for (float tp = 0; tp < 1; tp += 0.15) {
                mc.player.setPos(mc.player.getX(), mc.player.getY() - tp, mc.player.getZ());
            }
        }
    }
}
