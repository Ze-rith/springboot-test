package com.dgsw.liblong.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookRequestDto {
    private String bookName;
    private String description;
    private boolean borrowed;
}
