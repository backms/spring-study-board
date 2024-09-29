package com.example.springboard.api.service;

import com.example.springboard.api.domain.Board;
import com.example.springboard.api.domain.BoardEditor;
import com.example.springboard.api.exception.BoardNotFound;
import com.example.springboard.api.repository.BoardRepository;
import com.example.springboard.api.request.BoardCreate;
import com.example.springboard.api.request.BoardEdit;
import com.example.springboard.api.response.BoardResponse;
import com.example.springboard.api.response.BoardSearch;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void write(BoardCreate boardCreate) {
        Board board = Board.builder()
                .title(boardCreate.getTitle())
                .content(boardCreate.getContent())
                .writer(boardCreate.getWriter())
                .build();

        boardRepository.save(board);
    }

    public BoardResponse get(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFound::new);

        return BoardResponse.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
    }

    public List<BoardResponse> getList(BoardSearch boardSearch) {
        return boardRepository.getList(boardSearch).stream()
                .map(board -> new BoardResponse(board))
                .collect(Collectors.toList());
    }

    public BoardResponse edit(long boardId, @Valid BoardEdit boardEdit) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFound::new);

        BoardEditor.BoardEditorBuilder editorBuilder = board.toEditor();

        BoardEditor boardEditor = editorBuilder.title(boardEdit.getTitle())
                                                .content(boardEdit.getContent())
                                                .writer(boardEdit.getWriter())
                                                .build();

        board.edit(boardEditor);

        return new BoardResponse(board);
    }


    public void delete(long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(BoardNotFound::new);

        boardRepository.delete(board);
    }

}
