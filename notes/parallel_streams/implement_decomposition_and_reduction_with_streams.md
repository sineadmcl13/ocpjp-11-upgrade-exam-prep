### Implement decomposition and reduction with streams 

#### Reduction
The reduce method is a general mechanism for computing a value from a stream. The simplest form takes a binary 
function and keeps applying it, starting with the first two elements. 
```java
T reduce(T identity, BinaryOperator<T> accumulator);
```
It takes an initial value and an accumulator that is a `BinaryOperator` as arguments. The first time, the accumulator 
receives the initial value and the first element of the stream and arguments, and returns a value. The second time, the 
accumulator receives the value returns from its previous call and the second element from the stream. This continues 
until all elements of the stream have been passed to the accumulator

```java
List<Integer> nums = List.of(1, 2, 3, 4, 5);
Integer sum = numbers.stream().reduce(0, (n1, n2) -> n1 + n2);
System.out.println(sum);
```

#### Reduction Operations
A reduction operation takes a sequence of input elements and combines them into a single summary result, such as 
finding the sum or maximum of a set of numbers. The streams classes have multiple forms of general reduction operations 
called `reduce()` and `collect()` as well as multiple specialized reduction forms such as `sum()`, `max()`, or `count()`

A properly constructed reduce operation is inherently parallelizable so long as the function used to process the 
elements are associative and stateless

The example above can be rewritten as 
```java
Integer sum =  numbers.parallelStream().reduce(0, Integer::sum);
```

Reduction parallelizes well because the implementation can operate on subsets of the data in parallel, and then combine 
the intermediate results to get the final correct answer

In its more general form, a reduce operation on elements of type <T> yielding a result <U> requires 3 parameters
```java
<U> reduce(U identity,
          BiFunction<U, ? super T, U> accumulator,
          BinaryOperator<U> combiner);         
```

- The identity element is both an initial seed value for the reduction and a default result if there are no input elements
- The accumulator function takes a partial result and the next element, and produces a new partial set 
- THe combiner function combines 2 partial results to produce a new partial result. 

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
Integer sum = numbers.stream().reduce(0, 
    (res, i) -> res + i,                  // adds one element's value to partial result
    (part1, part2) -> part1 + part2);     // combine two partial results
System.out.print("Sum of all integers in the stream : " + sum);
```
