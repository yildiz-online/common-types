# Yildiz-Engine common-types

This is the official repository of The Common type library, part of the Yildiz-Engine project.
The common types library is a set of utility and helper classes to handle easily the exact type of files.

## Features

* Define the type according extension.
* Define the type according the magic number.
* Define group of types(image, archive).
* ...

## Requirements

To build this module, you will need a java 17 JDK and Maven 3.

## Coding Style and other information

Project website:
https://engine.yildiz-games.be

Issue tracker:
https://github.com/yildiz-online/common-types/issues

## License

All source code files are licensed under the permissive MIT license
(http://opensource.org/licenses/MIT) unless marked differently in a particular folder/file.

## Build instructions

Go to your root directory, where your POM file is located.

Then invoke maven

	mvn clean install

This will compile the source code, then run the unit tests, and finally build a jar file.

## Usage

In your maven project, add the dependency

```xml
<dependency>
    <groupId>be.yildiz-games</groupId>
    <artifactId>common-type</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Contact
Owner of this repository: Grégory Van den Borre
