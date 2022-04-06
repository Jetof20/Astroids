import org.springframework.stereotype.Component;

@Component
public class CompGed implements IThing {

    @Override
    public void thingy() {
        System.out.println("CompGed Thingy");
    }
}
