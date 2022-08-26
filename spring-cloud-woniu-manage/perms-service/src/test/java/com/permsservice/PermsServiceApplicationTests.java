package com.permsservice;

import com.permsservice.dao.mysql.PermsMysqlDao;
import com.permsservice.dao.po.RbacPermsPo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
@Transactional
class PermsServiceApplicationTests {

    @Resource
    private PermsMysqlDao permsMysqlDao;

    @Test
    void contextLoads() {
        List<RbacPermsPo> parentPerms = permsMysqlDao.findParentPermsByUserId(1);
        for (RbacPermsPo perm : parentPerms) {
            System.out.println(perm.getPercode());
        }
    }


    @Test
    public void demo3() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        Callable<String> callable = () -> {
            System.out.println("想想想想想"); System.out.flush();
            Thread.sleep(3000);
            return "hello world";
        };
        System.out.println("问问题");
        Future<String> future = service.submit(callable);
        // Mono<String> "装"的 callable 的执行结果。

        System.out.print("做其他题目");
        for (int i = 0; i <100; i++) {
            System.out.flush();
            System.out.print(".");
            System.out.flush();
            Thread.sleep(200);
        }
        System.out.println("");
//        System.out.println(future.get());

        System.out.println("拿到问题的结果：" + future.get());
    }

}
