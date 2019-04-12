package com.jyu.apts.rest;
import com.jyu.apts.dto.RecordAddDTO;
import com.jyu.apts.dto.RecordQueryDTO;
import com.jyu.apts.commons.dto.ResponseDTO;
import com.jyu.apts.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    /**
     * 部署合约
     * @return
     */
    @RequestMapping("/deployed_sol")
    public ResponseDTO deployedSol() {
       return walletService.deployedSol();
    }

    /**
     * 添加数据到区块链
     * @param recordAddDTO
     * @return
     */
    @RequestMapping("/addRecord")
    public ResponseDTO addRecord(@RequestBody @Valid RecordAddDTO recordAddDTO) {
       return walletService.addRecord(recordAddDTO);
    }

    /**
     * 获得区块链数据
     * @param recordQueryDTO
     * @return
     */
    @RequestMapping("/getRecord")
    public ResponseDTO getRecord(@RequestBody @Valid RecordQueryDTO recordQueryDTO){
        return walletService.getRecord(recordQueryDTO);
    }
}
