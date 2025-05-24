package org.knit.solutions.task45.clipboard;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SystemClipboardService implements ClipboardService {
    @Override
    public void copyPasswordToClipboard(String password) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(password), null);
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.schedule(() -> clipboard.setContents(
                new StringSelection(""), null), 5, TimeUnit.SECONDS);
        service.shutdown();
    }
}
