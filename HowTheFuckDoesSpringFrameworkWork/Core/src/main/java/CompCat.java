import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompCat implements IThing {
    @Override
    public void thingy() {
        System.out.println("meow");
    }

    @Bean(name = "CompCat")
    public CompCat GetCompCat() {
        return new CompCat();
    }
}