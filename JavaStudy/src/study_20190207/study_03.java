package study_20190207;

import java.io.*;

public class study_03 {
	static class C implements Serializable {
			 private int i;
			 C(int i) { this.i = i; 
		 }
			 
		 public String toString() { return "C(" + i + ")"; }
	}
	static byte[] write() throws IOException {
		
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 
		 try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			 oos.writeInt(100);
			 oos.writeObject(new C(10));
		 }
			 
		 return bos.toByteArray();
	}
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		 byte[] data = write();
		 
		 ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
		 
		 int i = ois.readInt();
		 
		 C c = (C) ois.readObject();
		 
		 System.out.println(i + ", " + c);
	} 
}
    