package com.vineyardsOfApan;

/*
This is the Wine class to uniquely identify the wines
 */
public class Wine {
      String nameOfWine = null;
      private Wine(){

      }

      public Wine(String nameOfWine){
          this.nameOfWine=nameOfWine;
      }

      @Override
      public int hashCode() {
            return nameOfWine.hashCode();
      }

      @Override
      public String toString() {
            return "Wine : "+nameOfWine;
      }

      @Override
      public boolean equals(Object obj) {
            return this.hashCode()==obj.hashCode();
      }
}
