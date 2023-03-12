package murach.DB;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

//Lớp này kế thừa lớp ObjectOutputStream và ghi đè phương thức
//writeStreamHeader() và writeClassDescriptor(), để đảm bảo rằng nó
//không ghi bất kỳ thông tin nào về tiêu đề hoặc mô tả lớp khi ghi 
//đối tượng vào file nhị phân. Thay vào đó, nó chỉ ghi tên của lớp.
public class AppendableObjectOutputStream extends ObjectOutputStream {
 
     AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
 
    @Override
    public void writeStreamHeader() throws IOException {
        // Do not write a header, but reset:
        // this line added after another question
        return;
    }
 
  
    AppendableObjectOutputStream()
            throws IOException {
        // Do not write a class descriptor, just the name:
    	super();
    }
}