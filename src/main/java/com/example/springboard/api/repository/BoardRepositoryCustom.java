package com.example.springboard.api.repository;

import com.example.springboard.api.domain.Board;
import com.example.springboard.api.response.BoardSearch;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> getList(BoardSearch boardSearch);

}
