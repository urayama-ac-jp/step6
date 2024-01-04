package com.classroom.assignment.controller;

import com.classroom.assignment.model.request.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/step6")
public class Step6Controller {

  @GetMapping
  public String index(Comment comment, Model model) {
    return "step6/index";
  }

  @PostMapping("/comment")
  public String evening(@Validated Comment comment, BindingResult result, Model model) {
    if(result.hasErrors()){
      return "step6/index";
    }
    model.addAttribute("name", comment.getName());
    model.addAttribute("content", comment.getContent());
    model.addAttribute("mail", comment.getMail());
    return "step6/confirm";
  }
}
