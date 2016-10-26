/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;

/**
 *
 * @author Jorge
 */
import java.io.*;
import java.util.*;
import javax.comm.*;

class evProp implements CommPortOwnershipListener
{

   public void ownershipChange(int tipo)
   {
      System.out.print("Valor: " + tipo);
      if (tipo == CommPortOwnershipListener.PORT_OWNED)
         System.out.println(" Se abre el puerto");
      else if (tipo == CommPortOwnershipListener.PORT_UNOWNED)
         System.out.println(" Se cierra el puerto");
      else if (tipo == CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED)
         System.out.println(" Requerido puerto usado");
   }
}
