package com.aster.app;

import com.aster.app.config.AppConfig;
import com.aster.data.service.DataService;
import com.aster.data.service.DataServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        test();
    }

    private static void test() throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        DataService client = applicationContext.getBean(DataService.class);
        String URL = "http://85.143.174.145:8080r/remote.php/dav/files/omicron//"; ///remote.php/files/?dir=/&fileid=176"
        client.propFind(URL, 2);
    }

}
