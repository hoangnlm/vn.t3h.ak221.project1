package utilPkg;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import mainPkg.HocVien;

public class IOUtils2 {
	private static String filePath = "/Users/Hoang/Documents/Eclipse/workspace/vn.t3h.ak221.project1/src/data/hocvien.dat";

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		IOUtils2.filePath = filePath;
	}

	// Write from ObjectStream to file
	public static void writeObjectStream(LinkedList<HocVien> hocViens) throws Exception {
		ObjectOutputStream objectOutputStream = null;

		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

			for (HocVien hv : hocViens) {
				objectOutputStream.writeObject(hv);
			}
		} finally {
			if (objectOutputStream != null)
				objectOutputStream.close();
		}
	}

	// Read from ObjectStream to a list variable
	public static LinkedList<HocVien> readObjectStream() throws Exception {
		LinkedList<HocVien> hocViens = new LinkedList<>();
		ObjectInputStream objectInputStream = null;

		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

			try {
				while (true) {
					hocViens.add((HocVien) objectInputStream.readObject());
				}
			} catch (EOFException e) {
				// Khong can lam gi het
			}
		} finally {
			if (objectInputStream != null)
				objectInputStream.close();
		}

		return hocViens;
	}
}
