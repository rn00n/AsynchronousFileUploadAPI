package org.shop.api.moduls.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board register(Board board) {
        board = boardRepository.save(board);
        return board;
    }

    @Override
    public List<Board> list() {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
        return boardList;
    }

    @Override
    public Board read(Integer boardNo) {
        Board board = boardRepository.findById(boardNo).get();
        return board;
    }

    @Override
    public void remove(Integer boardNo) {
        boardRepository.deleteById(boardNo);
    }

    @Override
    public Board modify(Board board) {
        Board boardEntity = boardRepository.findById(board.getBoardNo()).get();
        boardEntity.setTitle(board.getTitle());
        boardEntity.setContent(board.getContent());
        return boardEntity;
    }
}
