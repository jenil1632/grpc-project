package com.example.grpcserver;

import com.example.protos.HelloRequest;
import com.example.protos.HelloResponse;
import com.example.protos.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloServiceImplBase {

  @Override
  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseStreamObserver) {
    String greeting = new StringBuilder()
        .append("Hello ")
        .append(request.getFirstName() + " ")
        .append(request.getLastName())
        .toString();
    HelloResponse response = HelloResponse.newBuilder()
        .setGreeting(greeting)
        .build();

    responseStreamObserver.onNext(response);
    responseStreamObserver.onCompleted();
  }

}
