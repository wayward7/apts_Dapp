package com.jyu.apts.service.impl;

import com.jyu.apts.commons.consts.Consts;
import com.jyu.apts.dto.RecordAddDTO;
import com.jyu.apts.dto.RecordQueryDTO;
import com.jyu.apts.commons.dto.ResponseDTO;
import com.jyu.apts.commons.utils.IPFSUtil;
import com.jyu.apts.contract.APTS_sol_APTS;
import com.jyu.apts.contract.AddorGetContract;
import com.jyu.apts.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;


import java.io.IOException;

@Service
public class WalletServiceImpl implements WalletService {

    private static final Logger log = LoggerFactory.getLogger(WalletService.class);

    @Autowired
    private Consts consts;


    @Override
    public ResponseDTO deployedSol() {

        try {
            Credentials credentials = WalletUtils.loadCredentials(consts.getPassword(), consts.getPath());
            // 部署合约
            APTS_sol_APTS apts_sol_apts = AddorGetContract.addContract(credentials,consts.getGasPrice(),consts.getGasLimit());
            consts.writeContractAddr2File(apts_sol_apts.getContractAddress());
            // 部署完成后打印合约地址
            log.debug("部署的合约地址：" + apts_sol_apts.getContractAddress());
            return ResponseDTO.success("成功部署合约",apts_sol_apts.getContractAddress());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (CipherException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        }
    }

    @Override
    public ResponseDTO addRecord(RecordAddDTO recordAddDTO) {

        try {
            String hash = IPFSUtil.getInstance().addTxt(recordAddDTO.getData());
            Credentials credentials = WalletUtils.loadCredentials(consts.getPassword(), consts.getPath());
            String contractAddr = consts.getContractAddr();
            APTS_sol_APTS apts_sol_apts = AddorGetContract.getContract(contractAddr,credentials,consts.getGasPrice(),consts.getGasLimit());
            String result = apts_sol_apts.setRecord(new Utf8String(recordAddDTO.getCode()),new Utf8String(hash)).send().toString();
            return ResponseDTO.success(result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (CipherException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        }
    }

    @Override
    public ResponseDTO getRecord(RecordQueryDTO recordQueryDTO) {
        try {
            Credentials credentials = WalletUtils.loadCredentials(consts.getPassword(), consts.getPath());
            String contractAddr = consts.getContractAddr();
            APTS_sol_APTS apts_sol_apts = AddorGetContract.getContract(contractAddr,credentials,consts.getGasPrice(),consts.getGasLimit());
            Utf8String string = apts_sol_apts.getRecord(new Utf8String(recordQueryDTO.getCode())).send();
            String data = null;
            if (string != null){
                data = IPFSUtil.getInstance().cat(string.getValue());
            }
            RecordAddDTO result = new RecordAddDTO();
            result.setCode(recordQueryDTO.getCode());
            result.setData(data);
            return ResponseDTO.success(result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (CipherException e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.failture(e.getMessage());
        }
    }
}
