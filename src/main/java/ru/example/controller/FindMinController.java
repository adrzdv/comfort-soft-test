package ru.example.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/find")
public class FindMinController {


    public void findMin(@PathVariable String src, @PathVariable int n) {

    }
}
