/***********************************************************************
 * Module:  Projection.java
 * Author:  p1704709
 * Purpose: Defines the Class Projection
 ***********************************************************************/

package metier;

import java.util.Date;


/** @pdOid 752be3ed-4ed0-4147-b144-75fd0da15637 */
public class Projection {
   /** @pdOid 119df5c3-9f75-4ae0-9b89-982c98f645e6 */
   private Date dateProjection;
   /** @pdOid 9dbfdfaf-0be5-4740-aa8c-eaac7cf4b614 */
   private int heureProjection;
   /** @pdOid 388f8dbd-76ea-4f0b-a623-8dccbef19df0 */
   private java.lang.Boolean officielle;
   /** @pdOid 05db7606-951f-448f-b61b-d71d9a6a5cda */
   private int projectionID;
   
   /** @pdRoleInfo migr=no name=Salle assc=association3 mult=1..1 */
   private Salle salle;
   /** @pdRoleInfo migr=no name=Film assc=association1 mult=1..1 side=A */
   private Film film;
   
   /** @pdOid 6378f3be-2fc2-4f21-867a-33af25da9c5b */
   public Date getDateProjection() {
      return dateProjection;
   }
   
   /** @param newDateProjection
    * @pdOid 46b157f4-806c-4c90-87a6-5af9bccf54bb */
   public void setDateProjection(Date newDateProjection) {
      dateProjection = newDateProjection;
   }
   
   /** @pdOid 1b5a7399-062f-4bfc-968b-eef46c23fa6f */
   public int getHeureProjection() {
      return heureProjection;
   }
   
   /** @param newHeureProjection
    * @pdOid a060f1ef-82a9-4e7a-b0bb-73703a8fdadb */
   public void setHeureProjection(int newHeureProjection) {
      heureProjection = newHeureProjection;
   }
   
   /** @pdOid 6819004d-157f-47dc-a2db-f753d9d060a8 */
   public java.lang.Boolean getOfficielle() {
      return officielle;
   }
   
   /** @param newOfficielle
    * @pdOid 8b42c49c-c553-4248-8aee-0092299a335b */
   public void setOfficielle(java.lang.Boolean newOfficielle) {
      officielle = newOfficielle;
   }
   
   /** @pdOid 11da8143-e6a4-403c-b6bb-524486678aa9 */
   public int getProjectionID() {
      return projectionID;
   }
   
   /** @param newProjectionID
    * @pdOid a2a8af12-d708-4fde-98dd-8bde42ed8699 */
   public void setProjectionID(int newProjectionID) {
      projectionID = newProjectionID;
   }

}