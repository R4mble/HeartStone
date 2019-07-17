package com.tiantianchat.controller;

import com.tiantianchat.model.Player;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
