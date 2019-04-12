package com.jyu.apts.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.2.0.
 */
public class APTS_sol_APTS extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b61040f8061001e6000396000f30060606040526004361061004b5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166311dd88458114610050578063c1880a9814610118575b600080fd5b341561005b57600080fd5b6100a160046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496506101ad95505050505050565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100dd5780820151838201526020016100c5565b50505050905090810190601f16801561010a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561012357600080fd5b6101ab60046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405281815292919060208401838380828437509496506102ba95505050505050565b005b6101b5610336565b6000826040518082805190602001908083835b602083106101e75780518252601f1990920191602091820191016101c8565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390208054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156102ae5780601f10610283576101008083540402835291602001916102ae565b820191906000526020600020905b81548152906001019060200180831161029157829003601f168201915b50505050509050919050565b806000836040518082805190602001908083835b602083106102ed5780518252601f1990920191602091820191016102ce565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020908051610331929160200190610348565b505050565b60206040519081016040526000815290565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061038957805160ff19168380011785556103b6565b828001600101855582156103b6579182015b828111156103b657825182559160200191906001019061039b565b506103c29291506103c6565b5090565b6103e091905b808211156103c257600081556001016103cc565b905600a165627a7a72305820b954e4abf153415dd6b788aef582bc083b27d128949377781504b999935965340029";

    public static final String FUNC_GETRECORD = "getRecord";

    public static final String FUNC_SETRECORD = "setRecord";

    @Deprecated
    protected APTS_sol_APTS(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected APTS_sol_APTS(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected APTS_sol_APTS(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected APTS_sol_APTS(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Utf8String> getRecord(Utf8String code) {
        final Function function = new Function(FUNC_GETRECORD,
                Arrays.<Type>asList(code),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> setRecord(Utf8String code, Utf8String addr) {
        final Function function = new Function(
                FUNC_SETRECORD,
                Arrays.<Type>asList(code, addr),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static APTS_sol_APTS load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new APTS_sol_APTS(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static APTS_sol_APTS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new APTS_sol_APTS(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static APTS_sol_APTS load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new APTS_sol_APTS(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static APTS_sol_APTS load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new APTS_sol_APTS(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<APTS_sol_APTS> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(APTS_sol_APTS.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<APTS_sol_APTS> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(APTS_sol_APTS.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<APTS_sol_APTS> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(APTS_sol_APTS.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<APTS_sol_APTS> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(APTS_sol_APTS.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
