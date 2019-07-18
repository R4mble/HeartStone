package com.tiantianchat.controller;

import com.tiantianchat.config.CommonUtils;
import com.tiantianchat.config.JwtService;
import com.tiantianchat.config.WebConstants;
import com.tiantianchat.model.heartstone.Player;
import com.tiantianchat.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangyl
 * @date 2019/7/17
 */
@RestController
@RequestMapping("/player")
public class PlayerController {

    @PostMapping("/follow")
    public Player follow() {
        return null;
    }

    @Autowired
    private PlayerService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody Player user) {
        boolean res =  userService.createUser(user.getEmail(), user.getPassword(), user.getPassword());
        if (res) {
            return ResponseEntity.ok("注册成功");
        }
        return ResponseEntity.badRequest().body("注册失败");
    }

    @PostMapping("/users/login")
    public ResponseEntity userLogin(@NotBlank(message = "用户名或邮箱不能为空") @RequestParam String nameOrEmail,
                                    @NotBlank(message = "密码不能为空") @RequestParam String password,
                                    HttpServletRequest request,
                                    HttpServletResponse response) {

        Player user = userService.login(nameOrEmail, password);
        request.getSession().setAttribute(WebConstants.LOGIN_SESSION_KEY, user);
        CommonUtils.setCookie(response, Math.toIntExact(user.getId()));
        Map<String, Object> map = new HashMap<>(1);
        map.put("user", jwtService.toToken(user));
        return ResponseEntity.ok(map);
    }
}
