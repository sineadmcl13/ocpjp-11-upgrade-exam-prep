import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class LegalTypeInferenceExamples {

  //static var = "Illegal usage of var";
  //var s = "Illegal usage of var";

  static {
    var s = "legal var usage in static block";
  }

  {
    var s = "Legal var usage in initialization block";
  }

  public static void main(String[] args){
    var localVariable = "legal var as a local variable in a method";
    System.out.println(localVariable);

    List<String> stringList = List.of("Legal", "var", "usage", "in", "enhanced", "for", "loop");
    for(var s : stringList){
      System.out.println(s + " ");
    }

    for(var i =0; i < 10; i++){
      System.out.println("Legal usage of var in loop: " + i);
    }

    var varReturnFromMethod = getVarFromMethod();

    try(var output = new FileInputStream("random.txt")){
      System.out.println("Legal use of var in try with resources");
    } catch (IOException fnf){
      System.out.println("File not found, but usage of var in try with resources still works");
    }

    // Illegal usage of var. Can't assign to null
    //var x = null;
    // Can assign to null if you cast to type that can be inferred
    var x = (Integer) null;



  }

  private static int getVarFromMethod(){
    var i = 10;
    return 10; //legal usage of return var from a method
  }

  private void illegalVarUsageExamples(){
    // It must be initialised
    //var x;

    // Not allowed in compound declaration
    //var x,y = "attempting multiple initialization with var";

    // Not allowed to assign lambda to var
    //var p = (String[] s) -> s.length > 0;

    // Not allowed with method reference
    //var lowerCaseOp = String::toLowerCase;

    // not allowed as array initializer
    //var array = {1, 2, 3};

    // Can't reassign to a different type
    var inferredAsInt = 1;
    // inferredAsInt = "try to assign to String";

    // Illegal usage of var. //Can't assign to null
    //var x = null;
  }

  //private static void illegalVarAsParameterMethod(var x){
    //Can't use var a method parameter type
  //}

  //private var illegalVarUsageAsMethodReturnType{
    //Cant use var as method return type in method signature
  //}

}
