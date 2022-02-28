package dk.sdu.sbse.nbruntimeexample12.startup;
import org.openide.modules.ModuleInstall;

public class Init extends ModuleInstall {
    @Override
    public void restored() {
        System.out.println("Hello World");
    }
}
