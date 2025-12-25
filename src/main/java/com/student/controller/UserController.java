package com.student.controller;

import com.student.domain.PageResult;
import com.student.domain.Result;
import com.student.domain.User;
import com.student.domain.queryParam.UserQueryParam;
import com.student.service.UserService;
import com.student.util.BCryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 分页查询用户
     *
     * @param param 分页查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(UserQueryParam param) {
        log.info("分页查询用户，参数：{}", param);
        PageResult pageResult = userService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 操作结果
     */
    @PostMapping
    public Result add(@RequestBody User user) {
        // 校验用户类型是否合法
        if (user.getUserType() == null || (user.getUserType() != 1 && user.getUserType() != 2 && user.getUserType() != 3)) {
            return Result.error("用户类型必须为1（学生）或2（辅导员）或3（管理员）");
        }
        log.info("添加用户，参数：{}", user);
        user.setPassword(BCryptUtil.encryptPassword(user.getPassword()));
        userService.save(user);
        return Result.success();
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 操作结果
     */
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除用户，参数：{}", id);
        userService.removeById(id);
        return Result.success();
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 操作结果
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("更新用户，参数：{}", user);
        // 校验用户类型是否合法
        if (user.getUserType() == null || (user.getUserType() != 1 && user.getUserType() != 2 && user.getUserType() != 3)) {
            return Result.error("用户类型必须为1（学生）或2（辅导员）或3（管理员）");
        }
        user.setPassword(BCryptUtil.encryptPassword(user.getPassword()));
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 根据ID查询用户
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result geyById(@PathVariable Integer id) {
        log.info("根据ID查询用户，参数：{}", id);
        User user = userService.getById(id);
        return Result.success(user);
    }

}
