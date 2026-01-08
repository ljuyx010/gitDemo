package net.dpwl.webapi.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.dpwl.webapi.dto.PageDTO;
import net.dpwl.webapi.dto.UserFromDTO;
import net.dpwl.webapi.entity.User;
import net.dpwl.webapi.query.UserQuery;
import net.dpwl.webapi.service.UserService;
import net.dpwl.webapi.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:45
 */
@RestController
@Tag(name = "用户管理")
@RequestMapping("/users")
@RequiredArgsConstructor   // 自动注入UserService
public class UserController {

    private final UserService userService;

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return JSON格式的用户信息
     */
    @Operation(summary = "单用户信息",description = "根据用户ID查询用户信息")
    @Parameters({
            @Parameter(name = "id",description = "用户ID",required = true,in= ParameterIn.PATH)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable Integer id) {
        // 1.查询用户po
        User user = userService.getUserById(id);
        // 2.把po拷贝到vo
        UserFromDTO userFromDTO = new UserFromDTO();
        BeanUtil.copyProperties(user, userFromDTO);

        Map<String, Object> response = new HashMap<>();

        if (user != null) {
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", userFromDTO);
        } else {
            response.put("code", 404);
            response.put("message", "用户不存在");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 批量查询用户信息
     * @param ids 用户ID集合
     * @return User对象（自动转换为JSON）
     */
    @Operation(summary = "批量查询用户信息",description = "根据用户ID批量查询用户信息")
    @Parameters({
            @Parameter(name = "ids",description = "用户ID集合",required = true,in= ParameterIn.QUERY)
    })
    @GetMapping("/batch")
    public ResponseEntity<Map<String, Object>> getUsersByIds(@RequestParam("ids") List<Integer> ids) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 查询用户列表
            List<User> userList = userService.listByIds(ids);
            // 把po拷贝到vo
            List<UserFromDTO> userFromDTOList = BeanUtil.copyToList(userList, UserFromDTO.class);

            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", userFromDTOList);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 根据多条件查询用户信息
     * @param query 查询条件
     * @return User对象（自动转换为JSON）
     */
    @Operation(summary = "复杂条件查询用户信息",description = "根据复杂条件批量查询用户信息")
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getQueryUsers(UserQuery query) {
        Map<String, Object> response = new HashMap<>();
        System.out.println(query);
        try {
            // 查询用户列表
            List<User> userList = userService.queryUsers(query.getNickname(), query.getSex(), query.getYz(), query.getTel());
            // 把po拷贝到vo
            List<UserVO> userFromVOList = BeanUtil.copyToList(userList, UserVO.class);

            response.put("success", true);
            response.put("message", "查询成功");
            response.put("data", userFromVOList);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "查询失败");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 根据id删除用户
     */
    @Operation(summary = "删除用户",description = "根据用户ID删除用户（逻辑删除，设置yz为0）")
    @Parameters({
            @Parameter(name = "id",description = "用户ID",required = true,in= ParameterIn.PATH)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delUserById(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 删除数据
            userService.removeById(id);
            response.put("success", true);
            response.put("message", "用户删除成功");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "用户删除失败");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 添加用户
     * @param userFromDTO 用户表单对象
     * @return JSON格式的添加结果
     */
    @Operation(summary = "添加用户",description = "添加新用户")
    @Parameters({
            @Parameter(name = "user",description = "用户对象",required = true,in= ParameterIn.QUERY)
    })
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody UserFromDTO userFromDTO) {
        Map<String, Object> response = new HashMap<>();
        // 把dto拷贝到po
        User user = BeanUtil.copyProperties(userFromDTO, User.class);
        // 手动设置yz为0
        user.setYz(0);
        try {
            // 保存用户到数据库
            userService.save(user);
            response.put("success", true);
            response.put("message", "用户添加成功");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "用户添加失败");
        }
        return ResponseEntity.ok(response);
    }
    /**
     * 更新用户信息
     * @param userFromDTO 用户表单对象
     * @return JSON格式的更新结果
     */
    @Operation(summary = "更新用户信息",description = "根据用户ID更新用户信息")
    @Parameters({
            @Parameter(name = "user",description = "用户对象",required = true,in= ParameterIn.QUERY)
    })
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateUser(@RequestBody UserFromDTO userFromDTO) {
        Map<String, Object> response = new HashMap<>();
        // 把dto拷贝到po
        User user = BeanUtil.copyProperties(userFromDTO, User.class);
        try {
            // 更新用户到数据库
            userService.updateById(user);
            response.put("success", true);
            response.put("message", "用户更新成功");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "用户更新失败");
        }
        return ResponseEntity.ok(response);
    }

    /**
     * 分页查询用户信息
     * @param query 查询条件
     * @return 用户分页信息
     */
    @Operation(summary = "分页查询用户信息",description = "根据分页条件查询用户信息")
    @Parameters({
            @Parameter(name = "query",description = "分页查询条件",required = true,in= ParameterIn.QUERY)
    })
    @GetMapping("/page")
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        // 在service 完成查询
        return userService.queryUsersPage(query);
    }
}
