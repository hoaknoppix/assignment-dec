package au.com.nab.voucheradapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VoucheradapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoucheradapterApplication.class, args);
    }

}
