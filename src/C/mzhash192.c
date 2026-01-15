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

#include "mzhash192.h"

void mzhash192(const void* data, size_t length, uint64_t* output)
{
	const int8_t *bytes = (const int8_t*)data;
	uint64_t hash0 = 0xB04C2438F4F7D8D1uLL;
	uint64_t hash1 = 0xA3B8FD0DF0836C0DuLL;
	uint64_t hash2 = 0x9E9BDFDAEFC3A606uLL;
        
	while(length--) {
		uint64_t h0 = 0xD76F648260B0F9FDuLL * (*bytes ^ (hash0 << 8) ^ (hash0 >> 8));
		uint64_t h1 = 0xD1DA2131A0C25299uLL * (*bytes ^ (hash1 << 8) ^ (hash1 >> 8));
		hash0 = 0x188EF276E8755C0FuLL * (*bytes++ ^ (hash2 << 8) ^ (hash2 >> 8));
		hash1 = h0;
		hash2 = h1;
	}
	
	output[0] = hash0;
	output[1] = hash1;
	output[2] = hash2;
}

void mzhash192_str(const char* str, uint64_t* output)
{
	uint64_t hash0 = 0xB04C2438F4F7D8D1uLL;
	uint64_t hash1 = 0xA3B8FD0DF0836C0DuLL;
	uint64_t hash2 = 0x9E9BDFDAEFC3A606uLL;
		
	while(*str) {
		uint64_t h0 = 0xD76F648260B0F9FDuLL * (*str ^ (hash0 << 8) ^ (hash0 >> 8));
		uint64_t h1 = 0xD1DA2131A0C25299uLL * (*str ^ (hash1 << 8) ^ (hash1 >> 8));
		hash0 = 0x188EF276E8755C0FuLL * (*str++ ^ (hash2 << 8) ^ (hash2 >> 8));
		hash1 = h0;
		hash2 = h1;
	}
	
	output[0] = hash0;
	output[1] = hash1;
	output[2] = hash2;
}
