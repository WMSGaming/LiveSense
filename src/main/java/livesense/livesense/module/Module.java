package livesense.livesense.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.Packet;

public class Module {
    public static MinecraftClient mc = MinecraftClient.getInstance();
    public String name;
    public Category category;
    public int bind;
    public boolean toggled;

    public Module(String name, int bind, Category category) {
        this.name = name;
        this.bind = bind;
        this.category = category;

    }
    public String getName() {
        return name;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void onTick(){}

    public void onPacketSend(Packet<?> packet){}

    public void onEnable(){}

    public void onDisable(){}

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    public void toggle() {
        this.toggled = !toggled;

        if(toggled){
            onEnable();
        }else {
            onDisable();
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }
    public boolean nullCheck() {
        return mc.player == null || mc.world == null; // Borrowed from l4j cos good idea :)
        //https://github.com/Logging4J/AutoLog.CC/blob/master/src/main/java/cc/l4j/autolog/AutoLog.java
    }
    public enum Category{
        COMBAT("Combat"),
        MOVEMENT("Movement"),
        EXPLOIT("Exploit"),
        RENDER("Render");

        public final String name;

        Category(String name){
            this.name = name;
        }
    }
}
