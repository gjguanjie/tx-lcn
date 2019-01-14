package com.codingapi.txlcn.manager.config;

import com.codingapi.txlcn.spi.message.RpcConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 * Date: 19-1-9 下午6:13
 *
 * @author ujued
 */
@Configuration
public class MyRpcConfig implements InitializingBean {

    private final RpcConfig rpcConfig;

    private final TxManagerConfig managerConfig;

    @Autowired
    public MyRpcConfig(RpcConfig rpcConfig, TxManagerConfig managerConfig) {
        this.rpcConfig = rpcConfig;
        this.managerConfig = managerConfig;
    }

    @Override
    public void afterPropertiesSet() {
        rpcConfig.setAttrDelayTime(managerConfig.getDtxTime() / 1000);
    }
}