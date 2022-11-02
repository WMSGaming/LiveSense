package livesense.livesense.module.modules;

import livesense.livesense.mixin.ChatMessageC2SPacketAccessor;
import livesense.livesense.mixin.PlayerMoveC2SPacketAccessor;
import livesense.livesense.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import org.lwjgl.glfw.GLFW;

public class ChatSuffix extends Module {

    public ChatSuffix() {
        super("ChatSuffix", GLFW.GLFW_KEY_O, Category.RENDER);
    }

    @Override
    public void onPacketSend(Packet p) {

        if(p instanceof ChatMessageC2SPacket){

            String msg = ((ChatMessageC2SPacket) p).chatMessage();
            ((ChatMessageC2SPacketAccessor) p).setMessage(msg + " [LiveSense]");
        }

    }
}
