/*
 This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 Copyright (c) 2024 Grégory Van den Borre
 More infos available: https://engine.yildiz-games.be
 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright
 notice and this permission notice shall be included in all copies or substantial portions of the  Software.
 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package be.yildizgames.common.types;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

/**
 * @author Grégory Van den Borre
 */
public enum FileTypeCategories {

    IMAGES(new FileTypeCategory().addType(FileTypes.PNG).addType(FileTypes.JPG).addType(FileTypes.BMP).addType(FileTypes.GIF).addType(FileTypes.WEBP)),
    ARCHIVES(new FileTypeCategory().addType(FileTypes.ZIP).addType(FileTypes.SEVEN_ZIP).addType(FileTypes.RAR));

    private final FileTypeCategory category;

    FileTypeCategories(FileTypeCategory category) {
        this.category = category;
    }

    public final Optional<FileType> is(InputStream stream) throws IOException {
        return this.category.is(stream);
    }

    public final Optional<FileType> is(Path file) throws IOException {
        try (var is = Files.newInputStream(file)){
            return this.category.is(is);
        }
    }
}
