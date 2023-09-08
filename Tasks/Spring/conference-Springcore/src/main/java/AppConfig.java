import com.test.util.CalenderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
@ComponentScan({"com.test"})
public class AppConfig {

    @Bean(name = "cal")
    public CalenderFactory calenderFactory() {
        CalenderFactory factory = new CalenderFactory();
        factory.addDays(2);
        return factory;
    }

    @Bean(name = "Calender")
    public Calendar calendar() throws Exception {
        return calenderFactory().getObject();
    }


}
