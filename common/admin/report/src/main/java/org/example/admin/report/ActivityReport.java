package org.example.admin.report;

import org.example.utilities.StringUtils;
import org.example.list.LinkedList;
import org.example.admin.UserSession;
import java.time.LocalDateTime;

/**
 * Generates activity reports based on user sessions.
 */
public class ActivityReport {
    private final LinkedList sessions;
    private final LocalDateTime reportTime;

    public ActivityReport() {
        this.sessions = new LinkedList();
        this.reportTime = LocalDateTime.now();
    }

    /**
     * Adds a user session to the report.
     *
     * @param session the user session to add
     */
    public void addSession(UserSession session) {
        String sessionSummary = String.format("Session Duration: %d minutes, Activities: %s",
            session.getSessionDurationMinutes(),
            session.getActivityLog());
        sessions.add(sessionSummary);
    }

    /**
     * Generates a formatted report of all sessions.
     *
     * @return formatted report
     */
    public String generateReport() {
        String header = String.format("Activity Report - Generated at: %s%n",
            reportTime.toString());

        LinkedList reportLines = new LinkedList();
        reportLines.add(header);
        reportLines.add("=".repeat(50));

        for (int i = 0; i < sessions.size(); i++) {
            reportLines.add(String.format("Session %d:%n%s", i + 1, sessions.get(i)));
        }

        return StringUtils.join(reportLines);
    }
}