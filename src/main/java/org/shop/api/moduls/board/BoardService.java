package org.shop.api.moduls.board;

import java.util.List;

public interface BoardService {
    Board register(Board board);

    List<Board> list();

    Board read(Integer boardNo);

    void remove(Integer boardNo);

    Board modify(Board board);

}
