package au.com.nab.dummyvoucher.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "voucher")
public class ApplicationProperties {
  private int sleepTime;
  private int expirationTime;

  public int getSleepTime() {
    return sleepTime;
  }

  public void setSleepTime(int sleepTime) {
    this.sleepTime = sleepTime;
  }

  public int getExpirationTime() {
    return expirationTime;
  }

  public void setExpirationTime(int expirationTime) {
    this.expirationTime = expirationTime;
  }

  @Override
  public String toString() {
    return "ApplicationProperties{" +
        "sleepTime=" + sleepTime +
        ", expirationTime=" + expirationTime +
        '}';
  }
}
