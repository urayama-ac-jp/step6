package com.classroom.assignment.controller.api;

import static org.assertj.core.api.Assertions.assertThat;
import com.classroom.assignment.controller.Step6Controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.classroom.assignment.model.request.Comment;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.validation.BindingResult;

@SpringBootTest
@AutoConfigureMockMvc
class Step6ControllerTests {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private Step6Controller controller;

  @Test
  void contextLoads() {
    // given
    // when
    // then
    assertThat(controller).isNotNull();
  }

  @Test
  public void affiliationDepartmentItemExistenceConfirmation() throws Exception {
    // given
    // when
    // then

    // パラメータ設定
    Comment comment = new Comment("test", "test", "");
    // 実行
    ResultActions results = mockMvc.perform(post("/step6/comment")
        .flashAttr("comment", comment))
        // 検証
        // modelのいずれかにエラーがあること
        .andExpect(model().hasErrors())
        // postFormにエラーが存在すること
        .andExpect(model().attributeHasErrors("comment"));

    BindingResult bindResult = (BindingResult) results.andReturn().getModelAndView().getModel()
        .get(BindingResult.MODEL_KEY_PREFIX + "comment");
    String mes = bindResult.getFieldError().getDefaultMessage();
    assertThat(mes).isEqualTo("メールアドレスを入力してください");
  }

}
