Eucledian algorithm:
* If a>b :  gcd(a, b) = gcd(b, a-b);
* gcd(a,b)  = gcd (b, a%b);

* GCD (x, 0) = x
* GCD (x, 1) = 1
* GCD (-x, -y) = GCD (x, y) ; for all x,y positive and negative
* GCD (0,0) = undefined
* * Associative:  
gcd(a, b, c)  = gcd(gcd (a,b) , c) .. associative
* * Commutiative:
gcd(a, b) = gcd (b,a)
    
* * => gcd(a,b,c) = gcd(gcd(a,c), b) = gcd(gcd(a,b), c)
