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

import java.util.List;

/**
 * @author Grégory Van den Borre
 */
public enum FileTypes {

    PNG(new FileType("png", List.of("png"), new FileType.FileTypeBytes(List.of(
            new int[]{0x89, 0x50, 0x4e, 0x47, 0x0d, 0x0a, 0x1a, 0x0a})))),
    JPG(new FileType("jpg", List.of("jpg", "jpeg"), new FileType.FileTypeBytes(List.of(
            new int[]{0xff, 0xd8, 0xff, 0xdb},
            new int[]{0xff, 0xd8, 0xff, 0xe0, 0x00, 0x10, 0x4a, 0x46, 0x49, 0x46, 0x00, 0x01},
            new int[]{0xff, 0xd8, 0xff, 0xee},
            new int[]{0xff, 0xd8, 0xff, 0xe1},
            new int[]{0xff, 0xd8, 0xff, 0xe0})))),
    BMP(new FileType("bitmap", List.of("bmp"), new FileType.FileTypeBytes(List.of(
            new int[]{0x42, 0x4d})))),
    GIF(new FileType("gif", List.of("gif"), new FileType.FileTypeBytes(List.of(
            new int[]{0x47, 0x49, 0x46, 0x38, 0x37, 0x61},
            new int[]{0x47, 0x49, 0x46, 0x38, 0x39, 0x61})))),
    ZIP(new FileType("zip", List.of("zip"), new FileType.FileTypeBytes(List.of(
            new int[]{0x50, 0x4b, 0x03, 0x04},
            new int[]{0x50, 0x4b, 0x05, 0x06})))),
    SEVEN_ZIP(new FileType("7zip", List.of("7z"), new FileType.FileTypeBytes(List.of(
            new int[]{0x37, 0x7A, 0xBC, 0xAF, 0x27, 0x1C})))),
    RAR(new FileType("rar", List.of("rar"), new FileType.FileTypeBytes(List.of(
            new int[]{0x52, 0x61, 0x72, 0x21, 0x1a, 0x07, 0x01, 0x00,},
            new int[] {0x52, 0x61, 0x72, 0x21, 0x1a, 0x07, 0x01, 0x00})))),
    UNKNOWN(null);

    private final FileType type;

    FileTypes(FileType type) {
        this.type = type;
    }

    public final FileType getType() {
        return this.type;
    }
}
