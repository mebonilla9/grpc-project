package dev.manuel.grpcproject.grpcclient.application;

import dev.manuel.grpcproject.User;
import dev.manuel.grpcproject.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

  public static void main(String[] args) {

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    //TODO Stubs - generated from proto
    userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);
    User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("Manuels").setPassword("Manuel").build();
    User.ApiResponse response = userStub.login(loginRequest);
    System.out.println("Server response code: "+response.getResponseCode()+" Message: "+response.getResponseMessage());
  }
}
