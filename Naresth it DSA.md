## DSA With system design


### Session 5 - 7th Apr

#### Time complexity
- Big(O) notation we can judge independently how a program is actually performing
- Order of - Order of no of operations wrt to input
- Big(O) - be negative - always worst case scenario
- N is input and C is constant
    - O(N+C) = O(N)
    - O(N-C) = O(N)
    - O(N*C) = O(N)
    - O(N/C) = O(N)
    - O(N+N^2+N^3+N^4) = O(N^4)
    
## Questions

1. https://leetcode.com/problems/matrix-diagonal-sum/description/
2. https://leetcode.com/problems/maximum-number-of-pairs-in-array/description/
3. https://leetcode.com/problems/running-sum-of-1d-array/description/
4. https://leetcode.com/problems/squares-of-a-sorted-array/description/
5. https://leetcode.com/problems/left-and-right-sum-differences/description/
6. https://leetcode.com/problems/maximum-gap/description/                           -   Session 17
8. http://leetcode.com/problems/spiral-matrix-ii/description/                       -   Session 18   
9. http://leetcode.com/problems/spiral-matrix/description/                          -   Session 18   (HW)
10. http://leetcode.com/problems/spiral-matrix-iii/description/                     -   Session 18   (HW)
11. http://leetcode.com/problems/trapping-rain-water/                               -   Session 19
12. https://leetcode.com/problems/house-robber/description/                         -   Session 20   (HW)
13. https://leetcode.com/problems/single-number/description/                        -   Session 22        Bit Manipulation
14. https://docs.google.com/forms/d/e/1FAIpQLSfbjBqf4TxZD9E7ty8V6_h8o0ydjPt-taiQHC7nfXJ97iNj_w/viewform - Mock Test Array - Session 23
15. https://leetcode.com/problems/fizz-buzz/description/                            -   Session 23
16. https://leetcode.com/problems/maximum-subarray/description/                     -   Session 23
17. https://leetcode.com/problems/01-matrix/description/                            -   Session 23
18. https://leetcode.com/problems/next-permutation/description/                     -   Session 23
19. https://leetcode.com/problems/single-number-ii/description/                     -   Session 24
20. https://leetcode.com/problems/number-of-even-and-odd-bits/description/          -   Session 25   (HW)
21. https://leetcode.com/problems/counting-bits/description/                        -   Session 25   (HW)
22. https://leetcode.com/problems/binary-number-with-alternating-bits/description/  -   Session 25   (HW)
23. https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/         -   Session 25


### AND (&) operator
The bitwise AND operator compares two numbers bit by bit.

Rule:

        Bit A	Bit B	A & B
        0	0	    0
        0	1	    0
        1   	0	    0
        1	1	    1

The result is 1 only if both bits are 1.

### OR operator (|)
The OR operator follows these rules:

        Bit A	Bit B	A | B
        0	0	0
        0	1	1
        1	0	1
        1	1	1      

A bit becomes 1 if either bit is 1.

### NOT operator (~)

The NOT operator works on one bit (it is a unary operator).

        Bit A	   ~A
        0	    1
        1	    0

### XOR operator (^)
The XOR (Exclusive OR) operator follows these rules:

        Bit A	Bit B	A ^ B
        0	0	0
        0	1	1
        1	0	1
        1	1	0

A bit becomes 1 only if the two bits are different.

### Bitmasking
- Bitmasking is a technique of using binary numbers (bits) and bitwise operators (&, |, ^, ~, <<, >>) to manipulate individual bits of a number.
- Think of a number as a collection of ON/OFF switches.

### Quick Memory Tricks

        Operator	Meaning	        Think of it as
        &	        AND	        Check/Filter bits
        |	        OR	        Turn a bit ON
        ^	        XOR	        Flip (Toggle) a bit
        ~	        NOT	        Reverse every bit
        <<	        Left Shift	Move left (×2)
        >>	        Right Shift	Move right (÷2)

### One-line intuition

- Bitmasking → Manipulate individual bits.
- & → "Is this bit ON?"
- \| → "Turn this bit ON."
- ^ → "Change ON to OFF or OFF to ON."
- ~ → "Flip every bit."
- << → "Move bits left (multiply by 2 for positive numbers)."
- >> → "Move bits right (divide by 2 for positive numbers)."

