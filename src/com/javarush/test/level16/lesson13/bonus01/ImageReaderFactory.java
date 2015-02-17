package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by glebfox on 25.07.14.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes type){
        if (type != null) {
            if (type.equals(ImageTypes.BMP))
                return new BmpReader();
            if (type.equals(ImageTypes.JPG))
                return new JpgReader();
            if (type.equals(ImageTypes.PNG))
                return new PngReader();
        }

        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
