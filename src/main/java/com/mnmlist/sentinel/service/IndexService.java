package com.mnmlist.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author: zhangtengfei01
 * @date: 2021/10/31 10:11 AM
 */
@Service
public class IndexService {

    Random random = new Random(100);

    @SentinelResource(value = "doStatus", blockHandler = "blockHandler", fallback = "indexFallback")
    public Object doStatus() {
        int randomNum = random.nextInt(100);
        if (randomNum < 20) {
            return "success";
        }
        try {
            Thread.sleep(200);
        } catch (Exception ex) {
            System.out.println("error occurs");
        }
        return "success";
//        throw new RuntimeException("indexFallback test");
    }

    // 服务流量控制处理，参数最后多一个 BlockException，其余与原函数一致。
    public Object blockHandler(FlowException ex) {
        System.out.println("blockHandler_服务流量控制处理：" + ex.getMessage());
        return "blockHandler_服务流量控制处理";
    }

    // 服务熔断降级处理，函数签名与原函数一致或加一个 Throwable 类型的参数
    public Object indexFallback(Throwable throwable) {
        System.out.println("indexFallback_服务熔断控制处理：" + throwable.getMessage());
        return "indexFallback_服务熔断控制处理";
    }

}
