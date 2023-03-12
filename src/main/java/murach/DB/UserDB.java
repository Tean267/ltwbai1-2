package murach.DB;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import murach.business.User;

public class UserDB {

	public static void insert(User user, String relativePathToFile) {
		File f = new File(relativePathToFile);
		try {
			// Để khi ghi đối tượng vào file mà không thay thế dữ liệu cũ, chúng ta cần sử
			// dụng lớp FileOutputStream
			// với tham số thứ hai là true để bật chế độ ghi chồng (append mode).
			FileOutputStream fileOut = new FileOutputStream(
					"C:\\Users\\Tean\\eclipse-workspace\\LapTrinhWebProject\\src\\main\\webapp\\WEB-INF\\emailList.txt",
					true);
//				ObjectOutputStream out = new AppendableObjectOutputStream(fileOut);
			if (f.length() == 0) {
				ObjectOutputStream oos = new ObjectOutputStream(fileOut);
				oos.writeObject(user);
				oos.close();
			} else {
				AppendableObjectOutputStream out1 = new AppendableObjectOutputStream(fileOut);
				out1.writeObject(user);
				out1.close();
			}
			fileOut.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean emailExisted(String email, String relativePathToFile) throws IOException {
		File f = new File(relativePathToFile);
		if (f.length() != 0) {

			FileInputStream fis = new FileInputStream(
					"C:\\Users\\Tean\\eclipse-workspace\\LapTrinhWebProject\\src\\main\\webapp\\WEB-INF\\emailList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			User obj = null;
			try {
				while ((obj = (User) ois.readObject()) != null) {
					if (email.equals(obj.getEmail())) {
						return true;
					}
				}
			} catch (EOFException e) {
				// do nothing, end of file reached
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}