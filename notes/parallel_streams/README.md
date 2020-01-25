### Parallel Streams

Streams can be parallel or sequential. Operations on a sequential stream are processed in serial using one thread. 
Operations on a parallel stream, are processed in parallel using multiple streams. There are no additional steps 
required to process streams in parallel. This handled by the Streams API when you call the appropriate method

To produce a parallel stream you need to call the `parallelStream()` method of the `Collection` interface

```java
default Stream<E> parallelStream() {
}
```

