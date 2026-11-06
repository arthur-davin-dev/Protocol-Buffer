package kh.eco.istad.platform.order.client.customer;

import kh.eco.istad.platform.customer.v1.CustomerServiceGrpc;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.ImportGrpcClients;

@Configuration(proxyBeanMethods = false)
@ImportGrpcClients(target = "customer-channel", types = CustomerServiceGrpc.CustomerServiceBlockingStub.class)
public class CustomerGrpcClientConfiguration {
}
