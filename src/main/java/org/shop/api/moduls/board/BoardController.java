package org.shop.api.moduls.board;

import lombok.extern.java.Log;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Log
@RestController
@RequestMapping("/boards")
public class BoardController {

	@GetMapping
	public ResponseEntity<List<Board>> list() {
		log.info("게시판 목록");

		List<Board> boardList = new ArrayList<>();
		
		Board board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("향수");
		board.setContent("넓은 벌 동쪽 끝으로");
		board.setWriter("hongkd");
		board.setRegDate(LocalDate.now());

		boardList.add(board);
		
		board = new Board();
		
		board.setBoardNo(2);
		board.setTitle("첫 마음");
		board.setContent("날마다 새로우며 깊어지고 넓어진다");
		board.setWriter("hongkd");
		board.setRegDate(LocalDate.now());

		boardList.add(board);

		ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);

		return entity;
	}

	@PostMapping
	public ResponseEntity<String> register(@RequestBody Board board) {
		log.info("게시판 등록");

		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> read(@PathVariable("boardNo") Integer boardNo) {
		log.info("게시판 정보");

		Board board = new Board();
		
		board.setBoardNo(1);
		board.setTitle("향수");
		board.setContent("넓은 벌 동쪽 끝으로");
		board.setWriter("hongkd");
		board.setRegDate(LocalDate.now());

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@GetMapping(value = "/{boardNo}", produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") Integer boardNo) {
		log.info("게시판 정보Json");

		Board board = new Board();

		board.setBoardNo(1);
		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(LocalDate.now());

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@GetMapping(value = "/{boardNo}", produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") Integer boardNo) {
		log.info("게시판 정보Xml");

		Board board = new Board();

		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(LocalDate.now());

		ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);

		return entity;
	}

	@DeleteMapping("/{boardNo}")
	public ResponseEntity<String> remove(@PathVariable("boardNo") Integer boardNo) {
		log.info("게시판 삭제");

		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PutMapping(value = "/{boardNo}", consumes = "application/json")
	public ResponseEntity<String> modifyByJson(@PathVariable("boardNo") Integer boardNo, @RequestBody Board board) {
		log.info("게시판 수정 Json");

		System.out.println(board);

		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PutMapping(value = "/{boardNo}", consumes = "application/xml")
	public ResponseEntity<String> modifyByXml(@PathVariable("boardNo") Integer boardNo, @RequestBody Board board) {
		log.info("게시판 수정 Xml");

		System.out.println(board);

		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

		return entity;
	}

	@PostMapping(value = "/{boardNo}")
	public ResponseEntity<String> modifyPost(@PathVariable("boardNo") Integer boardNo, @RequestBody Board board) {
		log.info("부분수정");
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		return entity;
	}

}
