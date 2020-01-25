### Develop the code that use parallel streams

Streams can be sequential or parallel.
#### Sequential example
```java
List<Integer> nums = List.of(1, 2, 3, 4);
nums.stream().forEach(System.out::print);
//1234
```

#### Parallel example
```java
List<Integer> nums = List.of(1, 2, 3, 4);
numes.stream.parallelStream().forEach(System.out::print);
```

When stream operations run in parallel, the intent is that the same result is returned as if they had run serially. 
It is important that the operation are stateless and can be executed in an arbitrary order. 

Here is an example of something you should not do
```java
int[] shortWords = new int[12]; 
words.parallelStream().forEach(
s -> { if (s.length() < 12) 
  shortWords[s.length()]++; 
}); // Error—race condition!
System.out.println(Arrays.toString(shortWords));
```

The function passed to the `forEach()` runs concurrently in multiple threads, each updating a shared array. If you run 
this program multiple times, you will a different sequence of counts in each run