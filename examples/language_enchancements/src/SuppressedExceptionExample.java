public class SuppressedExceptionExample {

  public static class ClosableResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
      System.out.println("Closing ClosableResource");
      throw new Exception("Exception thrown closing ClosableResource");
    }
  }

  public static void main(String[] args) throws Exception {

    try(ClosableResource resource = new ClosableResource()){
      System.out.println("Calling from try-with-resources statement");
      throw new Exception("Exception from code within try-with-resources");
    }
  }

}
