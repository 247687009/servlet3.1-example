package conf;

import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by freeman on 2016/5/10.
 */
@Configuration
@ComponentScan(
        value = {"org.freeman"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
        }
)
public class RootConfiguration {

    @Bean
    public DataSource createDataSource() {
        return null;
    }

}
