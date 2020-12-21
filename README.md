# AreaUnderACurve
This java program will compute the area under a curve for any interval of the function f(x) = x^2 + x + 1 (other functions could also be implemented).

The program essentially uses a riemann sum to compute the area. The program starts with the area of a rectangle computed using the interval a to b.
The area of the rectange would have a height of f(b) and a width of b - a. Next the program replaces that rectangle with two rectangles from the intervals a to a+b/2
and a+b/2 to b. The sum of these rectangles is closer to the area under the curve.

The program repeats this process recursively on the largest rectangle in the set until the change in the area is miniscule. 

The program uses a Max-heap priority queue to keep track of the intervals.

Sample Input and Output:
'''
We have the function f(x) = x^2 + x + 1.
Please enter lower value a: 12
Please enter upper value b: 15

An approximation for the area under the curve f(x)
between a = 12.0 and b = 15.0 is 592.500961300582
'''
