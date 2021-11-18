package com.mnmlist.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author: zhangtengfei01
 * @date: 2021/10/31 10:11 AM
 */
@Service
public class IndexService {

    Random random = new Random(100);

    @SentinelResource(value = "doStatus", blockHandler = "blockHandler", fallback = "fallbackHandler")
    public Object doStatus() {
        Map<String, String> result = new HashMap<>();
        result.put("code", "A00000");
        result.put("msg", "success");
        int randomNum = random.nextInt(100);
        if (randomNum < 20) {
            return result;
        }
        try {
            Thread.sleep(200);
        } catch (Exception ex) {
            System.out.println("error occurs");
        }
        return result;
    }

    // 服务熔断降级处理，函数签名与原函数一致或加一个 Throwable 类型的参数
    public Object fallbackHandler(Throwable throwable) {
        System.out.println("fallbackHandler_服务熔断控制处理：" + throwable.getMessage());
        Map<String, String> result = new HashMap<>();
        result.put("code", "Q00333");
        result.put("msg", "Q00333-被降级了");
        return result;
    }

    // 服务流量控制处理，参数最后多一个 BlockException，其余与原函数一致。
    public Object blockHandler(FlowException ex) {
        System.out.println("blockHandler_服务流量控制处理：" + ex.getMessage());
        Map<String, String> result = new HashMap<>();
        result.put("code", "Q00333");
        result.put("msg", "Q00333-被限流了");
        return result;
    }
}
