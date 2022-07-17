package NikandrovLab5.utility;

import java.nio.ByteBuffer;

public class ByteBufferToString {
    public static String run(ByteBuffer byteBuffer){
        int limit = byteBuffer.limit();
        byte[] bytes = new byte[limit];
        byteBuffer.get(bytes, 0, limit);
        return new String(bytes);
    }
}
