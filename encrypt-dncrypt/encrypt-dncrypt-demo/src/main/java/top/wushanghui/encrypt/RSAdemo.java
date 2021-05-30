package top.wushanghui.encrypt;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wsh
 * @date 2021/3/24 13:50
 */
public class RSAdemo {

    // 加密算法
    private final static String ALGORITHM = "RSA";

    public static void main(String[] args) throws Exception {
        String content = "美国没有资格居高临下同中国说话，中国人不吃这一套。";

        Map<String, String> keyPair = getKeyPair();

        String privateKeyString = keyPair.get("privateKeyString");
        String publicKeyString = keyPair.get("publicKeyString");
        System.out.println("内容：" + content);


    }


    /**
     * 公钥加密
     * @param content 明文
     * @return 密文
     */
    public static String publicKeyEncrypt(String content, String publicKeyString) throws Exception {
        // 创建加密对象
        // 参数表示加密算法
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 初始化加密
        // 第一个参数:加密的模式
        // 第二个参数：使用私钥进行加密
        cipher.init(Cipher.ENCRYPT_MODE, str2PublicKey(publicKeyString));
        // 私钥加密
        byte[] bytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        String encryptStr = Base64.encode(bytes);
        System.out.println("encryptStr: " + encryptStr);
        return encryptStr;
    }

    /**
     * 私钥解密
     * @param content 密文
     * @param privateKeyString 私钥
     * @return 明文
     * @throws Exception
     */
    public static String privateKeyDecrypt(String content, String privateKeyString) throws Exception {
        // 创建加密对象
        // 参数表示加密算法
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        // 私钥进行解密
        cipher.init(Cipher.DECRYPT_MODE, str2PrivateKey(privateKeyString));
        // 对密文进行解密，不需要使用base64，因为原文不会乱码
        return new String(cipher.doFinal(Base64.decode(content.getBytes(StandardCharsets.UTF_8))));
    }

    private static PublicKey str2PublicKey(String publicKeyStr) throws Exception {
        byte[] bytes = Base64.decode(publicKeyStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePublic(keySpec);
    }

    private static PrivateKey str2PrivateKey(String privateKey) throws Exception {
        byte[] bytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
        return keyFactory.generatePrivate(keySpec);
    }

    private static Map<String, String> getKeyPair() throws NoSuchAlgorithmException {
        //  创建密钥对生成器对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 生成私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 生成公钥
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        // 对公私钥进行base64编码
        String privateKeyString = Base64.encode(privateKeyEncoded);
        String publicKeyString = Base64.encode(publicKeyEncoded);
        // 打印私钥
        System.out.println("私钥: " + privateKeyString);
        // 打印公钥
        System.out.println("私钥: " + publicKeyString);
        HashMap<String, String> map = new HashMap<>(2);
        map.put("privateKeyString", privateKeyString);
        map.put("publicKeyString", publicKeyString);
        return map;
    }

}
