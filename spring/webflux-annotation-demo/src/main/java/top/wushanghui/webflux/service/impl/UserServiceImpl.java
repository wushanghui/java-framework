package top.wushanghui.webflux.service.impl;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.wushanghui.webflux.entity.User;
import top.wushanghui.webflux.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2020-08-24 16:59
 */
@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy", "man", 20));
        this.users.put(2, new User("mary", "woman", 30));
        this.users.put(3, new User("jack", "woman", 50));
    }

    //根据 id 查询
    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    //添加用户
    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            //向 map 集合里面放值
            int id = users.size() + 1;
            users.put(id, person);
        }).thenEmpty(Mono.empty());
    }
}
