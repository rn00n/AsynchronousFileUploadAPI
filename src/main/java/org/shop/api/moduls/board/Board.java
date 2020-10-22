package org.shop.api.moduls.board;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode(of = "boardNo")
@NoArgsConstructor
@AllArgsConstructor
public class Board implements Serializable {

    @Id @GeneratedValue
    private Integer boardNo;

    private String title;
    private String writer;
    private String content;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate updDate;

}
