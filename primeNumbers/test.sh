echo rwh_primes
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.rwh_primes(1000000)"

echo rwh_primes1
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.rwh_primes1(1000000)"

echo rwh_primes2
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.rwh_primes2(1000000)"

echo sieve_wheel_30
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.sieve_wheel_30(1000000)"

echo sieveOfEratosthenes
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.sieveOfEratosthenes(1000000)"

echo sieveOfAtkin
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.sieveOfAtkin(1000000)"

echo ambi_sieve_plain
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.ambi_sieve_plain(1000000)"

echo sundaram3
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.sundaram3(1000000)"

echo NUMPY! ENTER THE BATTLE!
echo ambi_sieve
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.ambi_sieve(1000000)"

echo primesfrom3to
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.primesfrom3to(1000000)"

echo primesfrom2to
python -m timeit -s "import testBestPrimeNumberAlgorithms" "testBestPrimeNumberAlgorithms.primesfrom2to(1000000)"
