import java.util.function.BiFunction;
import java.util.function.UnaryOperator;


public class LambdaExpressionsWithVarExamples {

  public static void main(String[] args){

    UnaryOperator<String> unaryOperator = (var s) -> "This is legal usage of var in a lambda";

    UnaryOperator<String> lc = (@SuppressWarnings("") var s) -> s.toLowerCase(); //allowed to annotate the var

    //Not allowed to use var for some parameter and skip for others
    //BiFunction<String, String, String> lc = (var a, b) -> a + b;

    //Not allowed to mix var with explicit type:
    //BiFunction<String, String, String> lc = (var a, String b) -> a + b;

    //Not allowed to skip parentheses in single parameter lambda when using var
    //UnaryOperator<String> unOp = var s -> s.toLowerCase();
  }

}
