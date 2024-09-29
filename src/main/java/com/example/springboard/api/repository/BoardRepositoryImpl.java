package com.example.springboard.api.repository;

import com.example.springboard.api.domain.Board;
import com.example.springboard.api.domain.QBoard;
import com.example.springboard.api.response.BoardSearch;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Board> getList(BoardSearch boardSearch) {
        return jpaQueryFactory.selectFrom(QBoard.board)
                .limit(boardSearch.getSize())
                .offset(boardSearch.getOffset())
                .orderBy(QBoard.board.id.desc())
                .fetch();
    }
}
