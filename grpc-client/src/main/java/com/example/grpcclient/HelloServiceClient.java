package com.example.grpcclient;

import com.example.protos.HelloRequest;
import com.example.protos.HelloServiceGrpc.HelloServiceBlockingStub;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceClient {

  @GrpcClient("hello")
  HelloServiceBlockingStub helloServiceBlockingStub;

  @GetMapping("/hello")
  public String getMessage() {
    return helloServiceBlockingStub.hello(
        HelloRequest.newBuilder()
            .setFirstName("Jenil")
            .setLastName("Shah")
            .build()
    ).getGreeting();
  }

}
