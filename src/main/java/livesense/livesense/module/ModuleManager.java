package livesense.livesense.module;

import livesense.livesense.module.modules.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static List<Module> modules;

    public ModuleManager()  {
        modules = new ArrayList<>();

        modules.add(new Flight());
        modules.add(new LiveOverflowBypass());
        modules.add(new PacketFly());
        modules.add(new SurvivalSpoof());
        modules.add(new NoFall());
        modules.add(new CrystalTriggerBot());
        //modules.add(new BoatExecuter());
        modules.add(new HasteSpoof());
        modules.add(new NetherClip());
        modules.add(new NoWorldBorder());


    }

    public static List<Module> getModules(){
        return modules;
    }


    public static List<Module> getModulesInCategory(Module.Category c) {
        List<Module> modulesInCat = new ArrayList<>();
        for(Module m :  modules)  {
            if(m.getCategory() == c){
                modulesInCat.add(m);
            }
        }
        return modulesInCat;
    }
    public static Module getModulebyName(String module) {
        for(Module m : modules) {
            if(m.getName().equalsIgnoreCase(module)){
                return m;
            }
        }
        return null;
    }
}
