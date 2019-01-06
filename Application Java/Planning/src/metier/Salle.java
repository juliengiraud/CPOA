package metier;

/***********************************************************************
 * Module:  Salle.java
 * Author:  p1704709
 * Purpose: Defines the Class Salle
 ***********************************************************************/




/** @pdOid 4e8955b9-ab8d-4243-84f7-9e410c5ace7b */
public class Salle {
   /** @pdOid 401ccfcb-8042-4bf3-a5db-ab6495d5a290 */
   private int salleID;
   /** @pdOid 987342a7-5be0-4e15-b03a-d8c4ee503249 */
   private int capacite;
   
   /** @pdOid 2e5626a8-cd9b-4bbb-baa7-e2410bd93ddd */
   public int getSalleID() {
      return salleID;
   }
   
   /** @param newSalleID
    * @pdOid 854c3308-f953-458c-9176-91d03a45d0f5 */
   public void setSalleID(int newSalleID) {
      salleID = newSalleID;
   }
   
   /** @pdOid a2726c12-e7c9-43a6-a724-063a0aac2d2f */
   public int getCapacite() {
      return capacite;
   }
   
   /** @param newCapacite
    * @pdOid aa228d44-1373-47c3-baa8-75c5b31a3856 */
   public void setCapacite(int newCapacite) {
      capacite = newCapacite;
   }

}