package com.example.todoapp.controller;

import com.example.todoapp.domain.ToDo;
import com.example.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Controller
@RequiredArgsConstructor //스프링이 실행하면서 컨트롤러에 ToDoRepository를 넣어준다.
public class TodoController {

    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);

        return "todos";

    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo) {
        System.out.println(todo);

        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);

        return "redirect:/";
    }
}
