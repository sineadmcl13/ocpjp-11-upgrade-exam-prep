### Use local-variable type inference

####  Legal type inference usage 

- In a static/instance initialization block:
```java
class Example {
  static {
    var s = "Hello, there";
  }
  
  {
    var t = " Hello again";
  }
}
```

- As a local variable in a method:
```java
public static void main(String[] args) {
  var s = "Another hello";
}
```

- As iteration variable in enhanced for-loop:
```java
List<String> l = List.of("saying", "hello", "once", "more");
for(var s : l) {
  System.out.println(s + " ");
}
```

- As looping index in for-loop:
```java
for (var i = 0; i < 10; i++){
  System.out.println(i);
}
```

- As a value from another method:
```java
public static void main(String[] args){
  var x = getId();
}
static int getId(){
  return 10;
}
```

- As a return value in a method:
```java
public static void main(String[] args){
  int x = getId();
}
static int getId() {
  var x = 10;
  return x;
}
```

- As resource variable in the try-with-resource block:
```java
public void printFile() throws IOEXception {
  try (var input = new FileInputStream("index.txt")) {
  }
}
```

[Code Samples of Legal Var Usage](/examples/local_variable_type_inference/src/LegalTypeInferenceExamples.java)

#### Illegal type inference usage

- Not permitted as class field
```java
public class BadExample {
  static var = 0;
}
```

- Not permitted as instance variable:
```java
public class BadExample {
  var i = 0;  
}
```

- Not allowed as local variable without initialization:
```java
public static void main(String[] args){
  var x;
}
```

- Not allowed as parameter for method:
```java
public void printMessage(var msg){
  System.out.println(msg);
}
```

- Not allowed as method return type in method signature:
```java
public var badMethodSignatureExample(){
  return 10;
}
```

- Not allowed with explicit initialization to null:
```java
public staic void main(String[] args){
  var x = null;
}
```
> It can be initialized to null with an explicit cast
>```java
> public static void main(String[] args){
>  var x = (Integer) null; 
>}
>```

- Not allowed to reassign to a different(incompatible type):
```java
public static void main(String[] args){
  var x = 0;
  x = "Java"
}
```

- Not allowed in compound declaration, i.e when we declare multiple local variables, even with initialization:
```java
public static void main(String[] args){
  var x, y = 0;
}
```

- Not allowed as lambda expression type (still needs an explicit target type):
```java
public static void main(String[] args){
  var p = (String[] s) -> s.length > 0;
}
```

- Not allowed with array initializer (an array initializer still needs a target type):
```java
public static void main(String[] args){
  var array = {1, 2, 3};
}
```

- Not allowed with method reference (still needs an explicit target type):
```java
public static void main(String[] args){
  var lowerCaseOp = String::toLowerCase;
}
```

[Code Samples of Illegal Var Usage](/examples/local_variable_type_inference/src/LegalTypeInferenceExamples.java)
