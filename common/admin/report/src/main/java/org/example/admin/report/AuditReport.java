package org.example.admin.report;

import org.example.utilities.StringUtils;
import org.example.list.LinkedList;
import org.example.admin.AuditLog;
import java.time.LocalDateTime;

/**
 * Generates audit reports from audit logs.
 */
public class AuditReport {
    private final LinkedList auditLogs;
    private final LocalDateTime reportTime;

    public AuditReport() {
        this.auditLogs = new LinkedList();
        this.reportTime = LocalDateTime.now();
    }

    /**
     * Adds an audit log to the report.
     *
     * @param auditLog the audit log to add
     * @param systemName the name of the system the log is from
     */
    public void addAuditLog(AuditLog auditLog, String systemName) {
        String logSummary = String.format("System: %s - Entries: %d%n%s",
            systemName,
            auditLog.getEntryCount(),
            auditLog.getFormattedLog());
        auditLogs.add(logSummary);
    }

    /**
     * Generates a formatted audit report.
     *
     * @return formatted report
     */
    public String generateReport() {
        String header = String.format("Audit Report - Generated at: %s%n",
            reportTime.toString());

        LinkedList reportLines = new LinkedList();
        reportLines.add(header);
        reportLines.add("=".repeat(50));

        for (int i = 0; i < auditLogs.size(); i++) {
            reportLines.add(String.format("Log Set %d:%n%s", i + 1, auditLogs.get(i)));
            reportLines.add("-".repeat(30));
        }

        return StringUtils.join(reportLines);
    }
}