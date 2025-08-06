package org.example.admin;

import org.example.utilities.StringUtils;
import org.example.list.LinkedList;
import java.time.LocalDateTime;

/**
 * Represents an audit log for administrative actions.
 */
public class AuditLog {
    private final LinkedList entries;

    public AuditLog() {
        this.entries = new LinkedList();
    }

    /**
     * Adds a new audit log entry.
     *
     * @param action the action performed
     * @param user the user who performed the action
     * @param details additional details about the action
     */
    public void addEntry(String action, String user, String details) {
        String timestamp = LocalDateTime.now().toString();
        String entry = String.format("%s - User: %s - Action: %s - Details: %s",
            timestamp, user, action, details);
        entries.add(entry);
    }

    /**
     * Gets all audit log entries as a single string.
     *
     * @return formatted audit log entries
     */
    public String getFormattedLog() {
        return StringUtils.join(entries);
    }

    /**
     * Gets the number of entries in the audit log.
     *
     * @return number of entries
     */
    public int getEntryCount() {
        return entries.size();
    }
}