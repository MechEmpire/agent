import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * package: PACKAGE_NAME
 *
 * @author <tairy> tairyguo@gmail.com
 * @date 2020/12/14 下午3:17
 */
@Slf4j
public class AgentMainTest {

    public static void main(String[] args) {
//        AgentMain agentMain = new AgentMain();
//        agentMain.run();

//        System.out.println(Integer.toHexString(10));
//        System.out.println(Integer.toBinaryString(10));
//        System.out.println(Integer.highestOneBit(10));
//        System.out.println(Long.toHexString(4621819117588971520L));
//        byte[] intResult = ByteBuffer.allocate(4).putInt(10).array();
//        System.out.println(Arrays.toString(intResult));
//        byte[] result = ByteBuffer.allocate(8).putDouble(20.0).array();
//        System.out.println(Arrays.toString(result));
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int targetX = random.nextInt(1280);
            int targetY = random.nextInt(1280);
            log.info("target_x: {}, target_y: {}", targetX, targetY);
        }
    }

    public static byte[] double2Bytes(double d) {
        long value = Double.doubleToRawLongBits(d);
        byte[] byteRet = new byte[8];
        for (int i = 0; i < 8; i++) {
            byteRet[7 - i] = (byte) ((value >> 8 * i) & 0xff);
        }
        return byteRet;
    }

    public static double bytes2Double(byte[] arr) {
        long value = 0;
        for (int i = 0; i < 8; i++) {
            value |= ((long) (arr[7 - i] & 0xff)) << (8 * i);
        }
        return Double.longBitsToDouble(value);
    }
}