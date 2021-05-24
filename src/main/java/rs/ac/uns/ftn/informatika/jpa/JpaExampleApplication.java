 package rs.ac.uns.ftn.informatika.jpa;
 import java.io.IOException;
 import com.google.zxing.NotFoundException;
 import com.google.zxing.WriterException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaExampleApplication {
	/*
 public static void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height);
 
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
    
	
 public static String readQR(String path, String charset,
	              Map hashMap)
	throws FileNotFoundException, IOException,
	NotFoundException
	{
	BinaryBitmap binaryBitmap
	= new BinaryBitmap(new HybridBinarizer(
	new BufferedImageLuminanceSource(
	  ImageIO.read(
	      new FileInputStream(path)))));
	
	Result result
	= new MultiFormatReader().decode(binaryBitmap);
	
	return result.getText();
	}
	*/
	public static void main(String[] args)throws WriterException, IOException,
    NotFoundException {
		SpringApplication.run(JpaExampleApplication.class, args);
		/*
		  // The data that the QR code will contain
        String data = "alopurinol-2,monopril-1,brufen-4,andol-2";
 
        // The path where the image will get saved
        String path = "alopurinol-2,monopril-1,brufen-4,andol-2.png";
 
        // Encoding charset
        String charset = "UTF-8";
 
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        createQR(data, path, charset, hashMap, 200, 200);
        System.out.println("QR Code Generated!!! ");
        

        // Path where the QR code is saved
        String path = "C:\\Users\\Lenovo\\Desktop\\ISAAA\\ISA\\demo.png";
 
        // Encoding charset
        String charset = "UTF-8";
 
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        System.out.println(
            "QRCode output: "
            + readQR(path, charset, hashMap));
            */
	}

}
