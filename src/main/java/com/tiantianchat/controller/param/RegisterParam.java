package com.tiantianchat.controller.param;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Wangyl
 * @date 2019/7/22
 */
@Data
public class RegisterParam {

    @Size(min = 3, max = 12, message = "用户名长度应当在3-12个字符之间")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "用户名只能包含英文字母和数字")
    private String name;

    @Email(message = "邮箱格式不对")
    private String email;

    @Size(min = 6, max = 18, message = "密码长度应当在6-18个字符之间")
    private String password;
}
