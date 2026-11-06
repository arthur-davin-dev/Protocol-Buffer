package kh.eco.istad.platform.order.client.customer;

import kh.eco.istad.platform.customer.v1.CustomerServiceGrpc;
import kh.eco.istad.platform.customer.v1.GetCustomerRequest;
import kh.eco.istad.platform.customer.v1.GetCustomerResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerGrpcClient {

    private final CustomerServiceGrpc.CustomerServiceBlockingStub customerStub;

    public CustomerGrpcClient(CustomerServiceGrpc.CustomerServiceBlockingStub customerStub) {
        this.customerStub = customerStub;
    }

    public GetCustomerResponse getCustomer(String customerId) {
        return customerStub.getCustomer(GetCustomerRequest.newBuilder()
                .setCustomerId(customerId)
                .build());
    }
}
