package com.jyu.apts.commons.consts;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Properties;

@Component
public class Consts {

    @Autowired
    private Environment env;

    /**
     * GAS价格
     */
    public BigInteger getGasPrice() {
        return BigInteger.valueOf(1_000_000L);
    }
    /**
     * GAS上限
     */
    public BigInteger getGasLimit() {
        return BigInteger.valueOf(20_000_000L);
    }

    /**
     * 钱包密码
     * @return
     */
    public String getPassword() {
        return env.getProperty("com.wallet.password");
    }

    /**
     * 钱包路径
     * @return
     */
    public String getPath() {
        return env.getProperty("com.wallet.path");
    }

    /**
     * 钱包地址
     * @return
     */
    public String getAddress(){
        return env.getProperty("com.wallet.address");
    }

    /**
     * 将部署的智能合约地址保存到文件
     * @param contractAddr
     * @throws IOException
     */
    public void writeContractAddr2File(String contractAddr) throws IOException {
        Properties prop = new Properties();
        prop.setProperty("con.contract.address",contractAddr);
        String file = this.getClass().getResource("/").getPath() + "contract_address.properties";
        OutputStream outputStream = new FileOutputStream(file);
        prop.store(outputStream,"");
        outputStream.close();

    }

    /**
     * 读取智能合约地址
     * @return
     * @throws IOException
     */
    public String getContractAddr() throws IOException {
        Properties prop = new Properties();
        InputStream in = Consts.class.getResourceAsStream("/contract_address.properties");
        InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
        prop.load(reader);
        in.close();
        return prop.getProperty("con.contract.address");
    }
}
