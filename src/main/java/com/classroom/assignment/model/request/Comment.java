package com.classroom.assignment.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

public class Comment {

  @Size(min = 1, max = 20, message = "20文字以内で入力してください")
  private String name;

  @NotEmpty
  private String content;

  // ↓アノテーションを追加してください↓

  // ↑アノテーションを追加してください↑
  @Email(message = "メールアドレスの形式ではありません")
  private String mail;

  public Comment(String name, String content, String mail) {
    this.setName(name);
    this.setContent(content);
    this.setMail(mail);
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
