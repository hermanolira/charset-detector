package dev.hermano.util;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.ibm.icu.text.CharsetDetector;

public class CharsetUtil {

	public static String detectCharset(File file) {

		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			CharsetDetector detector = new CharsetDetector();
			detector.setText(bis);
			String charset = detector.detect().getName();
			bis.close();
			return charset;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
}
