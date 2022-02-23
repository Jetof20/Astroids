package dk.sdu.mmmi.jetof;
import org.openide.modules.*;
public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        System.out.println("Hello World");
    }
}
