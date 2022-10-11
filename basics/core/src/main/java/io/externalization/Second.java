package io.externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Second extends First implements Externalizable {
   private String secondCode;
   private String secondName;

   public String getSecondCode() {
      return secondCode;
   }

   public void setSecondCode(String secondCode) {
      this.secondCode = secondCode;
   }

   public String getSecondName() {
      return secondName;
   }

   public void setSecondName(String secondName) {
      this.secondName = secondName;
   }

   @Override
   public void writeExternal(ObjectOutput out) throws IOException {
      out.writeUTF(super.getFirstCode()); // метод для записи строчек
      out.writeUTF(super.getFirstName());
      out.writeUTF(getSecondCode());
      out.writeUTF(getSecondName());
   }

   @Override
   public void readExternal(ObjectInput in) throws IOException {
      super.setFirstCode(in.readUTF());
      super.setFirstName(in.readUTF());
      setSecondCode(in.readUTF());
      setSecondName(in.readUTF());
   }
}
