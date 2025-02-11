# mzHash192: A Fast and Efficient Non-Cryptographic Hash Function
We are excited to present mzHash192 , the latest addition to the mzHash family of non-cryptographic hash functions. Building upon the success of its predecessors, mzHash32 and mzHash64, mzHash128, mzHash192 extends the family with a 192-bit output while maintaining the same principles of simplicity, speed, and high performance in minimizing collisions.

```java
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
```
## Key Features of mzHash192
**192-Bit Output** : mzHash192 provides a larger hash space compared to other mzHash* family, making it suitable for applications requiring higher entropy or reduced collision probabilities.  
**Simplicity** : Like its counterparts, mzHash192 employs a straightforward algorithm that is easy to implement and understand, ensuring minimal overhead and maximum efficiency.  
**Speed** : Designed for optimal performance, mzHash192 processes input data quickly, making it ideal for real-time or high-throughput applications where computational resources are limited.  
**Low Collision Rate** : mzHash192 demonstrates excellent distribution properties, closely approximating the behavior of a theoretical Universal Hash Function. This ensures a near-random distribution of hash values, reducing the likelihood of collisions even for large datasets.  

## Hash Value Distribution Analysis
For hashing functions with length greater than or equal to 128 bits, it is very difficult, if not impossible, to count collisions, therefore, in order to verify the quality of the result, statistical analysis on hashing samples is used. A quality hashing function must produce an output with a uniform distribution and indistinguishable from a random sequence of bytes.

In this case, the hash values ​​for all strings between the number **"zero"** and the number **"nine million nine hundred ninety-nine thousand nine hundred ninety-nine"** were concatenated for a total of 10,000,000 hashes. VisualRT was used to analyze the output and the result passed all randomness tests, confirming the quality of the mzHash family algorithm.

![Alt Text](https://raw.githubusercontent.com/matteo65/mzHash192/main/Resource/mzhash192output.png)

**Length** = 32000000   
**Average byte frequency μ**= 125000.0   
**Minimum byte frequency** = 124032   
**Maximum byte frequency** = 125905   
**Variance σ<sup>2</sup>** = 113148.4921875   
**Standard Deviation σ** = 336.3755225748449   
**Coefficient of Variation <sup>σ</sup>/<sub>μ</sub>** = 0.26910041805987595   
**Chi-Square Test 𝛘<sup>2</sup>** = 231.72811199999995   
**Average bytes value = 127.48867140625 (127.5 random)   
**Entropy** = 7.999994776507291 bits (8 random)  
**Estimated Compressed Length** = 32000000  
**Monte Carlo for Pi 2D** = 3.1423254463953403 (error = 0.023325519453001927%)  
**Monte Carlo for Pi 3D** = 3.142381990997186 (error = 0.025125390030782416%)  
**Average of Contiguous Byte Pairs** = 32764.588664112147 (32767.5 random) (error 0.00888482761227758%)  
**4 Bytes Collisions** = 7413 (expected collisions = 7445.955891609192)  


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
