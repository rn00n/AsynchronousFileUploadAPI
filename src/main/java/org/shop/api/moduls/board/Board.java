package org.shop.api.moduls.board;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = "boardNo")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Board implements Serializable {

    private Integer boardNo;
    @NonNull
    private String title;
    private String writer;
    private String content;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate updDate;

}
