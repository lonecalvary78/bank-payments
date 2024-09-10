package demo.app.bank.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PaymentServiceDiscoveryApplication {
  public static void main(String[] args) {
    SpringApplication.run(PaymentServiceDiscoveryApplication.class, args);
  }
}
