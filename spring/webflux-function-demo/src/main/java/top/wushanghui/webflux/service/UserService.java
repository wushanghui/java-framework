package top.wushanghui.webflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.wushanghui.webflux.entity.User;

/**
 * @author wsh
 * @date 2020-08-24 16:57
 */
public interface UserService {

    // 根据id查询用户
    Mono<User> getUserById(int id);
    //查询所有用户
    Flux<User> getAllUser();
    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
