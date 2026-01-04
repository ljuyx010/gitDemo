package net.dpwl.webapi.controller;

import net.dpwl.webapi.entity.User;
import net.dpwl.webapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:45
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return JSON格式的用户信息
     */
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        //System.out.println(user.toString());
        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", user);
        } else {
            response.put("code", 404);
            response.put("message", "用户不存在");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 另一种返回方式：直接返回对象，Spring Boot会自动转换为JSON
     * @param id 用户ID
     * @return User对象（自动转换为JSON）
     */
    @GetMapping("/simple/{id}")
    public User getUserByIdSimple(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    /**
     * 使用MyBatis Plus的getById方法
     */
    @GetMapping("/mp/{id}")
    public ResponseEntity<Map<String, Object>> getUserByMpId(@PathVariable Integer id) {
        User user = userService.getById(id);

        Map<String, Object> response = new HashMap<>();

        if (user != null && user.getYz() == 0) {
            response.put("success", true);
            response.put("data", user);
        } else {
            response.put("success", false);
            response.put("message", "用户不存在或已被删除");
        }

        return ResponseEntity.ok(response);
    }
}
