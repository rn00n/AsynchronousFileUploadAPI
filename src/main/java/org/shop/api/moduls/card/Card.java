package org.shop.api.moduls.card;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class Card {
    @NotBlank
    private String no;

    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate validMonth;
}
