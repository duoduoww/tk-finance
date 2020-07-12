package com.tk.admin.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Objects;

/**
 * AES加解密工具类
 * Created by shuzheng on 2017/2/5.
 */
public class AESUtil {

    private static final String encodeRules = "zheng";

    /**
     * 普通AES加密
     * @param content 加密内容
     * @return 加密后的内容
     */
    public static String AESEncode(String content) {
       // return null;
        return encode(content, 0);
    }

    /**
     * 普通AES解密
     * @param content 解密内容
     * @return 解密后的内容
     */
    public static String AESDecode(String content) {
        return decode(content, 0);
    }

    /**
     * URL参数的AES加密
     * @param content 加密内容
     * @return 加密后的内容
     */
    /*public static String AESUrlEncode(String content) {
        return encode(content, 1);
    }*/

    /**
     * URL参数的AES解密
     * @param content 解密内容
     * @return 解密后的内容
     */
    public static String AESUrlDecode(String content) {
        return decode(content, 1);
    }

    /**
     * 加密 (type:0-普通加密；1-Url加密)
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     */
    private static String encode(String content, Integer type){
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey originalKey = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = originalKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteEncode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byteAES = cipher.doFinal(byteEncode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            //String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            String aesEnCode;
            if(Objects.equals(type, 0)){
                aesEnCode = new String(Base64.getEncoder().encode(byteAES));
            }else{
                aesEnCode = new String(Base64.getUrlEncoder().encode(byteAES));
            }
            //11.将字符串返回
            return aesEnCode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }

    /**
     * 解密 (type:0-普通加密；1-Url加密)
     * 解密过程：
     * 1.同加密1-4步
     * 2.将加密后的字符串反纺成byte[]数组
     * 3.将加密内容解密
     */
    private static String decode(String content, Integer type){
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey originalKey = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = originalKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byteContent;
            if(Objects.equals(type, 0)){
                byteContent = Base64.getDecoder().decode(content);
            }else{
                byteContent = Base64.getUrlDecoder().decode(content);
            }
            //byte[] byte_content = new BASE64Decoder().decodeBuffer(content);
            /*
             * 解密
             */
            byte[] byteDecode = cipher.doFinal(byteContent);
            return new String(byteDecode, "utf-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        //如果有错就返加nulll
        return null;
    }


    public static void main(String[] args) {
        /*String[] keys = {
                "", "root", "Lingju36ocOm"
        };
        System.out.println("key | AESEncode | AESDecode");
        for (String key : keys) {
            System.out.print(key + " | ");
            String encryptString = AESEncode(key);
            System.out.print(encryptString + " | ");
            String decryptString = AESDecode(encryptString);
            System.out.println(decryptString);
        }*/
        /*Map<String, String> shopMap = new HashMap<>();
        shopMap.put("shopId", "6");
        shopMap.put("deskId", "661");*/
        System.out.println(AESEncode("123456"));
        System.out.println(AESDecode("16iFXHBTukmDX0Z+9CCQvg=="));
    }

}
