package livesense.livesense.module.modules;


import livesense.livesense.module.Module;
import org.lwjgl.glfw.GLFW;

public class ClickGuiModule extends Module {

    public ClickGuiModule() {
        super("ClickGui", GLFW.GLFW_KEY_RIGHT_SHIFT, Category.RENDER);
    }

    @Override
    public void onEnable() {
        //mc.setScreen(new ClickGui());
    }

    @Override
    public void onDisable(){
        toggle();

    }

}
