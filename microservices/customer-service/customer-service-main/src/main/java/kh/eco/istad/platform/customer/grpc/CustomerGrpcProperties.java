package kh.eco.istad.platform.customer.grpc;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "customer.grpc")
public class CustomerGrpcProperties {

    private Map<String, Customer> customers = new HashMap<>();

    public Map<String, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;
    }

    public static class Customer {
        private String username = "";
        private String familyName = "";
        private String givenName = "";
        private String email = "";
        private String phoneNumber = "";
        private String status = "ACTIVE";

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getFamilyName() { return familyName; }
        public void setFamilyName(String familyName) { this.familyName = familyName; }
        public String getGivenName() { return givenName; }
        public void setGivenName(String givenName) { this.givenName = givenName; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
