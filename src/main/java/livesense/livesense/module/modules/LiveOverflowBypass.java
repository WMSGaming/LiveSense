package livesense.livesense.module.modules;

import livesense.livesense.mixin.PlayerMoveC2SPacketAccessor;
import livesense.livesense.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class LiveOverflowBypass extends Module {

    public LiveOverflowBypass() {
        super("LiveOverflowBypass", GLFW.GLFW_KEY_L, Category.EXPLOIT);
    }

    @Override
    public void onPacketSend(Packet p) {

        if(p instanceof PlayerMoveC2SPacket){
            double x = ((int)(((PlayerMoveC2SPacket) p).getX(mc.player.getX()) * 100)) / 100.0;
            double z = ((int)(((PlayerMoveC2SPacket) p).getZ(mc.player.getZ()) * 100)) / 100.0;

            ((PlayerMoveC2SPacketAccessor) p).setX(x);
            ((PlayerMoveC2SPacketAccessor) p).setZ(z);
        }

    }
}
