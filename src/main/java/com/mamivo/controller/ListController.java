package com.mamivo.controller;

import com.mamivo.entity.List;
import com.mamivo.service.IListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListController {

    IListService iListService;

    public ListController(IListService iListService) {
        this.iListService = iListService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createList(@RequestBody List list) {
        iListService.createList(list);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ok!");
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
