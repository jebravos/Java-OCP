package com.bravo.ocp.AdvanceClassDesign;

import java.io.IOException;
import java.sql.SQLException;

public class Overriding3  implements AA, BB{

  // When interfaces are involved, more than one method declaration may be implemented by a single method declaration.
  // In this case, the overriding declaration must have a throws declaration that is compatible with all overridden declarations
  @Override
  public void m1(){
    //... lots of code ...

  }

  // Different declarations of a method with different return types cannot be managed in the same way

}

interface AA{
   void m1() throws IOException;

}

interface BB{
  void m1() throws SQLException;

}



