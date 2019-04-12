package com.jyu.apts.commons.utils;

import io.ipfs.api.IPFS;
import io.ipfs.api.MerkleNode;
import io.ipfs.api.NamedStreamable;
import io.ipfs.multihash.Multihash;

import java.io.*;

public class IPFSUtil {

    private static IPFS ipfs;

    public static IPFSUtil getInstance(){
        if (ipfs == null){
            ipfs = new IPFS("/ip4/127.0.0.1/tcp/5001");
        }
        return new IPFSUtil();
    }

    public String addFile(InputStream ins,String fileName) throws IOException {
        File file = new File(fileName);
        OutputStream os = new FileOutputStream(file);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        ins.close();
        String hashStr = addFile(file);
        file.delete();
        return hashStr;
    }

    public String addFile(File file) throws IOException {
        NamedStreamable.FileWrapper fileWrapper = new NamedStreamable.FileWrapper(file);
        MerkleNode addResult = ipfs.add(fileWrapper).get(0);
        return addResult.hash.toString();
    }

    public void download(String filePathName,String hash) throws IOException {
        Multihash filePointer = Multihash.fromBase58(hash);
        byte[] data = ipfs.cat(filePointer);
        if(data != null){
            File file = new File(filePathName);
            if(file.exists()){
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data,0,data.length);
            fos.flush();
            fos.close();
        }
    }


    public String addTxt(String text) throws IOException {
        NamedStreamable.ByteArrayWrapper byteArrayWrapper = new NamedStreamable.ByteArrayWrapper(text.getBytes("utf-8"));
        MerkleNode addResult = ipfs.add(byteArrayWrapper).get(0);
        return addResult.hash.toString();
    }

    public String cat(String hash) throws IOException {
        byte[] data = ipfs.cat(Multihash.fromBase58(hash));
        return new String(data);
    }

}
