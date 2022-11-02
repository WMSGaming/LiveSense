package livesense.livesense.module.modules;

import livesense.livesense.mixin.PlayerMoveC2SPacketAccessor;
import livesense.livesense.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class NoFall extends Module {

    public NoFall() {
        super("NoFall", GLFW.GLFW_KEY_U, Category.MOVEMENT);
    }

    @Override
    public void onPacketSend(Packet p) {
        if(p instanceof PlayerMoveC2SPacket move){
            ((PlayerMoveC2SPacketAccessor) move).setOnground(true);
        }
    }

    @Override
    public void onDisable(){
        if(nullCheck()){return;}

    }

}
