package com.example.springboard.api.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardSearch {

    private static final int MAX_SIZE = 2000;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 10;

    public long getOffset() {
        return (long) (Math.max(1,page) * Math.min(size,MAX_SIZE));
    }

}
