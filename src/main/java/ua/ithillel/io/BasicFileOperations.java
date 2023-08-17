package ua.ithillel.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class BasicFileOperations {

    public static void basic() throws IOException {
        Path path = Path.of("src", "main", "resources");
//        Path path = Path.of("src/main/resources/hw3-words.db");

        System.out.println("absolute path: " + path.toAbsolutePath());


        File file = path.toFile();
//        File file = new File("src/main/resources/hw3-words.db");
//
        file.getName();
        System.out.println(file.exists());
//        file.mkdirs();
//        file.mkdir();
//        file.delete();
        System.out.println("Length: " + file.length());

//
        System.out.println("Length 2: " + Files.size(path));

        System.out.println(Files.list(path).toList());
        System.out.println(Files.isDirectory(path));
    }

    public static void readFileWithInputStream() {
        try (InputStream is = new FileInputStream("src/main/resources/hw3-words.db")) {
            byte[] bytes = is.readAllBytes();
            System.out.println(new String(bytes, UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFileWithReader() {
        var path = Path.of("src/main/resources/hw3-words.db");
        System.out.println();
        try (var is = new InputStreamReader(new FileInputStream(path.toFile()))){
            int c;
            while ((c = is.read()) != -1) {
                char value = (char) c;
                if (value != '\n' && value != '\r') {
                    System.out.print(value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readWithScanner() throws IOException {
//        var scanner = new Scanner(System.in);
//        var scanner = new Scanner( new FileInputStream(Path.of("src/main/resources/hw3-words.db").toFile()));
//        while (scanner.hasNext()) {
//            System.out.println("line: " + scanner.nextLine());
//        }
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/hw3-words.db"));
        System.out.println(lines);
    }


    public static void writeToFileWithOutputStream() throws IOException {
//        OutputStream out = new BufferedOutputStream(new FileOutputStream("out/2.txt"));
//        for (int i = 0; i < 1000; i++) {
//            out.write(("message " + i + "\n").getBytes(UTF_8));
//        }
//        out.close();

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("out/1.txt"))) {
            for (int i = 0; i < 1000; i++) {
                out.write(("message " + i + "\n").getBytes(UTF_8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFileWithWriter() throws FileNotFoundException {
        try (var out = new OutputStreamWriter(new FileOutputStream("out/3.txt"))) {
            out.write("message  333333");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFromResources() {
        try (InputStream is = BasicFileOperations.class.getResourceAsStream("/hw3-words.db")) {
            byte[] bytes = is.readAllBytes();
            System.out.println(new String(bytes, UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void other() throws IOException {
        Files.readAllLines(Path.of("src/main/resources/hw3-words.db"));
    }

    public static void main(String[] args) throws IOException {
//        basic();

//        readFileWithInputStream();
//        readFileWithReader();
//        readWithScanner();

//        writeToFileWithOutputStream();
//        writeToFileWithWriter();
        readFromResources();
    }


}
