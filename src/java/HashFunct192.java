/**
 * mzHash192
 * 
 * Strong, fast, simple, non-cryptographic 192-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2025
 * Licence: Public Domain
 * 
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 * 
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * 
 * For more information, please refer to <https://unlicense.org>
 * 
 */
public class HashFunct192 {
	
	public static class ThreeLongs {
		public long val1;
		public long val2;
		public long val3;
	}
	
	public static void mzHash192(byte[] data, int start, int length, ThreeLongs out) {
		long hash1 = 0;
		long hash2 = 0x7F573AFD9B2368FDL;
		long hash3 = 0xEBCDBA32A30D97ACL;
		
		for(int i = 0; i < length; i++) {
			long x = i + data[start + i];
			hash1 = 0x91C1BACD9E6787F3L * x ^ (hash3 << 2) ^ (hash3 >>> 2);
			hash2 = 0x447239684A147E94L * x ^ (hash2 << 2) ^ (hash2 >>> 2);
			hash3 = 0xFAADD3787DABBC1EL * x ^ (hash1 << 2) ^ (hash1 >>> 2);
		}
		out.val1 = hash1;
		out.val2 = hash2;
		out.val3 = hash3;
	}
	
	public static void mzHash192(byte[] data, int start, int length, long[] out) {
		long hash1 = 0;
		long hash2 = 0x7F573AFD9B2368FDL;
		long hash3 = 0xEBCDBA32A30D97ACL;
		
		for(int i = 0; i < length; i++) {
			long x = i + data[start + i];
			hash1 = 0x91C1BACD9E6787F3L * x ^ (hash3 << 2) ^ (hash3 >>> 2);
			hash2 = 0x447239684A147E94L * x ^ (hash2 << 2) ^ (hash2 >>> 2);
			hash3 = 0xFAADD3787DABBC1EL * x ^ (hash1 << 2) ^ (hash1 >>> 2);
		}
		out[0] = hash1;
		out[1] = hash2;
		out[2] = hash3;
	}

	public static long[] mzHash192(byte[] data, int start, int length) {
		long[] out = new long[3];
		mzHash192(data, start, length, out);
		return out;
	}
	
	public static void mzHash192(byte[] data, ThreeLongs out) {
		mzHash192(data, 0, data.length, out);
	}
	
	public static void mzHash192(byte[] data, long[] out) {
		mzHash192(data, 0, data.length, out);
	}
	
	public static long[] mzHash192(byte[] data) {
		long[] out = new long[3];
		mzHash192(data, 0, data.length, out);
		return out;
	}

}
