/**
 * mzhash192
 * 
 * Strong, fast, simple, non-cryptographic 192-bit hash function
 * 
 * Author: Matteo Zapparoli
 * Date: 2026-01
 * Reelease: 2
 *
 * SPDX-FileCopyrightText: 2026 Matteo Zapparoli <zapparoli.matteo@gmail.com>
 * SPDX-License-Identifier: Apache-2.0
 * See LICENSE file in project root.
 * 
 */

public class HashFunct192 {
	
	public static class ThreeLongs {
		public long val0;
		public long val1;
		public long val2;
	}
	
	private HashFunct192() {}
	
	public static void mzHash192(byte[] data, int start, int length, ThreeLongs out) {
		long hash0 = 0xB04C2438F4F7D8D1L;
		long hash1 = 0xA3B8FD0DF0836C0DL;
		long hash2 = 0x9E9BDFDAEFC3A606L;
		
		for(int i = 0; i < length; i++) {
            byte b = data[start + i];
            long h0 = 0xD76F648260B0F9FDL * (b ^ (hash0 << 8) ^ (hash0 >>> 8));
            long h1 = 0xD1DA2131A0C25299L * (b ^ (hash1 << 8) ^ (hash1 >>> 8));
            hash0 = 0x188EF276E8755C0FL * (b ^ (hash2 << 8) ^ (hash2 >>> 8));
            hash1 = h0;
            hash2 = h1;
		}
		out.val0 = hash0;
		out.val1 = hash1;
		out.val2 = hash2;
	}
	
	public static void mzHash192(byte[] data, int start, int length, long[] out) {
        long hash0 = 0xB04C2438F4F7D8D1L;
        long hash1 = 0xA3B8FD0DF0836C0DL;
        long hash2 = 0x9E9BDFDAEFC3A606L;
        
        for(int i = 0; i < length; i++) {
            byte b = data[start + i];
            long h0 = 0xD76F648260B0F9FDL * (b ^ (hash0 << 8) ^ (hash0 >>> 8));
            long h1 = 0xD1DA2131A0C25299L * (b ^ (hash1 << 8) ^ (hash1 >>> 8));
            hash0 = 0x188EF276E8755C0FL * (b ^ (hash2 << 8) ^ (hash2 >>> 8));
            hash1 = h0;
            hash2 = h1;
        }
        out[0] = hash0;
        out[1] = hash1;
        out[2] = hash2;
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
