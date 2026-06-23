package com.dgsw.liblong.controller;

import com.dgsw.liblong.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/returns")
public class ReturnController {

    private final ReturnService returnService;

    @DeleteMapping("/{id}")
    public String returnBook(@PathVariable Long id) {

        returnService.returnBook(id);

        return "반납 완료";

    }

}
