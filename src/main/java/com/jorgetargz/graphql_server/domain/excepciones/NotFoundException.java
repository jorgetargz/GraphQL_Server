package com.jorgetargz.graphql_server.domain.excepciones;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
