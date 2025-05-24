package org.knit.solutions.task39;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.HashSet;
import java.util.Set;

@TaskDescription(taskNumber = 39, taskDescription = "Паттерны. Посетитель (Visitor)")
public class Task39 implements Solution {
    public static void main(String[] args) {
        Task39 task = new Task39();
        task.execute();
    }

    @Override
    public void execute() {
        Set<FileSystemElement> fileSystem = new HashSet<>();

        FileSystemElement file1 = new File("file1", 100);
        FileSystemElement file2 = new File("file2", 200);
        FileSystemElement file3 = new File("file3", 300);
        FileSystemElement file4 = new File("file4", 400);

        Directory directory1 = new Directory("folder1");
        Directory directory2 = new Directory("folder2");

        FileSystemElement shortcut1 = new Shortcut("shortcut1", file1);
        FileSystemElement shortcut2 = new Shortcut("shortcut2", directory1);

        directory1.addElement(file1);
        directory1.addElement(file2);

        directory2.addElement(file3);
        directory2.addElement(shortcut1);

        fileSystem.add(directory1);
        fileSystem.add(directory2);
        fileSystem.add(file4);
        fileSystem.add(shortcut2);

        SizeAnalyser sizeAnalyser = new SizeAnalyser();
        Antivirus antivirus = new Antivirus();
        for (FileSystemElement element : fileSystem) {
            element.accept(sizeAnalyser);
            element.accept(antivirus);
        }
    }
}
