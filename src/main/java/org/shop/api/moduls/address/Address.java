package org.shop.api.moduls.address;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Address {
    @NotBlank
    private String postCode;

    @NotBlank
    private String location;
}
