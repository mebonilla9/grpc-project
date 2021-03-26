package dev.manuel.grpcproject.grpcserver.service;

import dev.manuel.grpcproject.User;
import dev.manuel.grpcproject.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

  @Override
  public void login(User.LoginRequest request, StreamObserver<User.ApiResponse> responseObserver) {
    System.out.println("Inside login");
    String userName = request.getUsername();
    String password = request.getPassword();

    User.ApiResponse.Builder response = User.ApiResponse.newBuilder();
    if (!userName.equals(password)) {
      //TODO Return failure message
      response.setResponseCode(-1).setResponseMessage("Invalid username or password login");
    } else {
      //TODO Return success message
      response.setResponseCode(1).setResponseMessage("Success login");
    }

    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void logout(User.Empty request, StreamObserver<User.ApiResponse> responseObserver) {
    super.logout(request, responseObserver);
  }
}
