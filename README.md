# mzHash192: A Fast and Efficient Non-Cryptographic Hash Function
We are excited to present mzHash192, the latest addition to the mzHash family of non-cryptographic hash functions. Building upon the success of its predecessors, mzHash32 and mzHash64, mzHash128, mzHash192 extends the family with a 192-bit output while maintaining the same principles of simplicity, speed, and high performance in minimizing collisions.

```C
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
```
## Key Features of mzHash192
**192-Bit Output** : mzHash192 provides a larger hash space compared to other mzHash* family, making it suitable for applications requiring higher entropy or reduced collision probabilities.  
**Simplicity** : Like its counterparts, mzHash192 employs a straightforward algorithm that is easy to implement and understand, ensuring minimal overhead and maximum efficiency.  
**Speed** : Designed for optimal performance, mzHash192 processes input data quickly, making it ideal for real-time or high-throughput applications where computational resources are limited.  
**Low Collision Rate** : mzHash192 demonstrates excellent distribution properties, closely approximating the behavior of a theoretical Universal Hash Function. This ensures a near-random distribution of hash values, reducing the likelihood of collisions even for large datasets.  

## Hash Value Distribution Analysis
For hashing functions with length greater than or equal to 128 bits, it is very difficult, if not impossible, to count collisions, therefore, in order to verify the quality of the result, statistical analysis on hashing samples is used. A quality hashing function must produce an output with a uniform distribution and indistinguishable from a random sequence of bytes.

In this case, the hash values ​​for all strings between the number **"zero"** and the number **"nine hundred ninety-nine thousand nine hundred ninety-nine"** were concatenated for a total of 1,000,000 hashes. VisualRT was used to analyze the output and the result passed all randomness tests, confirming the quality of the mzHash family algorithm.

![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash192/main/Resource/mzhash192output.png)

**Length** = 24000000   
**Average byte frequency μ**= 93750.0   
**Minimum byte frequency** = 93017   
**Maximum byte frequency** = 94438   
**Variance σ<sup>2</sup>** = 86445.195   
**Standard Deviation σ** = 294.016   
**Coefficient of Variation <sup>σ</sup>/<sub>μ</sub>** = 0.314%   
**Chi-Square Test 𝛘<sup>2</sup>** = 236.053   
**Average bytes value** = 127.501 (127.5 random)   
**Entropy** = 7.999993 bits (8 random)  
**Monte Carlo for π 2D** = 3.141132 (error = 0.015%)  
**Monte Carlo for π 3D** = 3.139822 (error = 0.056%)  
**Average of Contiguous Byte Pairs** = 32767.835 (32767.5 random) (error 0.001%)  
**4 Bytes Collisions** = 4174 (expected collisions = 4189.0)  


## Applications
mzHash192 is well-suited for a variety of non-cryptographic use cases, including:

- Data indexing and lookup in hash tables
- Caching mechanisms
- Consistent hashing for distributed systems
- Data deduplication
- Fast checksums for integrity verification

## Place in the mzHash Family
The mzHash family consists of three members:

**mzHash32** : A 32-bit hash function optimized for lightweight applications.   
**mzHash64** : A 64-bit hash function offering a balance between speed and collision resistance.   
**mzHash128** : A 128-bit hash function, providing a robust 128-bit output for demanding applications.   
**mzHash192** : A 192-bit hash function, guarantees greater safety and quality than functions with smaller output.  

Each function in the mzHash family adheres to the same design philosophy: simplicity, speed, and effectiveness. This consistency makes it easy for developers to choose the appropriate variant based on their specific requirements without compromising on quality.   

## Why Choose mzHash192?
For developers seeking a reliable, efficient, and easy-to-implement hash function, mzHash192 offers an attractive solution. Its combination of a large output size, low collision rate, and fast execution time makes it a strong contender in the realm of non-cryptographic hashing.

We invite you to explore mzHash192 and experience its capabilities firsthand. Whether you're building high-performance software or optimizing existing systems, mzHash192 is designed to meet your needs with elegance and efficiency.
