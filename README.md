# problem_501

## Eight Divisors

The eight divisors of 24 are 1, 2, 3, 4, 6, 8, 12 and 24.

The ten numbers not exceeding 100 having exactly eight divisors are 24, 30, 40, 42, 54, 56, 66, 70, 78 and 88.

Let f(n) be the count of numbers not exceeding n with exactly eight divisors.

You are given f(100) = 10, f(1000) = 180 and f(10^6) = 224427.

Find f(10^12).


https://projecteuler.net/problem=501

## Usage

Build a runnable jar

```bash
cd problem_501
gradle jar
```

Run jar, providing the 'n' variable and an optional algorithm

```bash
java -jar problem_501.jar N [ALGORITHM]
```

### Algorithms

`brute` Brute force method, with a few rules of thumb to save cycles.

`factor` Using factors to calculate the number of divisors.

`sqrt_brute` Similar to the brute force method, but using the square root of the number.

`sqrt_factor` (Default) Similar to the factor method, but using the square root of the number.


## References

http://mathschallenge.net/library/number/number_of_divisors

http://www.wikihow.com/Determine-the-Number-of-Divisors-of-an-Integer

## License

MIT
