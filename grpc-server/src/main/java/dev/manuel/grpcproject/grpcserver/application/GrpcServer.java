package dev.manuel.grpcproject.grpcserver.application;

import dev.manuel.grpcproject.grpcserver.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

  public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Starting GRPC Server");
    Server server = ServerBuilder
      .forPort(9090).addService(
        new UserService()
      ).build();
    server.start();
    System.out.println("Server started at port: "+server.getPort());
    server.awaitTermination();
  }
}
