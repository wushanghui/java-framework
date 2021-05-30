package top.wushanghui.encrypt;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author wsh
 * @date 2021/3/24 9:50
 */
public class AESDemo {

    /**
     * 算法
     */
    private final static String ALGORITHM_AES = "AES";

    public static void main(String[] args) throws Exception {
        String keys = "1";
        String content = "美国没有资格居高临下同中国说话，中国人不吃这一套。";
        System.out.println("内容：" + content);
        // 先测试加密，然后在测试解密
        String encrypt = encryptAES(content, keys);
        System.out.println("加密: " + encrypt);
        String decrypt = decryptAES(encrypt, keys);
        System.out.println("解密: " + decrypt);
    }

    private static byte[] getSecretKeyBytes(String keys) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_AES);
        keyGenerator.init(128, new SecureRandom(keys.getBytes(StandardCharsets.UTF_8)));
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("密钥："+ Base64.encode(secretKey.getEncoded()));
        return secretKey.getEncoded();
    }

    private static String encryptAES(String plaintext, String keys) throws Exception {
        // 获取加密对象
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        // 创建加密规则
        // 第一个参数key的字节
        // 第二个参数表示加密算法
        SecretKeySpec sks = new SecretKeySpec(getSecretKeyBytes(keys), ALGORITHM_AES);
        // ENCRYPT_MODE：加密模式
        // DECRYPT_MODE: 解密模式
        // 初始化加密模式和算法
        cipher.init(Cipher.ENCRYPT_MODE, sks);
        // 加密
        byte[] bytes = cipher.doFinal(plaintext.getBytes());
        // 输出加密后的数据
        return Base64.encode(bytes);
    }

    private static String decryptAES(String ciphertext, String keys) throws Exception {
        // 1,获取Cipher对象
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES);
        // 指定密钥规则
        SecretKeySpec sks = new SecretKeySpec(getSecretKeyBytes(keys), ALGORITHM_AES);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        // 3. 解密
        byte[] bytes = cipher.doFinal(Base64.decode(ciphertext));
        return new String(bytes);
    }
}
