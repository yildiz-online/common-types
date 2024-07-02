/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *  Copyright (c) 2023 Grégory Van den Borre
 *  More infos available: https://engine.yildiz-games.be
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 *  the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright
 *  notice and this permission notice shall be included in all copies or substantial portions of the  Software.
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 *  OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package be.yildizgames.common.types;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Grégory Van den Borre
 */
class FilesTypesTest {

    @Test
    void jpeg() throws IOException {
        FileType type = FileTypes.JPG.getType();
        Assertions.assertTrue(type.getExtensions().contains("jpg"));
        Assertions.assertTrue(type.getExtensions().contains("jpeg"));
        Assertions.assertTrue(type.is("test.jpg"));
        Assertions.assertTrue(type.is("test.jpeg"));
        Assertions.assertFalse(type.is("test.png"));
        var goodFileBytes = Files.readAllBytes(Path.of("src/test/resources/jpeg.jpg"));
        Assertions.assertTrue(type.is(goodFileBytes));
        var badFileBytes = Files.readAllBytes(Path.of("src/test/resources/webp.webp"));
        Assertions.assertFalse(type.is(badFileBytes));
    }

    @Test
    void webp() throws IOException {
        FileType type = FileTypes.WEBP.getType();
        Assertions.assertTrue(type.getExtensions().contains("webp"));
        Assertions.assertTrue(type.is("test.webp"));
        Assertions.assertFalse(type.is("test.png"));
        var goodFileBytes = Files.readAllBytes(Path.of("src/test/resources/webp.webp"));
        Assertions.assertTrue(type.is(goodFileBytes));
        var badFileBytes = Files.readAllBytes(Path.of("src/test/resources/jpeg.jpg"));
        Assertions.assertFalse(type.is(badFileBytes));
    }
}
