package com.jyu.apts.service;

import com.jyu.apts.dto.RecordAddDTO;
import com.jyu.apts.dto.RecordQueryDTO;
import com.jyu.apts.commons.dto.ResponseDTO;

public interface WalletService {

    ResponseDTO deployedSol();

    ResponseDTO addRecord(RecordAddDTO recordAddDTO);

    ResponseDTO getRecord(RecordQueryDTO recordQueryDTO);
}
