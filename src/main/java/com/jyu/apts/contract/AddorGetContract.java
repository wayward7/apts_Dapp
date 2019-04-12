package com.jyu.apts.contract;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

public class AddorGetContract {


    public static APTS_sol_APTS addContract(Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        APTS_sol_APTS apts_sol_apts = APTS_sol_APTS.deploy(web3j,credentials,gasPrice,gasLimit).send();
        return apts_sol_apts;
    }

    public static APTS_sol_APTS getContract(String contractAddr,Credentials credentials, BigInteger gasPrice, BigInteger gasLimit){
        Web3j web3j = Web3j.build(new HttpService());
        return APTS_sol_APTS.load(contractAddr,web3j,credentials,gasPrice,gasLimit);
    }
}
