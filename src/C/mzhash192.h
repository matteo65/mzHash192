#ifndef _MZHASH192_H
#define _MZHASH192_H

#include <stddef.h> // size_t
#include <stdint.h> // uint64_t

#ifdef __cplusplus
extern "C" {
#endif

void mzhash192(const void* data, size_t length, uint64_t* output);
void mzhash192_str(const char* str, uint64_t* output);

#ifdef __cplusplus
}
#endif

#endif
