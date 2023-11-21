package io.hyun.backend.entities.references;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Address {
    private String postNumber;
    private String address;
    private String detailAddress;
}
