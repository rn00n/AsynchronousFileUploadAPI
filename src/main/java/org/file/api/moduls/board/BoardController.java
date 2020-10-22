package org.file.api.moduls.board;

import lombok.extern.java.Log;
import org.shop.api.moduls.page.PageRequestVO;
import org.shop.api.moduls.page.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Log
@RestController
@RequestMapping("/api/boards")
@CrossOrigin(origins = "http://localhost:8081")
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping
	public ResponseEntity<List<Board>> list() {
		List<Board> boardList = boardService.list();
		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);
		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@Validated @RequestBody Board board, UriComponentsBuilder uriBuilder) {
		board = boardService.register(board);

		URI resourceUri = uriBuilder.path("boards/{boardNo}").buildAndExpand(board.getBoardNo()).encode().toUri();
		return ResponseEntity.created(resourceUri).build();
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") Integer boardNo) {
		Board board = boardService.read(boardNo);
		ResponseEntity<Board> entity = new ResponseEntity<>(HttpStatus.OK);
		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<Void> remove(@PathVariable("boardNo") Integer boardNo) {
		boardService.remove(boardNo);
		ResponseEntity<Void> entity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return entity;
	}

	@PutMapping("/{boardNo}")
	public ResponseEntity<Void> modifyByJson(@PathVariable("boardNo") Integer boardNo, @Validated @RequestBody Board board) {
		board = boardService.modify(board);
		ResponseEntity<Void> entity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return entity;
	}

}
