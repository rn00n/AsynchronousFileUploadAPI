package org.shop.api.moduls.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.shop.api.moduls.address.Address;
import org.shop.api.moduls.card.Card;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class Member {
    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 3)
    private String username;

    @Email
    private String email;

    private String gender;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Valid
    private Address address;

    @Valid
    private List<Card> cardList;
}
