package kh.eco.istad.platform.customer.grpc;

import kh.eco.istad.platform.customer.v1.CustomerServiceGrpc;
import kh.eco.istad.platform.customer.v1.GetCustomerRequest;
import kh.eco.istad.platform.customer.v1.GetCustomerResponse;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
public class CustomerGrpcService extends CustomerServiceGrpc.CustomerServiceImplBase {

    private final CustomerGrpcProperties properties;

    public CustomerGrpcService(CustomerGrpcProperties properties) {
        this.properties = properties;
    }

    @Override
    public void getCustomer(GetCustomerRequest request, StreamObserver<GetCustomerResponse> responseObserver) {
        final UUID customerId;
        try {
            customerId = UUID.fromString(request.getCustomerId());
        } catch (IllegalArgumentException ex) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                    .withDescription("customer_id must be a UUID")
                    .asRuntimeException());
            return;
        }

        CustomerGrpcProperties.Customer customer = properties.getCustomers().get(customerId.toString());
        if (customer == null) {
            responseObserver.onError(Status.NOT_FOUND
                    .withDescription("Customer " + customerId + " not found")
                    .asRuntimeException());
            return;
        }

        responseObserver.onNext(GetCustomerResponse.newBuilder()
                .setCustomerId(customerId.toString())
                .setUsername(customer.getUsername())
                .setFamilyName(customer.getFamilyName())
                .setGivenName(customer.getGivenName())
                .setEmail(customer.getEmail())
                .setPhoneNumber(customer.getPhoneNumber())
                .setStatus(customer.getStatus())
                .build());
        responseObserver.onCompleted();
    }
}
