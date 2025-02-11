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

#include "mzhash192.h"

void mzhash192(const char* data, size_t length, uint64_t* output)
{
	uint64_t hash1;
	uint64_t hash2 = 0x7F573AFD9B2368FDL;
	uint64_t hash3 = 0xEBCDBA32A30D97ACL;
		
	for(size_t i = 0; i < length; i++) {
		uint64_t x = i + data[i];
		hash1 = 0x91C1BACD9E6787F3L * x ^ (hash3 << 2) ^ (hash3 >> 2);
		hash2 = 0x447239684A147E94L * x ^ (hash2 << 2) ^ (hash2 >> 2);
		hash3 = 0xFAADD3787DABBC1EL * x ^ (hash1 << 2) ^ (hash1 >> 2);
	}
	output[0] = hash1;
	output[1] = hash2;
	output[2] = hash3;
}
