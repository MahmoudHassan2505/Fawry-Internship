import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.service.SpeakerService;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);

        System.out.println(service.findAll().get(0).getFirstname());
        System.out.println(service.findAll().get(0).getSeedNum());
    }
}
