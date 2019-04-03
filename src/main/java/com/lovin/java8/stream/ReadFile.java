/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lovin.java8.stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.File;

/**
 * @version $Id: ReadFile.java, v 0.1 2019年02月15日 14:38 lovin Exp $
 */
public class ReadFile {

    public static void main(String[] args) throws IOException {
        String fileName = "D:\\培训笔记.txt";
        Path path = new File(fileName).toPath();
        try(Stream< String > lines = Files.lines(path, StandardCharsets.UTF_8)){
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        }

        System.out.println("---------------------------------------------");

        try(Stream lines = Files.lines(Paths.get(fileName), Charset.defaultCharset())){
            lines.forEach(System.out::println);
        }catch(IOException e){}
    }
}