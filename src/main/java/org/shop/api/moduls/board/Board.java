package org.shop.api.moduls.board;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@EqualsAndHashCode(of = "boardNo")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Board implements Serializable {

    private Long boardNo;
    @NonNull
    private String title;
    private String writer;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime updDate;

}
